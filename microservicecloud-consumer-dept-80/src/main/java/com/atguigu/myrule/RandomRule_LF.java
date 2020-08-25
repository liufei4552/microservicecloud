package com.atguigu.myrule;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_LF extends AbstractLoadBalancerRule{

	private int totle=0;
	private int currentIndex=0;
	
	public Server choose(ILoadBalancer lb, Object key) {
		 if (lb == null) {
	            return null;
	        }
	        Server server = null;

	        while (server == null) {
	            if (Thread.interrupted()) {
	                return null;
	            }
	            List<Server> upList = lb.getReachableServers();
	            List<Server> allList = lb.getAllServers();

	            int serverCount = allList.size();
	            if (serverCount == 0) {
	                /*
	                 * No servers. End regardless of pass, because subsequent passes
	                 * only get more restrictive.
	                 */
	                return null;
	            }

				/*
				 * int index = chooseRandomInt(serverCount); server = upList.get(index);
				 */
	            if(totle<5) {
	            	server=upList.get(currentIndex);
	            	totle++;
	            }else {
					totle=0;
					currentIndex++;
					if(currentIndex>=upList.size()) {
						currentIndex=0;
					}
				}

	            if (server == null) {
	                /*
	                 * The only time this should happen is if the server list were
	                 * somehow trimmed. This is a transient condition. Retry after
	                 * yielding.
	                 */
	                Thread.yield();
	                continue;
	            }

	            if (server.isAlive()) {
	                return (server);
	            }

	            // Shouldn't actually happen.. but must be transient or a bug.
	            server = null;
	            Thread.yield();
	        }

	        return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

}

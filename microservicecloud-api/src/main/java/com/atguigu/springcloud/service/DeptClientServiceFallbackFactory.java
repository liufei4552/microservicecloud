package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DeptClientServiceFallbackFactory
 * @Description
 * @Author liufei
 * @Date 2020/8/25 15:16
 * @Version V1.0
 **/
@Component //不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {

                return new Dept().setDeptno(id).setDname("该ID："+id+"没有对应信息,Consumer客户端提供的降级服务，此刻procider服务已关闭").setDb_source("no this database in MYSQL");
            }

            @Override
            public List<Dept> list() {
                Dept dept=new Dept();
                dept.setDeptno(12L);
                dept.setDname("错误");
                dept.setDb_source("123");
                List<Dept>deptList=new ArrayList<>();
                deptList.add(dept);
                return deptList;
            }
        };
    }
}

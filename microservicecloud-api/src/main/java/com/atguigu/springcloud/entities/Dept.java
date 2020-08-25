package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
//链式写法
@Accessors(chain = true)
public class Dept implements Serializable{
	/**
	 * 主键
	 */
	private Long deptno;
	/**
	 * 部门名称
	 */
	private String dname;
	/**
	 * 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库
	 */
	private String db_source;
	
	private void psvm() {
		// TODO Auto-generated method stub
		Dept dept=new Dept();
		
		
	}


}

package com.atguuigu.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.entities.Dept;
import com.atguuigu.springcloud.dao.DeptDao;
import com.atguuigu.springcloud.service.DeptService;
@Service("DeptServiceImpl")
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao dao;
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}

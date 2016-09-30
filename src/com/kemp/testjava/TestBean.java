package com.kemp.testjava;

public class TestBean {

	private Bean bean = new Bean();
	
	public TestBean(){
		bean.id = 1;
		bean.name = "name1";
	}
	
	public Bean test(){
		Bean bean = new Bean();
		bean.id = this.bean.id;
		bean.name = "name2";
		return bean;
	}
	
	public Bean getBean(){
		return bean;
	}
}

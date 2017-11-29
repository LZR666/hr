package com.icss.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * 测试数据分析dao
 * */
public class TestAnaDao {
	
	@Test
	public void test(){
		
		//利用list嵌套map数据结构来存储数据结果
		HashMap<String,Object> map1 =new HashMap<>();
		map1.put("deptName", "财务部");
		map1.put("empCount", 5);
		
		HashMap<String,Object> map2 =new HashMap<>();
		map2.put("deptName", "运营部");
		map2.put("empCount", 5);
		
		HashMap<String,Object> map3 =new HashMap<>();
		map3.put("deptName", "开发部");
		map3.put("empCount", 5);
		
		ArrayList<HashMap<String,Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		System.out.println(list);
		
	}
	@Test
	public void testQueryEmpCount(){
		
	}
}

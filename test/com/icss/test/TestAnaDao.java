package com.icss.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * �������ݷ���dao
 * */
public class TestAnaDao {
	
	@Test
	public void test(){
		
		//����listǶ��map���ݽṹ���洢���ݽ��
		HashMap<String,Object> map1 =new HashMap<>();
		map1.put("deptName", "����");
		map1.put("empCount", 5);
		
		HashMap<String,Object> map2 =new HashMap<>();
		map2.put("deptName", "��Ӫ��");
		map2.put("empCount", 5);
		
		HashMap<String,Object> map3 =new HashMap<>();
		map3.put("deptName", "������");
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

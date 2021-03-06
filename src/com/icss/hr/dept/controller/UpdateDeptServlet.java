package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;


@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置相应编码
		response.setCharacterEncoding("utf-8");//需要浏览器手动切码
		//设置相应的MIME类型和编码
		response.setContentType("text/html/charset=utf-8");
		
		//相应输出流
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		//封装为pojo对象
		Dept dept = new Dept(Integer.parseInt(deptId),deptName,deptLoc);
		
		//调用业务对象的功能
		DeptService service= new DeptService();
		
		try {
			service.addDept(dept);
			out.println("部门增加成功");
			
			//重定向查询
			response.sendRedirect("QueryDeptServlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

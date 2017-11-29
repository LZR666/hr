package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * 根据登录名查询用户数据
 */
@WebServlet("/QueryEmpByLoginName")
public class QueryEmpByLoginName extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		//输出流
		PrintWriter out = response.getWriter();
		
		//从session范围去除登录名
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("EmpByLoginName");
		
		//调用业务对象
		EmpService service = new EmpService();
		
		try {
			Emp emp = service.queryEmpByLoginName(empLoginName);
		
			//转换为json数据响应到前端
			Gson gson = new Gson();
			out.write(gson.toJson(emp));
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

package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//输出流
		PrintWriter out = response.getWriter();
		
		//
		String empName = request.getParameter("empName");
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");		
		String empEmail = request.getParameter("empEmail");
		String empPhone = request.getParameter("empPhone");
		String empSal = request.getParameter("empSal");
		String empHireDate = request.getParameter("empHireDate");
		String deptId = request.getParameter("deptId");
		String jobId = request.getParameter("jobId");
		String empInfo = request.getParameter("empInfo");
		
		//封装对象
		Dept dept = new Dept();
		dept.setDeptId(Integer.parseInt(deptId));
		
		Job job = new Job();
		job.setJobId(Integer.parseInt(jobId));
		
		Emp emp = new Emp(empName,empLoginName,empPwd,empEmail,empPhone,Double.parseDouble(empSal),
				Date.valueOf(empHireDate),dept,job,null,empInfo);
		
		//调用业务对象
		EmpService service = new EmpService();
		
		try {
			service.addEmp(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
	}

}

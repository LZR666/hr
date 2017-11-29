package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * Servlet implementation class QueryPicServlet
 */
@WebServlet("/QueryPicServlet")
public class QueryPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//输出流
		PrintWriter out =response.getWriter();
		
		
		//调用业务对象
		PicService service = new PicService();
		
		
		try {
			List<Pic> list = service.queryPic();
			
			//转发为json数据，响应到客户端
			Gson gson =new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			out.write(gson.toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

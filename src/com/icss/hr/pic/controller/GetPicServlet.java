package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * 根据图片id返回二进制数据
 */
@WebServlet("/GetPicServlet")
public class GetPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//输出流
		OutputStream out =response.getOutputStream();
		
		//获得图片id
		String picId = request.getParameter("picId");
		
		//调用业务对象
		PicService Service = new PicService();
		
		try {
			Pic pic = Service.queryPicById(Integer.parseInt(picId));
			
			//获得图片数据流
			InputStream is =pic.getPicData();
			
			//响应数据
			byte[] b =new byte[1024 * 8];
			
			int len =is.read(b);

			while (len != -1) {
				out.write(b, 0, len);
				len = is.read(b);
			}
			
			out.close();
			is.close();
		
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

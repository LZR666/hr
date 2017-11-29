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
 * ����ͼƬid���ض���������
 */
@WebServlet("/GetPicServlet")
public class GetPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����
		OutputStream out =response.getOutputStream();
		
		//���ͼƬid
		String picId = request.getParameter("picId");
		
		//����ҵ�����
		PicService Service = new PicService();
		
		try {
			Pic pic = Service.queryPicById(Integer.parseInt(picId));
			
			//���ͼƬ������
			InputStream is =pic.getPicData();
			
			//��Ӧ����
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

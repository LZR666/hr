package com.icss.hr.pic.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

public class PicService {
	
	private PicDao dao = new PicDao();
	
	public void addPic(Pic pic) throws SQLException{
		dao.insert(pic);
	}
	public List<Pic> queryPic() throws Exception{
		
		return dao.query();
	}
	public Pic queryPicById(int PicId) throws Exception{
		return dao.queryById(PicId);
	}
	public Pic deletePic(int picId) throws SQLException{
		dao.deletePic(picId);
		return null;
	}
}

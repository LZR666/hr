package com.icss.hr.analysis.sevice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * Êý¾Ý·ÖÎö service
 * */

public class AnaService {
	
	public AnaDao dao =new AnaDao();
	
	public List<HashMap<String, Object>> queryEmpCount() throws SQLException{
		return dao.queryEmpCount();
	}

	
}

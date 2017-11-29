package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.batch.Main;

import javafx.scene.control.Alert;
import oracle.jdbc.driver.OracleDriver;

/**
 * 数据库连接工具类
 * @author DLETC
 *
 */
public class DbUtil {
	
	static {		
		try {
			//注册驱动
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
	}
	
	/**
	 * 利用简单工厂模式，返回数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "myhr";
		String password = "123456";
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		return conn;
	}	

}
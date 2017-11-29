package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.batch.Main;

import javafx.scene.control.Alert;
import oracle.jdbc.driver.OracleDriver;

/**
 * ���ݿ����ӹ�����
 * @author DLETC
 *
 */
public class DbUtil {
	
	static {		
		try {
			//ע������
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
	}
	
	/**
	 * ���ü򵥹���ģʽ���������ݿ�����
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
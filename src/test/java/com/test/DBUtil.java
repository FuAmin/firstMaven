package com.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBUtil {
	public static List<String[]> jdbcDriver(String url,String user,String pwd) throws SQLException{
		List<String[]> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select username,nickname from t_user";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url,user,pwd);
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String[] users = new String[2];
				users[0] = rs.getString("username");
				users[1] = rs.getString("nickname");
				list.add(users);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			con.close();
		}
		
		
		return list;
		
		
	}
}

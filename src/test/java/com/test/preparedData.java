package com.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//import org.testng.annotations.Test;





@RunWith(Parameterized.class)
public class preparedData {
	private String username;
	private String password;
	public preparedData(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	@Parameters
	public static Collection<String[]> getData() throws IOException,SQLException{
		return DBUtil.jdbcDriver("jdbc:mysql://localhost:3306/ray_shop", "root", "root");
	}
	
	@Test
	public void testParameter(){
		System.out.println(username+"-->"+password);
	}
	
}

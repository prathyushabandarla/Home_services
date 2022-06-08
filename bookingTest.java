package com.project;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class bookingTest {

	@Test
	public void test() {
		booking cc = new booking();
		try {
			String s1 = cc.admin();
			assertEquals(s1,"success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

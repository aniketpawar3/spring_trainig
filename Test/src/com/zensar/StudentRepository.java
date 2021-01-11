package com.zensar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentRepository {
	public boolean loginCheck(String susername, String spassword) {
		boolean result = false;
		Connection con = DBUtil.getMySqlDbConnection();
		String addStudentSql = "SELECT * FROM login WHERE username=?";
		try {
			PreparedStatement pst = con.prepareStatement(addStudentSql);
			pst.setString(1, susername); 
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String psswordDB = rs.getString("password");
				if(spassword.equals(psswordDB)) {
					result = true;
				}
			}

		} catch (Exception e) {
			System.out.println("addStudent catch" + e);
		}
		return result;
	}
}

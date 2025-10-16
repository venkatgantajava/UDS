package com.ecrops.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author NIC
 */
public class SqlDBUtil implements Serializable {
	public Connection getConnection() throws Exception {
		Connection con = null;
		Class.forName("org.postgresql.Driver");
		
		

		// con=DriverManager.getConnection("jdbc:postgresql://10.72.4.110:5433/epanta","postgres","SWATHI");
		// con=DriverManager.getConnection("jdbc:postgresql://10.72.4.33:5432/ekarshak","postgres","admin");
		// con=DriverManager.getConnection("jdbc:postgresql://172.19.150.49:5432/ekarshak","postgres","eKarshak@2012");
		// con = DriverManager.getConnection("jdbc:postgresql://192.168.148.149:5432/ekarshak", "postgres", "eKarshak@2012");
		// con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/ecrop_demo","postgres","root");
		//   con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/rbdb","postgres","root");
		//NIC DC Connection String
		 // con=DriverManager.getConnection("jdbc:postgresql://10.72.4.101/postgres","postgres","postgres");
//		  con=DriverManager.getConnection("jdbc:postgresql://10.72.4.78/postgres","postgres","postgres");
		  con=DriverManager.getConnection("jdbc:postgresql://10.160.6.216:5432/ecrop","ecrop","ecrop#6.216");
		  
		  //con=DriverManager.getConnection("jdbc:postgresql://10.72.4.56:5433/ecroplocal","postgres","root");

		return con;
	}

	public void closeConnection(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				con = null;
			}
			con = null;
		}

	}

	public void closePreparedStatement(PreparedStatement pst) {

		if (pst != null) {
			try {
				pst.close();
			} catch (Exception e) {
				pst = null;	
			}
			pst = null;

		}

	}

	public void closeStatement(Statement st) {

		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				st = null;
			}

		}

	}

	public void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				rs = null;
			}
			rs = null;

		}

	}

}

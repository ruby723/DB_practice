package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	public static void main(String[] args) {
		Connection conn =null;
		// 1. JDBC Drive 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url ="jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");

			// 3.연결 성공
			System.out.println("ok:"+ conn);
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : "+e);
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
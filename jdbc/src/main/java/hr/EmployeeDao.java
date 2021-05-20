package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public List<EmployeeVo> findByName(String name){
		List<EmployeeVo> result = new ArrayList<>();
		
		return result;
		
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3. SQL문 준비
			pstmt = conn.createStatement();
			
			//4. SQL문을 실행
			String sql =
				"select emp_no, date_format(birth_date, '%Y-%m-%d'), last_name" + 
			    "  from employees" +
				" where first_name like 'pat%'";
			rs = pstmt.executeQuery(sql);
			
			//5. 결과 가져오기
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String birthDate = rs.getString(2);
				String lastName = rs.getString(3);
				
				System.out.println(empNo + ":" + birthDate + ":" + lastName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

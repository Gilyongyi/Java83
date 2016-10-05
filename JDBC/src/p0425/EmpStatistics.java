package p0425;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.OracleConnection;

public class EmpStatistics {
	
	public void printStatistics(int maxSalary) throws SQLException{
		PreparedStatement pstmt = OracleConnection.getConnection()
				.prepareStatement("SELECT job_title, AVG(salary) "+
								"FROM employees e,jobs j "+
								"WHERE e.job_id=j.job_id "+
								"GROUP BY job_title "+
								"ORDER BY AVG(salary) DESC");
		ResultSet rs = pstmt.executeQuery();
		
		System.out.println("=======================");
		System.out.println("MAX Salary : "+maxSalary);
		System.out.println("=======================");
		
		while(rs.next()){
			String jobTitle = rs.getString("job_title");
			String salary = rs.getString("AVG(salary)");
			if(Integer.parseInt(salary)>=maxSalary){
			System.out.println("["+jobTitle+"]"+salary);
			}
		}
		rs.close();
		pstmt.close();
		OracleConnection.getConnection().close();
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int maxSalary=10000;
		new EmpStatistics().printStatistics(maxSalary);
		
		maxSalary=15000;
		new EmpStatistics().printStatistics(maxSalary);
		}
	}
	


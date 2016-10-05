package p0425;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.OracleConnection;

public class EmpManager1 {

	public void printEmployee(String jobs[]) throws SQLException{
		PreparedStatement pstmt = OracleConnection.getConnection()
				.prepareStatement("SELECT employee_id,first_name,salary "+
									"FROM employees e,jobs j "+
									"WHERE e.job_id=j.job_id "+
									"AND (j.job_title=? "+ 
									"OR j.job_title=?)");
			pstmt.setString(1,jobs[0]);
			pstmt.setString(2,jobs[1]);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int employeeId= rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				int salary1 = rs.getInt("salary");
				System.out.println(employeeId+" "+firstName+" "+salary1);
			}
			rs.close();
			pstmt.close();
			OracleConnection.getConnection().close();
	}
	
	
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String [] jobs ={"Accountant","Stock Clerk"};
		new EmpManager1().printEmployee(jobs);
	}

}

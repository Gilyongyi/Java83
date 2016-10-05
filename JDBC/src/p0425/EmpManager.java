package p0425;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.OracleConnection;

public class EmpManager {
	public void printEmployee(String name, int salary) throws SQLException{
		PreparedStatement pstmt = OracleConnection.getConnection()
				.prepareStatement("SELECT first_name,salary,employee_id "+
									"FROM employees "+
									"WHERE (first_name LIKE '%'||?||'%' "+
									"OR first_name LIKE initcap('%'||?||'%')) "+
									"AND salary>=? "+
									"ORDER BY employee_id");
			pstmt.setString(1,name);
			pstmt.setString(2,name);
			pstmt.setInt(3,salary);
			
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

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		new EmpManager().printEmployee("al",4000);
	}

}

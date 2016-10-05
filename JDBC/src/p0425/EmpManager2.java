package p0425;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.OracleConnection;

public class EmpManager2 {
	
	public static void printEmployee(String city,int lo,int hi)throws SQLException{
		PreparedStatement pstmt = OracleConnection.getConnection()
				.prepareStatement("SELECT e.last_name, vt.department_name "+
								"FROM employees e,departments d,locations l, "+
								"(SELECT e1.last_name,d1.department_name "+
									"FROM employees e1,departments d1 "+
									"WHERE e1.department_id=d1.department_id "+
									"AND salary BETWEEN ? AND ?) vt "+
								"WHERE d.department_name=vt.department_name "+
								"AND e.last_name=vt.last_name "+
								"AND d.location_id=l.location_id "+
								"AND l.city=?");
				
				pstmt.setInt(1,lo);
				pstmt.setInt(2,hi);
				pstmt.setString(3,city);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
					String lastName = rs.getString("last_name");
					String departmentName = rs.getString("department_name");
					System.out.println(lastName+" "+departmentName);
				}
				rs.close();
				pstmt.close();
				OracleConnection.getConnection().close();
	}
	
	public static void main(String[] args) throws SQLException {
		new EmpManager2();
		// TODO Auto-generated method stub
		EmpManager2.printEmployee("South San Francisco",7000,10000);
	}

}

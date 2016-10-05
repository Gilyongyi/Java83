package p0425;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.OracleConnection;

public class Prob6 {
	
	private static void printEmployeeList(String cityName, String deptName) throws Exception{
		PreparedStatement pstmt = OracleConnection.getConnection()
				.prepareStatement("SELECT city,department_name,first_name,salary "+
									"FROM locations l, departments d,employees e "+
									"WHERE l.location_id=d.location_id "+
									"AND e.department_id=d.department_id "+
									"AND l.city LIKE initcap(?||'%') AND "+
									"d.department_name LIKE initcap('%'||?||'%')");

				pstmt.setString(1,cityName);
				pstmt.setString(2,deptName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String city = rs.getString("city");
					String departmentName = rs.getString("department_name");
					String firstName = rs.getString("first_name");
					int salary=rs.getInt("salary");
					System.out.println(city+" "+departmentName+" "+firstName+" "+salary);
				}
				rs.close();
				pstmt.close();
				OracleConnection.getConnection().close();
	}
	
	public static void main(String []args) throws Exception{
		Prob6.printEmployeeList("lon","resource");
	}
}

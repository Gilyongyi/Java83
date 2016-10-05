package p0425;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.OracleConnection;

public class Prob5 {

	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			if(args.length!=1){
				System.out.println("부서의 아이디를 입력하세요...");
				System.exit(1);
			}
			String dept_id=args[0];
			
			PreparedStatement pstmt = OracleConnection.getConnection()
				.prepareStatement("SELECT e.employee_id,vt.department_name,e.salary,vt.AVG "+
									"FROM employees e, "+ 
									"(SELECT d1.department_name,e1.department_id,AVG(salary) AVG "+
									"FROM employees e1,departments d1 "+
									"WHERE e1.department_id=d1.department_id "+
									"GROUP BY e1.department_id,d1.department_name) vt "+
									"WHERE e.department_id=vt.department_id "+
									"and e.department_id=?");
				
				pstmt.setString(1,dept_id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
					int employeeId= rs.getInt("employee_id");
					String departmentName = rs.getString("department_name");
					int salary1 = rs.getInt("salary");
					int salary2 = rs.getInt("AVG");
					System.out.println(employeeId+" "+departmentName+" "
					+salary1+" "+salary2);
				}
				rs.close();
				pstmt.close();
				OracleConnection.getConnection().close();
		}
	}


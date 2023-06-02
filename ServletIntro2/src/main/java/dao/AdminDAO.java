package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.AdminDTO;

public class AdminDAO 
{
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/servlet";
		String user="root";
		String pass="root";
		
		Connection c = DriverManager.getConnection(url,user,pass);
		return c;
	}
	
	public String saveAdmin(AdminDTO v)
	{
		String query="insert into visitor (userName,password,dept) values (?,?,?)";
		try {
			Connection c=getConnection();
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, v.getName());
			ps.setString(2, v.getPassword());
			ps.setString(3, v.getDept() );
			
			int ex = ps.executeUpdate();
			return ex+" data added";
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		return "Something went wrong";
	}
	
	
}

package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AdminDTO;

public class VisRepo 
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
	
	public AdminDTO getVisitor(String name)
	{
		String query="Select * from visitor where userName=?";
		try {
			Connection c=getConnection();
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, name);
			ResultSet set = ps.executeQuery();
			AdminDTO v=new AdminDTO();
			while(set.next())
			{
				v.setName(set.getString(2));
				v.setPassword(set.getString(3));
			}
			return v;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
					//or
	
	public boolean isValid(String name, String password)
	{
		try {
			Connection c=getConnection();
			String q="select * from visitor where userName=?";
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1, name);
			ResultSet set = ps.executeQuery();
			
			String username = null;
			String pass =null; 
			while(set.next())
			{
				username=set.getString(2);
				pass=set.getString(3);
			}
			
			if(name.equals(username)&&pass.equals(password)) return true;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}

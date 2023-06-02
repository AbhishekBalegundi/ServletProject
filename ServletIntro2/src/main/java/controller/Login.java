package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AdminDTO;
import repository.VisRepo;

@WebServlet("/login")
public class Login extends HttpServlet 
{
	private VisRepo vis;
	{
		vis=new VisRepo();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String pass = req.getParameter("password");

		AdminDTO v = vis.getVisitor(name);
		boolean valid = vis.isValid(name, pass);
		
//		if(v==null) 
//		{
//			RequestDispatcher rd = req.getRequestDispatcher("invalid");
//			rd.forward(req, resp);
//		}
//		
//		else if(name.equals(v.getName()) && pass.equals(v.getPassword())) 
//		{
//			RequestDispatcher rd = req.getRequestDispatcher("valid");
//			rd.forward(req, resp);
//		}
		
		
		if(!valid) 
		{
			RequestDispatcher rd = req.getRequestDispatcher("invalid");
			rd.forward(req, resp);
		}
		
		else if(valid) 
		{
			RequestDispatcher rd = req.getRequestDispatcher("valid");
			rd.forward(req, resp);
		}
		
	}
}

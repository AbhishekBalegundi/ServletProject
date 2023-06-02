package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dto.AdminDTO;

public class SaveAdmin extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String dept = req.getParameter("dept");
		String pass = req.getParameter("password");
		AdminDTO adminDTO = new AdminDTO(user,pass,dept);
		
		AdminDAO dao = new AdminDAO();
		
		PrintWriter out = resp.getWriter();
		out.println(dao.saveAdmin(adminDTO));
		
	}
}

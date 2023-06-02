package responseRedirectTrial;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/respdirect2")

public class RespClass2 extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost in second servlet class");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String par = req.getParameter("name");
		String par1 = req.getParameter("email");
		System.out.println(par+par.length());
		System.out.println(par1);
		System.out.println("doGet in second servlet class");
	}
}

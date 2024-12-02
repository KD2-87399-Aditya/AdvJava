package com.sunbeam;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Info</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<h1>Student Information</h1>");
		out.printf("<h3><strong>First Name:</strong> Aditya</h3>");
		out.printf("<h3><strong>Last Name:</strong> Kumar</h3>");
		out.printf("<h3><strong>Qualification:</strong> B.Tech</h3>");
		out.printf("<h3><strong>Institute:</strong> Sunbeam</h3>");
		out.printf("<h3><strong>BirthDate:</strong> 21-08-2001</h3>");
		out.println("</body>");
		out.println("</html>");
	}
	
	


}

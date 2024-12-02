package com.sunbeam;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet{

	ArrayList<Marks> result;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
	 super.init(config);
	  result = new ArrayList<>();
	 result.add(new Marks("Java programming", 80.0));
	 result.add(new Marks("Web programming", 85.0));
	 result.add(new Marks("Database technologies", 83.0));
	 
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<Head>");
		out.println("<title>Marks Display</title>");
		out.println("</HEAD>");
		out.println("<body text-align='center'>");
		out.println("<div style='display: flex; justify-content: center;'>");
		out.println("<table border = '1' algin='center'>");
		out.println("<th>Subject</th><th>Marks</th>");
		for(Marks m : result) {
			out.println("<tr>");
			out.printf("<td>%s</td>",m.getSubject());
			out.printf("<td>%.2f</td>",m.getMarks());
			out.println("</tr>");
			
		}
		out.println("</div>");
		out.println("</body>");
		out.println("</HTML>");
		
	}
}

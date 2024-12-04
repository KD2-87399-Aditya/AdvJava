package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/can")

public class CandidateServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cname=req.getParameter("name");
		String cparty=req.getParameter("party");
		
		try(CandidateDao canDao=new CandidateDaoImpl();){
			Candidate c= new Candidate(0,cname,cparty,0);
			int a=canDao.save(c);
			PrintWriter	out=resp.getWriter();
			if(a==0) {
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>regisration  faild</h2>");
				out.println("<p><a href='newcandidate.html'>register Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}else {

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>regisration  sucessful</h2>");
				out.println("<p><a href='result'>list </a></p>");
		out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}

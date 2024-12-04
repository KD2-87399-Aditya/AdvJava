package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private int a;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get email and password from login page
		String first = req.getParameter("First");
		String last = req.getParameter("Last");
		String email = req.getParameter("email");
		System.out.println(email);
		String password = req.getParameter("passwd");
		String dob = req.getParameter("DateOfBirth");
		Date date = Date.valueOf(dob);
		// validate login against db records
		try(UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(email);
			
			System.out.println(dbUser);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			if(dbUser!=null){
				out.println("<p>User is Already registered.</p>");
				out.println("<p><a href='index.html'>Login Again</a></p>");
				
			}else{
				User u = new User();
				u.setFirstName(first);
				u.setLastName(last);
				u.setEmail(email);
				u.setPassword(password);
				u.setBirth(date);
				u.setRole("voter");
				a = userDao.save(u);
				if(a == 0){
					
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Login</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h2>Signup Failed</h2>");
					
					out.println("<p><a href='newuser.html'>SignUp Again</a></p>");
					out.println("</body>");
					out.println("</html>");
				}else {
					out.println("<h4>You have successfully registered.</h4>");
				}
			}
			
			// if login is failed, show "Invalid Login"
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}

package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")!=null) {
			if((int)session.getAttribute("role")==1) {
				System.out.println("getted admin");
				request.getRequestDispatcher("views/Admin.jsp").forward(request, response);;
			}else {
				System.out.println("getted user");
				request.getRequestDispatcher("views/User.jsp").forward(request, response);
			}
		}else {
			System.out.println("getted");
			response.sendRedirect("views/Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		if (request.getParameter("logout") == null) {
			UserService userService = new UserService();
			User user = userService.findUserByUsernameAndPassword(usernameString, passwordString);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user.getUsername());
				session.setAttribute("role", user.getRole());
				System.out.println(session.getAttribute("user"));
				System.out.println(session.getAttribute("role"));
				if (user.getRole()==1) {
					System.out.println("admin");
					request.getRequestDispatcher("views/Admin.jsp").forward(request, response);;
				} else if (user.getRole() == 0) {
					System.out.println("user");
					request.getRequestDispatcher("views/User.jsp").forward(request, response);
				}
			}else {
				System.out.println("user null");
				response.sendRedirect("views/Login.jsp");
			}
		}else {
			HttpSession session=request.getSession();
			session.removeAttribute("user");
			session.removeAttribute("role");
			response.sendRedirect("views/Login.jsp");
		}

	}

}

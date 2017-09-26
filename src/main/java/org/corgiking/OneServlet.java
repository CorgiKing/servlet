package org.corgiking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class OneServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("OneServlet init..."+getClass());
	}

	public void destroy() {
		System.out.println("OneServlet destroy...");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OneServlet service...");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OneServlet doGet...");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OneServlet doPost...");
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>OneServlet</title></head>");
		out.println("<body>");
		out.println("<form>");
		out.println("账号：<input type='text'/>");
		out.println("<br/>");
		out.println("密码：<input type='text'/>");
		out.println("<br/>");
		out.println("<input type='submit' value='登录'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}

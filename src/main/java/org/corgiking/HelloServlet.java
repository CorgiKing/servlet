package org.corgiking;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
    	System.out.println("init....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget....");
		
		response.setContentType("text/html;");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("Hello World !");
		out.print("世界那么大!我想去看看...");
		
		response.setIntHeader("refresh", 1);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:MM:ss");
		out.print(sdf.format(new Date()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy....");
	}

}

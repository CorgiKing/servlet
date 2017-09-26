package org.corgiking;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataServletContextListener implements ServletContextListener {
	private ServletContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.context = sce.getServletContext();
		
		context.setAttribute("author", "Corgi King");
	}
}

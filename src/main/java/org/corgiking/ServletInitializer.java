package org.corgiking;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

/**
 * 如果“metadata-complete”设置为“true”，
 * 部署工具必须忽略存在于应用的类文件中的所有servlet注解和web fragments。
 * 如果metadata-complete属性没有指定或设置为“false”，部署工具必须检查应用的类文件的注解
 */
/**
 * 容器会在类路径中查找实现 javax.servlet.ServletContainerInitializer接口的类，
 * 如果能发现的话，就会用它来配置Servlet容器。
 * 
 * 环境：servlet3.0+
 * P178
 * @author Corgi King
 *
 */
@HandlesTypes(value = { ServletContextServlet.class })
public class ServletInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

		System.out.println("ServletInitializer started!");

	}

}

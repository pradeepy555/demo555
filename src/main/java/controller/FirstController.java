package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	
	
	@RequestMapping(value="/save/page",method={RequestMethod.GET})
	public ModelAndView mobileTracking(){
		return new ModelAndView("first");
	}
	
	
	
	//old process as in servlet
	@RequestMapping(value ="/save")
	public HashMap<String, Object> saveData(){
		// initialize Spring's Application context
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-core-config.xml");
		// get bean declared with name "dataSource" in the configuration file
		DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");

		try{
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from student");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
			}
			resultSet.close();
			connection.close();
		}catch(Exception e){

		}
		return null;
	}
	
	
	

	
	@RequestMapping(value ="/save/ByTemplate")
	public HashMap<String, Object> saveDataByJdbcTemplate(){
		// initialize Spring's Application context
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring-servlet.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("src/main/resources/spring-servlet.xml");
		// get bean declared with name "dataSource" in the configuration file
		DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");

		JdbcTemplate template= new JdbcTemplate(dataSource);
		template.update("insert into Student (name, age) values (?, ?)", new Object[]{"Zara", 11});		
		return null;
	}
	
}

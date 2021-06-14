package com.cts;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;

import com.mysql.cj.jdbc.MysqlDataSource;

public class CamelDatabase {

	public static void main(String[] args)  throws Exception{
		MysqlDataSource datasource=	new MysqlDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/cameldb");
		datasource.setUser("root");
		datasource.setPassword("@sarath&lalitha@141");
		
	SimpleRegistry registry=new SimpleRegistry();
	registry.bind("myDataSource",MysqlDataSource.class,datasource);
		
	
		// TODO Auto-generated method stub
	CamelContext camel= new DefaultCamelContext();
		camel.addRoutes(new RouteBuilder() {
		@Override
		public void configure() throws Exception {
			from("direct:abc").
			to("jdbc:myDataSource").
			bean(new jdbcHandler(),"display");
		}
			
		});
		camel.start();
		ProducerTemplate producer=camel.createProducerTemplate();
		producer.sendBody("direct:abc","select * from customers");
		
	}

}

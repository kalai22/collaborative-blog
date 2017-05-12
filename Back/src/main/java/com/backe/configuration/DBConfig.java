package com.backe.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.backe.model.BlogComment;
import com.backe.model.BlogPost;
import com.backe.model.Friend;
import com.backe.model.Job;
import com.backe.model.ProfilePicture;
import com.backe.model.User;

@Configuration
@EnableTransactionManagement
public class DBConfig {
//create an instance
@Bean
public SessionFactory sessionFactory() {
LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
Properties hibernateProperties=new Properties();
hibernateProperties.setProperty(
"hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
hibernateProperties.setProperty("hibernate.show_sql", "true");
lsf.addProperties(hibernateProperties);
Class classes[]=new Class[]{User.class,ProfilePicture.class,Job.class,BlogPost.class,BlogComment.class,Friend.class};
return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}
@Bean
public DataSource getDataSource() {
BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
dataSource.setUsername("test");
dataSource.setPassword("admin");
return dataSource;
}
@Bean
public HibernateTransactionManager hibTransManagement(){
return new HibernateTransactionManager(sessionFactory());
}


}
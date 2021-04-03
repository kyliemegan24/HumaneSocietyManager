package com.HumaneSocietyManagerKs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.CaseStudyTemplate.repo")
@PropertySource("classpath:database.properties")
public class DataConfig {

	@Autowired
	private Environment environment;

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();

		emfBean.setJpaVendorAdapter(getJpaVendorAdapter());
		emfBean.setDataSource(dataSource());
		emfBean.setPersistenceUnitName("smsPersistenceUnit");
		emfBean.setPackagesToScan("com.CaseStudyTemplate.models");
		emfBean.setJpaProperties(getHibernateProperties());

		return emfBean;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager txManager() {
		return new JpaTransactionManager(
				Objects.requireNonNull(getEntityManagerFactoryBean().getObject()));
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put(DIALECT, environment.getRequiredProperty("hibernate.dialect"));
		properties.put(SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
		properties.put(FORMAT_SQL, environment.getRequiredProperty("hibernate.format_sql"));
		properties.put(HBM2DDL_AUTO, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put(ENABLE_LAZY_LOAD_NO_TRANS,
				environment.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));

		return properties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
		source.setUrl(environment.getRequiredProperty("jdbc.url"));
		source.setUsername(environment.getRequiredProperty("jdbc.username"));
		source.setPassword(environment.getRequiredProperty("jdbc.password"));

		return source;
	}

	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}


}


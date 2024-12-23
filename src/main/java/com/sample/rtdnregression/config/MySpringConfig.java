package com.sample.rtdnregression.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MySpringConfig {

	@Bean
	public DataSource rtDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rtdnreg-rt");
		dataSource.setUsername("venus");
		dataSource.setPassword("Hotplanet@ss2");
		return dataSource;
	}

	@Bean
	public DataSource dnDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rtdnreg-dn");
		dataSource.setUsername("venus");
		dataSource.setPassword("Hotplanet@ss2");
		return dataSource;
	}

	@Bean("rtjdbctemplate")
	JdbcTemplate getRTJdbcTemplate() {

		return new JdbcTemplate(rtDataSource());
	}

	@Bean("dnjdbctemplate")
	JdbcTemplate getDNJdbcTemplate() {

		return new JdbcTemplate(dnDataSource());
	}
}

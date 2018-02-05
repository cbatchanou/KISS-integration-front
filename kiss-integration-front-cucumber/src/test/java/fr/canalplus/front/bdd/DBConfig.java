package fr.canalplus.front.bdd;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan(basePackageClasses = DBConfig.class)
@Import(fr.canalplus.integration.common.DBConfig.class)
@PropertySources(value = { @PropertySource("classpath:configurations/connection.properties"), @PropertySource("classpath:configurations/sqlQueries.properties")})
public class DBConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean(name = "CGADEV10")
	public DataSource cgaDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("db.cga.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.cga.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.cga.password"));
		System.out.println("datasource cga:"+dataSource.toString());
		return dataSource;
	}
	
	@Bean(name = "SGEWEB")
	public DataSource sgeDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("db.sge.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.sge.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.sge.password"));
		System.out.println("datasource sge:"+dataSource.toString());
		return dataSource;
	}
	
	@Bean(name="cgaTemplate")
	public JdbcTemplate cgaJdbcTemplate(@Qualifier("CGADEV10") DataSource cgaDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(cgaDataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		System.out.println("jdbcTemplate cga:"+jdbcTemplate.toString());
		return jdbcTemplate;
	}
	
	@Bean(name="sgeTemplate")
	public JdbcTemplate sgeJdbcTemplate(@Qualifier("SGEWEB")DataSource sgeDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(sgeDataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		System.err.println("jdbcTemplate sge:"+jdbcTemplate.toString());
		return jdbcTemplate;
	}

}

package fr.canalplus.front.bdd;

import javax.sql.DataSource;

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
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackageClasses = DBConfig.class)
@Import(fr.canalplus.integration.common.DBConfig.class)
@PropertySources(value = { @PropertySource("classpath:configurations/connection.properties"),
						   @PropertySource("classpath:configurations/browserstack.properties"),
						   @PropertySource("classpath:configurations/stepMateriel.properties")})
public class DBConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean(name = "CGADEV10")
	public DataSource cgaDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("db.cga.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.cga.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.cga.password"));
		System.out.println("datasource cga:"+dataSource);
		return dataSource;
	}
	
	@Bean(name = "SGEWEB")
	public DataSource sgeDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("db.sge.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.sge.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.sge.password"));
		System.out.println("datasource sge:"+dataSource);
		return dataSource;
	}
	
	@Bean(name="cgaTemplate")
	public JdbcTemplate cgaJdbcTemplate(@Qualifier("CGADEV10") DataSource cgaDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(cgaDataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
	@Bean(name="sgeTemplate")
	public JdbcTemplate sgeJdbcTemplate(@Qualifier("SGEWEB")DataSource sgeDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(sgeDataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderCofigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

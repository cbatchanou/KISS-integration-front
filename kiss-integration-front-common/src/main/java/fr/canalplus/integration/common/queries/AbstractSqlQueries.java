package fr.canalplus.integration.common.queries;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author cbatchanou
 *
 */
public abstract class AbstractSqlQueries {
	
	@Autowired
	@Qualifier("JdbcTemplateCGA")
	private JdbcTemplate jdbcTemplateCGA; 
	
	@Autowired
	@Qualifier("JdbcTemplateSGE")
	private JdbcTemplate jdbcTemplateSGE;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Resource(name="sqlQueriesProperties")
	private Properties sqlQueriesProperties;

}

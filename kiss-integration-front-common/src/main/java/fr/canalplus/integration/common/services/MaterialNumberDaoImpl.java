package fr.canalplus.integration.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.canalplus.integration.common.beans.entities.MaterialNumber;
import fr.canalplus.integration.common.beans.entities.Subscriber;
import fr.canalplus.integration.common.services.interfaces.MaterialNumberDao;

@Repository
@Qualifier("materialNumberDao")
@PropertySource("classpath:configurations/sqlQueries.properties")
public class MaterialNumberDaoImpl implements MaterialNumberDao{

	@Value("${FIND_MATERIAL_ADSL}")
	private String find_material_adsl;
	
	@Value("${LIST_MATERIAL}")
	private String material;
	
	@Autowired
	@Qualifier("sgeTemplate")
	JdbcTemplate sgeTemplate;
	
	@Override
	public MaterialNumber findMaterial(String refArticle) {
		MaterialNumber material = (MaterialNumber) sgeTemplate.queryForObject(find_material_adsl, new Object[] {refArticle}, new BeanPropertyRowMapper(MaterialNumber.class));
		return material;
	}
	
	@Override
	public MaterialNumber findMaterial() {
		MaterialNumber material = (MaterialNumber) sgeTemplate.queryForObject(find_material_adsl, new BeanPropertyRowMapper(MaterialNumber.class));
		return material;
	}

	@Override
	public List<MaterialNumber> findAllMateriel() {
		//List<MaterialNumber> listmaterial = sgeTemplate.query(material_orange, new BeanPropertyRowMapper(MaterialNumber.class));
		return null;
	}

	

	
}

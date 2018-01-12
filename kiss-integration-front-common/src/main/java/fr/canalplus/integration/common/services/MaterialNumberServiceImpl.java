package fr.canalplus.integration.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.canalplus.integration.common.beans.entities.MaterialNumber;
import fr.canalplus.integration.common.services.interfaces.MaterialNumberDao;
import fr.canalplus.integration.common.services.interfaces.MaterialNumberService;

@Service("materialNumberService")
public class MaterialNumberServiceImpl implements MaterialNumberService{
	
	@Autowired
	MaterialNumberDao materialNumberDao;
	
	@Override
	public MaterialNumber findMaterial(String refArticle) {
		return materialNumberDao.findMaterial(refArticle);
	}

	@Override
	public List<MaterialNumber> findAllMateriel() {
		return materialNumberDao.findAllMateriel();
	}

	@Override
	public MaterialNumber findMaterial() {
		return materialNumberDao.findMaterial();
	}

	
}

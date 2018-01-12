package fr.canalplus.integration.common.services.interfaces;

import java.util.List;

import fr.canalplus.integration.common.beans.entities.MaterialNumber;

public interface MaterialNumberDao {

	public MaterialNumber findMaterial(String refArticle);
	
	public MaterialNumber findMaterial();
	
	public List<MaterialNumber> findAllMateriel();
}

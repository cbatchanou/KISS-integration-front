/**
 * 
 */
package fr.canalplus.front.bdd.steps.common;

/**
 * Interface définissant les comportements nécessaires à un DTO
 * @author cbatchanou
 *
 */
public interface IDTO {

	/**
	 * Cette méthode sera automatiquement appellée sur tous les objets implémentant {@link IDTO}
	 * Après l'execution d'un scénario.
	 * Il est important de l'implémenter correctement (réinitialiser à null tous les attributs de l'objet courant)
	 * afin de garantir que des données d'un scénario ne soient pas utilisées dans un autre scénario suivant.
	 */
	void reset();
}

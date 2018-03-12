package fr.canalplus.front.bdd.steps.common;

/**
 * @author cbatchanou
 *
 */
public interface IDTO {

	/**
	 * Cette mÃ©thode sera automatiquement appellÃ©e sur tous les objets
	 * implÃ©mentant {@link IDTO} AprÃ¨s l'execution d'un scÃ©nario. Il est
	 * important de l'implÃ©menter correctement (rÃ©initialiser Ã  null tous les
	 * attributs de l'objet courant) afin de garantir que des donnÃ©es d'un
	 * scÃ©nario ne soient pas utilisÃ©es dans un autre scÃ©nario suivant.
	 */
	void reset();
}

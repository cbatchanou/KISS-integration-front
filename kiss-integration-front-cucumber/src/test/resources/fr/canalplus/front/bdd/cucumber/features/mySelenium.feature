#language: fr
Fonctionnalité: Reset functionality on login page of Application

  @test
  Scénario: test de l'url
    Etant donné L'ouverture de la page souscription
	@liencanal @lien
  Scénario: Scénario de vérification du lien : En savoir plus sur les décodeurs CANAL
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur en savoir plus sur les decodeurs canal
	
	 #ne marche pas
	@liencompatible @lien  
  Scénario: Scénario de vérification du lien : En savoir plus sur les décodeurs compatibles
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur en savoir plus sur les decodeurs compatibles
	@lienmodalite @lien
  Scénario: Scénario de vérification du lien : Voir les modalités de loffre et des services
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur voir les modalités de loffre et des services
	@voirdetail @lien
  Scénario: Scénario de vérification du lien : Voir le detail
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur voir le detail

  Plan du Scénario: Formulaire de souscription de BOUYGUES et FREE
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et Que l'on renseigne les champs nom et téléphone
    Alors Valider donc le formulaire

    Exemples: 
      | operateur |
      | BOUYGUES  |
      | FREE      |

  Scénario: Formulaire souscription du materiel FREE
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel free
    Et Que l'on renseigne les champs nom et téléphone
    Alors Valider donc le formulaire

  Plan du Scénario: Formulaire souscription du materiel
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et Que l'on renseigne les champs nom et téléphone
    Et Que l'on renseigne le numéro de matériel <operateur>
    Alors Valider donc le formulaire

    Exemples: 
      | operateur |
      | ORANGE    |

  @Identification @formulaire
  Scénario: Formulaire identification
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur Le Decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Remplir tous les champs du formulaire

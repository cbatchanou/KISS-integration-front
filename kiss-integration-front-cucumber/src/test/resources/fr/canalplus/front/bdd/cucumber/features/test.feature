#language: fr
@tags
Fonctionnalité: test

  @test
  Plan du Scénario: test tnt
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur plus Le Cube
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 72h à domicile
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 | avec |

    Plan du Scénario: test tnt
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur plus Le Cube
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 72h à domicile
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 | avec |
      
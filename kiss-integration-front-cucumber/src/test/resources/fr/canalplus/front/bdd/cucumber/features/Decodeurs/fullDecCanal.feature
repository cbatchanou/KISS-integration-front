#language: fr
@Canal
Fonctionnalité: Parcours souscription - Decodeurs CANAL

  ## Step recevoir une parabole ##
  @boutiqueA
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole - Livraison en boutique
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix du retrait en 1h en boutique
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | etat |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans |

  @domicileA
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole - Livraison à domicile
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix du retrait en 72h à domicile
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | etat |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans |

  @relaisA
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole - Livraison en point relais
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de la livraison en 72h en point relais
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | etat |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans |

  @installation
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole - installation à domicile
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de l'installation à domicile
    Et Retour à la page mode de livraison

    Exemples: 
      | civility | Prenom | Nom    | CodePostal | Adresse              | Mobile     | etat |
      |        1 | Claude | CARPIN |      75001 | 13 Place de la Boule | 0166565656 | sans |

  @boutiqueA
  Plan du Scénario: Parcours CANAL avec l'option deja une parabole - Livraison en boutique
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et L'on clique sur jai deja une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix du retrait en 1h en boutique
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | etat |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | avec |

  @domicileB
  Plan du Scénario: Parcours CANAL avec l'option deja une parabole - Livraison à domicile
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix du retrait en 72h à domicile
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | etat |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | avec |

  @relaisB
  Plan du Scénario: Parcours CANAL avec l'option deja une parabole - Livraison en point relais
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et L'on clique sur jai deja une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de la livraison en 72h en point relais
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | etat |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | avec |

  Plan du Scénario: Souscription Full 12 mois SAT G9 - recevoir la parabole
    Etant donné L'ouverture de la page souscription avec un propalId <propalId>
    Et Vérifier la présence entete page
    Et Vérifier la présence du panier flottant
    Lorsque L'on clique sur le décodeur Canal
    Et Vérification des éléments présents dans soucription décodeur canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 1h en boutique

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | etat | propalId  |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans | 000012248 |

  Plan du Scénario: Souscription Full 12 mois SAT G9 - a déjà une parabole
    Etant donné L'ouverture de la page souscription avec un propalId <propalId>
    Et Vérifier la présence entete page
    Et Vérifier la présence du panier flottant
    Lorsque L'on clique sur le décodeur Canal
    Et Vérification des éléments présents dans soucription décodeur canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 1h en boutique

    Exemples: 
      | civility | Prenom | Nom    | CodePostal | Adresse     | Mobile     | etat | propalId  |
      |        1 | ghtyht | CARPIN |      87000 | rthrthrthrt | 0666565656 | sans | 000012248 |

  ## Nouveaux scénarios
    @test4 @new
  Plan du Scénario: Souscription Full 12 mois decodeur Canal avec reception de parabole et avec retrait en boutique
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur CANAL
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 1h en boutique
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 |      |

  @test5 @new
  Plan du Scénario: Souscription Full 12 mois decodeur Canal sans prendre de parabole
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur CANAL
    Et L'on clique sur jai deja une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 1h en boutique
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 |      |
      
     @test6  @new
  Plan du Scénario: Souscription Full 12 mois decodeur Canal avec reception de parabole et avec livraison à domicile
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur CANAL
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 72h à domicile
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 |      |

  @test7  @new  
  Plan du Scénario: Souscription Full 12 mois decodeur Canal avec reception de parabole, livraison à domicile + modification d'adresse
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur CANAL
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix du retrait en 72h à domicile avec changement d'adresse <zipCodeBis>, <adresseBis>

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec | zipCodeBis | adresseBis       |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 | avec |      87000 | rue du spectacle |

  @test8  @new
  Plan du Scénario: Souscription Full 12 mois decodeur Canal avec reception de parabole et avec livraison en point de relais
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur CANAL
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix de la livraison en 72h en point relais
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 |      |

  @test9  @new
  Plan du Scénario: Souscription Full 12 mois decodeur Canal avec reception de parabole et installation à domicile
    Etant donné L'ouverture de la page
    Et Le choix d'un Décodeur TV
    Lorsque L'on choisit le Décodeur CANAL
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix de l'installation à domicile
    Alors Récapitulatif de l'offre
    Alors Validation du paiement par CB <status> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse        | Mobile     | avec |
      |        1 | Clara  | DAVIAUD |      75010 | clavier azerty | 0225623562 |      |
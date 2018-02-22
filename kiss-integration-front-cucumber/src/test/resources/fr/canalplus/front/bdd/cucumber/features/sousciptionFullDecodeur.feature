#language: fr
Fonctionnalité: Parcours souscription - Decodeurs CANAL

  ## Step recevoir une parabole ##
  @SPboutique @full
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole: Livraison en boutique
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

  @SPdomicile @full
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole: Livraison à domicile
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix du retrait en 72h à domicile
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | etat |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans |

  @SPrelais @full
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole: Livraison en point relais
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de la livraison en 72h en point relais
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | etat |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans |

  @SPinstallation @full
  Plan du Scénario: Parcours CANAL avec l'option recevoir ma parabole: installation à domicile
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur recevoir une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de l'installation à domicile
    Et Retour à la page mode de livraison

    Exemples: 
      | civility | Prenom | Nom    | CodePostal | Adresse              | Mobile     | etat |
      |        1 | Claude | CARPIN |      75001 | 13 Place de la Boule | 0166565656 | sans |

  ## j'ai deja une parabole ##
  @APboutique @full
  Plan du Scénario: Parcours CANAL avec l'option deja une parabole: Livraison en boutique
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix du retrait en 1h en boutique
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | etat |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | avec |

  @APdomicile @full
  Plan du Scénario: Parcours CANAL avec l'option deja une parabole: Livraison à domicile
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

  @APrelais @full
  Plan du Scénario: Parcours CANAL avec l'option deja une parabole: Livraison en point relais
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de la livraison en 72h en point relais
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | etat |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | avec |

  @TNTrelais @full
  Plan du Scénario: Parcours décodeur CANAL +LE CUBE: Livraison en point relais
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal plus Le Cube
    Et Verification des elements presents dans soucription tnt
    Alors Cliquer sur Continuer
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Choix de la livraison en 72h en point relais
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | civility | Prenom   | Nom       | CodePostal | Adresse            | Mobile     | etat |
      |        2 | Danielle | Firmament |      87000 | avenue de La Borie | 0666565654 | avec |

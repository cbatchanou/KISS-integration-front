#language: fr
Fonctionnalité: Parcours souscription - TNT

  @TNTrelais
  Plan du Scénario: Souscription Full 24 mois TNT - Livraison Point Relais
    Etant donné L'ouverture de la page souscription avec un propalId <propalId>
    Lorsque L'on choisit le Décodeur plus Le Cube
    Et Vérifier la présence du panier flottant
    Et Vérifier la présence entete page
    Et Vérification des éléments présents dans soucription tnt 24 mois
    Alors Cliquer sur Continuer
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix de la livraison en 72h en point relais
    Et Récapitulatif de la souscription TNT 24 mois
    Et Validation du paiement par CB <etat> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom   | Nom       | CodePostal | Adresse            | Mobile     | etat | propalId  |
      |        2 | Danielle | Firmament |      87000 | avenue de La Borie | 0666565654 | sans | 000017130 |

  Plan du Scénario: Souscription Full 24 mois TNT - Livraison à domicile et paiement IBAN
    Etant donné L'ouverture de la page souscription avec un propalId <propalId>
    Lorsque L'on choisit le Décodeur plus Le Cube
    Et Vérifier la présence du panier flottant
    Et Vérifier la présence entete page
    Et Vérification des éléments présents dans soucription tnt 24 mois
    Alors Cliquer sur Continuer
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix de la livraison en 72h en point relais
    Et Récapitulatif de la souscription TNT 24 mois
    Et Validation du paiement par CB <etat> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom       | CodePostal | Adresse | Mobile     | etat | propalId  |
      |        2 | ghkfuy | lujholiup |      75010 | adresse | 0666565654 | avec | 000017130 |

  Plan du Scénario: Souscription Full 24 mois TNT - en boutique et paiement IBAN
    Etant donné L'ouverture de la page souscription avec un propalId <propalId>
    Lorsque L'on choisit le Décodeur plus Le Cube
    Et Vérifier la présence du panier flottant
    Et Vérifier la présence entete page
    Et Vérification des éléments présents dans soucription tnt 24 mois
    Alors Cliquer sur Continuer
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Et Choix de la livraison en 72h en point relais
    Et Récapitulatif de la souscription TNT 24 mois
    Et Validation du paiement par CB <etat> IBAN
    Et Vérifier que les données de la page félicitation sont correctes

    Exemples: 
      | civility | Prenom | Nom     | CodePostal | Adresse | Mobile     | etat | propalId  |
      |        1 | Marion | guaopnu |      75010 | adresse | 0666565654 | avec | 000017130 |

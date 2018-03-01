#language: fr
Fonctionnalité: Parcours souscription - TNT

  @TNTrelais
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

#Author: carolle.batchanou@cpexterne.org
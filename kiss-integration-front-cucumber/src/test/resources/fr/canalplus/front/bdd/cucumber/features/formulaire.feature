#language: fr
Fonctionnalité: Automatisation des formulaires - Page souscription

  @DecCanalP @formulaire @Automate
  Plan du Scénario: CREATION DE COMPTE VALIDE - PARCOURS DECODEUR CANAL
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     |                
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 |

  @DecCanalSP @formulaire @Automate
  Plan du Scénario: CREATION DE COMPTE VALIDE - PARCOURS DECODEUR CANAL +LE CUBE
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal plus Le Cube
    Et Verification des elements presents dans soucription tnt
    Alors Cliquer sur Continuer
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire

    Exemples: 
      | civility | Prenom   | Nom       | CodePostal | Adresse            | Mobile     | 
      |        2 | Danielle | Firmament |      87000 | avenue de La Borie | 0666565654 |
      
  @identification @formulaire @Automate
  Plan du Scénario: IDENTIFICATION ABONNE: MESSAGE D'ERREURS SUITE A DES DONNEES ERRONNEES
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors cliquer sur le lien Identifiez-vous
    Et Renseigner un <email> et un <MotDePasse>
    Et Verifier les messages d'erreurs

    Exemples: 
      | email                | MotDePasse  |
      | zoedjezmo@fd.fr      | SDshgdsk    |
      | frenicasanarez@fd.fr | balalalalal |

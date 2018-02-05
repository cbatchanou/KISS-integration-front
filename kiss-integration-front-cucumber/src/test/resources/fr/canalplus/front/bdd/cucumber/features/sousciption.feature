#language: fr
Fonctionnalité: Parcours souscription - Decodeurs CANAL

  ## DECODEURS CANAL ##
  @DECCANALX @full
  Plan du Scénario: Parcours décodeur CANAL avec l'option recevoir ma parabole
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur recevoir une parabole
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>, <Email>, <MotDePasse>
    Alors Valider donc le formulaire

    Exemples: 
      | civility | Prenom   | Nom    | CodePostal | Adresse            | Mobile     | Email                | MotDePasse     |
      |        1 | celestin | CARPIN |      87000 | avenue de La Borie | 0666565656 | celestin@yopmail.com | blablabla12345 |

  @DECCANALY @full
  Plan du Scénario: Parcours décodeur CANAL avec l'option deja une parabole
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>, <Email>, <MotDePasse>
    Alors Valider donc le formulaire

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | Email               | MotDePasse     |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | carolle@yopmail.com | blablabla12345 |

  @DECTNT @full
  Plan du Scénario: Parcours décodeur CANAL +LE CUBE
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur le decodeur Canal plus Le Cube
    Et Verification des elements presents dans soucription tnt
    Alors Cliquer sur Continuer
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>, <Email>, <MotDePasse>
    Alors Valider donc le formulaire

    Exemples: 
      | civility | Prenom   | Nom       | CodePostal | Adresse            | Mobile     | Email                | MotDePasse     |
      |        2 | Danielle | Firmament |      87000 | avenue de La Borie | 0666565654 | danielle@yopmail.com | blablabla12345 |
  
  
   ## BOX INTERNET ##
   
   

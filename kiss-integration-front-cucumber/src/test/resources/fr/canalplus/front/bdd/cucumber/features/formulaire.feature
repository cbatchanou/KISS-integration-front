#language: fr
Fonctionnalité: Automatisation des formulaires - Page souscription

  @op12 @fai
  Plan du Scénario: FORMULAIRE VALIDE: souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne les champs nom et téléphone
    Alors Valider donc le formulaire

    Exemples: 
      | operateur |
      | FREE      |
      | BOUYGUES  |

  @op3 @fai
  Plan du Scénario: FORMULAIRE VALIDE: souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne les champs nom et téléphone
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Valider donc le formulaire

    Exemples: 
      | operateur |
      | ORANGE    |

  @op456 @fai
  Plan du Scénario: FORMULAIRE VALIDE: souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Valider donc le formulaire

    Exemples: 
      | operateur   |
      | SFR         |
      | NUMERICABLE |
      | AUTRE       |

  @DecCanalP @formulaire
  Plan du Scénario: CREATION DE COMPTE VALIDE - PARCOURS DECODEUR CANAL
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>, <Email>, <MotDePasse>
    Alors Valider donc le formulaire

    Exemples: 
      | civility | Prenom  | Nom       | CodePostal | Adresse            | Mobile     | Email               | MotDePasse     |
      |        2 | carolle | Firmament |      87000 | avenue de La Borie | 0666565656 | carolle@yopmail.com | blablabla12345 |

  @DecCanalSP @formulaire
  Plan du Scénario: CREATION DE COMPTE VALIDE - PARCOURS DECODEUR CANAL +LE CUBE
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal plus Le Cube
    Et Verification des elements presents dans soucription tnt
    Alors Cliquer sur Continuer
    Alors Je créé une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>, <Email>, <MotDePasse>
    Alors Valider donc le formulaire

    Exemples: 
      | civility | Prenom   | Nom       | CodePostal | Adresse            | Mobile     | Email                | MotDePasse     |
      |        2 | Danielle | Firmament |      87000 | avenue de La Borie | 0666565654 | danielle@yopmail.com | blablabla12345 |

  @identification @formulaire
  Plan du Scénario: IDENTIFICATION ABONNE: MESSAGE D'ERREURS SUITE A DES DONNEES ERRONNEES
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors cliquer sur le lien Identifiez-vous
    Et Renseigner un <email> et un <MotDePasse> <status>
    Et Verifier les messages d'erreurs

    Exemples: 
      | email                | MotDePasse  | status   |
      | zoedjezmo@fd.fr      | SDshgdsk    | invalide |
      | frenicasanarez@fd.fr | balalalalal | invalide |

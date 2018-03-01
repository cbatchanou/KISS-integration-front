#language: fr
@fai
Fonctionnalité: Parcours souscription - FAI

  @op12
  Plan du Scénario: Souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne les champs nom et téléphone
    Alors Validation du formulaire
    Alors Création d'une personne avec les données: <civility>, <Prenom>, <Nom>, <CodePostal>, <Adresse>, <Mobile>
    Alors Validation du formulaire
    Et Validation du recapitulatif du récap matériel <operateur>
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | operateur | civility | Prenom  | Nom    | CodePostal | Adresse             | Mobile     | etat |
      | BOUYGUES  |        1 | hjgfhjh | CARPIN |      87000 | avenue de La Borie  | 0666565656 | sans |
      | FREE      |        1 | Romane  | DIJON  |      75001 | 2 Rue de la liberté | 0266565656 | sans |

  @op3
  Plan du Scénario: Souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne les champs nom et téléphone
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Validation du formulaire
    Et Validation du recapitulatif du récap matériel <operateur>
    Et Validation du paiement par CB <etat> IBAN

    Exemples: 
      | operateur | civility | Prenom    | Nom    | CodePostal | Adresse            | Mobile     | etat |
      | ORANGE    |        1 | khjgfkhfk | CARPIN |      87000 | avenue de La Borie | 0666565656 | sans |

  @op456
  Plan du Scénario: Souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Validation du formulaire

    Exemples: 
      | operateur   |
      | SFR         |
      | NUMERICABLE |
      | AUTRE       |
      | SMARTTV     |

  Plan du Scénario: <operateur>: Cas d'un nom invalide et d'un téléphone valide
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et Saisir le cas d'un nom invalide et d'un téléphone valide: <nom>; <phone>

    Exemples: 
      | operateur | nom        | phone      |
      | FREE      | SDJHCE658  | 0156785634 |
      | BOUYGUES  | QKJFH234Lµ | 0156785634 |

  Plan du Scénario: <operateur>: Cas d'un nom valide et d'un téléphone invalide
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et Saisir le cas d'un nom valide et d'un téléphone invalide: <nom>; <phone>

    Exemples: 
      | operateur | nom         | phone    |
      | FREE      | BILLANCOURT | 01565634 |
      | BOUYGUES  | CLERMOND    |          |

  Plan du Scénario: <operateur>: cas d'un materiel vide et invalide
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et Saisir le cas d'un materiel vide et invalide: <nom>; <phone>; <materiel>
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Validation du formulaire

    Exemples: 
      | operateur | nom      | phone      | materiel      |
      | ORANGE    | qsdfqsfq | 0156453445 |               |
      | ORANGE    | kujyguy  | 0156453445 | 2345566776544 |

  Plan du Scénario: <operateur>: Cas d'un recap matériel vide: afficher les bons messages d'erreurs
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et Saisir le cas d'un nom et d'un téléphone vides

    Exemples: 
      | operateur |
      | FREE      |
      | BOUYGUES  |
      | ORANGE    |

  Plan du Scénario: <operateur>:
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne les champs nom et téléphone
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Validation du formulaire

    Exemples: 
      | operateur |
      | ORANGE    |

  Plan du Scénario: FORMULAIRE INVALIDE: souscription du materiel <operateur>
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur materiel <operateur>
    Et L'on renseigne le numéro de matériel <operateur>
    Alors Validation du formulaire

    Exemples: 
      | operateur   |
      | SFR         |
      | NUMERICABLE |
      | AUTRE       |

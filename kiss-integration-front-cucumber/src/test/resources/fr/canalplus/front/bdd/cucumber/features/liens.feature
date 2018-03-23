#language: fr
Fonctionnalité: Autmatisation des liens de la boutique

  @url
  Plan du Scénario: test de l'url
    Etant donné L'ouverture de la page souscription avec un propalId <propalId>

    Exemples: 
      | propalId  |
      | 000017130 |

  @liencanal @lien
  Scénario: Scénario de vérification du lien : En savoir plus sur les décodeurs CANAL
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur en savoir plus sur les decodeurs canal

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

  @lienIdent @lien
  Scénario: IDENTIFICATION ABONNE : VERFIER QUE LE LIEN FONCTIONNE CORRECTEMENT
    Etant donné L'ouverture de la page souscription
    Lorsque L'on clique sur le decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors cliquer sur le lien Identifiez-vous

  
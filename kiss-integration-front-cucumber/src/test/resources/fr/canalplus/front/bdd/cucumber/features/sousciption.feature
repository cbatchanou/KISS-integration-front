#language: fr
Fonctionnalité: Reset functionality on login page of Application

  @DECCANAL @opt-Para
  Scénario: Parcours de souscription décodeur CANAL avec l'option recevoir ma parabole
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur Le Decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur recevoir une parabole
    Alors Remplir tous les champs du formulaire

  @DECCANAL @opt-SPara
  Scénario: Parcours de souscription décodeur CANAL avec l'option deja une parabole
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur Le Decodeur Canal
    Et Verification des elements presents dans soucription decodeurs canal
    Et L'on clique sur jai deja une parabole
    Alors Remplir tous les champs du formulaire
    Et Retour a la page precedente

  @DECTNT
  Scénario: Parcours de souscription décodeur TNT
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Lorsque L'on clique sur materiel Le Cube
    Et Verification des elements presents dans soucription tnt
    Alors Remplir tous les champs du formulaire
    Alors Cliquer sur Continuer

  Scénario: Scénario de validation de la page: MyCanal Soucrire - Configuration matériel
    Etant donné L'ouverture de la page souscription
    Et Verifier la presence entete page
    Et Verifier la presence du panier flottant
    Et Verifier que tous les elements de la page sont presents

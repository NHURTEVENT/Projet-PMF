## Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

- 1. Cadrage du projet Table des matières
   - Charte projet
   - Plan de Management Projet (A5)
   - Cahier des charges (A2)
   - Planning (A1)
- 2. Réalisation du projet Analyse des risques (A4) Erreur! Signet non défini.
   - Définition de l’architecture (A1)
   - Sprint Meeting (A repeter) (A1)
   - Développement du code en fonction des cas de tests (A repeter) (A1)
   - Daily meeting (A repeter) (A1)
- 3. Clôture du projet
   - Validation des tests fonctionnels (A1)
   - Evaluation de la vélocité (A1)
   - REX du projet (A1)
   - Bilan (A1)
- 4. Annexes..........................................................................................................................................
   - Outils
   - Organisation


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

## 1. Cadrage du projet Table des matières

### Charte projet

#### OBJ ECT IF S ( A1)

- Création d’un frigo permettant de maintenir une température définie par l’utilisateur.
- Le changement de la température intérieure doit se faire de sorte à ce qu’aucune
    condensation ne se forme.
- Une alerte doit se déclencher si la porte reste ouverte pendant trop de temps.
- Le refroidissement ne doit pas prendre trop de temps à refroidir le contenu.
- Le frigo doit pouvoir être piloté par une application contenant une interface graphique
    o L’utilisateur doit pouvoir modifier la température de consigne,
    o L’interface doit afficher l’évolution des températures,
    o Une indication doit apparaitre pour chaque alertes (Humidité & Porte Ouverte).

#### ENJ EUX ( A2)

Application des connaissances des prosits précédents.

- Electronique (Montages des capteurs sur la carte Arduino),
- Thermodynamique (Fonctionnement d’un module Peltier),
- Informatique (Interface Homme Machine en Java).

#### MACRO R ISQU ES ( A4)

#### MACRO PLANNING ( ET APES) ( A1)

```
I- Analyse Fonctionnelle
II- Gestion de projet
III- Electronique
IV- Informatique
```
1. Code Java
    a) Modélisation (UML)
    b) Implémentation
2. Code Arduino
V- Livrables

#### ACT EUR S ( A1)

#### MACRO BU DGET ( A5)

#### DEF IN IT ION DES R ESPON SABILIT E ( A1)


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

### Plan de Management Projet (A5)

### Cahier des charges (A2)

#### BESOIN S

- Création d’un frigo permettant de maintenir une température définie par l’utilisateur.
- Le changement de la température intérieure doit se faire de sorte à ce qu’aucune
    condensation ne se forme.
- Une alerte doit se déclencher si la porte reste ouverte pendant trop de temps.
- Le refroidissement ne doit pas prendre trop de temps à refroidir le contenu.
- Le frigo doit pouvoir être piloté par une application contenant une interface graphique
    o L’utilisateur doit pouvoir modifier la température de consigne,
    o L’interface doit afficher l’évolution des températures,
    o Une indication doit apparaitre pour chaque alertes (Humidité & Porte Ouverte).

#### CONT RAINT ES

Utilisation du matériel fournit :

- Carte Arduino,
- Module Peltier,
- Corps du frigo.

Date limite :

- Vendredi 24 Novembre 2017.

#### CRIT ER ES D E R EU SSIT ES


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

Affichage des températures sur l’IHM

Possibilité de régler la consigne sur l’IHM

#### T EST S FO NCT ION N ELS

- Lecture port série
- Écriture port série
- Modification du model par la CAD
- Modification de la consigne par l’IHM
- Alerte humidité
- Alerte porte ouverte
- Affichage des informations dans l’IHM

### Planning (A1)

#### OBS

#### PBS

#### W BS


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

#### PERT

Version en ligne zoomable:

https://www.lucidchart.com/documents/edit/23d68692-8ccb- 4809 - a14c-2e99ee91843a?demo=on#?


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

#### GANTT

## 2. REALISATION DU PROJET

#### DEFINITION DE L’ARCHIT ECT UR E (A1)

#### DIAGR AMME D E COMPO SANT


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

#### DIAGR AMME D E PAQU ET AGE

### Sprint Meeting (A repeter) (A1)


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

#### CREATION D’UNE VERSION

#### EVALUAT ION D E LA VELOCIT E

#### PLANN ING PO KER

#### MOD ELISAT ION ET CR EATION DES T EST S

Diagramme de classe

Diagramme de séquence


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

Création des jeux de tests unitaires :

Problèmes rencontrés lors de la visualisation des tests à écrire pour la CAD

Test fonctionnels réalisés :

- Lecture port série
- Écriture port série
- Modification du model par la CAD
- Modification de la consigne par l’IHM
- Alerte humidité
- Alerte porte ouverte
- Affichage des informations dans l’IHM

#### DEVELOPPEMENT D U CODE EN FO NCT ION DES C AS D E T EST S ( A R EPET ER) ( A1)

Une branche par feature.

### Daily meeting (A repeter) (A1)

Point quotidien sur l’avancement basé sur les ‘commit’ de l’équipe

Revu de code aléatoire par le chef de projet

Point sur les difficultés

## 3. Clôture du projet

### Validation des tests fonctionnels (A1)

Test fonctionnels réalisés :


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

- Lecture port série
- Écriture port série
- Modification du model par la CAD
- Modification de la consigne par l’IHM
- Alerte humidité
- Alerte porte ouverte
- Affichage des informations dans l’IHM

#### EVALUAT ION D E LA VELOCIT E ( A1)

### REX du projet (A1)

- Intéressant de communiquer avec une arduino
- Intéressant de (re)voir les bases de la thermodynamique pour la vie courante

### Bilan (A1)

#### PLANN ING R EEL

## 4. Annexes..........................................................................................................................................


Plan des rapports de stage

David Trimoulet dtrimoulet@cesi.fr

# Gestion de projet Exia

### Outils

#### VER SIO NN ING

Github : https://github.com/NHURTEVENT/Projet-PMF

#### GEST ION D ES EXIG EN CES

Trello : https://trello.com/b/HxT3Whu1/projet-pmf

#### PLANN IFICAT ION

Trello : https://trello.com/b/HxT3Whu1/projet-pmf

### Organisation

#### SPR INT

Un sprint dure deux jours de travail pour ce projet

#### DAILY MEET ING

A chaque démarrage de demi-journée.



# 🚚 DeliveryMatch – Plateforme de Co-Transport Collaboratif

DeliveryMatch est une application web innovante qui met en relation des **conducteurs** et des **expéditeurs** de colis dans une logique de co-transport collaboratif. L’objectif est de **réduire les coûts**, **optimiser les trajets** et **minimiser l’impact environnemental** en utilisant des trajets déjà planifiés.

---

## 🧠 Objectifs

- 💸 Réduction des coûts de transport
- ♻️ Moins d’émissions de CO₂
- 📦 Meilleure gestion logistique pour les particuliers et professionnels
- 🤝 Économie collaborative entre utilisateurs

---

## 🧰 Stack Technique

| Frontend                | Backend                            | Autres                                |
|-------------------------|-------------------------------------|----------------------------------------|
| Angular 16+             | Spring Boot                         | Docker                                 |
| Angular Material        | Spring Security (JWT)               | Swagger / Postman                      |
| TailwindCSS / Bootstrap | Spring Data JPA                     | Git / GitHub                           |
| Chart.js                | PostgreSQL / MySQL                  | JUnit (Tests unitaires)                |

---

## ✅ Fonctionnalités Clés

### 🔐 Authentification & Utilisateur
- Création de compte et connexion sécurisée
- JWT Token via Spring Security
- Gestion du profil utilisateur (update, rôle, mot de passe)

### 📦 Expéditeur
- Rechercher des trajets disponibles
- Envoyer une demande de transport
- Suivre les demandes & consulter l’historique
- Laisser une évaluation au conducteur

### 🚗 Conducteur
- Publier une annonce de trajet (lieu de départ, étapes, destination…)
- Voir les demandes reçues pour chaque trajet
- Accepter / Refuser une demande selon disponibilité
- Consulter l’historique des trajets effectués
- Évaluer les expéditeurs

### 🛠️ Administrateur
- Dashboard de gestion des utilisateurs, annonces, et demandes
- Validation, suspension ou suppression de comptes
- Statistiques et reporting avec Chart.js
- Supervision des performances générales

---

## 👤 User Stories (Extrait)

- En tant qu’utilisateur, je veux créer un compte et me connecter.
- En tant qu’expéditeur, je veux rechercher un trajet et envoyer une demande.
- En tant que conducteur, je veux publier un trajet et gérer les demandes reçues.
- En tant qu’administrateur, je veux avoir une vue d’ensemble de l’activité sur la plateforme.

---

## 🧩 Diagrammes UML

- 📌 Cas d’Utilisation
  ![image](https://github.com/user-attachments/assets/1c7b0eaf-47d2-4dfb-b85e-7f5831a8a3e9)
- 📌 Diagramme de Classe
  ![image](https://github.com/user-attachments/assets/1c2e67ba-dbf4-4b29-96bf-29430530d2d1)
- 📌 Séquence (publication trajet, acceptation demande, etc.)
  ![image](https://github.com/user-attachments/assets/dc274d2f-0aad-4e7b-89ac-953760ba0d39)
- 📌 Base de données (ERD)


---

## 🚀 Lancement du projet

### Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run

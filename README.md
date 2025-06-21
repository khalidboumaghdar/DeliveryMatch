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
  ![image](https://github.com/user-attachments/assets/415268dc-b259-446b-9b49-d6f1e98ae8fe)
- 📌 Diagramme de Classe
![image](https://github.com/user-attachments/assets/4baf871b-cace-4101-bc2f-1d538ded9812)
- 📌 Séquence (publication trajet, acceptation demande, etc.)
![image](https://github.com/user-attachments/assets/5d32b62d-f1d5-41b8-be36-1344c3fa04f9)
- 📌 Base de données (ERD)


---

## 🚀 Lancement du projet

### Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run

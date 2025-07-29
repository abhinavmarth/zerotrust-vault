# 🔐 Zero Trust Password Vault

A secure and scalable **password management system** built using **Spring Boot**, **Firebase Authentication**, and **MySQL**. This app allows users to register, log in securely, and manage their credentials (like Gmail, LinkedIn, etc.) in an encrypted and private vault.

---

## 🚀 Features

- 🔑 Firebase Authentication (Email/Password)
- 📦 Store and manage password entries
- 🔐 Secure API with token-based validation
- 📄 MySQL database integration with JPA
- 📁 JWT token verification (via Firebase Admin SDK)
- ☁️ Backend-only project (API ready for frontend integration)

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot (Java)
- **Authentication**: Firebase Auth
- **Database**: MySQL (JPA/Hibernate)
- **Build Tool**: Maven
- **Security**: Token-based Auth, Service Account Key

---

## 📁 Folder Structure

src/
└── main/
├── java/
│ └── com/yourapp/vault/
└── resources/
├── application.properties
└── firebase-adminsdk.json (ignored)

yaml
Copy
Edit

---

## 🔒 Security

- Tokens validated using Firebase Admin SDK
- `serviceAccountKey.json` is ignored using `.gitignore`
- JWT decoded and verified for every secured endpoint

---

## 🧾 Setup Instructions

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourname/zero-trust-vault.git
   cd zero-trust-vault
Add Firebase credentials

Download your Firebase serviceAccountKey.json

Place it in src/main/resources/

Make sure it’s ignored in .gitignore

Configure application.properties

properties
Copy
Edit
firebase.database.url=https://your-project-id.firebaseio.com
spring.datasource.url=jdbc:mysql://localhost:3306/password_db
spring.datasource.username=root
spring.datasource.password=your_password
Run the application

bash
Copy
Edit
mvn spring-boot:run

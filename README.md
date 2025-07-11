# 🏥 Hospital Management System

A complete Java-based Hospital Management System with MySQL backend.\
Supports role-based dashboards for **Admin**, **Doctor**, **Pharmacist**, and **Receptionist**.

---

## ✨ Features

- 🔑 Secure login with role-based access
- 🗂️ Patient management
- 🩺 Medical records management
- 📅 Appointment scheduling
- 💊 Inventory and prescriptions management
- 💵 Billing and payments
- 👥 Staff and user management
- 📊 Separate dashboards for each role

---

## 🚀 Technologies

- **Java (Swing GUI)**
- **MySQL Database**
- **JDBC** for database connectivity

---

## ⚙️ Setup

### ✅ Prerequisites

- Java JDK 17 or higher
- MySQL Server
- MySQL Connector/J (already included as `lib/mysql-connector-j-9.3.0.jar`)

---

### 💾 Database Setup

1️⃣ Create the database:

```sql
CREATE DATABASE hospital_db;
```

2️⃣ Import the schema:

```sql
SOURCE path/to/your/schema_final.sql;
```

3️⃣ Check tables:

```sql
USE hospital_db;
SHOW TABLES;
```

---

### 💻 Running the application

```bash
javac -cp ".;lib/mysql-connector-j-9.3.0.jar" src\models\*.java src\controllers\*.java src\views\*.java
java -cp ".;lib/mysql-connector-j-9.3.0.jar;src" Main
```

---

### 👤 Login Credentials (Sample Users)

| Username  | Password | Role         |
| --------- | -------- | ------------ |
| admin1    | admin123 | admin        |
| docjohn   | doc123   | doctor       |
| pharmzara | pharm123 | pharmacist   |
| recepali  | recep123 | receptionist |

---

## 🖥️ Folder Structure

```
src/
├── models/        # Database models
├── controllers/   # Business logic
├── views/         # GUI screens
├── core/          # Core classes (e.g., DB connection)
```

---

## 💬 Contribution

Feel free to fork, modify, and contribute to improve the system!

---

## ❤️ Acknowledgments

Developed as part of a Software Construction Project.\
Thanks to everyone who contributed and helped test the system!

---



# 🏏 Cricket Fantasy Team

A **full-stack web application** that allows users to **search cricket players, view their stats, and create their fantasy team**.  
Built with **Spring Boot (Java)** for the backend and **React** for the frontend.

---

## ✨ Features

- Search players by **name**, **country**, or **position**.
- Display players and their stats in a **beautiful responsive table**.
- Add players to your **fantasy team**.
- Full **CRUD support** (Create, Read, Update, Delete) for players.
- **PostgreSQL** database integration.

---

## 🛠️ Tech Stack

### **Frontend**
- React.js
- Axios (for API calls)
- TailwindCSS / Custom CSS

### **Backend**
- Java
- Spring Boot 
- Spring Data JPA & Hibernate
- PostgreSQL
- Maven

---

## 🚀 Getting Started

### **1. Clone the Repository**
```bash
git clone https://github.com/badarali5/cricket-fantasy-team.git
cd cricket-fantasy-team
```

### **2. Backend (Spring Boot)**

Navigate to the backend folder:
```bash
cd cricket-zone
```

Configure your `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cricket
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Run the backend server:
```bash
mvn spring-boot:run
```

Backend will start on:  
`http://localhost:8080/`

### **3. Frontend (React)**

Navigate to the React folder:
```bash
cd cricket-frontend
```

Install dependencies:
```bash
npm install
```

Start the React app:
```bash
npm start
```

Frontend will start on:  
`http://localhost:3000/`

---

## 🔗 API Endpoints (Sample)
- `GET /player` – Fetch all players  
- `GET /player?name=Virat` – Search players by name  
- `POST /player` – Add a player  
- `PUT /player` – Update player details  
- `DELETE /player/{playerName}` – Delete a player  

---

## 🔮 Future Enhancements
- **JWT Authentication** for secure login.  
- **Leaderboard system** for fantasy teams.  
- **Interactive player stats dashboard** (charts with Chart.js or Recharts).  
- **Dockerized setup** for deployment.  

---

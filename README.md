# Library Management System (QA-4)

## 📌 Project Overview
The **Library Management System** is a mini project developed as part of  
**Qualitative Assessment 4 (QA-4)**.  
It is a desktop-based application built using **JavaFX** for the user interface
and **MySQL** for database storage, connected via **JDBC**.

The system allows users to **add, view, update, and delete books** from the
library database using a clean and interactive JavaFX UI.

---

## 🛠️ Technologies Used
- **Java**: Java 23
- **JavaFX**: JavaFX SDK 25.0.2
- **Database**: MySQL 8.x
- **JDBC Driver**: mysql-connector-j 8.0.33
- **IDE**: Visual Studio Code

---

## 📂 Project Structure
Java_QA4/
│
├── .vscode/
│   └── launch.json
│
├── database/
│   └── library_db.sql
│
├── lib/
│   └── mysql-connector-j-8.0.33.jar
│
├── src/
│   ├── app/
│   │   └── Main.java
│   │
│   ├── controller/
│   │   └── BookController.java
│   │
│   ├── model/
│   │   └── Book.java
│   │
│   ├── util/
│   │   └── DBUtil.java
│   │
│   └── view/
│       └── BookView.java
│
├── .gitignore
├── README.md



---

## 🗄️ Database Design

### Database Name

### Table: `books`
| Column Name | Data Type | Description |
|------------|----------|-------------|
| book_id | INT (PK) | Unique Book ID (manual, reusable) |
| title | VARCHAR(100) | Book title |
| author | VARCHAR(100) | Book author |

⚠️ **Note:**  
`AUTO_INCREMENT` is intentionally NOT used.  
Deleted book IDs are reused by implementing custom logic in Java.

---

## 🔁 CRUD Operations Implemented
- **Create**: Add a new book
- **Read**: View all books using TableView
- **Update**: Update selected book details
- **Delete**: Delete selected book

All operations are triggered from the **JavaFX UI** and executed using **JDBC**.

---

## ▶️ How to Run the Project (VS Code)

### 1️⃣ Compile the Project
Run this command from the project root:

```bat
javac ^
--module-path "C:\Program Files\javafx-sdk-25.0.2\lib" ^
--add-modules javafx.controls,javafx.fxml ^
-cp "lib\mysql-connector-j-8.0.33.jar" ^
-d out ^
src\app\Main.java ^
src\controller\*.java ^
src\model\*.java ^
src\util\*.java ^
src\view\*.java

### 2 Compile the Project
java ^
--module-path "C:\Program Files\javafx-sdk-25.0.2\lib" ^
--add-modules javafx.controls,javafx.fxml ^
-cp "out;lib\mysql-connector-j-8.0.33.jar" ^
app.Main

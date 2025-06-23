# 📝 TaskCrudJDBC

**TaskCrudJDBC** is a simple Java console application that allows you to perform basic CRUD (Create, Read, Update, Delete) operations on a task database using plain JDBC. It’s perfect as a base for task management systems or for practicing Java-MySQL integration without frameworks.

---

## 🚀 Features

- 📌 Add new tasks with name, status, priority, and due date
- 📄 List all registered tasks
- ✏️ Update task information
- 🗑️ Delete tasks by ID
- 📅 Handles automatic registration and due dates
- 🔐 Uses `PreparedStatement` for SQL injection protection

---

## 🧑‍💻 Requirements

- Java 8 or higher
- MySQL 5.7+
- (Optional) Maven

---

## ⚙️ Setup Instructions

### 1. Create the database and table

Ensure you have a MySQL database and run the following SQL to create the `tasks` table:

```sql
CREATE TABLE tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL DEFAULT 'new task',
  register_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status ENUM('INBOX') NOT NULL DEFAULT 'INBOX',
  due_date DATETIME DEFAULT NULL,
  priority ENUM('LOW', 'MEDIUM') DEFAULT 'LOW'
);
```
### 2. Configure the database connection

Open the file:
``` src/main/java/org/jdbc/util/DatabaseConn.java ```
and replace the connection credentials with your actual database details:

```java
private static final String URL = "jdbc:mysql://localhost:3306/your_database";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

---
## ▶️ How to Run
You can run the project from your IDE (IntelliJ, Eclipse, etc.) or via the terminal.

### Compile
```bash
javac -d bin src/main/java/org/jdbc/**/*.java
```

### Run
```bash
java -cp bin org.jdbc.Main
```
---
## 🤝 Contributing
- Want to improve this project? Contributions are welcome! You could:

- Add new features (filters, sorting, validations)

- Improve the input experience

- Refactor the structure or add a GUI (Swing, JavaFX)

---
## 🧠 Author
Hernani JG
https://github.com/hernanijg
Passionate about backend development and clean, scalable Java solutions.
# Vox: Freedom

**Vox: Freedom** is a lightweight Spring Boot application that allows users to create posts and view posts by others. The app features user authentication, CRUD operations for posts, and transactional operations involving multiple tables.

---

## Table of Contents

* [Features](#features)
* [Technologies](#technologies)
* [Getting Started](#getting-started)

  * [Prerequisites](#prerequisites)
  * [Installation](#installation)

    * [Linux / MacOS](#linux--macos)
    * [Windows](#windows)
  * [Database Setup](#database-setup)

    * [Linux (Ubuntu/Debian)](#linux-ubuntudebian)
    * [Windows](#windows-1)
* [Configuration](#configuration)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)

---

## Features

* User Authentication & Authorization
* CRUD operations for posts (Create, Read, Update, Delete)
* At least one transaction spanning multiple tables

---

## Technologies

* **Java 21**
* **Spring Boot 4.0.0**
* **MariaDB**
* **Maven**

---

## Getting Started

### Prerequisites

* Java 21 installed
* Maven installed
* MariaDB database installed

---

### Installation

#### Linux / MacOS

```bash
git clone <repository-url>
cd vox
./mvnw spring-boot:run
```

#### Windows (PowerShell or Command Prompt)

```powershell
git clone <repository-url>
cd vox
mvnw.cmd spring-boot:run
```

---

### Database Setup

#### Linux (Ubuntu/Debian)

1. **Install MariaDB**

```bash
sudo apt update
sudo apt install mariadb-server mariadb-client -y
```

2. **Start and enable MariaDB service**

```bash
sudo systemctl start mariadb
sudo systemctl enable mariadb
```

3. **Secure the installation**

```bash
sudo mysql_secure_installation
```

Follow the prompts to set a root password and remove anonymous users.

4. **Create the database and user**

```bash
sudo mariadb -u root -p
```

Inside the MariaDB shell:

```sql
CREATE DATABASE freedomwall;
CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON freedomwall.* TO 'your_username'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

#### Windows

1. **Download and install MariaDB**
   [MariaDB Official Downloads](https://mariadb.org/download/)

2. **Start MariaDB**
   Open the **Services** app, locate `MariaDB`, and ensure it is running.

3. **Create the database and user**

Open **MariaDB Command Line Client** or `cmd`:

```sql
CREATE DATABASE freedomwall;
CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON freedomwall.* TO 'your_username'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

4. **Update application properties** with your database credentials.

---

## Configuration

Update `application.properties` or `application.yml` with your database and app settings:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/freedomwall
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

You can also customize other settings like server port or security configurations in the same file.

---

## Usage

1. Visit the application at [http://localhost:8080](http://localhost:8080)
2. Register and log in
3. Create posts
4. Browse posts created by other users

> All interactions are through the web interface; no public API endpoints are exposed.

---

## Contributing

1. Fork the repository
2. Create a new branch for your feature/fix
3. Commit your changes
4. Submit a pull request

---

## License

This project is licensed under the **MIT License**.

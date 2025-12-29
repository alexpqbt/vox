# Vox: Freedom

[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.0-green?logo=spring)](https://spring.io/projects/spring-boot)
[![MariaDB](https://img.shields.io/badge/MariaDB-10.11-blue?logo=mariadb)](https://mariadb.org/)

**Vox: Freedom** is a lightweight Spring Boot application for creating and viewing posts with user authentication, CRUD operations, and transactional support across multiple tables.

---

## Quick Start

1. Clone the repository:

```bash
git clone <repository-url>
cd vox
```

2. Configure your database credentials in `application.properties` (see [Configuration](#configuration))

3. Run the application:

* **Linux / MacOS**:

```bash
./mvnw spring-boot:run
```

* **Windows (PowerShell / Command Prompt)**:

```powershell
mvnw.cmd spring-boot:run
```

4. Open [http://localhost:8080](http://localhost:8080) in your browser

---

## Table of Contents

* [Features](#features)
* [Prerequisites](#prerequisites)
* [Installation](#installation)
* [Database Setup](#database-setup)
* [Configuration](#configuration)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)

---

## Features

* User authentication & authorization
* CRUD operations for posts
* Transactional operations spanning multiple tables

---

## Prerequisites

| Tool    | Required Version | Installation Notes                               |
| ------- | ---------------- | ------------------------------------------------ |
| Java    | 21               | [Download](https://www.oracle.com/java/)         |
| Maven   | Latest           | [Install](https://maven.apache.org/install.html) |
| MariaDB | 10+              | [Download](https://mariadb.org/download/)        |

---

## Installation

Clone the repository and run the application:

* **Linux / MacOS**:

```bash
git clone <repository-url>
cd vox
./mvnw spring-boot:run
```

* **Windows (PowerShell / CMD)**:

```powershell
git clone <repository-url>
cd vox
mvnw.cmd spring-boot:run
```

---

## Database Setup

### Linux (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install mariadb-server mariadb-client -y
sudo systemctl start mariadb
sudo systemctl enable mariadb
sudo mysql_secure_installation
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

### Windows

1. Download and install MariaDB: [MariaDB Downloads](https://mariadb.org/download/)
2. Ensure the `MariaDB` service is running
3. Open **MariaDB Command Line Client** or `cmd`:

```sql
CREATE DATABASE freedomwall;
CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON freedomwall.* TO 'your_username'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

---

## Configuration

Set database connection and JPA options in `application.properties`:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/freedomwall
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

Other settings such as server port and security options can also be configured here.

---

## Usage

1. Navigate to [http://localhost:8080](http://localhost:8080)
2. Register a new account and log in
3. Create, read, update, or delete posts
4. Browse posts created by other users

> All interactions occur through the web interface; no public API endpoints are provided.

---

## Contributing

1. Fork the repository
2. Create a new branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m "Add some feature"`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Submit a pull request

# Vox: Freedom

Vox: Freedom is a simple Spring Boot application that allows users to create posts and enables other logged-in users to read them. The app includes user authentication, CRUD functionality, and transactional operations involving multiple tables.

## Features

* User Authentication & Authorization
* CRUD functionality for posts
* At least one transaction spanning multiple tables

## Technologies

* Java 21
* Spring Boot 4.0.0
* MariaDB
* Maven

## Getting Started

### Prerequisites

* Java 21 installed
* Maven installed
* MariaDB database

### Installation

#### On Linux/MacOS

```bash
git clone <repository-url>
cd vox
./mvnw spring-boot:run
```

#### On Windows (PowerShell or Command Prompt)

```powershell
git clone <repository-url>
cd vox
mvnw.cmd spring-boot:run
```

### Database Setup

#### On Linux (Ubuntu/Debian)

1. **Install MariaDB**:

```bash
sudo apt update
sudo apt install mariadb-server mariadb-client -y
```

2. **Start and enable MariaDB service**:

```bash
sudo systemctl start mariadb
sudo systemctl enable mariadb
```

3. **Secure MariaDB installation**:

```bash
sudo mysql_secure_installation
```

Follow the prompts to set a root password and remove anonymous users.

4. **Create the database and user**:

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

#### On Windows

1. **Download MariaDB**:
   Go to the [MariaDB official downloads page](https://mariadb.org/download/) and download the Windows installer.

2. **Install MariaDB**:
   Run the installer and follow the steps. Set a root password when prompted.

3. **Start MariaDB**:
   Open the **Services** app, locate `MariaDB`, and make sure it is running. Alternatively, use `mariadb.exe` from the installation folder.

4. **Create the database and user**:
   Open the **MariaDB Command Line Client** (or `cmd`) and enter:

```sql
CREATE DATABASE freedomwall;
CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON freedomwall.* TO 'your_username'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

After this, update your `application.properties` with the username, password, and database name.

The application will start on `localhost:8080` unless otherwise configured.

## Configuration

The application uses `application.properties` (or `application.yml`) to configure database and other settings. At minimum, you will need to set:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/freedomwall
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

Other configuration options, such as server port or security settings, can also be customized in the same file.

## Usage

Once running, users can:

1. Register an account and log in.
2. Create posts.
3. Read posts from other users.

Since this is an internal app, no public API endpoints are exposed. All interactions are through the web interface.

## Contributing

1. Fork the repository
2. Create a new branch for your feature/fix
3. Commit your changes
4. Submit a pull request

## License

This project is licensed under the MIT License.
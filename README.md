# 🏦 Banking System using JDBC and MySQL

Welcome to the 🏦 Banking System repository! This project implements a simple banking system in Java, utilizing JDBC for database connectivity and MySQL as the backend database.

## Overview

This banking system allows users to perform various banking operations such as registration, login, balance inquiry, deposit, withdrawal, and funds transfer.

## Features

- 📝 **User Registration**: Users can create new accounts by providing their full name, email, and password.
- 🔒 **User Login**: Registered users can log in using their email and password.
- 💼 **Account Management**: Users can open new bank accounts, inquire about their account balance, and perform deposit, withdrawal, and funds transfer operations.
- 🔐 **Secure Transactions**: Transactions are secured using a security pin associated with each account.

## Technologies Used

- ☕ Java
- 💾 JDBC (Java Database Connectivity)
- 🗄️ MySQL

## Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/your-username/banking-system.git

```
1. Import the project into your preferred Java IDE.

2. Set up MySQL database:

  - Install MySQL Server if not already installed.
  - Create a new database named banking_system.
  - Import the banking_system.sql file located in the database folder to initialize the database schema and sample data.
3. Configure MySQL connection:

  - Open src/main/java/com/bank/utils/DBConnection.java.
  - Modify the url, username, and password variables according to your MySQL server configuration.
4. Build and run the project.

Usage
 Run the application.
 Register as a new user or log in with existing credentials.
 Perform various banking operations such as deposit, withdrawal, balance inquiry, and funds transfer.
 
Code Structure
📁 BankingApp.java: Main class containing the entry point of the application and the main menu for user interaction.
📁 User.java: Class for user registration and login functionalities.
📁 Accounts.java: Class for managing user accounts, including account creation and existence checks.
📁 AccountManager.java: Class for managing account-related operations such as deposit, withdrawal, funds transfer, and balance inquiry.
Contributions
🎉 Contributions are welcome! If you have any suggestions or want to report a bug, please open an issue or create a pull request.

License
This project is licensed under the MIT License.




#java #corejava #jdbc #mysql #mysqlqueries

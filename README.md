# Library-Management-System

This is a Library Management System implemented in Java 7. It helps librarians manage books, patrons, lending processes, and supports multiple library branches. The system demonstrates Object-Oriented Programming (OOPs), SOLID principles, and uses Factory and Observer design patterns.

Features:
1) Book Management
2) Patron Management
3) Lending process
4) Inventory Management
5) Multi-branch Support (Optional Extension)

Concepts Used:
1) Inheritance, Encapsulation, Polymorphism, Abstraction
2) SOLID principles
3) Factory Pattern (Creating book instances) and Observer pattern (Logging checkout and return events)

Folder / Project structure:

library/
├── Main.java
├── model/
│   ├── Book.java
│   ├── Patron.java
│   ├── Branch.java
├── service/
│   ├── BookService.java
│   ├── PatronService.java
│   ├── LendingService.java
│   ├── BranchService.java
├── factory/
│   └── BookFactory.java
├── observer/
│   ├── Event.java
│   ├── EventListener.java
│   ├── EventManager.java
│   └── ConsoleLoggerListener.java
└── util/
    └── LoggerUtil.java

<img width="940" height="1279" alt="UML Diagram" src="https://github.com/user-attachments/assets/c9e41e9d-8c67-4973-a644-4bf00e6389ce" />

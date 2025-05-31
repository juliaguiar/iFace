# iFace

**iFace** is a simple social network application that runs entirely through the terminal. Built with Java and Maven, it allows users to interact in a text-based environment by creating profiles, managing friendships, sending messages, and more.

## Features

- Create and manage user profiles  
- Add and remove friends  
- Send and receive messages  
- Create and join communities  
- View user and community information  
- Simple menu navigation via terminal

## Technologies

- **Java**  
- **Maven** (build and dependency management)  
- **Object-Oriented Design**  

## Project Structure

- `model/` – Domain classes (User, Message, Community, etc.)  
- `controller/` – Business logic and user actions  
- `view/` – Terminal interface  
- `dao/` – Simple data handling (in-memory)  
- `exception/` – Custom exception handling  

## How to Run

1. Make sure you have **Java 17+** and **Maven** installed.
2. Clone the repository:

   ```bash
   git clone https://github.com/juliaguiar/iFace.git

3. Navigate to the project root (where pom.xml is located) and run:

    ```bash
    mvn clean install
    
This will download the dependencies and compile the project.

 4. Run the application:

    ```bash
    java -cp target/iface-0.0.1-SNAPSHOT.jar br.com.ufal.ic.iface.view.Login
    

This is a learning-focused project and does not persist data between sessions.

Designed to reinforce object-oriented principles and basic Java architecture.

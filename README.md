# Library Management System

## Setup and Run Instructions

To set up and run this project, follow these steps:

1. **Clone the repository into your IDE:**
    ```sh
    git clone https://github.com/clapathiotis/LibraryManagement.git
    cd LibraryManagement
    ```

2. **Ensure you have the following installed:**
    - **Maven:** You can download it from [Maven's official website](https://maven.apache.org/download.cgi). Check Maven was installed by running:
       ```sh
        mvn -version
       ```
    - **Node.js:** Download it from [Node.js official website](https://nodejs.org/). Check it was installed by running:
       ```sh
        node -v
       ```
    - **Java 17 or later:** Download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html). Check version with:
       ```sh
        java -version
       ```
    - **Spring Boot:** Follow the instructions on [Spring Boot's official website](https://docs.spring.io/spring-boot/installing.html) to set it up with Maven.
      ```sh
      brew install spring-boot (MACOS)
      ```
    - **Angular CLI:** Install it globally using npm:
      ```sh
      npm install -g @angular/cli
      ```
      Note: In order to use npm commands, installing Node is a prerequisite.

3. **Move to the library_app folder by:**
    ```sh
    cd ./library_app
    ```

4. **Build the project:**
    ```sh
    mvn clean install
    ```

5. **Run the application:**
First run the npm run build command and then the sprint boot command (Tip: You may use 2 terminals for this in same directory)
    ```sh
    npm run build
    mvn spring-boot:run
    ```

6. **Access the application:**
    Open your browser and navigate to `http://localhost:8080`.


7. **Runnning the tests:**
Make sure you are on the library_app direrctory and run the command
    ```sh
    mvn test
    ```

Through your IDE you can also run the tests/sprinng boot as long as you navigate to the LibraryAppApplication.java for springboot and test folder respectively.

That's it! You should now have the application up and running.

![image](https://github.com/user-attachments/assets/af0de397-d74e-4e7b-921c-ad120ea12b1c)

Tests run:
![image](https://github.com/user-attachments/assets/daca1150-4c36-4eda-90e1-71c03c52d4bc)
![image](https://github.com/user-attachments/assets/bd5eb0cf-0d50-432b-a277-509cd682c509)

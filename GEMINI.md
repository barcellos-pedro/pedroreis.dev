# Project Overview

This is a portfolio Java web application that displays project statistics, with a traditional MVC architecture using Spring Boot controllers, models, and JTE templates for the view layer.

The application fetches repository data from the GitHub API, stores it in a local SQLite database, and displays it on the website.

## Technologies

*   **Backend:** Java 25, Spring Boot 3.5.7
*   **Frontend:** JTE (Java Template Engine) 3.2.1, HTML, CSS
*   **Database:** SQLite
*   **Build:** Maven
*   **Deployment:** Docker, GitHub Actions

## Architecture

The application follows a traditional Model-View-Controller (MVC) architecture:

*   **Model:** The data layer, represented by classes in `src/main/java/com/pedroreis/dev/model`, which map to database tables.
*   **View:** The presentation layer, implemented using JTE templates located in `src/main/jte`.
*   **Controller:** The request-handling layer, consisting of Spring Boot controllers in `src/main/java/com/pedroreis/dev/controller` that process user input, interact with the model, and select the appropriate view to render.

### Data Flow

1.  The `GithubClient` fetches repository data from the GitHub API.
2.  The data is stored in the SQLite database.
3.  Controllers retrieve data from the database via the models.
4.  The data is passed to the JTE templates.
5.  The JTE templates are rendered as HTML and sent to the browser.

### Key Directories

*   `src/main/java`: Contains the Java source code for the application.
*   `src/main/resources`: Contains the application's resources, such as configuration files, database schema, and static assets.
*   `src/main/jte`: Contains the JTE templates for the view layer.
*   `target`: Contains the compiled application code and build artifacts.

## Building and Running

### Prerequisites

*   Java 25
*   Maven

### Running Locally

1.  Clone the repository.
2.  Run the application with `mvn spring-boot:run`.
3.  The application will be available at `http://localhost:8080`.

### Building for Production

1.  Run `mvn clean package` to build the application JAR file.
2.  The JAR file will be located in the `target` directory.

### Running with Docker

1.  Build the Docker image with `docker build -t pedroreis.dev .`.
2.  Run the Docker container with `docker run -p 8080:8080 pedroreis.dev`.

## Development Conventions

*   The project follows the standard Spring Boot project structure.
*   JTE templates are used for the view layer.
*   The application uses a `GithubClient` to fetch data from the GitHub API.
*   The data is stored in an SQLite database.
*   The database schema is defined in `src/main/resources/schema.sql`.
*   Initial data is inserted from `src/main/resources/data.sql`.

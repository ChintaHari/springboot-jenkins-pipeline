# Spring Boot with Jenkins Pipeline Project

## Introduction
This project demonstrates the use of Jenkins Continuous Integration/Continuous Deployment (CI/CD) pipeline with a Spring Boot application to automate the building, testing, and deployment phases. The application is a simple Spring Boot REST service, which displays a message indicating that the Jenkins pipeline is operational.

## System Design
The CI/CD process is depicted as follows:
1. **Commit Code**: Developers commit code to the GitHub repository.
2. **Jenkins CI/CD**: Jenkins automates the process of building the Maven project, building the Docker image, and pushing the image to Docker Hub.

![System Design](/images/Architecture.jpg)

## Pre-requisites
- Java 17
- Maven 3.9.8
- Docker
- Jenkins with Maven and Docker plugins installed
- Access to a Docker Hub repository

## Project Structure
- `SpringbootJenkinsPipelineApplication.java`: Entry point for the Spring Boot application.
- `pom.xml`: Maven build file with dependencies and build configuration.
- `Dockerfile`: Instructions for building the Docker image of the application.
- `Jenkinsfile`: Defines the Jenkins pipeline configuration.

## Setup and Configuration

### Step 1: Clone the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/ChintaHari/springboot-jenkins-pipeline.git
cd springboot-jenkins-pipeline
```

### Step 2: Build the Project with Maven
Navigate to the project directory and run:

```bash
mvn clean install
```

This command builds the project and generates a `.jar` file under the `target` directory.

### Step 3: Building the Docker Image
Run the following command to build the Docker image:

```bash
docker build -t <your_dockerhub_username>/springboot-jenkins-pipeline .
```

### Step 4: Push the Image to Docker Hub
Login to Docker Hub and push the image:

```bash
docker login -u <your_dockerhub_username> -p <your_password>
docker push <your_dockerhub_username>/springboot-jenkins-pipeline
```


## Jenkins Pipeline Steps

### Step 1: Configure Jenkins
- Add credentials for GitHub and Docker Hub in Jenkins.
- Configure Maven in Jenkins global tool configuration.

### Step 2: Create a New Pipeline Job
- Select 'New Item', enter a name for the job, and choose 'Pipeline'.
- Under the pipeline definition, select 'Pipeline script from SCM'.
- Set SCM to 'Git' and enter the repository URL and credentials.
- Paste the Jenkinsfile path or script directly if you are using the script approach.

### Step 3: Run the Pipeline
- Build the pipeline manually for the first time or trigger automatically upon code commit.
- The pipeline executes the following stages:
  - **Build Maven**: Checks out the code and builds the project using Maven.
  - **Build Docker Image**: Builds a Docker image and tags it.
  - **Push Image to Docker Hub**: Logs in to Docker Hub and pushes the built image.

## Conclusion
This Jenkins pipeline automation simplifies the process of integrating and delivering updates for a Spring Boot application, ensuring that each commit is built, tested, and deployed systematically to Docker Hub.

For more information on Jenkins configurations or troubleshooting, refer to the official [Jenkins documentation](https://www.jenkins.io/doc/).

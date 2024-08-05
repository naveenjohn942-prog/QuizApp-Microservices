# QuizApp Microservices

This project is a microservices-based application for creating and managing quizzes. It includes separate services for quizzes, questions, and results, built using Spring Boot.

## Table of Contents

- [Introduction](#introduction)
- [Architecture](#architecture)
- [Services](#services)
- [Getting Started](#getting-started)

## Introduction

QuizApp-Microservices is a distributed application designed to handle the various aspects of quiz management. It leverages the microservices architecture to ensure scalability, flexibility, and maintainability.

## Architecture

The application is divided into the following microservices:

- **Quiz Service**: Manages quiz creation and retrieval.
- **Question Service**: Handles questions associated with quizzes.
- **Result Service**: Manages user responses and results.

Each service is independently deployable and communicates with other services via REST APIs.

## Services

### Quiz Service

- **Endpoint**: `/quizzes`
- **Description**: Provides endpoints to create, update, delete, and retrieve quizzes.

### Question Service

- **Endpoint**: `/questions`
- **Description**: Manages questions, including creating, updating, deleting, and retrieving questions for specific quizzes.

### Result Service

- **Endpoint**: `/results`
- **Description**: Records and retrieves user responses and quiz results.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.3.2 or higher

### Running the Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/naveenjohn942-prog/QuizApp-Microservices.git
   cd QuizApp-Microservices

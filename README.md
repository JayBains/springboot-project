Welcome to our Sping Boot project written in Java and TypeScript.

# Group Consolidation Project

## Overview
This project involves creating a **full-stack application** that consists of:
- A **TypeScript frontend**
- A **Spring Boot server**
- A **MySQL database**

The goal is to consolidate learning by building a **working MVP** by **Friday PM** to demo as a group.

## Project Stages

### Stage 1 - Data Design (0.5 Days)
- Define the **database structure**
- Identify **tables** and their **relationships**
- Determine **attributes (columns)** for each table
- Create an **Entity Relationship Diagram (ERD)**

### Stage 2 - API Setup (1 Day)
- Define **API endpoints** to interact with the database
- Example API structure for a greetings application:

  | Endpoint                       | Method | Description                         |
    |--------------------------------|--------|-------------------------------------|
  | `/greetings`                   | GET    | Returns all greetings               |
  | `/greetings/{greetingId}`      | GET    | Returns a specific greeting         |
  | `/greeting`                    | POST   | Creates a new greeting              |
  | `/greetings/{greetingId}`      | DELETE | Deletes a greeting                  |
  | `/greetings/{searchByCountry}` | GET    | Returns all greeting from a country |

### Stage 3 - Frontend Connection (1 Day)
- Build a **TypeScript frontend** to consume the API and display data
- Consider the **user journey** and how data will be presented
- Design the UI to align with the **application theme**

## Collaboration Guidelines
- One person creates the **repository** and adds group members as **collaborators**
- Keep a **clear commit history**, use concise but clear commit messages
- Work in **feature branches** before merging into the main branch

## Final Notes
- This project will be completed in **small groups (4 people)**
- The aim is to **combine all learned modules** into a small, functional project
- The **main focus is an MVP**, but it can be expanded after the course
- Ensure project scope is manageable within the **given timeframe**

Happy coding! 🚀

# Group Project Action Plan

## Project Theme: Pokémon Card Picker
**Description:** Users select categories, and a Pokémon card is generated based on their choices.

## Wednesday: Database & Backend Setup

### 1. Design the Database (Morning)
- [ ] Elias & Jay: Identify required data (e.g., Pokémon name, type, abilities, stats, image, etc.)
- [ ] Elias & Jay: Define database tables and relationships
- [ ] Elias & Jay: Create an Entity Relationship Diagram (ERD)
- [ ] Elias & Jay: Set up MySQL database schema
- [ ] Nazrin & Adil: Create mock Pokémon card data in JSON format
- [ ] Nazrin & Adil: Review database design and suggest any missing data
- [ ] Group: Quick meeting to finalise database structure

### 2. Backend Setup & Frontend Preparation (Afternoon)
- [ ] Elias & Jay: Set up Spring Boot project and connect to MySQL
- [ ] Elias & Jay: Create entity classes and define relationships
- [ ] Elias & Jay: Implement basic API routes (GET: fetch random card, GET: fetch by category, etc.)
- [ ] Elias & Jay: Test APIs using Postman to verify data retrieval
- [ ] Elias & Jay: Set up Railway project for backend deployment
- [ ] Nazrin & Adil: Set up TypeScript project with HTML & CSS structure
- [ ] Nazrin & Adil: Create UI layout with HTML elements and CSS styling
- [ ] Nazrin & Adil: Set up Fetch API to make test calls to backend
- [ ] Group: End-of-day check-in to align backend and frontend progress

## Thursday: API Completion & Frontend Development

### 3. Complete API & Connect to Database (Morning)
- [ ] Elias & Jay: Implement all CRUD operations in backend
- [ ] Elias & Jay: Add error handling for invalid requests
- [ ] Elias & Jay: Set up CORS configuration to allow frontend requests
- [ ] Elias & Jay: Deploy backend API to Railway and test connections
- [ ] Nazrin & Adil: Build UI for category selection and card display
- [ ] Nazrin & Adil: Display mock Pokémon card data in the UI
- [ ] Nazrin & Adil: Implement interactivity using TypeScript (event listeners, form handling, etc.)
- [ ] Group: Share API responses so frontend can start connecting real data

### 4. Connect Frontend to Backend (Afternoon)
- [ ] Nazrin & Adil: Replace mock data with real API data using Fetch API
- [ ] Nazrin & Adil: Handle loading states, user input validation, and error messages
- [ ] Nazrin & Adil: Improve UI styling for a cleaner look
- [ ] Elias & Jay: Optimise API response times and fix any issues
- [ ] Elias & Jay: Implement pagination, sorting, or filtering if necessary
- [ ] Elias & Jay: Ensure backend is fully deployed on Railway
- [ ] Group: Full team testing to ensure API and UI integration works properly

## Friday Morning: Final Fixes & Demo Prep

### 5. Debugging & Testing
- [ ] All Team Members: Test the full user flow and fix any remaining bugs
- [ ] All Team Members: Ensure UI looks good on different screen sizes
- [ ] All Team Members: Improve anything that needs final polishing

### 6. Deployment & Demo Preparation
- [ ] All Team Members: Deploy backend on Railway and ensure it works correctly
- [ ] All Team Members: Deploy frontend on GitHub Pages or Netlify
- [ ] All Team Members: Prepare for the Friday PM demo
  - [ ] Decide who presents what
  - [ ] Ensure each team member can explain their part

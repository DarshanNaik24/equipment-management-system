# Equipment Management System

Full-stack web application to manage equipment and their maintenance lifecycle.

This project is built as a monorepo containing backend, frontend, and database setup folders.

---

# 📁 Project Structure
/backend
/frontend
/db
README.md
COMPLIANCE.md

/backend
/frontend
/db
README.md
COMPLIANCE.md
src/main/resources/application.properties

3. Configure PostgreSQL:
4. spring.datasource.url=jdbc:postgresql://localhost:5432/equipment_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080

4. Build and run backend:
mvn clean install -DskipTests
mvn spring-boot:run

Backend will run at:http://localhost:8080


---

# 💻 Frontend Setup

1. Navigate to frontend folder:cd frontend

  
2. Install dependencies:npm install

3. Start development server: npm run dev

Frontend runs at: http://localhost:3000


---

# 🗄 Database Setup

1. Install PostgreSQL.
2. Create the database:
   CREATE DATABASE equipment_db;
   
3. Execute schema file: psql -U postgres -d equipment_db -f db/schema.sql

4. 
4. Insert seed data:psql -U postgres -d equipment_db -f db/data.sql

5. 
---

# 📌 Core Features

- View equipment list (table format)
- Add new equipment
- Edit existing equipment
- Delete equipment
- Dynamic equipment type from database
- Maintenance logging
- View maintenance history per equipment

Each equipment contains:
- Name
- Type (dropdown from database)
- Status (Active, Inactive, Under Maintenance)
- Last Cleaned Date

---

# 🔄 Maintenance Workflow

When a maintenance record is added:

- Equipment status automatically changes to Active
- Last Cleaned Date updates to Maintenance Date
- Maintenance history is stored and retrievable

All logic implemented in backend service layer.

---

# 🔐 Status Constraint Rule

Equipment cannot be marked as Active if the Last Cleaned Date is older than 30 days.

If violated:
- Backend rejects the request
- Meaningful error message returned to UI

Rule enforced in backend.

---

# 📚 REST API Endpoints

## Equipment
- GET /api/equipment
- POST /api/equipment
- PUT /api/equipment/{id}
- DELETE /api/equipment/{id}

## Maintenance
- POST /api/maintenance
- GET /api/equipment/{id}/maintenance

---

# 🧱 Database Design

Tables:
- equipment
- equipment_type
- maintenance_log

Relationships:
- Equipment → Many-to-One → EquipmentType
- MaintenanceLog → Many-to-One → Equipment

Equipment types are stored in a separate table and are not hardcoded.
New types can be added without changing application code.

---

# 📦 Additional Libraries Used

Frontend:
- Tailwind CSS
- shadcn/ui

Backend:
- Spring Boot Starter Web
- Spring Data JPA
- PostgreSQL Driver

All installation steps are provided above.

---

# 📝 Assumptions

- PostgreSQL running locally on port 5432
- Backend runs on port 8080
- Frontend runs on port 3000
- Valid database credentials configured
- Equipment types seeded before creating equipment

---

# 🚀 How to Run Entire Project

1. Start PostgreSQL
2. Create database
3. Run backend
4. Run frontend
5. Open browser at http://localhost:3000






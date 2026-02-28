# COMPLIANCE CONFIRMATION

This project complies with all assignment requirements.

---

## ✅ UI Compliance

- No inline styles (style={{}}) were used anywhere in the project.
- No raw HTML form elements (<input>, <select>, <button>) were used directly.
- All UI components use shadcn/ui with Tailwind CSS.
- Add and Edit operations reuse the same form component.
- Basic validation implemented in frontend.

---

## ✅ Backend Compliance

- Spring Boot used with Java.
- Layered architecture implemented:
  - Controller
  - Service
  - Repository
- All business rules are enforced in the backend service layer.
- Proper exception handling implemented.
- Appropriate HTTP status codes returned.
- Safe, parameterized queries via Spring Data JPA.

---

## ✅ Business Rule Enforcement

1. Equipment cannot be marked Active if Last Cleaned Date is older than 30 days.
2. Adding a maintenance record:
   - Automatically sets equipment status to Active.
   - Updates Last Cleaned Date to Maintenance Date.
3. Maintenance history can be viewed per equipment.

All rules are enforced in backend logic.

---

## ✅ Database Compliance

- PostgreSQL used.
- Proper foreign key relationships implemented.
- Equipment types stored in separate table.
- Equipment types are not hardcoded in schema.
- Schema supports adding new equipment types without code changes.

---

## ✅ Repository Structure

The repository is a monorepo and contains:

- /backend
- /frontend
- /db
- README.md
- COMPLIANCE.md

All instructions from the assignment have been followed.

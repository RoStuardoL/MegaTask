# Customer Management System

A full-stack application for managing customer relationships, built with Spring Boot and React.

## Project Structure

### Backend (`/backend`)

#### Configuration (`/backend/src/main/java/com/example/customermanagement/config`)
- `OpenApiConfig.java` - Swagger/OpenAPI documentation setup
- `SecurityConfig.java` - Spring Security configuration
- `JwtAuthenticationFilter.java` - JWT authentication handling
- `RestTemplateConfig.java` - HTTP client configuration

#### Controllers (`/backend/src/main/java/com/example/customermanagement/controller`)
- `AuthController.java` - Authentication endpoints
- `CustomerController.java` - Customer management
- `CustomerInteractionController.java` - Customer interaction tracking
- `CustomerNoteController.java` - Customer notes management
- `UserController.java` - User management
- `WeatherController.java` - Weather integration

#### DTOs (`/backend/src/main/java/com/example/customermanagement/dto`)
Data Transfer Objects for request/response handling:
- Authentication (`AuthRequest.java`, `AuthResponse.java`, `RegisterRequest.java`)
- Customer (`CustomerDTO.java`, `CustomerCreateRequest.java`, `CustomerUpdateRequest.java`)
- Interactions (`CustomerInteractionDTO.java`, `CustomerInteractionRequest.java`)
- Notes (`CustomerNoteDTO.java`, `CustomerNoteRequest.java`)
- Users (`UserDTO.java`, `UserUpdateRequest.java`)

#### Models (`/backend/src/main/java/com/example/customermanagement/model`)
Database entities:
- `Customer.java` - Customer information
- `CustomerInteraction.java` - Customer interaction records
- `CustomerNote.java` - Customer notes
- `User.java` - User accounts
- `AuditLog.java` - System audit logging

#### Services (`/backend/src/main/java/com/example/customermanagement/service`)
Business logic implementation:
- Authentication (`AuthService.java`, `JwtService.java`)
- Customer Management (`CustomerService.java`)
- Interactions (`CustomerInteractionService.java`)
- Notes (`CustomerNoteService.java`)
- Users (`UserService.java`)
- Weather Integration (`WeatherService.java`)
- Audit Logging (`AuditLogService.java`)
- Email Notifications (`EmailService.java`)

### Frontend (`/src`)

#### Components (`/src/components`)
- `Layout.tsx` - Main application layout
- `Navbar.tsx` - Navigation bar

#### Pages (`/src/pages`)
- `Login.tsx` - Authentication page

#### Store (`/src/store`)
- `auth.ts` - Authentication state management

## Database (`/database`)

- `schema.sql` - Database structure
- `sample_data.sql` - Initial test data

## Documentation (`/docs`)

- `component-structure.md` - Frontend architecture
- `database-schema.md` - Database design
- `system-architecture.md` - System overview

## Modification Guide

### Adding New Features

1. **Database Changes**
   - Add new tables/columns in `database/schema.sql`
   - Update sample data in `database/sample_data.sql`

2. **Backend Implementation**
   - Create/update model in `backend/src/main/java/.../model/`
   - Add DTO classes in `backend/src/main/java/.../dto/`
   - Define service interface in `backend/src/main/java/.../service/`
   - Implement service in `backend/src/main/java/.../service/impl/`
   - Create controller in `backend/src/main/java/.../controller/`

3. **Frontend Implementation**
   - Add new types in `src/types/index.ts`
   - Create components in `src/components/`
   - Add pages in `src/pages/`
   - Update routing in `src/App.tsx`
   - Add state management in `src/store/`

### Security Considerations

- JWT authentication required for protected endpoints
- Role-based access control (ADMIN/USER)
- Password encryption using BCrypt
- CORS configuration
- Input validation using Jakarta Validation

## Configuration

Key configuration files:
- `application.yml` - Backend settings
- `pom.xml` - Backend dependencies
- `package.json` - Frontend dependencies
- `tsconfig.json` - TypeScript configuration
- `vite.config.ts` - Vite build configuration
- `tailwind.config.js` - CSS framework configuration

## Getting Started

1. **Database Setup**
   ```bash
   mysql -u root -p < database/schema.sql
   mysql -u root -p < database/sample_data.sql
   ```

2. **Backend**
   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```

3. **Frontend**
   ```bash
   npm install
   npm run dev
   ```

## API Documentation

Access Swagger UI at: `http://localhost:8080/api/swagger-ui.html`
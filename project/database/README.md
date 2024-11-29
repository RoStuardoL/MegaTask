# Database Configuration

This directory contains the SQL scripts for setting up the Customer Management System database.

## Schema Overview

The database consists of the following tables:

1. `users`
   - Stores user information and authentication details
   - Supports role-based access control (admin/user)
   - Indexed on email and role for faster queries

2. `customers`
   - Main customer information
   - Tracks creation and updates
   - References users table for created_by
   - Indexed on email, status, and created_by

3. `customer_notes`
   - Stores notes/comments about customers
   - Links to both customers and users
   - Supports cascading deletes for customer records

4. `customer_interactions`
   - Tracks all interactions with customers
   - Supports different interaction types
   - Includes timestamps for interaction tracking
   - Indexed for efficient querying

## Features

- **Referential Integrity**: All foreign keys are properly configured with appropriate actions
- **Indexing**: Strategic indexes on frequently queried columns
- **Audit Trail**: Automatic timestamp tracking for creation and updates
- **Data Types**: Appropriate data types chosen for each column
- **Character Sets**: UTF8MB4 for full Unicode support
- **Sample Data**: Includes initial data for testing

## Setup Instructions

1. Create the database and tables:
   ```sql
   source schema.sql
   ```

2. Load sample data:
   ```sql
   source sample_data.sql
   ```

## Security Considerations

- Passwords are stored as hashes (bcrypt)
- Role-based access control implemented
- Email uniqueness enforced
- Input validation required in application layer

## Maintenance

Regular maintenance tasks:
- Backup database regularly
- Monitor index usage
- Optimize queries as needed
- Archive old interactions if needed
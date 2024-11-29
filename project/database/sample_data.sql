-- Insert sample users
INSERT INTO users (id, email, password_hash, name, role) VALUES
('1', 'admin@example.com', '$2b$10$xJwK3GUNn5K8pMpK8Z8zXuVz5q5Q5q5q5q5q5q5q5q5q5q5q5q', 'Admin User', 'admin'),
('2', 'user@example.com', '$2b$10$xJwK3GUNn5K8pMpK8Z8zXuVz5q5Q5q5q5q5q5q5q5q5q5q5q5q', 'Regular User', 'user');

-- Insert sample customers
INSERT INTO customers (id, name, email, phone, address, status, created_by) VALUES
('1', 'John Doe', 'john@example.com', '+1234567890', '123 Main St, City, Country', 'active', '1'),
('2', 'Jane Smith', 'jane@example.com', '+0987654321', '456 Oak Ave, Town, Country', 'active', '1'),
('3', 'Bob Johnson', 'bob@example.com', '+1122334455', '789 Pine Rd, Village, Country', 'inactive', '2');

-- Insert sample customer notes
INSERT INTO customer_notes (id, customer_id, user_id, note) VALUES
('1', '1', '1', 'Initial meeting completed. Customer interested in premium package.'),
('2', '1', '2', 'Follow-up call scheduled for next week'),
('3', '2', '1', 'Customer requested product demo');

-- Insert sample customer interactions
INSERT INTO customer_interactions (id, customer_id, user_id, type, description, interaction_date) VALUES
('1', '1', '1', 'meeting', 'Initial consultation meeting', NOW() - INTERVAL 1 DAY),
('2', '1', '2', 'call', 'Follow-up call about requirements', NOW() - INTERVAL 12 HOUR),
('3', '2', '1', 'email', 'Sent product information', NOW() - INTERVAL 2 DAY);
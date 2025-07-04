-- Insert sample departments
INSERT INTO departments (name, description, location, budget, created_at, updated_at) VALUES
('Human Resources', 'Manages employee relations and company policies', 'New York', 250000.00, NOW(), NOW()),
('Information Technology', 'Handles all technology and software development', 'San Francisco', 1500000.00, NOW(), NOW()),
('Finance', 'Manages financial operations and accounting', 'Chicago', 800000.00, NOW(), NOW()),
('Marketing', 'Handles marketing campaigns and brand management', 'Los Angeles', 600000.00, NOW(), NOW()),
('Sales', 'Manages sales operations and customer relations', 'Miami', 400000.00, NOW(), NOW()),
('Operations', 'Handles day-to-day business operations', 'Dallas', 350000.00, NOW(), NOW());

-- Insert sample employees
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_title, salary, is_active, department_id, created_at, updated_at) VALUES
('John', 'Doe', 'john.doe@company.com', '+1-555-0101', '2023-01-15', 'Software Engineer', 85000.00, true, 2, NOW(), NOW()),
('Jane', 'Smith', 'jane.smith@company.com', '+1-555-0102', '2023-02-20', 'HR Manager', 75000.00, true, 1, NOW(), NOW()),
('Bob', 'Johnson', 'bob.johnson@company.com', '+1-555-0103', '2023-03-10', 'Financial Analyst', 65000.00, true, 3, NOW(), NOW()),
('Alice', 'Brown', 'alice.brown@company.com', '+1-555-0104', '2023-04-05', 'Marketing Specialist', 58000.00, true, 4, NOW(), NOW()),
('Charlie', 'Davis', 'charlie.davis@company.com', '+1-555-0105', '2023-05-12', 'Sales Representative', 55000.00, true, 5, NOW(), NOW()),
('Diana', 'Wilson', 'diana.wilson@company.com', '+1-555-0106', '2023-06-18', 'Operations Manager', 72000.00, true, 6, NOW(), NOW()),
('Edward', 'Miller', 'edward.miller@company.com', '+1-555-0107', '2023-07-22', 'Senior Software Engineer', 95000.00, true, 2, NOW(), NOW()),
('Fiona', 'Garcia', 'fiona.garcia@company.com', '+1-555-0108', '2023-08-15', 'HR Specialist', 52000.00, true, 1, NOW(), NOW()),
('George', 'Rodriguez', 'george.rodriguez@company.com', '+1-555-0109', '2023-09-10', 'Accountant', 60000.00, true, 3, NOW(), NOW()),
('Helen', 'Martinez', 'helen.martinez@company.com', '+1-555-0110', '2023-10-05', 'Digital Marketing Manager', 68000.00, true, 4, NOW(), NOW()),
('Ivan', 'Anderson', 'ivan.anderson@company.com', '+1-555-0111', '2023-11-20', 'Sales Manager', 80000.00, true, 5, NOW(), NOW()),
('Julia', 'Taylor', 'julia.taylor@company.com', '+1-555-0112', '2023-12-15', 'Operations Analyst', 56000.00, true, 6, NOW(), NOW()),
('Kevin', 'Thomas', 'kevin.thomas@company.com', '+1-555-0113', '2024-01-08', 'DevOps Engineer', 88000.00, true, 2, NOW(), NOW()),
('Laura', 'Jackson', 'laura.jackson@company.com', '+1-555-0114', '2024-02-14', 'Recruitment Specialist', 48000.00, true, 1, NOW(), NOW()),
('Mike', 'White', 'mike.white@company.com', '+1-555-0115', '2024-03-20', 'Financial Controller', 85000.00, true, 3, NOW(), NOW());
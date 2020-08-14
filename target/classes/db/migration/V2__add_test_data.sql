-- Create positions

INSERT INTO positions(job_name) VALUES ('Apprentice Engineer'), ('Software Engineer'), ('Senior Software Engineer'), ('Scrum Master'), ('Director'), ('VP');

-- Create some pension providers

INSERT INTO providers(provider) VALUES ('Direct Line Group');
INSERT INTO providers(provider) VALUES ('Aviva');
INSERT INTO providers(provider) VALUES ('Prudential');
INSERT INTO providers(provider) VALUES ('Nest');

-- Create some employees

INSERT INTO employees(first_name, last_name, job_id, age, salary) VALUES ('John', 'Doe', '1', 23, 20000);
INSERT INTO employees(first_name, last_name, job_id, age, salary) VALUES ('Susan', 'Smith', '4', 34, 41000);
INSERT INTO employees(first_name, last_name, job_id, age, salary) VALUES ('Gareth', 'Johnson', '3', 29, 46000);
INSERT INTO employees(first_name, last_name, job_id, age, salary) VALUES ('Jackie', 'Chan', '2', 32, 75000);
INSERT INTO employees(first_name, last_name, job_id, age, salary) VALUES ('Luan', 'Kirkwood', '6', 25, 1200000);
INSERT INTO employees(first_name, last_name, job_id, age, salary) VALUES ('Jonny', 'Craig', '5', 56, 1550000);

-- Create some pension funds

INSERT INTO pensions(employeeId, contribution_amount) VALUES (1, 0);
INSERT INTO pensions(employeeId, contribution_amount) VALUES (2, 3000);
INSERT INTO pensions(employeeId, contribution_amount) VALUES (3, 12000);
INSERT INTO pensions(employeeId, contribution_amount) VALUES (4, 32000);
INSERT INTO pensions(employeeId, contribution_amount) VALUES (5, 244000);
INSERT INTO pensions(employeeId, contribution_amount) VALUES (6, 4250000);

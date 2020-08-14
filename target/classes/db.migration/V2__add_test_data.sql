-- Create positions

INSERT INTO positions(job_name) VALUES ('Apprentice Engineer'), ('Software Engineer'), ('Senior Software Engineer'), ('Scrum Master'), ('Director'), ('VP');

-- Create some pension providers

INSERT INTO providers(provider) VALUES ('Direct Line Group');
INSERT INTO providers(provider) VALUES ('Aviva');
INSERT INTO providers(provider) VALUES ('Prudential');

-- Create some employees

INSERT INTO employees(first_name, last_name, position, age, salary) VALUES ('Fred', 'Gordon', 'apprentice', 21, 20000);
INSERT INTO employees(first_name, last_name, position, age, salary) VALUES ('Bobby', 'Brown', 'regular', 24, 41000);
INSERT INTO employees(first_name, last_name, position, age, salary) VALUES ('Alfred', 'Doorstop', 'regular', 29, 46000);
INSERT INTO employees(first_name, last_name, position, age, salary) VALUES ('Jackie', 'Poyton', 'director', 32, 75000);
INSERT INTO employees(first_name, last_name, position, age, salary) VALUES ('Bruce', 'Fierston', 'ceo', 41, 120000);
INSERT INTO employees(first_name, last_name, position, age, salary) VALUES ('Sandris', 'Kupavskis', 'stakeholder', 24, 1550000);

-- Create some pension funds

INSERT INTO pension_funds(employee_id, contribution_amount, pension_provider) VALUES (1, 0, 'SaveWhileYouCan');
INSERT INTO pension_funds(employee_id, contribution_amount, pension_provider) VALUES (2, 3000, 'SaveWhileYouCan');
INSERT INTO pension_funds(employee_id, contribution_amount, pension_provider) VALUES (3, 12000, 'SaveWhileYouCan');
INSERT INTO pension_funds(employee_id, contribution_amount, pension_provider) VALUES (4, 32000, 'RetireRich');
INSERT INTO pension_funds(employee_id, contribution_amount, pension_provider) VALUES (5, 244000, 'RetireRich');
INSERT INTO pension_funds(employee_id, contribution_amount, pension_provider) VALUES (6, 4250000, 'NeverStopMakingMoney');

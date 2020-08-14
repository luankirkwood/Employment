CREATE TABLE positions (
    job_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    job_name VARCHAR(255)
);

CREATE TABLE providers (
    provider VARCHAR(255) NOT NULL PRIMARY KEY
);

CREATE TABLE employees (
    employeeId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR (255) NOT NULL,
    age int NOT NULL,
    salary VARCHAR(255) NOT NULL,
    job_id INT NOT NULL,
    FOREIGN KEY (job_id) REFERENCES positions (job_id)
);

CREATE TABLE pensions (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeId int NOT NULL,
    FOREIGN KEY (employeeId) REFERENCES employees (employeeId),
    provider VARCHAR(255) DEFAULT 'Direct Line Group',
    contribution_amount int DEFAULT 0,
    FOREIGN KEY (provider) REFERENCES providers(provider)

);
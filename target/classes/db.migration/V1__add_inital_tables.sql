CREATE TABLE positions (
    job_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    job_name VARCHAR(255)
);

CREATE TABLE employees (
    employee_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR (255) NOT NULL,
    age int NOT NULL,
    salary VARCHAR(255) NOT NULL,
    job_id INT NOT NULL,
    FOREIGN KEY (job_id) REFERENCES positions (job_id)
);

CREATE TABLE pensions (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id int NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees (employee_id),
    provider VARCHAR(255) DEFAULT 'Direct Line Group',
    contribution_amount int DEFAULT 0,
    FOREIGN KEY (provider) REFERENCES providers(provider)

);

CREATE TABLE providers (
    id int AUTO_INCREMENT,
    provider VARCHAR(255) NOT NULL PRIMARY KEY
)
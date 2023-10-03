PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE drivers (
    driver_id INT PRIMARY KEY NOT NULL,
    driver_name CHAR(50) NOT NULL,
    driver_grade INT NOT NULL,
    driver_location CHAR(50) NOT NULL,
    driver_slots_open INT NOT NULL,
    driver_commission REAL NOT NULL
);
CREATE TABLE customers (
    customer_id INT PRIMARY KEY NOT NULL,
    customer_name CHAR(50) NOT NULL,
    customer_grade INT NOT NULL,
    customer_order CHAR(50) NOT NULL
);
COMMIT;

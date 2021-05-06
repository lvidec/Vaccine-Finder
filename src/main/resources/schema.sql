CREATE TABLE IF NOT EXISTS vaccine(
    id INT AUTO_INCREMENT PRIMARY KEY,
    vax_name VARCHAR(100) NOT NULL,
    comp_name VARCHAR(100) NOT NULL,
    type VARCHAR(20) NOT NULL,
    needed_doses INT NOT NULL,
    warehouse_doses INT NOT NULL
);

CREATE TABLE IF NOT EXISTS side_effect(
    id INT AUTO_INCREMENT,
    short_desc VARCHAR(100) NOT NULL,
    long_desc VARCHAR(500) NOT NULL,
    frequency INT NOT NULL,
    vaccine_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (vaccine_id) REFERENCES vaccine(id)
);
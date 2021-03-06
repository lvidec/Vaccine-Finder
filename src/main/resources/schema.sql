CREATE TABLE IF NOT EXISTS vaccine(
    id INT AUTO_INCREMENT PRIMARY KEY,
    research_name VARCHAR(100) NOT NULL,
    manufacturer_name VARCHAR(100) NOT NULL,
    type VARCHAR(20) NOT NULL,
    number_of_shots INT NOT NULL,
    available_doses INT NOT NULL
);

CREATE TABLE IF NOT EXISTS side_effect(
    id INT AUTO_INCREMENT,
    short_description VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    frequency INT NOT NULL,
    vaccine_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (vaccine_id) REFERENCES vaccine(id)
);

CREATE TABLE IF NOT EXISTS USER (
    id identity,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS authority (
    id identity,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_authority(
    user_id INT NOT NULL,
    authority_id INT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES USER(id),
    CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES authority(id)
);
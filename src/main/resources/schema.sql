CREATE TABLE IF NOT EXISTS Vaccine(
    id INT AUTO_INCREMENT PRIMARY KEY,
    vaxName VARCHAR(100) NOT NULL,
    compName VARCHAR(100) NOT NULL,
    TYPE VARCHAR(20) NOT NULL,
    neededDoses INT NOT NULL,
    warehouseDoses INT NOT NULL
);

CREATE TABLE IF NOT EXISTS SideEffect(
    id INT AUTO_INCREMENT,
    shortDesc VARCHAR(100) NOT NULL,
    longDesc VARCHAR(500) NOT NULL,
    frequency INT NOT NULL,
    vaccineId INT,
    PRIMARY KEY (id),
    FOREIGN KEY (vaccineId) REFERENCES Vaccine(id)
);
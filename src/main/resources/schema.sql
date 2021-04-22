create table if not exists Vaccine(
    vaxName varchar(100) primary key,
    compName varchar(100) not null,
    type varchar(20) not null,
    neededDoses int not null,
    warehouseDoses int not null

    );

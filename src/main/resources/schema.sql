create table if not exists SideEffect(
    sideEffectId int auto_increment primary key,
    shortDesc varchar(100) not null,
    longDesc varchar(500) not null,
    frequency int not null
);


create table if not exists Vaccine(
    id int auto_increment,
    vaxName varchar(100) not null,
    compName varchar(100) not null,
    type varchar(20) not null,
    neededDoses int not null,
    warehouseDoses int not null,
    sideEffect int,
    primary key (id),
    foreign key (sideEffect) references SideEffect(sideEffectId)
);
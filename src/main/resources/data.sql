INSERT INTO SideEffect
(shortDesc, longDesc, frequency) VALUES
('Alergijska reakcija', 'Moguća je pojava alergijske reakcije na određene sastojke cjepiva', 3),
('Rak pluca', 'Moguća je pojava raka pluca na određene sastojke cjepiva', 1);


INSERT INTO Vaccine
(vaxName, compName, TYPE, neededDoses, warehouseDoses, sideEffect) VALUES
('Pfizer-BioNTech', 'Pfizer, Inc., and BioNTech', 'mRNA', 2, 300, 1),
('Moderna', 'ModernaTX, Inc.', 'mRNA', 2, 20000, 2),
('vakcinaZaMoze', 'Mozi', 'mRNA', 1, 100000, 2);
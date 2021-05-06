INSERT INTO vaccine
(vax_name, comp_name, type, needed_doses, warehouse_doses) VALUES
('Pfizer-BioNTech', 'Pfizer, Inc., and BioNTech', 'mRNA', 2, 300),
('Moderna', 'ModernaTX, Inc.', 'mRNA', 2, 20000),
('vakcinaZaMoze', 'Mozi', 'mRNA', 1, 100000);

INSERT INTO side_effect(short_desc, long_desc, frequency, vaccine_id) VALUES
('Alergijska reakcija', 'Moguća je pojava alergijske reakcije na određene sastojke cjepiva', 3, 1),
('Rak pluca', 'Moguća je pojava raka pluca na određene sastojke cjepiva', 1, 1),
('Bol u prsima', 'Moguća je pojava boli u prsima', 20, 2),
('Cist ko suza', 'Nemoguca je pojava icega ak si moz', 100, 3);
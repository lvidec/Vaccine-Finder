INSERT INTO vaccine(research_name, manufacturer_name, type, number_of_shots, available_doses) VALUES
('Pfizer-BioNTech', 'Pfizer, Inc., and BioNTech', 'mRNA', 2, 300),
('Moderna', 'ModernaTX, Inc.', 'mRNA', 2, 20000),
('vakcinaZaMoze', 'Mozi', 'mRNA', 1, 100000);

INSERT INTO side_effect(short_description, description, frequency, vaccine_id) VALUES
('Alergijska reakcija', 'Moguća je pojava alergijske reakcije na određene sastojke cjepiva', 3, 1),
('Rak pluca', 'Moguća je pojava raka pluca na određene sastojke cjepiva', 1, 1),
('Bol u prsima', 'Moguća je pojava boli u prsima', 20, 2),
('Cist ko suza', 'Nemoguca je pojava icega ak si moz', 100, 3);

INSERT INTO user(id, username, password, first_name, last_name) VALUES
(1, 'admin', '$2a$10$7L7a0r29iWOtBG/ASaqd0uwwb1oJYwwNh6.27P9sHOhDuju0b8wce', 'Admin', 'Admirovic'),
(2, 'user', '$2a$10$EsML0xcdPH5TaQhnPDRohuql9STvgvHA9lF5sMA.VCgO6XCQMzyDy', 'Userito', 'Usmehmetovic'),
(3, 'deleter', '$2a$10$RaTsZ6SLhuB/gBbwNXApCu5nLJDVjTQrGv/q9SyGl3Zmi8SEIlNxa', 'Deleteruny', 'Deletovic');

INSERT INTO authority(id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_DELETER');

INSERT INTO user_authority(user_id, authority_id) VALUES
(1, 1),
(2, 2),
(3, 3);
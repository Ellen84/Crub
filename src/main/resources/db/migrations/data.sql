DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS address;

CREATE TABLE persons
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    minor   boolean,
    resident boolean,
    email   VARCHAR(250)    NOT NULL,
    national_number  VARCHAR(250)    NOT NULL,
    address_id BIGINT NOT NULL,
    birth_place  VARCHAR(250),
    date_of_birth DATE,
    marital_status VARCHAR(250),
    partner_name VARCHAR(250)
);

CREATE TABLE address
(
    id       BIGINT NOT NULL AUTO_INCREMENT,
    street   VARCHAR(100),
    city     VARCHAR(100),
    postcode VARCHAR(20),
    country  VARCHAR(2),
    PRIMARY KEY (id)
);

INSERT INTO address (id, street, city, postcode, country) VALUES
(1, 'Lalastraat', 'Beringen', '3580', 'België'),
(2, 'Gestelstraat', 'Gestel', '3560', 'België');

INSERT INTO persons (id, name, last_name, minor, resident, email, national_number, address_id, birth_place, date_of_birth, marital_status, partner_name) VALUES
(1, 'Aliko', 'Dangote', false, true, 'aliko.dangote@argeus.be', '89073116530', 1, 'Hasselt', '1989-07-31', 'UNMARRIED', 'Lara Bandala'),
(2, 'Bill', 'Gates', false, true, 'bill.gates@argeus.be', '65062016790', 2, 'New York', '1965-06-20', 'MARRIED', 'Jane Tarzan');

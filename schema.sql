CREATE DATABASE ticket_sell;
CREATE SCHEMA ticket_sell;

SELECT * FROM pg_timezone_names WHERE abbrev = current_setting('TIMEZONE');
SHOW TIMEZONE;

CREATE TABLE IF NOT EXISTS client (
                                    id BIGSERIAL PRIMARY KEY,
                                    first_name VARCHAR(50) NOT NULL,
                                    last_name VARCHAR(50) NOT NULL,
                                    middle_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS ticket (
                                    id BIGSERIAL PRIMARY KEY,
                                    client_id BIGINT NOT NULL,
                                    route_id DECIMAL NOT NULL,
                                    status VARCHAR(50) NOT NULL,
                                    payment_id BIGINT
);

CREATE TABLE IF NOT EXISTS route (
                                    id BIGSERIAL PRIMARY KEY,
                                    route_identity VARCHAR(50) NOT NULL,
                                    departure_station VARCHAR(50) NOT NULL,
                                    departure_date TIMESTAMP NOT NULL,
                                    price DECIMAL NOT NULL,
                                    available_seats INT NOT NULL
);

CREATE TABLE IF NOT EXISTS payment (
                                    id BIGSERIAL PRIMARY KEY,
                                    amount float NOT NULL,
                                    status VARCHAR(6) NOT NULL,
                                    checked BOOLEAN NOT NULL DEFAULT false,
                                    created_date TIMESTAMP NOT NULL,
                                    updated_date TIMESTAMP NOT NULL DEFAULT NOW()
);

UPDATE route r SET available_seats = (SELECT available_seats FROM route WHERE id = '1') - 1
    WHERE r.id = '1';

SELECT status FROM payment WHERE id = '1';

SELECT id FROM payment WHERE status = 'NEW' AND checked = false;

SELECT * FROM ticket WHERE payment_id IN ('1','2');
SELECT * FROM route WHERE id IN ('1');



CREATE DATABASE ticket_sell;
CREATE SCHEMA ticket_sell;

CREATE TABLE IF NOT EXISTS payment (
                                       id BIGSERIAL PRIMARY KEY,
                                       ticket_id BIGINT,
                                       status VARCHAR(6) NOT NULL,
                                       crated_date TIMESTAMP NOT NULL,
                                       updated_date TIMESTAMP NOT NULL
);






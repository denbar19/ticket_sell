CREATE DATABASE ticket_sell;
CREATE SCHEMA ticket_sell;

SELECT * FROM pg_timezone_names WHERE abbrev = current_setting('TIMEZONE');
SHOW TIMEZONE;

CREATE TABLE IF NOT EXISTS client
(
    id          uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS ticket
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    client_id  uuid      NOT NULL,
    route_id   uuid      NOT NULL,
    status     SMALLINT NOT NULL,
    payment_id uuid
);

CREATE TABLE IF NOT EXISTS route
(
    id                uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    route_identity    VARCHAR(50) NOT NULL,
    departure_station VARCHAR(50) NOT NULL,
    departure_date    TIMESTAMP   NOT NULL,
    price             DECIMAL     NOT NULL,
    available_seats   INT         NOT NULL
);

CREATE TABLE IF NOT EXISTS payment
(
    id           uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    amount       float          NOT NULL,
    status       SMALLINT NOT NULL,
    checked      BOOLEAN        NOT NULL DEFAULT false,
    created_date TIMESTAMP      NOT NULL DEFAULT current_timestamp,
    updated_date TIMESTAMP      NOT NULL DEFAULT NOW()
);

UPDATE route r SET available_seats = (SELECT available_seats FROM route WHERE id = '1') - 1
    WHERE r.id = '1';
UPDATE route r SET available_seats = (SELECT available_seats FROM route WHERE id = '8d636348-543f-488d-bd99-4b2f5a64eced') - '1'
    WHERE r.id = '8d636348-543f-488d-bd99-4b2f5a64eced';


SELECT status FROM payment WHERE id = '1';

SELECT id FROM payment WHERE status = 'NEW' AND checked = false;

SELECT * FROM ticket WHERE payment_id IN ('e7853984-d40f-412c-b6a0-00760110fd10', 'a0a033fb-d3cc-47c2-9c2d-3b70aa3b2290');
SELECT * FROM ticket WHERE payment_id IN ('1','2');
SELECT * FROM route WHERE id IN ('1');

INSERT INTO payment (amount, status, checked, created_date, updated_date)
    VALUES (0.0, 'NEW', false, '2023-02-27T21:57:58.023686831', '2023-02-27T21:57:58.023686831') RETURNING *;

SELECT status FROM payment WHERE id = 'fc78cc9d-185d-44d0-a57d-10a7c9934d8a';

CREATE TYPE payment_status AS ENUM ('NEW', 'DONE', 'FAILED');
CREATE TYPE ticket_status AS ENUM ('ACTIVE', 'COMPLETED', 'PENDING');

SELECT pg_type.oid, typarray, typname, typcategory
    FROM pg_catalog.pg_type
        LEFT   JOIN (select ns.oid as nspoid, ns.nspname, r.r
                     from pg_namespace as ns
                         join ( select s.r, (current_schemas(false))[s.r] as nspname
                                from generate_series(1, array_upper(current_schemas(false), 1)) as s(r) ) as r
                             using ( nspname )        ) as sp
            ON sp.nspoid = typnamespace
    WHERE typname IN ('payment_status', 'ticket_status')
    ORDER BY sp.r, pg_type.oid DESC ;
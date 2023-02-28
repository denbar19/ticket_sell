CREATE TABLE IF NOT EXISTS payment
(
    id           uuid PRIMARY KEY,
    amount       float          NOT NULL,
    status       payment_status NOT NULL,
    checked      BOOLEAN        NOT NULL DEFAULT false,
    created_date TIMESTAMP      NOT NULL DEFAULT current_timestamp,
    updated_date TIMESTAMP      NOT NULL DEFAULT NOW()
);

CREATE TYPE payment_status AS ENUM ('NEW', 'DONE', 'FAILED');
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_users (

    id SERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    height FLOAT NOT NULL,
    weight FLOAT NOT NULL,
    status VARCHAR(40) NOT NULL,
    objective VARCHAR(40) NOT NULL,
    flat VARCHAR(40)NOT NULL


);
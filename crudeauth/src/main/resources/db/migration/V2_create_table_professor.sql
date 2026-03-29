CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_teacher (

    id SERIAL PRIMARY KEY,
    teachername VARCHAR(40) NOT NULL,
    telephone VARCHAR(40) NOT NULL,
    email VARCHAR(50) NOT NULL



);
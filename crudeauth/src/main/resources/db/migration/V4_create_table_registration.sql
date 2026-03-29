CREATE EXTESIONS IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_registration (
    id serial PRIMARY KEY,
    studentId INTEGER NOT NULL,
    startDate TIMESTAMP NOT NULL,
    endDante TIMESTAMP NOT NULL,
    status VARCHAR (10)NOT NULL

)

ALTER TABLE tb_registration DROP COLUMN studentId;
ALTER TABLE tb_registration ADD COLUMN users_id INTEGER;
ALTER TABLE tb_registration
ADD CONSTRAINT fk_registration_user
FOREIGN KEY (users_id)
REFERENCES tb_user(id);

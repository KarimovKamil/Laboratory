CREATE TABLE credentials
(
  id bigserial NOT NULL,
  login character varying(50) NOT NULL,
  password character varying(50) NOT NULL,
  salt VARCHAR(50) NOT NULL,
  CONSTRAINT credentials_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE credentials
  OWNER TO postgres;


INSERT INTO credentials (id, login, password, salt) VALUES (1, 'masha', '123','202cb962ac59075b964b07152d234b70');
INSERT INTO credentials (id, login, password, salt) VALUES (2, 'tanya', '456', '250cf8b51c773f3f8dc8b4be867a9a02');
INSERT INTO credentials (id, login, password, salt) VALUES (3, 'victor', '789', '68053af2923e00204c3ca7c6a3150cf7');



CREATE TABLE IF NOT EXISTS employee(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	age INTEGER NOT NULL,
	role VARCHAR(128) NOT NULL,
	status BOOLEAN DEFAULT TRUE,
	is_deleted BOOLEAN DEFAULT FALSE
);
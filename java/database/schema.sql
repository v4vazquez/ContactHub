BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, contacts, profile_pictures;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE contacts (
    contact_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id),
    name VARCHAR(255) NOT NULL,
    notes TEXT,
    birthdate DATE,
    email VARCHAR(100),
    address TEXT,
    likes TEXT,
    dislikes TEXT
);
CREATE TABLE profile_pictures(
    profile_picture_id SERIAL PRIMARY key,
    contact_id INT references contacts(contact_id),
    profile_picture_url VARCHAR(255)
);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS trip, fish, users CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE trip (
        trip_id serial,
		user_id int NOT NULL,
        date TIMESTAMP,
        location varchar(32) NOT NULL,
        weather varchar(32),
        comments varchar(300),
        CONSTRAINT PK_trip PRIMARY KEY(trip_id),
		CONSTRAINT FK_trip_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE fish (
		user_id int NOT NULL,
        trip_id int NOT NULL,
        fish_id serial,
        species varchar(32) NOT NULL,
        length int,
        lure varchar(32),
        CONSTRAINT PK_fish PRIMARY KEY(fish_id),
        CONSTRAINT FK_fish_trip FOREIGN KEY(trip_id) REFERENCES trip(trip_id),
		CONSTRAINT FK_fish_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

COMMIT;
BEGIN TRANSACTION;

DROP TABLE IF EXISTS trip, fish CASCADE;

CREATE TABLE trip (
        trip_id serial,
        date TIMESTAMP,
        location varchar(32) NOT NULL,
        weather varchar(32),
        comments varchar(300),
        CONSTRAINT PK_trip PRIMARY KEY(trip_id)
);

CREATE TABLE fish (
        trip_id int NOT NULL,
        fish_id serial,
        species varchar(32) NOT NULL,
        length int,
        lure varchar(32),
        CONSTRAINT PK_fish PRIMARY KEY(fish_id),
        CONSTRAINT FK_fish_trip FOREIGN KEY(trip_id) REFERENCES trip(trip_id)
);

COMMIT;
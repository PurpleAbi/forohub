CREATE TABLE profiles(
                        id                  INT           not null auto_increment,
                        name                VARCHAR (100) not null unique,

                        PRIMARY KEY (id)
);

CREATE TABLE users(
                        id                  INT           not null auto_increment,
                        name                VARCHAR (100) not null unique,
                        email               VARCHAR (100) not null unique,
                        password            VARCHAR (255) not null,
                        profile_id          INT           not null,

                        PRIMARY KEY (id),
                        CONSTRAINT fk_users_profile_id FOREIGN KEY (profile_id) REFERENCES profiles(id)
);
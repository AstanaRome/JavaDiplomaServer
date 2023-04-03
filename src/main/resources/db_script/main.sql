use_medicine_db

CREATE TABLE users(
                      id int not null auto_increment,
                      first_name varchar(50) not null,
                      last_name varchar(50) not null,
                      email varchar(50) not null unique,
                      created_at timestamp,
                      updated_at timestamp,
                      PRIMARY KEY (id)
);
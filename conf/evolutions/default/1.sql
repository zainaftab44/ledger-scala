# --- !Ups

CREATE TABLE Accounts
(
    id      BIGINT(20) AUTO_INCREMENT,
    name    TEXT,
    balance BIGINT(20) UNSIGNED,
    PRIMARY KEY (id)
);

INSERT INTO Accounts (id,name,balance)
Values (1, 'user', 200),
       (2, 'A', 200),
       (3, 'B', 200),
       (4, 'Zain', 200),
       (5, 'Jieren', 200);

# --- !Downs

DROP TABLE Accounts;
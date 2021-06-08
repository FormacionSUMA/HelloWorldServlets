
CREATE TABLE IF NOT EXISTS usuarios
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    login      VARCHAR(60)  NOT NULL,
    password   VARCHAR(255) NOT NULL,
    fullname   VARCHAR(255) NOT NULL,
    created_at datetime     NOT NULL,
    active     INT(1)       NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (login)
);

TRUNCATE TABLE usuarios;

INSERT INTO usuarios VALUES (NULL, 'pepe', '1234', 'Pepe PEREZ', NOW(), 1);
INSERT INTO usuarios VALUES (NULL, 'sauron', '1234', 'Sauron', NOW(), 0);

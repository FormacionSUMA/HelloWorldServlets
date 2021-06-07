--
-- helloworldservletsdb
--

CREATE TABLE IF NOT EXISTS `usuarios`
(
    `id`         int(11)                       NOT NULL AUTO_INCREMENT,
    `login`      varchar(60) COLLATE utf8_bin  NOT NULL,
    `password`   varchar(255) COLLATE utf8_bin NOT NULL,
    `fullname`   varchar(255) COLLATE utf8_bin NOT NULL,
    `created_at` datetime                      NOT NULL,
    `active`     tinyint(1)                    NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `login` (`login`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

INSERT INTO usuarios VALUES (NULL, 'pepe', '1234', 'Pepe PEREZ', NOW(), 1);
INSERT INTO usuarios VALUES (NULL, 'sauron', '1234', 'Sauron', NOW(), 0);



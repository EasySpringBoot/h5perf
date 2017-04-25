CREATE DATABASE IF NOT EXISTS `h5perf`
  DEFAULT CHARACTER SET utf8;
USE `h5perf`;

DROP TABLE IF EXISTS `test_case`;

CREATE TABLE `test_case` (
  `id`             INT(11) NOT NULL AUTO_INCREMENT,
  `container_type` VARCHAR(45)      DEFAULT NULL
  COMMENT '‘ORIGIN_WEBVIEW’,’UC_WEBVIEW’',
  `test_url`       VARCHAR(45)      DEFAULT NULL,
  `net_type`       VARCHAR(45)      DEFAULT NULL
  COMMENT '‘WIFI’,‘3G’,‘4G’',
  `gmt_created`    DATETIME         DEFAULT NULL,
  `gmt_modified`   DATETIME         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `test_resource`;

CREATE TABLE `test_resource` (
  `id`            INT(11) NOT NULL AUTO_INCREMENT,
  `test_case_id`  INT(11)          DEFAULT NULL,
  `start_time`    BIGINT(11)       DEFAULT NULL,
  `resource_url`  VARCHAR(500)     DEFAULT NULL,
  `resource_type` VARCHAR(45)      DEFAULT NULL
  COMMENT 'IMG,JS,CSS,OTHER',
  `resource_time` BIGINT(11)       DEFAULT NULL
  COMMENT 'onLoadResource资源时间戳',
  `resource_size` BIGINT(11)       DEFAULT NULL
  COMMENT '资源大小',
  `gmt_created`   DATETIME         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `test_time_data`;

CREATE TABLE `test_time_data` (
  `id`               INT(11) NOT NULL AUTO_INCREMENT,
  `test_case_id`     INT(11)          DEFAULT NULL,
  `on_recieve_title` VARCHAR(45)      DEFAULT NULL
  COMMENT '近似白屏时间',
  `on_page_finished` VARCHAR(45)      DEFAULT NULL
  COMMENT '页面加载完成时间',
  `dom_content_load` VARCHAR(45)      DEFAULT NULL
  COMMENT 'dom内容加载完成时间',
  `load`             VARCHAR(45)      DEFAULT NULL
  COMMENT '资源加载完成时间',
  `gmt_created`      DATETIME         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `h5perf`.`user` (
  `id`       INT          NOT NULL AUTO_INCREMENT,
  `workno`   VARCHAR(45)  NULL,
  `name`     VARCHAR(45)  NULL,
  `email`    VARCHAR(45)  NULL,
  `password` VARCHAR(100) NULL,
  `role`     VARCHAR(45)  NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `h5perf`.`role` (
  `id`         INT         NOT NULL AUTO_INCREMENT,
  `role_key`   VARCHAR(45) NULL,
  `role_value` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `role_key`)
);


INSERT INTO `h5perf`.`user` (`id`, `workno`, `name`, `email`, `password`, `role`)
VALUES ('1', '1', 'root', 'root@123.com', '123456', 'ROLE_USER,ROLE_ADMIN');
INSERT INTO `h5perf`.`user` (`id`, `workno`, `name`, `email`, `password`, `role`)
VALUES ('2', '1', 'jack', 'jack@123.com', '123456', 'ROLE_USER');

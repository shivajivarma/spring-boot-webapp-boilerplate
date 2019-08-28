CREATE TABLE IF NOT EXISTS `boilerplate`.`USER`
(
id          INT NOT NULL auto_increment,
authorities VARCHAR(255),
password    VARCHAR(255),
username    VARCHAR(255),
PRIMARY KEY (id)
)
auto_increment=1; 

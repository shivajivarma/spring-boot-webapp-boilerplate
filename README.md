# Spring Boot Webapp Boilerplate
Spring Boot based Web Application boilerplate, with stateless authentication using JWT.

## Setup

* Install MySQL  
* Create database with name `boilerplate`
* Run the below script to create USER table.
```mysql
CREATE TABLE IF NOT EXISTS `boilerplate`.`USER`
(
id          INT NOT NULL auto_increment,
authorities VARCHAR(255),
password    VARCHAR(255),
username    VARCHAR(255),
PRIMARY KEY (id)
)
auto_increment=1; 
```

Clone the repository.
  ```cmd
  git clone https://github.com/shivajivarma/spring-boot-webapp-boilerplate
  ```

## Run

To run the demo application just execute this command in the root directory:

```cmd
gradlew.bat bootRun
```

And navigate to [http://localhost:8080](http://localhost:8080) to check the demo. 

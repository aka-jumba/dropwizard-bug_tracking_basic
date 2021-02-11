# User Service

# prerequisite
 - Install maven (https://github.com/rajivkanaujia/alphaworks/wiki/Installing-Maven)
 - MYSQL
 
# DB Setup
```
create database user_service;

CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `external_id` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` text DEFAULT NULL,
  `dob` DATE NOT NULL,
  `phone` varchar(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `external_id_idx` (`external_id`),
  UNIQUE KEY `phone_idx` (`phone`),
  UNIQUE KEY `email_idx` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

# Running the Code
1. `mvn clean install -U`
2. `java -jar target/user-service-1.0-SNAPSHOT.jar server src/main/resources/user.yaml`

## API Collection
```https://www.getpostman.com/collections/97c924c99770ab2a2f71```
  
# References
https://www.dropwizard.io/en/stable/getting-started.html

https://maven.apache.org/guides/getting-started/

https://jdbi.org/

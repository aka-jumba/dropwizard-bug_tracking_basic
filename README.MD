# User Service

# prerequisite
 - Install maven (https://github.com/rajivkanaujia/alphaworks/wiki/Installing-Maven)
 - MYSQL
 
# DB Setup
```
create database user_service;

CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `external_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` text,
  `dob` date NOT NULL,
  `phone` varchar(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `external_id_idx` (`external_id`),
  UNIQUE KEY `phone_idx` (`phone`),
  UNIQUE KEY `email_idx` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `bugs` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `bug_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `bug_description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `priority` int NOT NULL DEFAULT '5',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bug_name` (`bug_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bugs_users` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `bug_name` varchar(45) NOT NULL DEFAULT '',
  `external_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bug_name` (`bug_name`,`external_id`),
  KEY `external_id` (`external_id`),
  CONSTRAINT `bugs_users_ibfk_1` FOREIGN KEY (`bug_name`) REFERENCES `bugs` (`bug_name`),
  CONSTRAINT `bugs_users_ibfk_2` FOREIGN KEY (`external_id`) REFERENCES `users` (`external_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```

# Running the Code
1. `mvn clean install -U`
2. `java -jar target/user-service-1.0-SNAPSHOT.jar server src/main/resources/user.yaml`
  
# References
https://www.dropwizard.io/en/stable/getting-started.html

https://maven.apache.org/guides/getting-started/

https://jdbi.org/

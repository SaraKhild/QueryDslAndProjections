# Project by Using QueryDSL And Projection Concepts
<br>

## Overview
 In this project I built up using the concepts of QueryDSl and Procjection
 <br>
 
## Usages
SpringBoot, QueryDSL, MySQL
<br> 

## Architecture of the Project

 ### 1-src folder
    - controllers folder
    - models folder
    - services folder
    - repositories
 
### 2-Maven pom.xml
<br>

  - MoiveInfo and MovieReview pom.xml:   
    
```
 <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>


		<!-- Dependency for MySQL Database -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
			<version>8.0.30</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<!-- Hibernate -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>${hibernate.version}</version>
		</dependency>

		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-apt</artifactId>
			<version>${querydsl.version}</version>
			<classifier>jakarta</classifier>
		</dependency>

		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-jpa</artifactId>
			<version>${querydsl.version}</version>
			<classifier>jakarta</classifier>
		</dependency>

		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-jpa-codegen</artifactId>
			<version>${querydsl.version}</version>
			<classifier>jakarta</classifier>
		</dependency>

</dependencies>
 ```
<br>

### 3-Application.properties.yml

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3312/db
spring.datasource.username=db
spring.datasource.password=nFLhPPKOnkW1FA1e
spring.jpa.show-sql=true

 ```
### Run the program
<br>


  * 1- run MovieInfo and add information on postman
  <img width="750" alt="movieInfo-get" src="https://user-images.githubusercontent.com/67427643/214279762-ddb80a1c-e63e-48eb-a4ef-c58a38fb6c2c.png">

  * 2- run MovieReview and add information on postman
  <img width="767" alt="movieReview-get" src="https://user-images.githubusercontent.com/67427643/214281321-1cf3f998-7250-420e-8747-20f348b633c1.png">
  
  * 3- run Movie to get information and review about movie by id on postman
  <img width="761" alt="movie-get" src="https://user-images.githubusercontent.com/67427643/214282384-c41c1c48-8884-41b0-ab67-821cf07d2a74.png">
  
---
<br>

### Good Luck <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="30px"> 


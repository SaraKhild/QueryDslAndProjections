# Project by Using QueryDSL And Projection Concepts
<br>

## Overview
This project simplifies the concepts of QueryDSl and Procjection
 <br>
 
## Usages
- SpringBoot
-  QueryDSL
-  MySQL

## Architecture of the Project

 ### 1- src folders
 
   - Controllers folder
   - Models folder
   - Services folder
   - Repositories folder
 
 ### 2-Maven pom.xml
<br>

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
## • Queries Results of Employee

<br>

### This query 

#### Code :space_invader:

<br>

```
        @Override
        public List<String> getUniqueJobName() {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath.jopName).distinct().from(entityPath).fetch();
                return result;

        }
```
<br>


#### Result :star_struck:

<br>

<img width="1200" alt="" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/9716ee0e-b951-4621-b62f-112dfa0a55a9">


---

---
---
---
<br>

### Good Luck <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="30px"> 


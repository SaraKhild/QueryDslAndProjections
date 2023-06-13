# Project by Using QueryDSL And Projection Concepts
<br>

## Overview
I code a project by using SpringBoot simplify <strong> QueryDSl </strong> concept that is a framework which enables the construction of type-safe SQL, instead of writing queries as inline strings or externalizing them into XML files they are constructed via a fluent API, besid <strong> Procjection </strong> concept is defined as taking a vertical subset from the columns of a single table that retains the unique rows. This kind of SELECT statement returns some of the columns and all the rows in a table.
 <br>
 
## Usages
- SpringBoot
-  QueryDSL
-  MySQL

## Architecture of the Project

 ### 1- src folders
   - Controllers folder
   - Models folder
   - Projections
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
 ## Let's Start :mechanical_arm:
### • Queries Results of Employee

##### :pencil2: `This query comparing employee name that is sending with employees name that is stored and then fetches employee information` 

###### Code :computer:

<br>

```
        @Override
        public Employee findByName(String employeeName) {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath).from(entityPath).where(entityPath.employeeName.eq(employeeName))
                                .fetchOne();
                return result;
        }
```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="employeeWithName" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/84135306-7752-4e68-b951-a9d23d5737c0">

---

<br>

##### :pencil2: `This query fetches jops name infrequently` 

###### Code :computer:

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

###### Result :star_struck:

<br>

<img width="1200" alt="" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/9716ee0e-b951-4621-b62f-112dfa0a55a9">

---

<br>

##### :pencil2: `This query multiply current salary of employee with 15% and show employees name and new salary increase`

###### Code :computer:


```
        @Override
        public List<EmployeeProjection> getEmployeeNameWithIncreasedSalary() {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                entityPath.employeeName.as("employeeName"),
                                                entityPath.salary.multiply(Expressions.ONE.multiply(1.350))
                                                                .as("salary"))) // Increase 15%
                                .from(entityPath).fetch();
                // --------------------------another way----------------------------
                // var result = query.select(entityPath.employeeName,
                // entityPath.salary).from(entityPath)
                // .fetch().stream()
                // .map(x -> new EmployeeProjection(x.get(entityPath.employeeName),
                // x.get(entityPath.salary)))
                // .collect(Collectors.toList());

                return result;
        }
```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="employee4part1" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/c97aafcf-6088-4abd-a74b-9f65de55801d" hapace="20">

<br>
<br>

<img width="931" alt="employee4part2" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/0228b502-c3c2-4d20-9b6a-ba16d4f718b0">

---

<br>

##### :pencil2: This query 

###### Code :computer:

<br>

```
	@Override
        public List<Employee> getEmployeeNotBelongToDepartment(int departmentNo) {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath).from(entityPath)
                                .where(entityPath.department.departmentNo.notIn(departmentNo)).fetch();
                return result;
        }
```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="employee2part1" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/c8fe1b9f-23a8-4d04-9d16-3aec50544df5" haspace="20">

<br>
<br>

<img width="1200" alt="employee2part2-done" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/91c9080c-4737-4f60-8eff-84c67b001d3e">

---

<br>

##### :pencil2: This query

###### Code :computer:

<br>

```
	@Override
        public List<Employee> getEmployeeWhoJoinedBefore(int year) {

                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath).from(entityPath)
                                .where(entityPath.hireDate.year().lt(year)).fetch();
                return result;

        }
```

<br>

##### Result :star_struck:

<br>

<img width="1200" alt="employee3part1" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/ba72a8cd-1599-44b6-b8bb-ff7f285fae41" hapace="20">

<br>
<br>

<img width="1200" alt="employee3part2" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/1258a234-c6fd-4637-92d8-63f3ca34da15">

---

<br>

##### :pencil2: `This query fetches employee number, employee name, department number, department name <br> where department number on employee equal department number on department` 


###### Code :computer:

<br>

```
	@Override
        public List<EmployeeProjection> getEmployeeWithDepartment() {
                var employeeEntityPath = QEmployee.employee;
                var departmentEntityPath = QDepartment.department;
                var query = new JPAQuery<>(this.entityManager);

                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                employeeEntityPath.employeeNo.as("employeeNo"),
                                                employeeEntityPath.employeeName.as("employeeName"),
                                                departmentEntityPath.departmentNo.as("departmentNo"),
                                                departmentEntityPath.departmentName.as("departmentName")))
                                .innerJoin(departmentEntityPath)
                                .on(employeeEntityPath.department.departmentNo.eq(departmentEntityPath.departmentNo));

                return result.fetch();
        }

```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="emWithdepartment1" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/5e748fc1-2e8b-400c-9b00-dd6a4acd8128" hapace="20">

<br>
<br>

<img width="1200" alt="emWithdepartment2" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/f53f750c-73f6-4815-87be-411b54090c72" hapace="20">

<br>
<br>

<img width="1200" alt="emWithdepartment3" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/e1265e5a-9997-429b-8cf5-e93c37026c11">


---

<br>

##### :pencil2: `This query calculates the employee average salary and then <br> fetches employee name and jop name which it's greater than this salary average`

###### Code :computer:

<br>

```
	@Override
        public List<EmployeeProjection> getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees() {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var subQuery = query.select(entityPath.salary.avg()).from(entityPath).fetchOne();
                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                entityPath.employeeName.as("employeeName"),
                                                entityPath.jopName.as("jopName"), entityPath.salary.as("salary")))
                                .from(entityPath).where(entityPath.salary.gt(subQuery)).fetch();

                return result;
        }

```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="employee5part1" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/c5429e1b-c931-45b5-a619-f9de13ada800" haspace="20">

<br>
<br>

<img width="1200" alt="employee5part2" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/c307f6c1-e7d8-4c10-ba26-1e5932864006">

---

<br>

##### :pencil2: this


###### Code :computer:

<br>

```
	@Override
        public List<EmployeeProjection> countAllEmployeesUnderEachManager() {
                var entityPathManager = QEmployee.employee;
                var entityPathEmployee = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                entityPathManager.employeeNo.as("employeeNo"),
                                                entityPathManager.employeeName.as("employeeName"),
                                                entityPathManager.jopName.as("jopName"),
                                                entityPathManager.managerId.as("managerId"),
                                                entityPathEmployee.count().as("count")))
                                .from(entityPathEmployee)
                                .join(entityPathManager)
                                .on(entityPathEmployee.managerId.eq(entityPathManager.employeeNo))
                                .groupBy(entityPathManager.employeeName, entityPathManager.employeeNo, entityPathManager.jopName)
                                .fetch();     
                return result;
        }

```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="count1" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/4881bdbb-2783-45bc-8a11-8e04699bfdee"
     haspace="20">

<br>
<br>

<img width="1200" alt="count3" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/409486d3-2e2f-4425-bf76-07a297573856">

---

<br>

##### :pencil2: `This query fetches employee number based on manager name that sending and then <br> compare this employee number that it's came with managerId and then show employees information who under this manager`

###### Code :computer:

<br>

```
	@Override
        public List<Employee> getEmployeesWhoseUnderManagerName(String managerName) {
                var entityPathManager = QEmployee.employee;
                var entityPathEmployee = QEmployee.employee;
                var findIdManagerQuery = new JPAQuery<>(this.entityManager);
                var findEmployeeQuery = new JPAQuery<>(this.entityManager); 

                var subQuery = findIdManagerQuery.select(entityPathManager.employeeNo).from(entityPathManager)
                                .where(entityPathManager.employeeName.like("%" + managerName + "%")).fetchOne();
          
                var result = findEmployeeQuery.select(entityPathEmployee).from(entityPathEmployee)
                                .where(entityPathEmployee.managerId.eq(subQuery));

                return result.fetch();
        }

```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="employee7" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/40415bde-cd29-4616-ba99-663e23822fd9" haspace="20">

<br>
<br>

---
---
---

<br>

## • Queries Results of Department

##### :pencil2: `This query comparing department name that is sending with department name that is stored and then fetches department information` 

###### Code :computer:

<br>

```
    @Override
    public Department findByName(String departmentName) {

        var entityPath = QDepartment.department;
        var query = new JPAQuery<>(this.entityManager);
        var result = query.select(entityPath).from(entityPath).where(entityPath.departmentName.eq(departmentName))
                .fetchOne();

        return result;

    }
```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="departmentbyname" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/43306b6a-62c4-4a6f-9dca-81c3ccf4a581">

<br>

--

<br>

##### :pencil2: `This query take department number that is sending and filter then show department information except this department number`

###### Code :computer:

<br>

```
    @Override
    public List<DepartmentProjection> findAllDepartmentsThatIsNotIncludeThisDepartmentNo(int departmentNo) {
        var entityPath = QDepartment.department;
        var query = new JPAQuery<>(this.entityManager);
        var result = query
                .select(Projections.bean(DepartmentProjection.class, entityPath.departmentNo.as("departmentNo"),
                        entityPath.departmentName.as("departmentName")))
                .where(entityPath.departmentNo.notIn(departmentNo)).from(entityPath).fetch();

        return result;

    }
```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="department4" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/593455fc-4a15-4cba-82c4-c3e53f311f27">

<br>

--

<br>

##### :pencil2: This query 

###### Code :computer:

<br>

```
    @Override
    public List<Department> findAllDepartmentsThatEmployeesNotIncluded() {
        var departmentEntityPath = QDepartment.department;
        var employeeEntityPath = QEmployee.employee;
        var query = new JPAQuery<>(this.entityManager);
        var subQuery = query.select(employeeEntityPath.department.departmentNo).from(employeeEntityPath).fetch();
        var result = query.select(departmentEntityPath).from(departmentEntityPath)
                .where(departmentEntityPath.departmentNo.notIn(subQuery)).fetch();

        return result;
    }
```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="department5" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/c45f6969-e25b-4635-8f76-f6e3dadd4090">

<br>

--

<br>

<br>

##### :pencil2: `This query comparing depratment number of employee and department number of department  <br> and group same values then counting them where are grater than 2`

###### Code :computer:

<br>

```
 @Override
    public List<DepartmentProjection> findDepartmentsHaveAtLeastTwoEmployees() {
        var entityPath = QDepartment.department;
        var employeeEntityPath = QEmployee.employee;
        var query = new JPAQuery<>(this.entityManager);
        var result = query
                .select(Projections.bean(DepartmentProjection.class, entityPath.departmentNo.as("departmentNo"),
                        entityPath.departmentName.as("departmentName")))
                .from(entityPath, employeeEntityPath)
                .where(entityPath.departmentNo.eq(employeeEntityPath.department.departmentNo))
                .groupBy(entityPath.departmentName,entityPath.departmentNo)
                .having(entityPath.count().goe(2))
                .fetch();

        return result;
    }

```

<br>

###### Result :star_struck:

<br>

<img width="1200" alt="department6" src="https://github.com/SaraKhild/QueryDslAndProjections/assets/67427643/b379916a-730f-4833-8ef9-f92d5ece839a">

<br>

--


### Good Luck <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="30px"> 


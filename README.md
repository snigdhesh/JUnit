# JUnit

#### Why @SpringBootTest is used in Spring Boot test cases?

- In Spring Boot, `@SpringBootTest` is used to provide a bridge between Spring Boot test features and JUnit.
- It is an annotation that can be used to specify that, the spring application context can be used in the test cases.   
- It allows us to inject beans into our test class.
- It allows test cases to access `application.properties` file or `application.yml` file.
- Mock objects like data, REST APIs etc.
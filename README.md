# Project Structure
This Project is using Controller, Service, Repository layer. We can see, Layer Project like as follows:

com.belajar.restapi
├── config
│   └── SwaggerConfig.java
├── controller
│   └── HardwareController.java
├── entity
│   └── Hardware.java
├── implement
│   └── HadwareServiceImpl.java
├── repository
│   └── HardwareRepository.java
├── RestApiApplication.java
├── service
│   └── HardwareService.java
└── util
    └── Response.java
    
# How to Run Project
>- mvn clean install spring-boot:run

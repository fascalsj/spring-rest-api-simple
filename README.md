# Project Structure
This Project is using Controller, Service, Repository layer. We can see, Layer Project like as follows:

com.belajar.restapi
├── config
│   └── SwaggerConfig.java           *configuration file for swagger documentation
├── controller
│   └── HardwareController.java      * our router to handle Hardware module
├── entity
│   └── Hardware.java                * our object mapping table Hardware
├── implement
│   └── HadwareServiceImpl.java      * our logic process and implementing service interface
├── repository
│   └── HardwareRepository.java      * our query related with table Hardware
├── RestApiApplication.java          * our Main Class
├── service
│   └── HardwareService.java         * our interface to JPA
└── util
    └── Response.java                * our files to give a response
    
# How to Run Project
>- mvn clean install spring-boot:run

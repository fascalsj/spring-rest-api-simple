# Project Structure
This Project is using Controller, Service, Repository layer. We can see, Layer Project like as follows:

  
com.belajar.restapi
├── config
│   └── SwaggerConfig.java           *configuration file for swagger documentation
├── controller
│   └── HardwareController.java      * our router to handle Hardware module
├── entity
│   └── Hardware.java                * our object mapping table Hardware
├── implement
│   └── HadwareServiceImpl.java      * our logic process and implementing service interface
├── repository
│   └── HardwareRepository.java      * our query related with table Hardware
├── RestApiApplication.java          * our Main Class
├── service
│   └── HardwareService.java         * our interface to JPA
└── util
    └── Response.java                * our files to give a response
    
    
    com.belajar.restapi
 ├─common/                          * our common files
 │   ├──Constant                    * our files to maintain constant variables
 │   └──Tool                        * our files to maintain static/ reusable methods
 │
 ├──config/                         * our configuration files
 │   └──SwaggerConfig               * configuration file to configure swagger documentation
 │
 ├──dto
 │   ├──FailureResponse             * our JSON format that return by exception handler
 │   ├──SuccessResponse             * our JSON format that return is transaction/ process is success
 │   └──Response                    * our JSON standard JSON format
 │
 ├──exception                       * our custom exception files and exception handler
 │   └──HandlerException            * our runtime exception handler that return a nice JSON
 │
 ├──interceptor                     * our filter files
 │   ├──Interceptor                 * our main Interceptor
 │   └──LogInterceptor              * our pre and post handle that log activity in web service
 │
 ├──entity                          * our entity files that mapping to table in database
 │   └──Person                      * our object mapping table Person
 │
 ├──controller                      * our controller files that define endpoints/ route mapping
 │   └──PersonController            * our endpoint to handle Person module
 │
 ├──service                         * our service files to handle business logic
 │   └──PersonService               * our logic to handle Person module
 │
 └──repository                      * out repository files to handle query / command to database
     └──PersonRepository            * our query related with table Person
     
# How to Run Project
>- mvn clean install spring-boot:run

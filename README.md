# Project Structure
This Project is using Controller, Service, Repository layer. We can see, Layer Project like as follows:

com.belajar.restapi
 ├─common/                          * our common files
 │   └──Response                    * our files to give a response
 │
 ├──config/                         * our configuration files
 │   └──SwaggerConfig               * configuration file for swagger documentation
 │
 ├──entity                          * our entity files that mapping to table in database
 │   └──Hardware                    * our object mapping table Hardware
 │
 ├──controller                      * our controller files for routing web access in our project
 │   └──HardwareController          * our router to handle Hardware module
 │
 ├──service                         * our service files to accessing JPA
 │   └──HardwareService             * our interface to JPA
 │
 ├──implementation                  * our service files to implementing service interface
 │   └──HardwareServiceImpl         * our logic process
 │
 └──repository                      * out repository files to handle query / command to database
     └──HardwareRepository          * our query related with table Person
     
# How to Run Project
>- mvn clean install spring-boot:run

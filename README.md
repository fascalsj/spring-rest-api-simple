# Project Structure
This Project is using Controller, Service, Repository layer. We can see, Layer Project like as follows:

com.belajar.restapi<br />
├── config<br />
│   └── SwaggerConfig.java<br />
├── controller<br />
│   └── HardwareController.java<br />
├── entity<br />
│   └── Hardware.java<br />
├── implement<br />
│   └── HadwareServiceImpl.java<br />
├── repository<br />
│   └── HardwareRepository.java<br />
├── RestApiApplication.java<br />
├── service<br />
│   └── HardwareService.java<br />
└── util<br />
    └── Response.java<br />
    
# How to Run Project
>- mvn clean install spring-boot:run

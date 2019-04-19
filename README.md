# Pelican Translation Project
Complete sample project with spring cloud using eureka, feign\

## A sample ready to use project with all basic configuration for -
1.    Spring cloud config (taking out and putting all the properties file at the same location)
2.    Eureka discovery enabled to maintain scaled up 
3.    Use of feign client to call different micro service wherever necessary
4.    fallback support for feign

## How to start
### Eureka server
cd eureka-server/   
mvn spring-boot:run  
move to http://localhost:8761 to keep a track of registered server  

### Estonia Service  
cd estonia-service    
mvn spring-boot:run  
http://localhost:8911/translation/hello


### Belgium Service  
cd belgium-service    
mvn spring-boot:run  
http://localhost:8913/translation/hello


### Lithuania Service  
cd lithuania-service    
mvn spring-boot:run  
http://localhost:8912/translation/hello


### Pelican Service  
cd pelican    
mvn spring-boot:run  
http://localhost:8080/country/Estonia/hello

## Feign  
Feign is when one micro service need to call to other micro service, it will use feign client (@EnableFeignClient). It can be demonstrated as when we call the api gateway to get translation it routes the call to estonia-service which in turns makes a call to pelican service to get translation information.  
GET http://localhost:8080/country/Estonia/hello gets routed to GET http://localhost:8911/translation/hello

## Endpoints 
http://localhost:8080/country/Estonia/hello  
http://localhost:8080/country/Belgium/hello  
http://localhost:8080/country/Lithuania/hello  

## Test
Controller unit test can be testable for pelican project

cetinkaltar@gmail.com

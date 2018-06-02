# springboot-java8
The project is made on spring boot. The project summarize the new features present in Java 8.
It contain list of harcoded topics list. You can call the apis's with POSTMAN to add,delete,update Topic list
In addition, it uses 
1) Java 8 NIO methods 
2) String operations
3) Stream operations
4) IntStream functions
5) Functional interface
6) Lambda functions
7) Optional datatype
8) Foreach loops
9) Default and Static methods in interface
10) Java 8 LocalDateTime API
11) Pattern



## Getting Started
1) Download or clone the project with link 
(https://github.com/RehmanMuradAli/springboot-java8/)

## Available API's

Greetings
```
GET /
```
Get all Topics in List
```
GET /topic
```
Get Topic of given ID
```
GET /topic/{id}
```

Add Topic in List
```
POST /topic
```
Update Topic of given ID
```
PUT /topic/{id}
```
Delete Topic of given ID
```
DELETE /topic/{id}
```

Get all Topics whose ID's length is greater than minLength
```
GET /topic/minimum/length/{minLength}
```

Get all Topics sorted by ID
```
GET /topic/sort
```

String Operations on Topic List
```
GET /topic/string/operation
```

File Operations on Topic List
```
GET /topic/file/operation
```
Java 8 Date Time example
```
GET /datetime
```



### Prerequisites

1) Java sdk
2) POSTMAN

### Installing



```
1) Download or clone
2) Import the project
3) Run on location machine
4) Open Postman, to call API's (  localhost:8080 )
```


## Helpful Links
Spring:

https://spring.io/guides

Java 8: 

http://www.baeldung.com/java-8-functional-interfaces

http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/

https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html

http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html

https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html

https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

http://www.baeldung.com/foreach-java

http://winterbe.com/posts/2015/03/25/java8-examples-string-number-math-files/

http://www.baeldung.com/java-8-comparator-comparing

http://www.baeldung.com/java-8-sort-lambda

https://dzone.com/articles/java-8-friday-goodies-new-new


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Rehman Murad Ali** 



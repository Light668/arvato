
# arvato
Aufgaben von Timo Radtke, 08.04.2019

## Prerequirements

* maven
* git

## Install
#### note:
it's highly recommended to clone the repository into a path without any spaces, e.g. `c:/develop` but not `c:/my path/`

* clone the repository:
`git clone https://github.com/Light668/arvato`

## Exercise 1:

* move into the project:
`cd arvato`
* move into the exercise1 project:
`cd aufgabe1`
* install dependencies and run tests:
`mvn clean install`
* checkout the source code with an IDE of your choice

    #### test with your own textfiles:

    * insert your textfiles `List1.txt` and `List2.txt` into `src/main/resources/`
    * run `mvn exec:java`


## Exercise 2:

* move into the exercise2 project:
`cd aufgabe2/aufgabe2`
* install dependencies and run tests:
`mvn clean install`
* run the application:
`mvn spring-boot:run`
* send your HTTP POST requests to `http://localhost:8080/text/analyze`
The application will return an JSON object as response

## Exercise 3:

* install dependencies and run tests:
`mvn clean install`
The class `ProfitableFlears.java` contains the method `public static int getOptimalValue(Float money, List<Flear> flears)`, that will return the optimal rating.



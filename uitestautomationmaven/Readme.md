Maven commands

- Maven Clean  - Clean the project/ remove the target folder files / cleaning the already compiled files- apart from this, if you add any new dependecies, it will install the new depedencies.
- Maven Build    --- We can use commands like mvn clean, mvn clean install, mvn compile package, mvn install test

- Maven Install  - It will install the project / Execute the project which is already compiled/ 
  - Compile test project
  - Any pending jar files will be downloaded
  - Execute the project
-Maven Test
-Maven package

--------------------------------------------------------

maven commands from commanline
- cleaning the project -->  mvn clean
- install or execute the project -> mvn install
--------------------------------------------------------\\

Run specific tests which is configured in pom.xml file
* mvn clean test -U -Pselenium-tests
mvn test -Dsurefire.suiteXmlFiles=testng.xml

* Execute multiple test classes by name: -Dtest=”TestClassName1, TestClassName2, TestClassName3…”
* Execute multiple test classes by name pattern: -Dtest=”*ServiceUnitTest” or -Dtest=”The*UnitTest, Controller*Test”
* Specify multiple test methods by name: -Dtest=”ClassName#method1+method2″
* Specify multiple method names by name pattern: -Dtest=”ClassName#whenSomethingHappens_*”

* mvn test -Dtest="TheSecondUnitTest#whenTestCase2_thenPrintTest2_1"
* •mvn test -Dtest="LoginTest#verifyLoginFunctionalityWithValidData"

* mvn clean test -Dgroup=smoke


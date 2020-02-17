# Adverity-Treasure-Hunt

Implemented using Java, JUnit and Maven.
Did not implement the read-from-STDIN functionality to save time during manual testing - marked by TODO tags if one should want to change it later. Instead, the array from the specification is read in from a simple String in the main method.

# How to Run the Project with Maven
mvn clean package exec:java -Dexec.mainClass="com.ullrich.lukas.functional.RecursiveVersion" for the recursive solution
mvn clean package exec:java -Dexec.mainClass="com.ullrich.lukas.objectoriented.IterativeVersion" for the iterative solution


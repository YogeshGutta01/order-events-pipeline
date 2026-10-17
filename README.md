# Order Events Pipeline

Capstone project for the 12-week plan. Week 1 starter: the Order domain model.

## Run it
```
mvn test                 # run the unit tests
mvn compile exec:java -Dexec.mainClass=com.orderpipeline.Main   # needs exec plugin; or just click Run in IntelliJ
```
In IntelliJ: File > Open > select this folder, choose "Open as Project", set the SDK to Temurin 21, then right-click `Main` > Run.

## Week 1 daily exercises (put them in `src/main/java/com/orderpipeline/practice/`)
- **Mon** Syntax and control flow: FizzBuzz; sum of 1..100; print a multiplication table; find the largest number in an int array; check if a number is prime.
- **Tue** Classes and interfaces: create a `Shape` interface with `area()`, implement `Circle` and `Rectangle`; write a `BankAccount` class with deposit/withdraw.
- **Wed** Inheritance and polymorphism: `Animal` with `Dog` and `Cat` overriding `speak()`; add an enum `Day` with a `isWeekend()` method; turn `Point(x, y)` into a record.
- **Thu** Collections: count word frequency with a `Map<String,Integer>`; remove duplicates using a `Set`; sort a `List<OrderItem>` by total.
- **Fri** Exceptions and Optional: write a method that throws a custom exception; use `Optional` for a lookup that may find nothing; solve 5 easy LeetCode problems.
- **Sat (project)** Add a `cancel()` test, a `deliver()` method with tests, and an `OrderItem` equality test. Commit and push to GitHub.

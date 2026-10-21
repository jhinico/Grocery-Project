public class Grocery {
    public static Logic_Gate logic = new Logic_Gate();
    public static void main(String[] args) {
        logic.system_Flow();
        Logic_Gate.scan.close();
        
    }
}

/*
TO DO LIST:
1.) ADD TO CART (DONE)
2.) CUSTOMER FUNCTION (DONE)
3.) STRING TO INT IN RESTOCK (DONE)
4.) SEPERATE ADMIN TO CUSTOMER FUNCTION (NOT DONE)
5.) ADD CHANGE PRICE FUNCTION (DONE)
6.) ADD CHECKOUT FUNCTION (NOT DONE)
7.) PRINT RECEIPT (NOT DONE)
8.) REMOVE ITEM IN CART FUNCTION (DONE)
9.) DISPLAY CART CURRENT TOTAL PAYMENT (DONE)
10.) DISPLAY CART (DONE)

NEW 21/10/2026:
1.) SET PRODUCT FEILD TO PRIVATE
2.) ADD GETTER AND SETTER METHODS FOR PRODUCT FIELDS
3.) SET ERROR HANDLING IN PRODUCT PRICECONTROL()
4.) SET ERROR HANDLING IN PRODUCT STOCKCONTROL()
5.) ADD METHOD THAT STOPS REMOVING ITEM IN INVENTORY WHEN OPEN
6.) ADD METHOD THAT STOPS CLOSING THE STORE WHEN AN CUSTOMER IS STILL IN THE STORE
7.)
*/

/*
TO LEARN LIST(OOP):
1.) Method Overriding
2.) Polymorphism
3.) Abstraction
4.) Abstract Classes
5.) Interfaces
6.) Composition
7.) Aggregation
8.) Exception Handling (try-catch-finally, throw, throws)
9.) Access Modifiers (public, private, protected, default)
10.) The final Keyword
11.) Object References
12.) Collections Framework (ArrayList, HashMap, HashSet)
13.) Generics
14.) Enum Types (enum)
15.) Association Between Objects
16.) Upcasting and Downcasting
17.) Dynamic Method Dispatch
18.) The instanceof Operator
19.) Dependency Injection
20.) SOLID Principles
21.) Object Cloning
22.) Inner Classes and Nested Classes
23.) Records in Java
24.) Immutable Objects
25.) Shallow Copy vs. Deep Copy
*/
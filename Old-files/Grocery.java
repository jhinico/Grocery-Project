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
*/

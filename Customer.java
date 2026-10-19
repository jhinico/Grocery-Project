class Customer {
    public void customer_Flow() {
        boolean loop = true;
        boolean loop2 = true;
        while (loop == true) {
            Logic_Gate.shoppingCart.customer_upper();
            System.out.println("1.) Add Product To Cart");
            System.out.println("2.) Remove Product To Cart");
            System.out.println("3.) Change Amount To Product");
            System.out.println("4.) Check Total Payment");
            System.out.println("5.) Checkout");
            System.out.println("6.) Exit");
            System.out.println("Type (1)/(add) Or (2)/(remove) Or (3)/(Amount) Or (4)/(total) Or (5)/(checkout) Or (6)/(exit) To Continue");
            loop2 = true;
            while (loop2 == true) {
                System.out.print("Input: ");
                String input = Logic_Gate.scan.nextLine();
                System.out.println();

                switch (input.toLowerCase()) {
                    case "1":
                    case "add":
                        Logic_Gate.shoppingCart.customer_lower();
                        Logic_Gate.shoppingCart.addToCart(null, 0);
                        loop2 = false;
                        break;

                    case "2":
                    case "remove":
                        Logic_Gate.shoppingCart.customer_lower();
                        Logic_Gate.shoppingCart.removeToCart();
                        loop2 = false;
                        break;

                    case "3":
                    case "amount":
                        Logic_Gate.shoppingCart.customer_lower();
                        Logic_Gate.shoppingCart.change_amount();
                        loop2 = false;
                        break;

                    case "4":
                    case "total":
                        Logic_Gate.shoppingCart.customer_lower();
                        Logic_Gate.shoppingCart.totalPayment(); 
                        loop2 = false;
                        break;

                    case "5":
                    case "checkout":
                        Logic_Gate.shoppingCart.customer_lower();
                        Logic_Gate.shoppingCart.checkOut();
                        loop2 = false;
                        break;

                    case "6":
                    case "exit":
                        Logic_Gate.shoppingCart.customer_lower();
                        loop2 = false;
                        loop = false;
                        Grocery.logic.system_Flow();
                        break;

                    default:
                        System.out.println("Error: Invalid Input");
                        break;
                }
            }
        }
    }
}

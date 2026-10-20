class Manager_Admin {

    public void manager_Flow() {
        boolean loop = true;

        while (loop == true) {
            System.out.println("1.) Add Product");
            System.out.println("2.) Remove Product");
            System.out.println("3.) Change Product Price");
            System.out.println("4.) Display Product");
            System.out.println("5.) Store State: Close/Open");
            System.out.println("6.) Exit");
            System.out.println("Type (1)/(add) Or (2)/(remove) Or (3)/(Change) Or (4)/(display) Or (5)/(state) Or ((6)/(exit) To Continue");
            System.out.print("Input: ");
            String input = Logic_Gate.scan.nextLine();
            System.out.println("");
            

            switch (input.toLowerCase()) {
                case "1": case "add":
                    Logic_Gate.inventory.addProduct();
                    break;

                case "2": case "remove":
                    Logic_Gate.inventory.removeProduct();
                    break;

                case "3": case "change":
                    Logic_Gate.inventory.changePrice();
                    break;

                case "4": case "display":
                    Logic_Gate.inventory.display_inventory();
                    break;
                    
                case "5": case "state":
                    Logic_Gate.store_state.generalState_control();
                    break;

                case "6": case "exit":
                    loop = false;
                    break;

                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
    }
}

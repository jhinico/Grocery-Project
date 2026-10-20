class Re_stocker {

    public void restocker_Flow() {
        boolean loop = true;

        while (loop == true) {
            System.out.println("1.) Increase Stock");
            System.out.println("2.) Display Stock");
            System.out.println("3.) Exit");
            System.out.println("Type (1)/(increase) Or (2)/(display) Or (3)/(exit) To Continue");
            System.out.print("Input: ");
            String input = Logic_Gate.scan.nextLine();
            System.out.println("");
            

            switch (input.toLowerCase()) {
                case "1": case "increase":
                    Logic_Gate.inventory.re_Stock();
                    break;

                case "2": case "display":
                    Logic_Gate.inventory.display_stock();
                    break;

                case "3": case "exit":
                    loop = false;
                    break;

                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
    }
}
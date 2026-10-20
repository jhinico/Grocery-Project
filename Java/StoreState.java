class StoreState {
    private static boolean storeState = true;

    public void generalState_control() {
        boolean loop = true;

        while (loop == true) {
            System.out.println("1.) Open Store");
            System.out.println("2.) Close Store");
            System.out.println("Type One Of The Following: Open/Close");
            System.out.print("Input: ");
            String input = Logic_Gate.scan.nextLine();

            switch (input.toLowerCase()) {
                case "open":
                case "1":
                    store_open();
                    loop = false;
                    break;

                case "2":
                case "close":
                    store_close();
                    loop = false;
                    break;

                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
    }

    public void store_close() {
        if (storeState == true) {
            System.out.println();
            storeState = false;
        } else {
            System.out.println("The Store Is Already Close\n");
        }
    }

    public void store_open() {
        if (storeState == false) {
            System.out.println();
            storeState = true;
        } else {
            System.out.println("The Store Is All Ready Open\n");
        }
    }

    public void customer_Blocker() {
        if (storeState == true) {
            Logic_Gate.customer.customer_Flow();
        } else {
            System.out.println("Store Is Still Closed\n");
        }
    }
}

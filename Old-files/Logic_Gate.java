import java.util.Scanner;

class Logic_Gate {
    public static Scanner scan = new Scanner(System.in);
    public static Manager_Admin manager_System = new Manager_Admin();
    public static Re_stocker restocker_System = new Re_stocker();
    public static Inventory inventory = new Inventory();
    public static ShoppingCart shoppingCart = new ShoppingCart();
    public static Customer customer = new Customer();
    public static StoreState store_state = new StoreState();

    public void system_Flow() {
        boolean loop = true;

        while (loop == true) {
            System.out.println("Pick Your Position");
            System.out.println("1.) Manager");
            System.out.println("2.) Restocker");
            System.out.println("3.) Customer");
            System.out.println("4.) Exit");
            System.out.println("Type (1)/(manager) Or (2)/(restocker) Or (3)/(customer) (4)/(exit) To Continue");
            System.out.print("Input: ");
            String input = scan.nextLine();
            System.out.println("");

            switch (input.toLowerCase()) {
                case "1": case "manager":
                    manager_System.manager_Flow();
                    break;

                case "2": case "restocker":
                    restocker_System.restocker_Flow();
                    break;

                case "3": case "customer":
                    store_state.customer_Blocker();
                    break;

                case "4": case "exit":
                    loop = false;
                    break;

                default:
                    System.out.println("Error: Invalid Input");
                    break;
            }
        }
    }
}

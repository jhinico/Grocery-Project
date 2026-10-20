import java.util.ArrayList;

class Inventory {
    private ArrayList<Product> product_list = new ArrayList<>();

    public void addProduct() {
        String p_name;
        double p_price;

        while (true) {
            System.out.print("Give Product Name: ");
            p_name = Logic_Gate.scan.nextLine();

            if (p_name.trim().isEmpty()) {
                System.out.println("Product Name Is Null/Blank");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Give Product Price: ");
            String p_price1 = Logic_Gate.scan.nextLine();

            if (p_price1.trim().isEmpty()) {
                System.out.println("Error: Price Is Null/Blank");
                continue;
            }

            try {
                p_price = Double.parseDouble(p_price1.trim());

                if (p_price <= 0) {
                    System.out.println("Error: Price Cannot Be Equals/Less Than 0");
                    continue;
                }
                if (!Double.isFinite(p_price)) {
                    System.out.println("Error: Please Enter A Valid Finite Price");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please Enter A Valid Price");
            }
        }
        product_list.add(new Product(p_name.trim(), p_price));
        System.out.println("Product Added To Inventory");
        System.out.println("");
        display();
    }

    public void removeProduct() {
        boolean inventoryChecker = product_list_Checker();

        if (inventoryChecker == true) {
            display();
            System.out.print("Type The Index Of Selected Item To Remove The Following Product: ");
            int index = index_Handler();
            product_list.remove(index);
            display();
        }
    }

    public void re_Stock() {
        int p_stock = 1;
        boolean inventoryChecker = product_list_Checker();

        if (inventoryChecker == true) {
            display_stock();
            System.out.print("Type The Index Of Selected Item To Restock The Following Product: ");
            int index = index_Handler();
            Product selected_Product = product_list.get(index);

            while (true) {
                System.out.print("Amount: ");
                String p_stock1 = Logic_Gate.scan.nextLine();

                if (p_stock1.trim().isEmpty()) {
                    System.out.println("Error: Amount Is Null/Blank");
                    continue;
                }

                try {
                    p_stock = Integer.parseInt(p_stock1.trim());

                    if (p_stock <= 0) {
                        System.out.println("Error: Amount Cannot Be Equals/Less Than 0");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please Enter A Valid Amount");
                }
            }
            selected_Product.increase_Stock(p_stock);
            display_stock();
        }
    }

    public void changePrice() {
        double p_price = 0;
        boolean inventoryChecker = product_list_Checker();

        if (inventoryChecker == true) {
            display_price();
            System.out.print("Type The Index Of Selected Item To Change The Price Of The Following Product: ");
            int index = index_Handler();
            Product selected_Product = product_list.get(index);

            while (true) {
                System.out.print("Give Product Price: ");
                String p_price1 = Logic_Gate.scan.nextLine();

                if (p_price1.trim().isEmpty()) {
                    System.out.println("Error: Price Is Null/Blank");
                    continue;
                }

                try {
                    p_price = Double.parseDouble(p_price1.trim());

                    if (p_price <= 0) {
                        System.out.println("Error: Price Cannot Be Equals/Less Than 0");
                        continue;
                    } else if (!Double.isFinite(p_price)) {
                        System.out.println("Error: Please Enter A Valid Finite Price");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please Enter A Valid Number");
                }
            }
            selected_Product.priceControl(p_price);
            display_price();
        }
    }

    public int index_Handler() {
        int p_index;
        String p_index1;

        while (true) {
            p_index1 = Logic_Gate.scan.nextLine();

            if (p_index1.trim().isEmpty()) {
                System.out.println("Error: Index Is Null/Blank");
                System.out.print("Index: ");
                continue;
            }

            try {
                p_index = Integer.parseInt(p_index1.trim());

                if (p_index >= product_list.size() || p_index < 0) {
                    System.out.println("Error: Index Is Not Valid/Not Exist");
                    System.out.print("Index: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please Enter A Valid Index");
                System.out.print("Index: ");
            }
        }
        return p_index;
    }

    public void display_inventory() {
        int item_index = 0;

        for (Product item : product_list) {
            System.out.println("(" + item_index + ")" + "Product: " + item.product_name + " |" + "Price: " + item.price
                    + " |" + "Stock: " + item.stock + " | " + item.product_id);
            item_index++;
        }
        System.out.println("");
    }

    public void display_stock() {
        int item_index = 0;

        for (Product item : product_list) {
            System.out.println(
                    "(" + item_index + ")" + "Product: " + item.product_name + " |" + "Stock: " + item.stock + " |");
            item_index++;
        }
        System.out.println("");
    }

    public void display_price() {
        int item_index = 0;

        for (Product item : product_list) {
            System.out.println(
                    "(" + item_index + ")" + "Product: " + item.product_name + " |" + "Price: " + item.price + " |");
            item_index++;
        }
        System.out.println("");
    }

    public void display() {
        int item_index = 0;

        for (Product item : product_list) {
            System.out.println("(" + item_index + ")" + "Product: " + item.product_name + " |");
            item_index++;
        }
        System.out.println("");
    }

    public boolean product_list_Checker() {
        if (product_list.isEmpty()) {
            System.out.println("No Product Inside The Store");
            System.out.println("");
            return false;
        } else {
            return true;
        }
    }

    public boolean product_list_StockChecker() {
        boolean toReturn = false;
        int stockCheck = 0;
        for (Product item : product_list) {
            if (item.stock > 0) {
                stockCheck++;
            } else {
            }
        }

        boolean inventoryChecker = product_list_Checker();

        if (inventoryChecker == true) {
            if (stockCheck == 0) {
                System.out.println("Every Product In The Store Has No Stock");
                toReturn = false;
            } else {
                toReturn = true;
            }
        }
        return toReturn;
    }

    public Product getProduct() {
        boolean inventoryChecker = product_list_Checker();
        int index = 0;

        if (inventoryChecker == true) {
            index = index_Handler();
        }
        return product_list.get(index);
    }
}
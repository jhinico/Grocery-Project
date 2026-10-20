import java.util.ArrayList;

class ShoppingCart {
    private ArrayList<CartItem> cart_Product = new ArrayList<>();

    public void addToCart(Inventory inventory, int index) {
        boolean inventoryChecker = Logic_Gate.inventory.product_list_StockChecker();
        boolean loop = true;
        boolean loop1 = true;
        int amount = 0;


        if (inventoryChecker == true) {

            Logic_Gate.inventory.display_inventory();

            while (loop == true) {
                System.out.print("Type The Index Of Selected Item To Add To Cart: ");
                Product selectedProduct = Logic_Gate.inventory.getProduct();

                int blocker = doubleProduct_Blocker(selectedProduct);
                if (selectedProduct.stock == 0) {
                    System.out.println("Error: The Product Selected Has No Stock");
                } else if (blocker == 1) {
                    System.out.println("The Chosen Product Is Already In Cart");
                    while (loop1 == true) {
                        System.out.print("Want To Change Amount? Y/N: ");
                        String input = Logic_Gate.scan.nextLine();
                        System.out.println();

                        switch (input.toLowerCase()) {
                            case "y", "yes":
                                CartItem theProduct = productSafetyNet(selectedProduct);
                                product_AmountSafetyNet(theProduct, selectedProduct);
                                loop = false;
                                Logic_Gate.customer.customer_Flow();
                                break;

                            case "n", "no":
                                loop = false;
                                loop1 = false;
                                break;

                            default:
                                System.out.println("Error: Invalid Input");
                                break;
                        }
                    }
                } else {
                    while (true) {
                        System.out.print("Amount: ");
                        String amount1 = Logic_Gate.scan.nextLine();

                        if (amount1.trim().isEmpty()) {
                            System.out.println("Error: Amount Is Null/Blank");
                            continue;
                        }

                        try {
                            amount = Integer.parseInt(amount1.trim());

                            if (amount <= 0) {
                                System.out.println("Error: Amount Cannot Be Equals/Less Than 0");
                                continue;
                            } else if (amount > selectedProduct.stock) {
                                System.out.println("Error: Amount Is More Than Whats On Stock");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Please Enter A Valid Amount");
                        }
                    }
                    cart_Product.add(new CartItem(selectedProduct, amount));
                    display_cart();
                    break;
                }
            }
        }
    }

    public void removeToCart() {
        boolean cartChecker = cart_Product_Checker();

        if (cartChecker == true) {
            display_cart();
            System.out.print("Type The Index Of Selected Item To Remove Item To Cart: ");
            int index = index_Handler();
            cart_Product.remove(index);
            display_cart();
        }
    }

    public void display_cart() {
        boolean cartChecker = cart_Product_Checker();
        int index = 0;

        if (cartChecker == true) {
            for (CartItem item : cart_Product) {
                System.out.println("(" + index + ")" + "Product: " + item.product.product_name + " |" + "Price: "
                        + item.product.price + " |" + "Amount: " + item.amount + " |");
                index++;
            }
            System.out.println();
        }
    }

    public void totalPayment() {
        double total = 0;
        boolean cartChecker = cart_Product_Checker();

        if (cartChecker == true) {
            for (CartItem item : cart_Product) {
                total += item.product.price * item.amount;
            }
            display_cart();
            System.out.println("Total: " + total + "\n");
        }
    }

    public void checkOut() {
        double finalTotal = 0;
        boolean cartChecker = cart_Product_Checker();

        if (cartChecker == true) {
            for (CartItem item : cart_Product) {
                finalTotal += item.product.price * item.amount;
            }

            receipt_upper();
            display_cart();
            System.out.println("Total: " + finalTotal + " |");
            receipt_lower();
            checkout_remover();
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

                if (p_index >= cart_Product.size() || p_index < 0) {
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

    public boolean cart_Product_Checker() {
        if (cart_Product.isEmpty()) {
            System.out.println("No Product Inside The Cart");
            System.out.println("");
            return false;
        } else {
            return true;
        }
    }

    public void checkout_remover() {
        int numProduct = cart_Product.size();
        for (int i = 0; i != numProduct ; i++) {
            int index = 0;
            CartItem call = cart_Product.get(index);
            call.checkoutfinal();
            cart_Product.remove(index);
        }
    }

    public void receipt_upper() {
        System.out.println("============================================================");
        System.out.println("                         RECEIPT                            ");
        System.out.println("============================================================");

    }

    public void receipt_lower() {
        System.out.println("============================================================\n\n\n\n");
    }

    public void customer_upper() {
        System.out.println("============================================================");
        System.out.println("                         CUSTOMER                           ");
        System.out.println("============================================================");

    }

    public void customer_lower() {
        System.out.println("============================================================\n\n\n\n");
    }

    public void change_amount() {
        int amount = 0;
        boolean inventoryChecker = cart_Product_Checker();

        if (inventoryChecker == true) {
            display_cart();
            System.out.print("Type The Index Of The Product In Cart: ");
            int index = index_Handler();
            CartItem selected_Product = cart_Product.get(index);

            while (true) {
                System.out.print("Amount: ");
                String amount1 = Logic_Gate.scan.nextLine();

                if (amount1.trim().isEmpty()) {
                    System.out.println("Error: Amount Is Null/Blank");
                    continue;
                }

                try {
                    amount = Integer.parseInt(amount1.trim());

                    if (amount <= 0) {
                        System.out.println("Error: Amount Cannot Be Equals/Less Than 0");
                        continue;
                    } else if (amount > selected_Product.product.stock) {
                        System.out.println("Error: Amount Is More Than Whats On Stock");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please Enter A Valid Amount");
                }
            }
            selected_Product.changeAmount(amount);
            display_cart();
        }
    }

    public int doubleProduct_Blocker(Product selectedProduct) {
        int forBlocker = 0;

        for (CartItem item : cart_Product) {
            if (item.product.product_id == selectedProduct.product_id) {
                forBlocker++;
            }
        }
        return forBlocker;
    }

    public void product_AmountSafetyNet(CartItem theProduct, Product selectedProduct) {
        int amount = 0;

        while (true) {
            System.out.print("Amount: ");
            String amount1 = Logic_Gate.scan.nextLine();

            if (amount1.trim().isEmpty()) {
                System.out.println("Error: Amount Is Null/Blank");
                continue;
            }

            try {
                amount = Integer.parseInt(amount1.trim());

                if (amount <= 0) {
                    System.out.println("Error: Amount Cannot Be Equals/Less Than 0");
                    continue;
                } else if (amount > selectedProduct.stock) {
                    System.out.println("Error: Amount Is More Than Whats On Stock");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please Enter A Valid Amount");
            }
        }
        theProduct.amount = amount;
        display_cart();
    }

    public CartItem productSafetyNet(Product selecteProduct) {
        CartItem theProduct = cart_Product.get(0);
        for (CartItem product : cart_Product) {
            if (product.product.product_id == selecteProduct.product_id) {
                theProduct = product;
            }
        }
        return theProduct;
    }
}
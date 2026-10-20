class Product {
    String product_name;
    double price;
    int stock;
    int product_id;
    static int id;

    public Product(String product_name, double price) {
        this.product_name = product_name;
        this.price = price;
        this.stock = 20;
        this.product_id = id;
        id++;
    }

    public void increase_Stock(int p_stock) {
        this.stock += p_stock;
    }

    public void priceControl(double p_price) {
        this.price = p_price;
    }
}

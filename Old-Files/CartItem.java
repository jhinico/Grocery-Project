class CartItem {
    Product product;
    int amount;

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public void checkoutfinal() {
        this.product.stock -= this.amount;
    }

    public void changeAmount(int amount) {
        this.amount = amount;
    }
}

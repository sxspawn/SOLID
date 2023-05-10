public class Purchase {

    private int productId;
    private int count;

    public Purchase(int productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

}
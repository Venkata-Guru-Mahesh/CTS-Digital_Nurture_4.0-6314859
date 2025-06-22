public class Product {
    @SuppressWarnings("unused")
    int productId;
    String productName;
    @SuppressWarnings("unused")
    String category;

    public Product(int productId, String productName,String category) {
        this.category = category;
        this.productId = productId;
        this.productName = productName;
    }

}

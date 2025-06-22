import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int equals = products[mid].productName.compareToIgnoreCase(targetName);

            if (equals == 0) {
                return products[mid];
            } else if (equals < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Facewash", "Cosmetics"),
            new Product(103, "Chair", "Furniture"),
            new Product(104, "Table", "Furniture"),
            new Product(105, "Camera", "Electronics")
        };

        System.out.println("Using Linear Search:");
        Product result1 = linearSearch(productList, "Camera");
        if (result1 != null)
            System.out.println("Found: " + result1.productName);
        else
            System.out.println("Product not found");



        Product result2 = linearSearch(productList, "Mobile");
        if (result2 != null)
            System.out.println("Found: " + result2.productName);
        else
            System.out.println("Product not found");



        Arrays.sort(productList, Comparator.comparing(p -> p.productName));


        System.out.println("\nUsing Binary Search:");
        Product result3 = binarySearch(productList, "Camera");
        if (result3 != null)
            System.out.println("Found: " + result3.productName);
        else
            System.out.println("Product not found");


        Product result4 = binarySearch(productList, "Mobile");
        if (result4 != null)
            System.out.println("Found: " + result4.productName);
        else
            System.out.println("Product not found");
    }
}

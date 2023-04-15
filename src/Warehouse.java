package src;

import java.util.ArrayList;
import java.util.List;

// Принцип Single Responsibility. Класс Warehouse отвечает только за управление запасами товаров на складе, обеспечивает их хранение и выдачу.
public class Warehouse {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void processOrder(Product product, int amount) {
        product.decreaseQuantity(amount);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProducts(int amount) {
        List<Product> selectedProducts = new ArrayList<>();
        int totalAmount = 0;

        for (Product product : products) {
            if (totalAmount >= amount) {
                break;
            }

            int availableAmount = Math.min(amount - totalAmount, product.getQuantity());
            Product selectedProduct = new Product(product.getName(), availableAmount, product.getPrice());
            selectedProducts.add(selectedProduct);

            totalAmount += availableAmount;
        }

        return selectedProducts;
    }

    public void increaseProductQuantity(Product product, int amount) {
        product.increaseQuantity(amount);
    }

    public void decreaseProductQuantity(Product product, int amount) {
        product.decreaseQuantity(amount);
    }
}
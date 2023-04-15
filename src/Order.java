package src;
// The Single Responsibility Principle. Класс Order отвечает только за обработку заказов на товары со склада и использует объекты класса Product для реализации этой функциональности. 

public class Order {
    public void processOrder(Product product, int amount) {
        if (product.getQuantity() >= amount) {
            product.decreaseQuantity(amount);
            System.out.println("Order processed");
        } else {
            throw new IllegalArgumentException("Insufficient quantity");
        }
    }
}
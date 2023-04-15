package src;
// принцип единственной ответственности (SRP), разделяя логику работы с продуктами на класс Product, логику работы со складом на класс Warehouse и логику обработки заказов на класс Order. Мы также применяем принцип открытости/закрытости (OCP), создавая классы Product, Warehouse и Order, которые могут быть легко расширены и изменены без изменения кода в других классах.

public class Main {
    public static void main(String[] args) {
        // создаем объект склада
        Warehouse warehouse = new Warehouse();
        
        // создаем объекты продуктов
        Product product1 = new Product("Продукт 1", 10, 5.0);
        Product product2 = new Product("Продукт 2", 20, 10.0);
        
        // добавляем продукты на склад
        warehouse.addProduct(product1);
        warehouse.addProduct(product2);
        
        // обрабатываем заказы
        try {
            // пытаемся обработать заказ на продукт 1 в количестве 5 штук
            warehouse.processOrder(product1, 5);
            System.out.println("Заказ на " + product1.getName() + " обработан успешно.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при обработке заказа на " + product1.getName() + ": " + e.getMessage());
        }
        
        try {
            // пытаемся обработать заказ на продукт 2 в количестве 25 штук
            warehouse.processOrder(product2, 25);
            System.out.println("Заказ на " + product2.getName() + " обработан успешно.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при обработке заказа на " + product2.getName() + ": " + e.getMessage());
        }
        
        // выводим информацию о продуктах на складе
        for (Product product : warehouse.getProducts()) {
            System.out.println("Название продукта: " + product.getName());
            System.out.println("Количество продукта: " + product.getQuantity());
            System.out.println("Цена продукта: " + product.getPrice());
        }
        }
}
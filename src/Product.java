package src;
// Принцип Single Responsibility - класс отвечает только за хранение информации о товаре
public class Product {
private String name;
private int quantity;
private double price;

// Принцип Dependency Inversion - используем конструктор для внедрения зависимостей
public Product(String name, int quantity, double price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
}

// Принцип Encapsulation - скрываем внутреннее состояние класса, чтобы не дать изменять его напрямую
public String getName() {
    return name;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public double getPrice() {
    return price;
}

// Принцип Single Responsibility - методы отвечают только за изменение количества товара
public void decreaseQuantity(int amount) {
    if (amount > 0 && amount <= quantity) {
        quantity -= amount;
    } else {
        throw new IllegalArgumentException("Invalid amount");
    }
}

public void increaseQuantity(int amount) {
    if (amount > 0) {
        quantity += amount;
    } else {
        throw new IllegalArgumentException("Invalid amount");
    }
}
}
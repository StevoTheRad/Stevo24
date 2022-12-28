package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test

    public void addTestBooks() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Властелин колец", 900, "Дж. Толкин");
        Book book2 = new Book(2, "Тихий Дон", 350, "М.А. Шолохов");
        Book book3 = new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test

    public void addTestSmartphones() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smarthphone smart1 = new Smarthphone(1, "Nokia", 30_000, "Nokia");
        Smarthphone smart2 = new Smarthphone(2, "Iphone", 60_000, "Apple");
        Smarthphone smart3 = new Smarthphone(3, "Xiaomi", 20_000, "Xiaomi");

        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] actual = repo.findAll();
        Product[] expected = {smart1, smart2, smart3};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test

    public void searchTestShouldFindOneBook() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Властелин колец", 900, "Дж. Толкин");
        Book book2 = new Book(2, "Тихий Дон", 350, "М.А. Шолохов");
        Book book3 = new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Собака");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test

    public void searchTestShouldFindZeroBooks() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Властелин колец", 900, "Дж. Толкин");
        Book book2 = new Book(2, "Тихий Дон", 350, "М.А. Шолохов");
        Book book3 = new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Кот");
        Product[] expected = {};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test

    public void addTestShouldFindOneSmartphone() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smarthphone smart1 = new Smarthphone(1, "Nokia", 30_000, "Nokia");
        Smarthphone smart2 = new Smarthphone(2, "Iphone", 60_000, "Apple");
        Smarthphone smart3 = new Smarthphone(3, "Xiaomi", 20_000, "Xiaomi");

        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {smart2};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test

    public void addTestShouldFindZeroSmartphone() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smarthphone smart1 = new Smarthphone(1, "Nokia", 30_000, "Nokia");
        Smarthphone smart2 = new Smarthphone(2, "Iphone", 60_000, "Apple");
        Smarthphone smart3 = new Smarthphone(3, "Xiaomi", 20_000, "Xiaomi");

        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] actual = manager.searchBy("OnePlus");
        Product[] expected = {};

        Assertions.assertArrayEquals(actual, expected);

    }
}

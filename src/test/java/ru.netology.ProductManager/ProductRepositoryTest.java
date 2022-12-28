package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test

    public void deleteTestBooks() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Властелин колец", 900, "Дж. Толкин");
        Book book2 = new Book(2, "Тихий Дон", 350, "М.А. Шолохов");
        Book book3 = new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.deleteById(3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test

    public void DeleteTestSmartphones() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smarthphone smart1 = new Smarthphone(1, "Nokia", 30_000, "Nokia");
        Smarthphone smart2 = new Smarthphone(2, "Iphone", 60_000, "Apple");
        Smarthphone smart3 = new Smarthphone(3, "Xiaomi", 20_000, "Xiaomi");

        repo.add(smart1);
        repo.add(smart2);
        repo.add(smart3);
        repo.deleteById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {smart1, smart3};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test

    public void deleteTestBooksWithWrongID() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Властелин колец", 900, "Дж. Толкин");
        Book book2 = new Book(2, "Тихий Дон", 350, "М.А. Шолохов");
        Book book3 = new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        ;
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.deleteById(4));
    }

    @Test

    public void DeleteTestSmartphonesWithWrongID() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smarthphone smart1 = new Smarthphone(1, "Nokia", 30_000, "Nokia");
        Smarthphone smart2 = new Smarthphone(2, "Iphone", 60_000, "Apple");
        Smarthphone smart3 = new Smarthphone(3, "Xiaomi", 20_000, "Xiaomi");

        repo.add(smart1);
        repo.add(smart2);
        repo.add(smart3);


        Assertions.assertThrows(NotFoundException.class, () -> repo.deleteById(5));

    }
}

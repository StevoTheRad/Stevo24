package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class ProductManagerTest {

    @Test

    public void addTest () {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 =new Book(1, "Властелин колец", 900, "Дж. Толкин"  );
        Book book2 =new Book(2, "Тихий Дон", 350, "М.А. Шолохов"  );
        Book book3 =new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(actual, expected);

    }
}

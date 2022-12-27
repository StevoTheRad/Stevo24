package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class ProductRepositoryTest {

    @Test

    public void deleteTest() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 =new Book(1, "Властелин колец", 900, "Дж. Толкин"  );
        Book book2 =new Book(2, "Тихий Дон", 350, "М.А. Шолохов"  );
        Book book3 =new Book(3, "Собака Баскервилей", 400, "Артур Конан Дойл");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.deleteById(3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(actual, expected);
    }
}

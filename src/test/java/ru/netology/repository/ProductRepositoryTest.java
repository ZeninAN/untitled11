package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    private Book id = new Book();

    @Test
    public void save() {
        Product first = new Product(1, "книга", 4);
        Product second = new Product(2, "нетелефон", 5);
        repo.save(first);
        repo.save(second);
        repo.removeById(1);

        Product[] expected = new Product[]{second};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ex() throws NotFoundException {
        Product first = new Product(1, "книга", 4);
        Product second = new Product(2, "нетелефон", 5);
        repo.save(first);
        repo.save(second);
        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(3));
    }
}
//Product[] actual = repo.findAll();
//Product[] expected = {first,second};

//assertArrayEquals(expected, actual);
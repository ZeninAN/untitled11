import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerProductTest {
    private ManagerProduct man = new ManagerProduct(new ProductRepository());
    private Book first = new Book(1, "крест", 455, "человек");
    private Book second = new Book(2, "книга", 245, "пушкин");
    private Smartphone one = new Smartphone(3, "айфон", 4000, 45);
    private Smartphone two = new Smartphone(4, "айфон", 6000, 23);

    @Test
    public void search() {
        man.saveProduct(first);
        man.saveProduct(second);

        Product[] expected = new Product[]{first};
        Product[] actual = man.searchBy("крест");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void search2() {
        man.saveProduct(first);
        man.saveProduct(second);
        man.saveProduct(one);

        Product[] expected = new Product[]{};
        Product[] actual = man.searchBy("one");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void search3() {
        man.saveProduct(first);
        man.saveProduct(second);
        man.saveProduct(one);
        man.saveProduct(two);

        Product[] expected = new Product[]{one, two};
        Product[] actual = man.searchBy("айфон");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void save() {
        man.saveProduct(first);
        man.saveProduct(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = man.findAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        man.saveProduct(first);
        man.saveProduct(second);

        man.removeById(1);

        Product[] expected = new Product[]{second};
        Product[] actual = man.findAllProducts();
        assertArrayEquals(expected, actual);
    }
}




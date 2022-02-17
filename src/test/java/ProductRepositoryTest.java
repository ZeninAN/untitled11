import org.junit.jupiter.api.Test;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    private Book id = new Book();
    @Test
    public void save(){
        Product first = new Product(1,"книга",4);
        Product second = new Product(2,"нетелефон",5);
        repo.save(first);
        repo.save(second);
      repo.removeById(1);

      Product[] expected = new Product[]{second};
      Product[] actual = repo.findAll();
      assertArrayEquals(expected,actual);
    }

}
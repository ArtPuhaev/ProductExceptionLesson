package ru.netology.javaqa.javaqamvn.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.exceptionclass.AlreadyExistsException;
import ru.netology.javaqa.javaqamvn.exceptionclass.NotFoundException;

public class ShopRepositoryTest {
    @Test
    public void shouldAddToArray() {
        Product product1 = new Product(1, "Book", 450);
        Product product2 = new Product(2, "TShirt", 2100);
        Product product3 = new Product(3, "Pants", 4000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        Product[] expected = {product1, product2, product3};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnExceptionWhenAddingSimilarId() {
        Product product1 = new Product(1, "Book", 450);
        Product product2 = new Product(2, "TShirt", 2100);
        Product product3 = new Product(2, "Pants", 4000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product3);
        });

    }

    @Test
    public void shouldRemoveById() {
        Product product1 = new Product(1, "Book", 450);
        Product product2 = new Product(2, "TShirt", 2100);
        Product product3 = new Product(3, "Pants", 4000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(3);

        Product[] expected = {product1, product2};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnExceptionWhenRemovingNonExistentId() {
        Product product1 = new Product(1, "Book", 450);
        Product product2 = new Product(2, "TShirt", 2100);
        Product product3 = new Product(3, "Pants", 4000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(6);
        });
    }
}

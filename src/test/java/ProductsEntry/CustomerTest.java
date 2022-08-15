package ProductsEntry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class CustomerTest {
    List<Products> customerCart;
    Customer customer;
    @BeforeEach
    void setUp() {
        customerCart = new ArrayList<>();
        Products products = new Products("Bars","Carrot",12,1.77);
        Products products2 = new Products("Snacks","Potato Chips",12,1.77);
        customerCart.add(products);
        customerCart.add(products2);
         customer = mock(Customer.class);
    }

    @Test
    void buyProduct() {
        customer.buyProduct(customerCart);
        doNothing().when(customer).buyProduct(isA(List.class));

        verify(customer,times(1)).buyProduct(customerCart);
    }
}
package ProductsEntry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class CashierTest {
  static Queue<Customer> customerList;
 static Customer customer;
 static Cashier cashierMock;
 static Queue<CustomerDTO> customerDTOQueue;
 static CustomerDTO customerDTO;
 static Cashier cashier;
   static HashMap<String, Products> storeProduct;
    @BeforeAll
   static void setUp(){
         cashierMock = mock(Cashier.class);
         customerList = new LinkedList<>();
         customer = new Customer("John", 101, List.of(new Products("Bars","Carrot",12,1.77), new Products("snacks", "Potato Chips", 20, 1.68)));
         customerDTOQueue = new PriorityQueue<>(new CustomerDTOComparation());
        customerDTO  = new CustomerDTO("Gozie","Carrot",23,2);
        cashier = new Cashier("Chigozie",3);
        customerDTOQueue.add(customerDTO);
        Products products = new Products("Bars","Carrot",12,1.77);
          storeProduct = new HashMap<>();
          storeProduct.put("Carrot",products);
    }
    @Test
    @DisplayName("Should set product queue")
    void shouldTest() throws Exception{
        customerList.add(customer);
        cashierMock.setProductQueue(customerList);
        doNothing().when(cashierMock).setProductQueue(isA(Queue.class));
        verify(cashierMock, times(1)).setProductQueue(customerList);

    }
    @Test
    void validateProductShouldReturnTrue(){
        cashier.setProd(storeProduct);
        Assertions.assertTrue(cashier.validateProduct(customerDTOQueue));
    }
    @Test
    void ExceptionShouldBeThrownWhenProductIsInvalid() throws IllegalArgumentException{
        Queue<CustomerDTO> customerDTOQueue2 = new PriorityQueue<>(new CustomerDTOComparation());
      CustomerDTO customerDTO1  = new CustomerDTO("Gozie","Carrot",23,2);
        customerDTOQueue2.add(customerDTO1);

     Throwable exception =   Assertions.assertThrows(IllegalArgumentException.class,()->cashier.validateProduct(customerDTOQueue2));

     Assertions.assertEquals("Invalid product",exception.getMessage());

    }
}
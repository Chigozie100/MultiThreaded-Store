package ProductsEntry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreTest {

    @Test
    void setProducts() {
        Store store = mock(Store.class);
        store.setProducts();

        doNothing().when(store).setProducts();
        verify(store,times(1)).setProducts();
    }
}
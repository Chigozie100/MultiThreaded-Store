package ProductsEntry;

import java.util.Comparator;

public class CustomerDTOComparation implements Comparator<CustomerDTO> {

    @Override
    public int compare(CustomerDTO o1, CustomerDTO o2) {
        if (o1.getProductQuantity() < o2.getProductQuantity()) return 1;


        else if (o1.getProductQuantity() == o2.getProductQuantity()) {
            if (o1.getCustomerID() > o2.getCustomerID())
                return 1;
        }  return -1;
    }

}

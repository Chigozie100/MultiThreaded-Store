package ProductsEntry;

import ProductsEntry.Enums.ProductStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer {
    private String customerName;
    private int CustomerId;
    private HashMap<String, List<Products>> listOfProducts ;
    private List<Products> customerCart = new ArrayList<>();
    private ProductStatus productStatus;

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    int totalItemInCart = 0;

    public Customer(String customerName, int customerId) {
        this.customerName = customerName;
        CustomerId = customerId;
        this.listOfProducts = listOfProducts;
    }
    public Customer(String customerName, int customerId, List<Products> products) {
        this.customerName = customerName;
        CustomerId = customerId;
        this.customerCart = products;
    }

    public int getTotalItemInCart() {
        return totalItemInCart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public void buyProduct(List<Products> customercart){
            for (Products item : customercart) {
                if (listOfProducts.containsKey(item.getProductCategory())) {
                    List<Products> prod = listOfProducts.get(item.getProductCategory());
                    for (Products pro : prod) {
                        if (pro.getProductName().equalsIgnoreCase(item.getProductName())) {
                            pro.setProductQuantity(pro.getProductQuantity() - item.getProductQuantity());
                            customerCart.add(item);
                        }
                    }
                }

            }
            if(customerCart.isEmpty())
            {
                System.out.println("No product in cart");
            }
    }

    public List<Products> getCustomerCart() {
        return customerCart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", CustomerId=" + CustomerId +
                ", listOfProducts=" + listOfProducts +
                ", customerCart=" + customerCart +
                ", totalItemInCart=" + totalItemInCart +
                '}';
    }


}



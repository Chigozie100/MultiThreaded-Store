package ProductsEntry;


import lombok.AllArgsConstructor;
import lombok.Data;



public class CustomerDTO {
    private String customerName;
    private String productName;
    private int productQuantity;
    private int customerID;

    public CustomerDTO(String customerName, String productName, int productQuantity, int customerID) {
        this.customerName = customerName;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", customerID=" + customerID +
                '}';
    }
}


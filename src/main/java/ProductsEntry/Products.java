package ProductsEntry;

import java.util.Objects;

public class Products {
    private String productCategory;
    private String ProductName;
    private int ProductQuantity;
    private double productPrice;

    public Products(String productCategory, String productName, int productQuantity, double productPrice) {
        this.productCategory = productCategory;
        ProductName = productName;
        ProductQuantity = productQuantity;
        this.productPrice = productPrice;
    }


    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productCategory='" + productCategory + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", ProductQuantity=" + ProductQuantity +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return ProductQuantity == products.ProductQuantity && Double.compare(products.productPrice, productPrice) == 0 && productCategory.equals(products.productCategory) && ProductName.equals(products.ProductName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategory, ProductName, ProductQuantity, productPrice);
    }
}

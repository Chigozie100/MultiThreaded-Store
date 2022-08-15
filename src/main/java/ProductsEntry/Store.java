package ProductsEntry;

import ProductsEntry.Enums.ProductStatus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {
    private ArrayList<Products> products;
    private HashMap<String, Products> productList = new HashMap<>();
    private ProductStatus productStatus;
    private ArrayList<Products> temp = new ArrayList<>();

    public void setProducts() {
        String path ="/Users/user/Documents/Decagon_java_Assignments/Week_3/MultiThreaded-Store/src/myFile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";

            int iterate = 0;
            while ((line = br.readLine()) != null) {
                if (iterate == 0) {
                    iterate++;
                    continue;
                }
                String[] str = line.split(",");
                Products listOfProducts = new Products(str[3], str[4], Integer.parseInt(str[5]), Double.parseDouble(str[6]));

                if (productList.containsKey(str[4])){
                    Products pro = productList.get(str[4]);
                  pro.setProductQuantity(pro.getProductQuantity() + listOfProducts.getProductQuantity());
                  productList.put(str[4],pro);
                }
                else {
                    productList.put(str[4],listOfProducts);
                }
            }
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
        } catch (IOException e) {
            // throw new RuntimeException(e);
        }
    }

    public HashMap<String, Products> getProductList() {
        return productList;
    }

    public void setProductList(HashMap<String, Products> productList) {
        this.productList = productList;
    }
}

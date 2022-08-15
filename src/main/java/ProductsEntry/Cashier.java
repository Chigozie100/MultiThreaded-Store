package ProductsEntry;

import java.util.*;

public class Cashier extends Employees implements Runnable{
    private CustomerDTOComparation  cmp = new CustomerDTOComparation();
private Queue<CustomerDTO> carrotList = new PriorityQueue<>(cmp);
private Queue<CustomerDTO> potatochipsList = new PriorityQueue<>(cmp);
private Queue<CustomerDTO> oatmealList = new PriorityQueue<>(cmp);
private Queue<CustomerDTO> wholewheatList = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> Bran = new PriorityQueue<>(cmp);
private HashMap<String, Products> storeProduct = new HashMap<>();



    public Cashier(String employeeName, int employeeId) {
        super(employeeName, employeeId);
    }

    public void setProductQueue(Queue<Customer> customer){
        for (Customer cus : customer) {
            for (Products pro : cus.getCustomerCart()) {
                if (pro.getProductName().equalsIgnoreCase("Carrot")) {
                    carrotList.offer(new CustomerDTO(cus.getCustomerName(), pro.getProductName(), pro.getProductQuantity(),cus.getCustomerId()));
                } else if (pro.getProductName().equalsIgnoreCase("Potato Chips")) {
                    potatochipsList.offer(new CustomerDTO(cus.getCustomerName(), pro.getProductName(), pro.getProductQuantity(), cus.getCustomerId()));
                } else if (pro.getProductName().equalsIgnoreCase("Oatmeal Raisin")) {
                    oatmealList.offer(new CustomerDTO(cus.getCustomerName(), pro.getProductName(), pro.getProductQuantity(),cus.getCustomerId()));
                } else if (pro.getProductName().equalsIgnoreCase("whole wheat")) {
                    wholewheatList.offer(new CustomerDTO(cus.getCustomerName(), pro.getProductName(), pro.getProductQuantity(), cus.getCustomerId()));
                }
                else if (pro.getProductName().equalsIgnoreCase("Bran")) {
                    wholewheatList.offer(new CustomerDTO(cus.getCustomerName(), pro.getProductName(), pro.getProductQuantity(), cus.getCustomerId()));
                }
            }
        }
    }

    public boolean validateProduct(Queue<CustomerDTO> products){
        for(CustomerDTO i : products){
            if(storeProduct.containsKey(i.getProductName())){
                Products prod = storeProduct.get(i.getProductName());
                //to check if customer prod quan is greater than d store quantity
                //update store quan
                if(i.getProductQuantity() > prod.getProductQuantity() && prod.getProductQuantity() != 0) {
                    int reduce = i.getProductQuantity() - prod.getProductQuantity();
                    i.setProductQuantity(i.getProductQuantity() - reduce);
                    prod.setProductQuantity(i.getProductQuantity() - prod.getProductQuantity());
                    storeProduct.put(i.getProductName(),prod);
                }
                //update store quan when cus quan is <= prod quan
              else {
                    int newProd = prod.getProductQuantity() - i.getProductQuantity();
                    prod.setProductQuantity(newProd);
                    storeProduct.put(i.getProductName(),prod);
                }


            }
            else{
                throw new IllegalArgumentException("Invalid product");
            }

        }
        return true;
    }
    public void sellByPriority(Queue<CustomerDTO> customerDTO){
           boolean result = validateProduct(customerDTO);
           if(result)
           {
               while (customerDTO.peek() != null){
                   System.out.println(customerDTO.poll());
               }
           }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String issuesReceipt(){
        return "Thanks for your shopping with us";
    }


    public Queue<CustomerDTO> getCarrotList() {
        return carrotList;
    }

    public Queue<CustomerDTO> getPotatochipsList() {
        return potatochipsList;
    }

    public Queue<CustomerDTO> getOatmealList() {
        return oatmealList;
    }

    public Queue<CustomerDTO> getWholewheatList() {
        return wholewheatList;
    }

    public HashMap<String, Products> getProd() {
        return storeProduct;
    }

    public void setProd(HashMap<String, Products> prod) {
        this.storeProduct = prod;
    }

    public Queue<CustomerDTO> getBran() {
        return Bran;
    }

    public void setBran(Queue<CustomerDTO> bran) {
        Bran = bran;
    }

     @Override
     public void run() {
         for (int i = 1; i < 5; i++){
             System.out.println("Current value after" + Thread.currentThread().getName() + " " + i);
         }
     }
 }

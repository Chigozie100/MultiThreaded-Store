package ProductsEntry;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //STORE
        Store store = new Store();
        store.setProducts();




        //PRODUCTS
//        List<Products> customercart = List.of( new Products("Snacks", "potato chips", 10, 1.35),
//                                    new Products("Cookies", "chocolate chip", 15, 1.87));

        //CUSTOMER


//
//        Customer customer = new Customer("Gozie",1);
//       customer.buyProduct(customercart);

       // System.out.println(customer.getCustomerCart());

        Queue<Customer> customerList = new LinkedList<>();


        Customer john = new Customer("John", 101, List.of(new Products("Bars","Carrot",12,1.77), new Products("snacks", "Potato Chips", 20, 1.68)));
        Customer fabian = new Customer("Fabian", 106, List.of(new Products("Crackers", "Whole Wheat", 456, 1.68), new Products("Cookies", "Oatmeal Raisin", 34, 3.49)));
        Customer ada = new Customer("Ada", 103, List.of(new Products("Crackers", "Whole Wheat", 456, 3.49), new Products("Bars", "Carrot", 10, 1.77)));
        Customer obum = new Customer("Obum", 104, List.of(new Products("Cookies", "Oatmeal Raisin", 754, 2.84), new Products("Crackers", "Whole Wheat", 5, 3.49)));
        Customer kosi = new Customer("Kosi", 105, List.of(new Products("Snacks", "Potato Chips", 23, 1.68), new Products("Cookies", "Oatmeal Raisin", 25, 3.49)));
        Customer david = new Customer("David", 106, List.of(new Products("Snacks", "Potato Chips", 23, 1.68), new Products("Cookies", "Oatmeal Raisin", 34, 3.49)));

        Customer kenny = new Customer("David", 106, List.of(new Products("Snacks", "Bran", 1777, 1.68), new Products("Cookies", "Oatmeal Raisin", 34, 3.49)));

        Runnable runnable = () ->{
        customerList.add(john);
        customerList.add(fabian);
        customerList.add(ada);
        customerList.add(obum);
        customerList.add(kosi);
        customerList.add(david);
        customerList.add(kenny);

            System.out.println("Current Thread for adding-> " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(runnable);
        thread.start();


       // cashier
        Cashier cashier1 = new Cashier("Cjah", 1002);


        cashier1.setProd(store.getProductList());
        cashier1.setProductQueue(customerList);


        System.out.println(store.getProductList());


           CustomerThread  customerThread = new CustomerThread(cashier1, cashier1.getCarrotList());
           customerThread.start();
           CustomerThread customerThread1 = new CustomerThread(cashier1, cashier1.getOatmealList());
           customerThread1.start();
           CustomerThread customerThread2 = new CustomerThread(cashier1, cashier1.getPotatochipsList());
           customerThread2.start();
           CustomerThread customerThread3 = new CustomerThread(cashier1, cashier1.getWholewheatList());
           customerThread3.start();
           CustomerThread customerThread4 = new CustomerThread(cashier1, cashier1.getBran());
           customerThread4.start();

        HashMap<String,Products> hashMap = store.getProductList();

        System.out.println(hashMap);


    }
}

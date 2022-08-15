package ProductsEntry;

import java.util.Queue;

public class CustomerThread implements Runnable{
    private Cashier cashier;
    private Thread thread;
    private Queue<CustomerDTO> customerDTOQueue;

    public CustomerThread(Cashier cashier, Queue<CustomerDTO> customerDTOQueue) {
        this.cashier = cashier;
        this.customerDTOQueue = customerDTOQueue;
    }

    @Override
    public void run() {
            System.out.println("Current thread -> "+Thread.currentThread().getName());
            cashier.sellByPriority(customerDTOQueue);
    }
    public void start(){
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
}

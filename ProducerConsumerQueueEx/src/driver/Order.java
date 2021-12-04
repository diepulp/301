package driver;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private String origin;
    private String item;
    private int qty;
    private int orderNum;

    //use the class field that is thread safe
    //thread safe options for a field (balance, sum)
    private static AtomicInteger genId = new AtomicInteger(1);

    public Order(String origin, String item, int qty) {
        this.origin = origin;
        this.item = item;
        this.qty = qty;
        this.orderNum = getNextOrderNum();
    }

    private int getNextOrderNum(){
        //use atomic integer genId to initialize orderNum
        return genId.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Order{" +
                "origin='" + origin + '\'' +
                ", item='" + item + '\'' +
                ", qty=" + qty +
                ", orderNum=" + orderNum +
                '}';
    }
}

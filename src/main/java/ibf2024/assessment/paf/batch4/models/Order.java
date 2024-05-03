package ibf2024.assessment.paf.batch4.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
    
    private String orderId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date date;
    private int brewerId;
    // stringify json
    // private List<BeerOrder> orders;
    private String orders;



    public Order() {
        this.orderId =  UUID.randomUUID().toString().substring(0, 8);
    }
    
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getBrewerId() {
        return brewerId;
    }
    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }
    public String getOrders() {
        return orders;
    }
    public void setOrders(String orders) {
        this.orders = orders;
    }

    



}

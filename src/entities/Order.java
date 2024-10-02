package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Order() {}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItem() {
        return items;
    }




    public void addItems(OrderItem item) {
        items.add(item);
    }
    public void removeItems(OrderItem item) {
        items.remove(item);
    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: " +"\n");
        sb.append("Order moment: " + sdf2.format(getMoment()) +"\n");
        sb.append("Client:  " + getClient().getName() +" ("+ sdf.format(getClient().getBirthDate()) + ") - "+ getClient().getEmail()  + "\n");

        sb.append("Order items: " + "\n");
        for(OrderItem c : items) {
            sb.append(c.getProduct().getName() +", $"+ c.getProduct().getPrice() + ", " +"Quantity: "+c.getProduct().getQuantity() + " Subtotal: " + c.getProduct().subTotal()+ "\n");
        }
        double sum = 0.0;
        for(OrderItem c : items) {
            sum += c.getProduct().subTotal();
        }
        sb.append("TOTAL PRICE: $ "+ sum + "\n");

        return sb.toString();
    }


}

package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


        System.out.println("Enter client data: ");
        System.out.printf("Name: ");
        String name = sc.nextLine();
        System.out.printf("Email: ");
        String email = sc.nextLine();
        System.out.printf("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        System.out.println("Enter order data: ");
        System.out.printf("Status: ");
        String status = sc.nextLine();

        Client client = new Client(name, email, birthDate);
        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.printf("How many items to this order? ");
        int items = sc.nextInt();

        for(int i = 0; i < items; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.printf("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.printf("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.printf("quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, productPrice, quantity);
            OrderItem orderItem = new OrderItem(items, product);
            order.addItems(orderItem);
        }

//        System.out.println("ORDER SUMMARY: ");
//        System.out.println("Order moment: " + sdf2.format(order.getMoment()));
//        System.out.println("Order status: " + order.getStatus());
//        System.out.println("Client: " + order.getClient().getName() +" ("+ sdf.format(order.getClient().getBirthDate()) + ") - "+ order.getClient().getEmail());
//        System.out.println("ORDER ITEMS: ");
        System.out.println(order);

    }
}
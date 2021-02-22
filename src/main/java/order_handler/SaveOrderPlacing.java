package order_handler;

import exception.ParseOrderException;
import pizza_order.PizzaOrder;
import serializer.OrderSerializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveOrderPlacing extends OrderPlacing {
    private final String FILEORDER;
    private final OrderSerializer ORDERSERIALIZER;
    private OrderPlacing orderPlacing;

    public SaveOrderPlacing(String FILEORDER, OrderSerializer ORDERSERIALIZER, OrderPlacing orderPlacing) {
        this.FILEORDER = FILEORDER;
        this.ORDERSERIALIZER = ORDERSERIALIZER;
        this.orderPlacing=orderPlacing;
    }

    public void orderHandlerImpl(PizzaOrder pizzaOrder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEORDER, true))) {
            writer.write(ORDERSERIALIZER.serialize(pizzaOrder) + "\r\n");
            System.out.println("Заказ записан в файл");
            writer.flush();
            orderPlacing.orderHandlerImpl(pizzaOrder);
        } catch (IOException e) {
            new ParseOrderException().getMessage();
        }
    }

}

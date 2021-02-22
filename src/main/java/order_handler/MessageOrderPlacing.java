package order_handler;

import pizza_order.PizzaOrder;
import serializer.OrderSerializer;

public class MessageOrderPlacing extends OrderPlacing {
   private final OrderSerializer ORDERSERIALIZER;


    public MessageOrderPlacing(OrderSerializer orderserializer) {
       ORDERSERIALIZER=orderserializer;

    }


    private void getMessage (PizzaOrder pizzaOrder) {
        System.out.printf("Заказ %s принят в работу",
                ORDERSERIALIZER.serialize(pizzaOrder));
    }

    public  void orderHandlerImpl(PizzaOrder pizzaOrder){
        getMessage(pizzaOrder);
    }
}

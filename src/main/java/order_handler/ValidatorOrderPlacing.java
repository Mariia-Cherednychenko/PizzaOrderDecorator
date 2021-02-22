package order_handler;

import pizza_order.PizzaOrder;
import serializer.OrderSerializer;

public class ValidatorOrderPlacing extends OrderPlacing {
    private final OrderSerializer ORDERSERIALIZER;
    private OrderPlacing orderPlacing;

     public ValidatorOrderPlacing(OrderSerializer ORDERSERIALIZER, OrderPlacing orderPlacing) {
        this.ORDERSERIALIZER = ORDERSERIALIZER;
        this.orderPlacing=orderPlacing;
    }

     public void orderHandlerImpl(PizzaOrder order) {
         System.out.println("Ваш заказ: пицца " + ORDERSERIALIZER.serialize((PizzaOrder) order));
            orderPlacing.orderHandlerImpl(order);

    }
}

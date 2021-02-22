import order_handler.*;
import pizza_order.PizzaOrder;
import serializer.OrderSerializer;
import serializer.PerfoundOrderSerializer;

public class Main {
    public static void main(String[] args) {
        OrderSerializer orderSerializer = new PerfoundOrderSerializer();
        String FILEORDER = "fileOrder.txt";
        PizzaOrder pizzaOrder = new PizzaOrder("vegitarian", 1);

        OrderPlacing orderPlacing = new MessageOrderPlacing(orderSerializer);
        orderPlacing = new SaveOrderPlacing(FILEORDER, orderSerializer, orderPlacing);
        orderPlacing=new ValidatorOrderPlacing(orderSerializer,orderPlacing);

        orderPlacing.orderHandlerImpl(pizzaOrder);


    }

}
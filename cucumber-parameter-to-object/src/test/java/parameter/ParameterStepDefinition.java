package parameter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;

public class ParameterStepDefinition {

	@Given("Customer orders at {orderTime} on {orderDate}")
	public void customer_orders_at_on(LocalTime time, LocalDate date) {
		System.out.println(time);
		System.out.println(date);
	}

	// Customer orders 'Spicy Meatballs' dish 2 numbers
	@Given("Customer orders {dishName} dish {int} numbers")
	public void customer_orders_numbers_of_dish(Dish dish, int quantity) {
		OrderLine ol = new OrderLine(dish, quantity);
		System.out.println(ol);
	}

	// Customer orders 4 numbers of 'Spaghetti Aglio E Olio' dish
	@Given("Customer orders {orderline} dish")
	public void customer_orders_numbers_of_dish(OrderLine ol) {
		System.out.println(ol);
	}
	
	//Table Number 4 orders 1 quantity "Espresso"
	@Given("Table Number {} orders {int} quantity {dishName}")
	public void table_Number_orders_quantity(Table table, int quantity, Dish dish) {
	    System.out.println(dish);
	    System.out.println(table);
	}
	
	@Given("Customer orders the dishes")
	public void customer_Orders_the_dishes(List<OrderLine> orderLines) {
	    System.out.println(orderLines);
	}
	
	@Given("Dishes in menu")
	public void dishes_in_Menu(List<Dish> dishes) {
	    System.out.println(dishes);
	}
	
	@Given("Menu dishes")
	public void menu_Dishes(Menu menu) {
	    System.out.println(menu);
	}
	
	@Given("Customer orders the below dishes")
	public void customer_Orders_the_below_dishes(Map<OrderLineId, OrderLine> orderLines) {
	    System.out.println(orderLines);
	}
	
	@Given("Customer orders the following dishes")
	public void customer_Orders_the_followng_dishes(Map<Integer, OrderLine> orderLines) {
	    System.out.println(orderLines);
	}
}

package parameter;

import java.time.LocalDate;
import java.time.LocalTime;

import cucumber.api.java.en.Given;

public class ParameterStepDefinition {

	@Given("Customer orders at {orderTime} on {orderDate}")
	public void customer_orders_at_on(LocalTime time, LocalDate date) {
		System.out.println(time);
		System.out.println(date);
	}

	@Given("Customer orders {dishName} dish {int} numbers")
	public void customer_orders_numbers_of_dish(Dish dish, int quantity) {
		OrderLine ol = new OrderLine(dish, quantity);
		System.out.println(ol);
	}

	@Given("Customer orders {orderline} dish")
	public void customer_orders_numbers_of_dish(OrderLine ol) {
		System.out.println(ol);
	}
}

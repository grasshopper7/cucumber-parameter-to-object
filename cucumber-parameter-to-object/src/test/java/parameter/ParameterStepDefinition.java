package parameter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import cucumber.api.java.en.Given;

public class ParameterStepDefinition {

	@Given("Customer orders at {orderTime} on {orderDate}")
	public void customer_orders_at_on(LocalTime time, LocalDate date) {
		String timeText = time.format(DateTimeFormatter.ofPattern("h:m:s a"));
		String dateText = date.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
		System.out.println("Order paced at " + timeText + " on " + dateText);
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

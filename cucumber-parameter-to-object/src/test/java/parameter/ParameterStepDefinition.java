package parameter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import cucumber.api.java8.En;

public class ParameterStepDefinition implements En {

	public ParameterStepDefinition() {
		Given("Customer orders at {orderTime} on {orderDate}", (LocalTime time, LocalDate date) -> {
			String timeText = time.format(DateTimeFormatter.ofPattern("h:m:s a"));
			String dateText = date.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
			System.out.println("Order paced at " + timeText + " on " + dateText);
		});

		Given("Customer orders {dishName} dish {int} numbers", (Dish dish, Integer quantity) -> {
			OrderLine orderline = new OrderLine(dish, quantity);
			System.out.println(orderline);
		});

		Given("Customer orders {orderline} dish", (OrderLine orderline) -> {
			System.out.println(orderline);
		});
	}
}

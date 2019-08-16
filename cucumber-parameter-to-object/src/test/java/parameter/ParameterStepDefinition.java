package parameter;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;

public class ParameterStepDefinition {

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

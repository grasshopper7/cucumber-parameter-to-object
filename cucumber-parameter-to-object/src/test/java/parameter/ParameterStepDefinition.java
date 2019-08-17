package parameter;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;

public class ParameterStepDefinition {

	@Given("Table Number {} orders {} quantity {}")
	public void table_Number_orders_quantity(Table table, int quantity, Dish dish) {
		System.out.println(dish);
		System.out.println(table);
	}

	@Given("Customer orders the dishes")
	public void customer_Orders_the_dishes(List<OrderLine> orderLines) {
		System.out.println(orderLines);
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

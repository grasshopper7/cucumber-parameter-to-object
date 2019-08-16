package parameter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

public class ParameterConfigurer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {

		typeRegistry.defineParameterType(new ParameterType<>("orderTime", "\\d{2}:\\d{2}:\\d{2}", LocalTime.class,
				(String s) -> LocalTime.parse(s)));

		typeRegistry.defineParameterType(new ParameterType<>("orderDate", "\\d{4}-\\d{2}-\\d{2}", LocalDate.class,
				(String s) -> LocalDate.parse(s)));

		typeRegistry.defineParameterType(new ParameterType<>("dishName", ".*?", Dish.class, (String s) -> new Dish(s)));

		typeRegistry.defineParameterType(
				new ParameterType<>("orderline", "(\\d)+ numbers of [\'\"]([a-zA-Z0-9_ ]*)[\'\"]", OrderLine.class,
						(String[] args) -> new OrderLine(new Dish(args[1]), Integer.parseInt(args[0]))));

	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}
}

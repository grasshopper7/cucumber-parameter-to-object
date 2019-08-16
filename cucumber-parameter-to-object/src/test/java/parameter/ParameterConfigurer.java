package parameter;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;

public class ParameterConfigurer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {

		// TableEntryTransformer
		typeRegistry.defineDataTableType(new DataTableType(OrderLine.class,
				(Map<String, String> entry) -> new OrderLine(new Dish(entry.get("dish")),
						Integer.parseInt(entry.get("quantity")))));

		// TableCellTransformer
		typeRegistry.defineDataTableType(
				new DataTableType(OrderLineId.class, (String cell) -> new OrderLineId(Integer.parseInt(cell))));

		// TableRowTransformer
		typeRegistry.defineDataTableType(new DataTableType(Dish.class,
				(List<String> row) -> new Dish(row.get(0), DishType.valueOf(row.get(1)))));

		// TableTransformer
		typeRegistry.defineDataTableType(new DataTableType(Menu.class, (DataTable table) -> {
			Menu menu = new Menu();
			List<Dish> dishes = table.asMaps().stream()
					.map(d -> new Dish(d.get("dish"), DishType.valueOf(d.get("type")))).collect(Collectors.toList());
			menu.setDishes(dishes);
			return menu;
		}));

	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}
}

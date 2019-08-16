package parameter;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

public class ParameterConfigurer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {

		JacksonTableTransformer jacksonTableTransformer = new JacksonTableTransformer();
		typeRegistry.setDefaultParameterTransformer(jacksonTableTransformer);
		typeRegistry.setDefaultDataTableEntryTransformer(jacksonTableTransformer);
		typeRegistry.setDefaultDataTableCellTransformer(jacksonTableTransformer);

		// --------------------------------------------

		/*
		 * typeRegistry.defineParameterType(new ParameterType<>("orderTime",
		 * "\\d{2}:\\d{2}:\\d{2}", LocalTime.class, (String s) -> LocalTime.parse(s)));
		 * 
		 * typeRegistry.defineParameterType(new ParameterType<>("orderDate",
		 * "\\d{4}-\\d{2}-\\d{2}", LocalDate.class, (String s) -> LocalDate.parse(s)));
		 * 
		 * typeRegistry.defineParameterType(new ParameterType<>("dishName", ".*?",
		 * Dish.class, (String s) -> new Dish(s)));
		 * 
		 * typeRegistry.defineParameterType( new ParameterType<>("orderline",
		 * "(\\d)+ numbers of [\'\"]([a-zA-Z0-9_ ]*)[\'\"]", OrderLine.class, (String[]
		 * args) -> new OrderLine(new Dish(args[1]), Integer.parseInt(args[0]))));
		 */

		// --------------------------------------------

		/*
		 * // TableEntryTransformer typeRegistry.defineDataTableType(new
		 * DataTableType(OrderLine.class, (Map<String, String> entry) -> new
		 * OrderLine(new Dish(entry.get("dish")),
		 * Integer.parseInt(entry.get("quantity")))));
		 * 
		 * // TableCellTransformer typeRegistry.defineDataTableType( new
		 * DataTableType(OrderLineId.class, (String cell) -> new
		 * OrderLineId(Integer.parseInt(cell))));
		 * 
		 * // TableRowTransformer typeRegistry.defineDataTableType(new
		 * DataTableType(Dish.class, (List<String> row) -> new Dish(row.get(0),
		 * DishType.valueOf(row.get(1)))));
		 * 
		 * // TableTransformer typeRegistry.defineDataTableType(new
		 * DataTableType(Menu.class, (DataTable table) -> { Menu menu = new Menu();
		 * List<Dish> dishes = table.asMaps().stream() .map(d -> new Dish(d.get("dish"),
		 * DishType.valueOf(d.get("type")))).collect(Collectors.toList());
		 * menu.setDishes(dishes); return menu; }));
		 */

	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	private static final class JacksonTableTransformer
			implements ParameterByTypeTransformer, TableEntryByTypeTransformer, TableCellByTypeTransformer {

		private final ObjectMapper objectMapper = new ObjectMapper();

		public Object transform(String value, Type type) {
			return objectMapper.convertValue(value, objectMapper.constructType(type));
		}

		@Override
		public <T> T transform(Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) {
			return objectMapper.convertValue(entry, type);
		}

		@Override
		public <T> T transform(String value, Class<T> cellType) {
			return objectMapper.convertValue(value, cellType);
		}

	}

}

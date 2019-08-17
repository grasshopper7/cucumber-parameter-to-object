package parameter;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;

public class ParameterStepDefinition {

	@Given("List<E> Dish Types at restaurant")
	public void dish_Types_at_Restaurant_list(List<String> dishTypes) {
		System.out.println(dishTypes);
	}
	
	@Given("List<List<E>> Dishes at restaurant")
	public void dishes_at_Restaurant_list_of_list(List<List<String>> dishDetails) {
		System.out.println(dishDetails);
	}
	
	@Given("List<Map<K,V>> Dishes at restaurant")
	public void dishes_at_Restaurant_list_of_map(List<Map<String,String>> dishDetails) {
		System.out.println(dishDetails);
	}
	
	@Given("Map<K,V> Dishes at restaurant")
	public void dishes_at_Restaurant_map(Map<Integer,String> dishDetails) {
		System.out.println(dishDetails);
	}

	@Given("Map<K,List<V>> Dishes at restaurant")
	public void dishes_at_Restaurant_map_of_list(Map<Integer,List<String>> dishDetails) {
		System.out.println(dishDetails);
	}
}

Feature: DataTable to Simple Collection Conversion

  # List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V>, Map<K, List<V>>
  # E,K,V must be a String, Integer, Float, Double, Byte, Short, Long, BigInteger or BigDecimal.
  
  Scenario: List<String>
    Given List<E> Dish Types at restaurant
      | Appetizer |
      | Pasta     |
      | Pizza     |
      | Dessert   |
      | Beverage  |

  Scenario: List<List<String>>
    Given List<List<E>> Dishes at restaurant
      | 1 | Appetizer | Spicy Meatballs      |
      | 2 | Pasta     | Sausage Pappardelle  |
      | 3 | Pizza     | Chicken Alla Diavola |
      | 4 | Dessert   | Nocha Mousse         |
      | 5 | Beverage  | Macchiato            |

  Scenario: List<Map<String,String>>
    Given List<Map<K,V>> Dishes at restaurant
      | id | type      | dish                 |
      |  1 | Appetizer | Spicy Meatballs      |
      |  2 | Pasta     | Sausage Pappardelle  |
      |  3 | Pizza     | Chicken Alla Diavola |
      |  4 | Dessert   | Nocha Mousse         |
      |  5 | Beverage  | Macchiato            |

  Scenario: Map<Integer,String>>
    Given Map<K,V> Dishes at restaurant
      | 1 | Spicy Meatballs      |
      | 2 | Sausage Pappardelle  |
      | 3 | Chicken Alla Diavola |
      | 4 | Nocha Mousse         |
      | 5 | Macchiato            |
      
        Scenario: Map<Integer,List<String>>
    Given Map<K,List<V>> Dishes at restaurant
      |  1 | Appetizer | Spicy Meatballs      |
      |  2 | Pasta     | Sausage Pappardelle  |
      |  3 | Pizza     | Chicken Alla Diavola |
      |  4 | Dessert   | Nocha Mousse         |
      |  5 | Beverage  | Macchiato            |

import java.util.LinkedList;
import java.util.List;

public class LambdaExpressions {
  public static int getPopulation(List<Country> countries, Continent continent) {
    return countries
      .stream()
      .filter(country -> country.getContinent().equals(continent))
      .map(country -> country.getPopulation())
      .reduce(0, (left, right) -> left + right);
  }

  public static void main(String[] args) {
    LinkedList<Country> list = new LinkedList<Country>();

    list.add(new Country("A", Continent.AFRICA, 100));
    list.add(new Country("B", Continent.AFRICA, 200));
    list.add(new Country("C", Continent.AMERICA, 300));
    list.add(new Country("D", Continent.AMERICA, 400));
    list.add(new Country("E", Continent.AMERICA, 500));
    list.add(new Country("F", Continent.ANTARCTICA, 600));
    list.add(new Country("G", Continent.ASIA, 700));
    list.add(new Country("H", Continent.ASIA, 800));
    list.add(new Country("I", Continent.EUROPE, 900));
    list.add(new Country("J", Continent.EUROPE, 1000));

    System.out.printf("The population of %s continent is: %d\n", Continent.AFRICA, getPopulation(list, Continent.AFRICA));
    System.out.printf("The population of %s continent is: %d\n", Continent.AMERICA, getPopulation(list, Continent.AMERICA));
    System.out.printf("The population of %s continent is: %d\n", Continent.ANTARCTICA, getPopulation(list, Continent.ANTARCTICA));
    System.out.printf("The population of %s continent is: %d\n", Continent.ASIA, getPopulation(list, Continent.ASIA));
    System.out.printf("The population of %s continent is: %d\n", Continent.AUSTRALIA, getPopulation(list, Continent.AUSTRALIA));
    System.out.printf("The population of %s continent is: %d\n", Continent.EUROPE, getPopulation(list, Continent.EUROPE));
  }
}

enum Continent {
  AFRICA,
  AMERICA,
  ANTARCTICA,
  ASIA,
  AUSTRALIA,
  EUROPE;
}

class Country {
  private String name;
  private Continent continent;
  private int population;

  public Country(String name, Continent continent, int population) {
    this.name = name;
    this.continent = continent;
    this.population = population;
  }

  public Continent getContinent() {
    return this.continent;
  }

  public int getPopulation() {
    return this.population;
  }
}

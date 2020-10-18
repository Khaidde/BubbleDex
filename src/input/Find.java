package input;
import main.Window;

import java.util.ArrayList;

public class Find {
  /**
   * Finds the Person by name
   * @param name name of Person searching for
   * @return Person with the name
   */
  public Person getPerson (String name) {
    ArrayList<Person> search = Window.allPeople; //I think my getPeople() call might be wrong(?)
    for (int i = 0; i < search.size(); i++) {
      if (((search.get(i)).getName()).equals(name)) {
        return search.get(i);
      }
    }
    return null;
  }
}

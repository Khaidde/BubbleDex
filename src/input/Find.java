package input;
import java.util.ArrayList;
import java.util.Objects;

// Take in a string name and return a person
public class Find {
  public Person getPerson (String name) {
    ArrayList<Person> search = Group.getPeople(); //I think the getPeople() call might be wrong(?)
    for (int i = 0; i < search.size(); i++) {
      if (((search.get(i)).getName()).equals(name)) {
        return search.get(i);
      }
    }
    return null;
  }
}

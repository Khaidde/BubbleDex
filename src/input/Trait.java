package input;

import java.util.ArrayList;
import java.util.Objects;

public class Trait {
    String event;
    private ArrayList<Person> people;

    public Trait(String event, ArrayList<Person> people) {
        this.event = event;
        for (int i = 0; i < people.size(); i++)
            this.people.add(people.get(i));
    }

    public Trait(String event) {
        this(event, new ArrayList<>());
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public int numberOfPeople() {
        return people.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trait trait = (Trait) o;
        return Objects.equals(event, trait.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event);
    }

    @Override
    public String toString() {
        return "Trait{" +
                "event='" + event + '\'' +
                ", people=" + people +
                '}';
    }
}

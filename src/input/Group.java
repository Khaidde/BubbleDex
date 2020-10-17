package input;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
    String event;
    private ArrayList<Person> people;

    public Group(Group other) {
        this(other.event, other.people);
    }

    public Group(String event, ArrayList<Person> people) {
        this.event = event;
        for (int i = 0; i < people.size(); i++)
            this.people.add(people.get(i));
    }

    public Group(String event) {
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
        Group trait = (Group) o;
        return Objects.equals(event, trait.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event);
    }

    @Override
    public String toString() {
        return "Group{" +
                "event='" + event + '\'' +
                ", people=" + people +
                '}';
    }
}

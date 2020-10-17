package input;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private boolean toggleOn;
    private ArrayList<Trait> traits;        //the indexes of the traits should match the exact time they were there.
    private ArrayList<Date> time;

    public Person(String name, boolean toggleOn, ArrayList<Trait> traits, ArrayList<Date> time) {
        this.name = name;
        this.toggleOn = toggleOn;
        this.traits = new ArrayList<>();
        this.time = new ArrayList<>();

        if(traits.size() != time.size())
            System.out.println("Warning: traits and time don't match!");
        for (int i = 0; i < traits.size(); i++)
            this.traits.add(traits.get(i));
        for (int i = 0; i < time.size(); i++)
            this.time.add(time.get(i));
    }

    public String getName() {
        return name;
    }

    public boolean isToggleOn() {
        return toggleOn;
    }

    public ArrayList<Trait> getTraits() {
        return traits;
    }

    public ArrayList<Date> getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return toggleOn == person.toggleOn &&
                Objects.equals(name, person.name) &&
                Objects.equals(traits, person.traits) &&
                Objects.equals(time, person.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, toggleOn, traits, time);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", toggleOn=" + toggleOn +
                ", traits=" + traits +
                ", time=" + time +
                '}';
    }
}

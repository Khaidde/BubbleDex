package input;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private boolean toggleOn;
    private ArrayList<Trait> traits;

    public Person(String name, boolean toggleOn, ArrayList<Trait> traits) {
        this.name = name;
        this.toggleOn = toggleOn;
        this.traits = new ArrayList<>();

        for (int i = 0; i < traits.size(); i++)
            this.traits.add(traits.get(i));
    }

    public Person(String name, ArrayList<Trait> traits) {
        this(name, false, traits);
    }

    public Person(String name) {
        this(name, false, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public boolean isToggleOn() {
        return toggleOn;
    }
    
    public void addTraits(Trait trait) {
        this.traits.add(trait);
    }

    public ArrayList<Trait> getTraits() {
        return traits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return toggleOn == person.toggleOn &&
                Objects.equals(name, person.name) &&
                Objects.equals(traits, person.traits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, toggleOn, traits);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", toggleOn=" + toggleOn +
                ", traits=" + traits +
                '}';
    }
}

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
    
    public void addTrait(Trait trait) {
        this.traits.add(trait);
    }

    public ArrayList<Trait> getTraits() {
        return traits;
    }

    public void setTraits(ArrayList<Trait> traits) {
        for (int i = 0; i < traits.size(); i++) {
            this.traits.add(traits.get(i));
        }
    }

    public Group getGroup(Date time) {
        for (int i = 0; i < traits.size(); i++) {
            Trait t = traits.get(i);
            if(t.getDate().includes(time)) {
                return t.getGroup();
            }
        }
        System.out.println("Could not find a Group for that specific date");
        return null;
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
        return name + "{" +
                "toggleOn=" + toggleOn +
                ", traits=" + traits +
                '}';
    }
}

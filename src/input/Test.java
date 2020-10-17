package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class Test {
    public static void main(String[] args) throws IOException {
        Set<Group> allTraits = new LinkedHashSet<>();
        ArrayList<Person> peeps = FileReader.read("Test.xlsx", allTraits);

        for (Group g : allTraits) {
            System.out.println(g);
        }
    }
}

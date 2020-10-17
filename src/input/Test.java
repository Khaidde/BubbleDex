package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class Test {
    public static void main(String[] args) throws IOException {
        Set<Group> allGroups = new LinkedHashSet<>();
        ArrayList<Person> peeps = FileReader.read("Test.xlsx", allGroups);

        for (Group g : allGroups) {
            System.out.println(g);
        }
    }
}

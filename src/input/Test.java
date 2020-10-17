package input;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> peeps = new ArrayList<>();
        peeps = FileReader.read("Test.xlsx");

        for (Person p :
                peeps) {
            System.out.println(p);
        }
    }
}

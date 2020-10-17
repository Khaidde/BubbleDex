package input;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Class that handles files.
 *
 * @author allison
 */
public class FileReader { //pretty sure this will be an all static methods class

    /**
     * Takes in a file and reads it to create the Persons from the file and Groups.
     * @param fileLoc where the excel file is located
     * @param allGroups a Set of all the Groups known in the current program (enter and empty one if none are known),
     *                 will add the new Groups it finds to it
     * @return an ArrayList of all the Persons in the file
     * @throws IOException Cannot find file. :C
     */
    public static ArrayList<Person> read(String fileLoc, Set<Group> allGroups) throws IOException {
        ArrayList<Person> peeps = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(fileLoc));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        String name = "";
        Person p = new Person("N/A");
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String s = cell.getStringCellValue();
                System.out.println(s);

                if (s.equals("Name")) {                                 //should reset the hold variables
                    peeps.add(p);
                    name = "";
                } else if (name.equals("")) {                           //when the cell is a name
                    name = s;
                    p = new Person(name);
                } else if (s.matches(".*[A-z].*")){              //when the cell is a trait
                    Group g = new Group(s);
                    if (allGroups.add(g)) {
                        g.getPeople().add(p);
                    } else {
                        ArrayList<Group> help = new ArrayList<Group>(allGroups);
                        help.get(help.indexOf(g)).getPeople().add(p);
                    }

                    cell = cellIterator.next();
                    s = cell.getStringCellValue();

                    Date d;
                    int initMonth = Integer.parseInt(s.substring(0, s.indexOf("/")));
                    s = s.substring(s.indexOf("/") + 1);
                    int initYear = Integer.parseInt(s.substring(0, s.indexOf(",")));
                    if(s.indexOf(",") + 1 > s.length() - 1) {
                        d = new Date(initMonth, initYear);
                    } else {
                        s = s.substring(s.indexOf(",") + 1);
                        int finMonth = Integer.parseInt(s.substring(0, s.indexOf("/")));
                        s = s.substring(s.indexOf("/") + 1);
                        int finYear = Integer.parseInt(s);

                        d = new Date(initMonth, initYear, finMonth, finYear);
                    }
                    p.getTraits().add(new Trait(g, d));
                } else {
                    System.out.println("Input was not recognized: " + s);
                }
            }

            if (!iterator.hasNext()) {
               peeps.add(p);
            }
        }
        
        inputStream.close();
        peeps.remove(0);
        return peeps;
    }
}

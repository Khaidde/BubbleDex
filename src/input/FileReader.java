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
import java.util.List;
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

        while (iterator.hasNext()) {
            Row nextRow = iterator.next(); //Each row will be a person
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            String name = "";
            ArrayList<Trait> traits = new ArrayList<>();        //Personal traits
            //TODO: Add time into this

            Person p = new Person("Non");
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (name.equals("")) {
                    name = cell.getStringCellValue();
                    p = new Person(name);
                } else {
                    Group g = new Group(cell.getStringCellValue());
                    if (allGroups.add(g)) {
                        g.getPeople().add(p);
                    } else {
                        ArrayList<Group> help = new ArrayList<Group>(allGroups);
                        help.get(help.indexOf(g)).getPeople().add(p);
                    }
                    Trait hold = new Trait(g, null);
                    traits.add(hold);
                }
            }
            peeps.add(p);
        }
        
        inputStream.close();
        return peeps;
    }
}

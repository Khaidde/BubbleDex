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

public class FileReader { //pretty sure this will be an all static methods class
    public static ArrayList<Person> read(String fileLoc, Set<Group> allTraits) throws IOException {
        ArrayList<Person> peeps = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(fileLoc));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next(); //Each row will be a person
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            String name = "";
            ArrayList<Trait> traits = new ArrayList<>();
            //TODO: Add time into this
            int i = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (name.equals("")) {
                    name = cell.getStringCellValue();
                } else {
                    Group g = new Group(cell.getStringCellValue());
                    Trait hold = new Trait(g, null);
                    traits.add(hold);
                    allTraits.add(g);
                }
            }
            Person p = new Person(name, traits);
            peeps.add(p);
        }
        
        inputStream.close();
        return peeps;
    }
}

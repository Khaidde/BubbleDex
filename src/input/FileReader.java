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

public class FileReader { //pretty sure this will be an all static methods class
    public void read(String fileLoc) throws IOException {
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
                    System.out.print(cell.getStringCellValue());
                    name = cell.getStringCellValue();
                } else {
                    System.out.print(cell.getStringCellValue());
                    Trait hold = new Trait(cell.getStringCellValue()); //TODO: don't make repeat traits, switch to Hashset?
                    traits.add(hold);
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
        
        inputStream.close();
    }
}

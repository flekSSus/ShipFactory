import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


class ExcelManager
{
    private static ExcelManager instance;
    private static final String XLSX_FILENAME = "ships.xlsx";

    private ExcelManager(){}

    public static ExcelManager getInstance()
    {
        if(instance == null) 
        {
            instance=new ExcelManager();
        }
        return instance;        
    }

    public void toExcel(List ships) 
    {
        try (Workbook workbook = new XSSFWorkbook()) 
        {
            Sheet sheet = workbook.createSheet("Ships");

            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Name", "Type", "Max Speed", "Crew Size"};
            for (int i = 0; i < headers.length; i++) 
            {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                CellStyle headerStyle = workbook.createCellStyle();
                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerStyle.setFont(headerFont);
                cell.setCellStyle(headerStyle);
            }

            int rowIndex = 1;
            for (int i=0;i<ships.size();++i) 
            {
                var ship= ships.get(i);
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(ship.Get_Id());
                row.createCell(1).setCellValue(ship.Get_Name());
                row.createCell(2).setCellValue(ship.Get_Type());
                row.createCell(3).setCellValue(ship.Get_Speed());
                row.createCell(4).setCellValue(ship.Get_Crew_Size());
            }

            for (int i = 0; i < headers.length; i++) 
            {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(XLSX_FILENAME)) 
            {
                workbook.write(fos);
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

    }


    public List importFromExcel(String filename) 
    {
        List ships= new List();
        try (FileInputStream fis = new FileInputStream(filename)) 
        {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) 
            {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    String id =  row.getCell(0).getStringCellValue();
                    String name= row.getCell(1).getStringCellValue();
                    String type = row.getCell(2).getStringCellValue();
                    double maxSpeed = row.getCell(3).getNumericCellValue();
                    int crewSize= (int )row.getCell(4).getNumericCellValue();

                    var builder = new ShipBuilder();
                    builder.setId(id);
                    builder.setName(name);
                    builder.setType(type);
                    builder.setMaxSpeed(maxSpeed);
                    builder.setCrewSize(crewSize);
                    ships.add(builder.getVehicle());
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
        return ships;
    }
}


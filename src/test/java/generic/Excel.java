package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel  {
	
public static String getCellvalue(String PATH,String sheet,int row,int cell)
	{
		String v="";
		try
		{
		  FileInputStream fis=new FileInputStream(PATH);
		  Workbook wb = WorkbookFactory.create(fis);
		  Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
		  v = c.getStringCellValue();
		
		}
		catch(Exception e)
		{
			Reporter.log("path is invalid",true);
		}
		return v;
	}

}

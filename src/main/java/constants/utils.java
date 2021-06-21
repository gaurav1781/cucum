package constants;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utils
{
	private static XSSFWorkbook Excelworkbook;
	private static XSSFSheet Excelsheet;
	private static XSSFCell cell;

	/*Method to set the path and to open the Excel File*/
	/* We are going to send Filepath and Sheetname is arguments to the function*/
	public static void setExcelFile(String Filepath,String Sheetname) throws IOException
	{
		FileInputStream excelfile=new FileInputStream("D:\\Software\\Java Workspace\\cucum\\Keyword1.xlsx");
		Excelworkbook=new XSSFWorkbook(excelfile);
		Excelsheet=Excelworkbook.getSheet(Sheetname);
	}
	/*Method to read data from the cells of the Excel*/
	/* Passing rownumber and colnumber as parameters*/


	public static  String getExcelData(int rownum,int colnum) throws IOException
	{
		cell=Excelsheet.getRow(rownum).getCell(colnum);
		String Cellvalue=cell.getStringCellValue();
		return Cellvalue;
	}
}

package xls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;

public class sampleJXL {

	public String path;
	public Sheet sheet = null;
	private Workbook workbook = null;
	public String sheetName = null;
	public int rowNum = 0;
	public String colName = null;
	public static int tempNum;
	public int colNum;
	public String cellValue;

	public void openWorkBook(String path) throws BiffException, IOException {
		this.path = path;
		workbook = Workbook.getWorkbook(new File(path));
		sheet = workbook.getSheet(0);
		
	}

	public int getRowCount(String sheetName) throws FileNotFoundException {
		this.sheetName = sheetName;
		sheet = workbook.getSheet(sheetName);
		int number = sheet.getRows();
		return number;

	}

	public String getCellContent(String sheetName, String colName, int rowNum) {
		this.sheetName = sheetName;
		this.rowNum = rowNum;
		this.colName = colName;
		sheet = workbook.getSheet(sheetName);
		int rn = sheet.getRows();
		int cn = sheet.getColumns();

		for (int i = 0; i < rn; i++) {
			for (int j = 0; j < cn; j++) {
				//System.out.println(""+j +i +sheet.getCell(j, i).getContents());
				if (sheet.getCell(j, i).getContents().equalsIgnoreCase(colName)) {
					tempNum = j;
				}

			}
		}
		String content = sheet.getCell(tempNum, rowNum).getContents();
		return content;

	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		this.sheetName = sheetName;
		this.rowNum = rowNum;
		this.colNum = colNum;
		sheet = workbook.getSheet(sheetName);
		String content = sheet.getCell(colNum, rowNum).getContents();
		return content;

	}
	
	private int getColumnCount(String sheetName) {
		this.sheetName = sheetName;
		sheet = workbook.getSheet(sheetName);
		int number = sheet.getColumns();
		return number;
	}

	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		this.sheetName = sheetName;
		this.cellValue = cellValue;
		this.colName = colName;
		sheet = workbook.getSheet(sheetName);
		int rn = sheet.getRows();
		int cn = sheet.getColumns();

		for (int i = 0; i < rn; i++) {
			for (int j = 0; j < cn; j++) {
				if (sheet.getCell(j, i).getContents()
						.equalsIgnoreCase(cellValue)) {

					if (sheet.getCell(j, 0).getContents()
							.equalsIgnoreCase(colName)) {
						tempNum = i;
					}
				}
			}
		}
		return tempNum;
	}

	public boolean isSheetExist(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws IOException, BiffException {
		//sampleJXL sxl = new sampleJXL("C://Users//kyadavalli//workspace//MyAutomation//src//xls//suite.xls");
		sampleJXL sxl = new sampleJXL();
		String temName;
		sxl.openWorkBook("C://Users//kyadavalli//workspace//MyAutomation//src//xls//suite.xls");
		sampleJXL sx2 = new sampleJXL();
		for(int i=0;i<sxl.getRowCount("First Sheet");i++){
					if(sxl.getCellContent("First Sheet", "Run Mode", i).equalsIgnoreCase("Y")){
					temName=sxl.getCellContent("First Sheet", "ShortCut", i);
					System.out.println(temName+" is temName");
					sx2.openWorkBook("C://Users//kyadavalli//workspace//MyAutomation//src//xls//"+temName+".xls");
					for(int x=1;x<sx2.getRowCount("Test Run");x++){
					System.out.println(sx2.getCellContent("Test Run","Steps",x));
					}
					
				}
				
		}
		
		/*System.out.println(sxl.getCellContent("First Sheet", "TSID", 2));
		System.out.println(sxl.getCellData("First Sheet", 2, 5));
		System.out.println(sxl.getCellRowNum("First Sheet", "Ali Gajani",
				"rishi"));
		System.out.println(sxl.isSheetExist("First Sheet"));
		System.out.println(sxl.isSheetExist("Second Sheet"));*/
				
	}

	
}

package com.priya.xls;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class samplwritejxl {

	public String path;
	public Sheet sheet = null;
	private Workbook wb = null;
	public String sheetName = null;
	public int rowNum;

	public String writeResult(String wbPath, String sheetName)
			throws RowsExceededException, WriteException, IOException,
			BiffException {
		this.path = wbPath;
		this.sheetName = sheetName;
		wb = Workbook.getWorkbook(new File(wbPath));
		WritableWorkbook copy = Workbook.createWorkbook(new File(wbPath), wb);
		WritableSheet sheet = copy.getSheet(sheetName);
		WritableCell cell = sheet.getWritableCell(10, 0);
		Label l = new Label(10, 0, "Result");
		cell = (WritableCell) l;
		sheet.addCell(cell);
		copy.write();
		copy.close();
		wb.close();
		return "success";
	}

	public String writePass(String wbPath, String sheetName, int rowNum)
			throws RowsExceededException, WriteException, IOException,
			BiffException {
		this.rowNum = rowNum;
		this.path = wbPath;
		this.sheetName = sheetName;
		wb = Workbook.getWorkbook(new File(wbPath));
		WritableWorkbook copy = Workbook.createWorkbook(new File(wbPath), wb);
		WritableSheet sheet = copy.getSheet(sheetName);
		WritableCell cell = sheet.getWritableCell(10, 0);
		Label l = new Label(10, rowNum, "Pass");
		cell = (WritableCell) l;
		sheet.addCell(cell);
		copy.write();
		copy.close();
		wb.close();
		return "success";
	}

	public String writeFail(String wbPath, String sheetName, int rowNum)
			throws RowsExceededException, WriteException, IOException,
			BiffException {
		this.rowNum = rowNum;
		this.path = wbPath;
		this.sheetName = sheetName;
		wb = Workbook.getWorkbook(new File(wbPath));
		WritableWorkbook copy = Workbook.createWorkbook(new File(wbPath), wb);
		WritableSheet sheet = copy.getSheet(sheetName);
		WritableCell cell = sheet.getWritableCell(10, 0);
		Label l = new Label(10, rowNum, "Fail");
		cell = (WritableCell) l;
		sheet.addCell(cell);
		copy.write();
		copy.close();
		wb.close();
		return "fail";
	}

	public static void main(String[] args) throws BiffException, IOException,
			RowsExceededException, WriteException {

		samplwritejxl sx3 = new samplwritejxl();
		sx3.writeResult(
				"C://Users//kyadavalli//workspace//MyAutomation//src//xls//abc.xls",
				"Test Run");

	}
}
/*
 * public boolean addHyperLink(String sheetName, String screenShotColName,
 * String testCaseName, int index, String url, String message) { }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public boolean addColumn(String sheetName, String colName) { this.colName =
 * colName; sheet = workbook.getSheet(sheetName); sheet.insertColumn(1); }
 * public boolean addColumn(String sheetName, String colName) {
 * 
 * 
 * public boolean removeSheet(String sheetName) { }
 * 
 * 
 * public boolean addSheet(String sheetname) {
 * 
 * 
 * 
 * public boolean setCellData(String sheetName, String colName, int rowNum,
 * String data, String url) {
 * 
 * 
 * 
 * // returns true if data is set successfully else false public boolean
 * setCellData(String sheetName, String colName, int rowNum, String data) {
 * 
 * 
 * 
 * public String getCellData(String sheetName, int colNum, int rowNum) { } }
 */

package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import keywords.keywords;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import xls.sampleJXL;
import xls.samplwritejxl;

public class sample {
	public static Properties OR = new Properties();
	public static WebDriver driver = null;
	public static Logger APP_LOGS;
	public static FileInputStream fs;
	public static keywords keywords;
	public static Method method[];
	public static String keyword_execution_result;
	public static sampleJXL sxl;
	public static samplwritejxl sx3;
	public static sampleJXL sx2;
	public static int y;
	public static int s;
	public static String Name;

	public static void main(String[] args) throws IOException,
			RowsExceededException, WriteException, BiffException,
			NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InterruptedException {

		APP_LOGS = Logger.getLogger("devpinoyLogger");
		fs = new FileInputStream(System.getProperty("user.dir")
				+ "//src//OR//OR.properties");
		OR.load(fs);
		driver = new InternetExplorerDriver();
		driver.get("http://10.11.1.23");
		Thread.sleep(10000);
		sxl = new sampleJXL();
		sx3 = new samplwritejxl();
		String temName;
		sxl.openWorkBook("C://Users//kyadavalli//workspace//MyAutomation//src//xls//suite.xls");
		sx2 = new sampleJXL();
		for (int i = 1; i < sxl.getRowCount("First Sheet"); i++) {
			if (sxl.getCellContent("First Sheet", "Run Mode", i)
					.equalsIgnoreCase("Y")) {
				temName = sxl.getCellContent("First Sheet", "ShortCut", i);
				sample.APP_LOGS.debug("********************" + temName
						+ "********************");

				sx2.openWorkBook("C://Users//kyadavalli//workspace//MyAutomation//src//xls//"
						+ temName + ".xls");
				for (int x = 1; x < sx2.getRowCount("Test Run"); x++) {
					// write logic to execute test cases)
					if (sx2.getCellContent("Test Run", "Run Mode", x)
							.equalsIgnoreCase("Y")) {
						String tcName = sx2.getCellContent("Test Run", "Name",
								x);

						sample.APP_LOGS.debug(tcName
								+ " is running becasuse run mode is Y");

						if (sx2.isSheetExist(tcName)) {

							for (s = 1; s < (sx2.getRowCount(tcName)); s++) {
								sample.APP_LOGS.debug(tcName
										+ " is going to run for "
										+ (sx2.getRowCount(tcName) - 1)
										+ " times");
								for (y = 1; y < sx2.getRowCount("Test Cases"); y++) {
									Name = sx2.getCellContent("Test Cases",
											"Name", y);
									if (Name.equalsIgnoreCase(tcName)) {

										executeKeywords();
									}
								}
							}
						} else {

							for (int r = 1; r < sx2.getRowCount("Test Cases"); r++) {
								Name = sx2.getCellContent("Test Cases", "Name",
										r);
								if (Name.equalsIgnoreCase(tcName)) {
									String step = sx2.getCellContent(
											"Test Cases", "Steps", r);
									String Object = sx2.getCellContent(
											"Test Cases", "Object", r);
									String Value = sx2.getCellContent(
											"Test Cases", "Value", r);

									sample.APP_LOGS.debug("  " + step + "   "
											+ Object + "   " + Value + "");

								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean executeKeywords() throws NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InterruptedException {
		// TODO Auto-generated method stub
		String step = sx2.getCellContent("Test Cases", "Steps", y);
		String Object = sx2.getCellContent("Test Cases", "Object", y);
		String Value = sx2.getCellContent("Test Cases", "Value", y);
		if (Value.contains("|")) {
			System.out.println("value contains |");
			String path = Value;
			String segments[] = path.split("|", 4);
			String cName = segments[3];
			Value = sx2.getCellContent(Name, cName, s);
		}

		System.out.println("executing Keywords");
		sample.APP_LOGS
				.debug("  " + step + "   " + Object + "   " + Value + "");

		return true;
	}
}

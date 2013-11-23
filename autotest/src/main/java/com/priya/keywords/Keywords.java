package com.priya.keywords;

import org.openqa.selenium.By;

import com.priya.driver.AutoTestDriver;

public class Keywords {

	public static String typeString(String Object, String Name) {
		String flag = "Fail";
		try {
			AutoTestDriver.APP_LOGS.debug(Name + " will be typed at " + Object);

			AutoTestDriver.driver.findElement(By.xpath(Object)).sendKeys(Name);
			flag = "Pass";
		} catch (Exception e) {
			System.out.println(e);
			flag = "Fail";
		}
		return flag;

	}

	public static String click(String Object, String Name) {
		String flag = "Fail";
		try {
			AutoTestDriver.APP_LOGS.debug(Object + " will be clicked");

			AutoTestDriver.driver.findElement(By.xpath(Object)).click();
			flag = "Pass";
		} catch (Exception e) {
			System.out.println(e);
			flag = "Fail";
		}
		return flag;

	}

	public static String verifyText(String Object, String Name) {
		String flag = "Fail";
		if (AutoTestDriver.driver.findElement(By.linkText(Name)) != null) {
			AutoTestDriver.driver.findElement(By.linkText(Name)).click();
			flag = "Pass";
		}
		return flag;
	}

	public static String openURL(String Object, String Name) {
		String flag = "Fail";
		try {
			AutoTestDriver.driver.get(Name);
		} catch (Exception ex) {
			System.out.println("could not open the specified URL");
		}

		return flag;
	}

	public static String navigate(String Object, String Name) {
		// object will not be an input...has to be read from OR
		String flag = "Fail";
		AutoTestDriver.APP_LOGS.debug("navigating");
		try {
			if (Name == "Administration" || Name == "administration")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectA"));

			if (Name == "Compliance Manager" || Name == "compliance manager")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectC"));

			if (Name == "Enterprise Risk Manager"
					|| Name == "enterprise risk manager")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectE"));

			if (Name == "Vendor Risk Manager" || Name == "vendor risk manager")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectV"));

			if (Name == "Threat & Vulnerability Manager"
					|| Name == "threat & vulnerability manager")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectT"));

			if (Name == "Policy Manager" || Name == "policy manager")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectP"));

			if (Name == "Incident Manager" || Name == "incident manager")
				AutoTestDriver.driver.navigate().to(AutoTestDriver.OR.getProperty("ObjectI"));
			flag = "Pass";
		} catch (Exception e) {
			System.out.println(e);
			flag = "Fail";
		}
		return flag;

	}

	public static String dropDown(String Object, String Name) {
		return "pass";

	}

	public static String radioButton(String Object, String Name) {
		return "pass";

	}

	public static String leftArrow(String Object, String Name) {
		return "pass";

	}

	public static String rightArrow(String Object, String Name) {
		return "pass";

	}

	public static String dragDrop(String Object, String Name) {
		return "pass";

	}

}

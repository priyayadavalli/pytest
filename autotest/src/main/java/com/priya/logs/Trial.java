package com.priya.logs;

public class Trial {

	public static void main(String[] args) {

		String string = "d|username";
		String[] split = string.split("|", 4);
		System.out.println(split[0] + " 0");
		System.out.println(split[1] + " 1");
		System.out.println(split[2] + " 2");
		System.out.println(split[3] + " 3");
		System.out.println("over");

	}

}

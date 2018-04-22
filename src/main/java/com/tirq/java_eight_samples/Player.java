package com.tirq.java_eight_samples;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

	private String name;
	private int number;
	private boolean captain;

	public void printName() {
		System.out.println("The player name is: " + name);
	}

	public void printNumber() {
		System.out.println("The player number is: " + number);
	}

}

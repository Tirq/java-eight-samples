package com.tirq.java_eight_samples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

	public Player(String name) {
		this.name = name;
	}

	public Player(String name, int number) {
		this.name = name;
		this.number = number;
	}

}

package com.tirq.java_eight_samples;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chapter3 {

	public static void main(String[] args) {

		System.out.println("a - sample starting thread before java8...");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("running now...");
			}
		};
		new Thread(r).start();
		System.out.println("b - sample starting thread using lambda...");
		Runnable r1 = () -> {
			System.out.println("running now...");
		};
		new Thread(r1).start();
		System.out.println("c - thread with less code using lambda...");
		new Thread(() -> {
			System.out.println("running now...");
		}).start();
		System.out.println("d - a little less code using lambda...");
		new Thread(() -> System.out.println("running now...")).start();

		System.out.println("d - action from awt button before java8...");
		java.awt.Button btn = new Button();
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked ...");
			}
		});
		System.out.println("e - action from awt button using lambda...");
		btn.addActionListener((e) -> {
			System.out.println("Button clicked ...");
		});
		System.out.println("f - less code using lambda...");
		btn.addActionListener(e -> System.out.println("Button clicked ..."));

		System.out.println("g - Own functional interface before java8 ...");
		Validator<Integer> oddValidator = new Validator<Integer>() {
			@Override
			public boolean isValid(Integer t) {
				return t % 2 != 0;
			}
		};
		System.out.println("Is 5 odd? " + oddValidator.isValid(5));
		System.out.println("g - Own functional interface using lambda...");
		Validator<Integer> oddValidatorLambda = t -> t % 2 != 0;
		System.out.println("Is 5 odd? " + oddValidatorLambda.isValid(5));
		System.out.println("h - read local variable inside a lambda...");
		String color = "blue";
		new Thread(() -> System.out.println("The sky is " + color)).start();
	}

}

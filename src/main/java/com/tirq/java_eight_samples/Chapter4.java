package com.tirq.java_eight_samples;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Chapter4 {

	public static void main(String... args) {
		Team team = Team.getMutableTeam();
		Consumer<Player> printName = p -> p.printName();
		Consumer<Player> printNumber = p -> p.printNumber();
		System.out.println("a - default method andThen...");
		team.getPlayers().forEach(printName.andThen(printNumber));
		
		System.out.println("b - default method removeIf...");
		Predicate<Player> predicate = new Predicate<Player>() {
			@Override
			public boolean test(Player t) {
				return t.getNumber() > 11;
			}
		};
		team.getPlayers().removeIf(predicate);
		
		System.out.println("c - default method removeIf using lambda...");
		Predicate<Player> predicateLambda = t -> t.getNumber() > 11;
		team.getPlayers().removeIf(predicateLambda);
		
		System.out.println("d - removeIf using lambda with less code...");
		team.getPlayers().removeIf(p -> p.getNumber() > 11);
		team.getPlayers().forEach(printName);
	}
}

package com.tirq.java_eight_samples;

import java.util.function.Consumer;

public class Chapter2 {

	public static void main(String[] args) {
		Team team = Team.getImmutableTeam();
		
		System.out.println("a - Iterate list before java8...");
		for (Player p : team.getPlayers()) {
			p.printName();
		}
		
		System.out.println("b - forEach - a new persperctive ...");
		team.getPlayers().forEach(new ShowerPlayer());
		
		System.out.println("c - forEach - using inner class");
		team.getPlayers().forEach(new Consumer<Player>() {
			@Override
			public void accept(Player p) {
				p.printName();
			}
		});
		
		System.out.println("d - Introducing the lambda concept...");
		Consumer<Player> shower = p -> p.printName();
		team.getPlayers().forEach(shower);
		
		System.out.println("e - Less code, same result...");
		team.getPlayers().forEach(p -> p.printName());
	}

}

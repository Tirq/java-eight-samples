package com.tirq.java_eight_samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Chapter5 {

	public static void main(String[] args) {
		Team team = Team.getMutableTeam();
		System.out.println("a - sort before java8...");
		Comparator<Player> comparator = new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		Collections.sort(team.getPlayers(), comparator);
		team.getPlayers().forEach(p -> p.printName());
		
		System.out.println("b - sort using lambda...");
		Comparator<Player> comparatorLambda = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Collections.sort(team.getPlayers(), comparatorLambda);
		
		System.out.println("c - sort using lambda with less code...");
		Collections.sort(team.getPlayers(), (p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println("d - sort, lambda without Collections...");
		team.getPlayers().sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println("e - sort using lambda with static methods...");
		Function<Player, String> byName = p -> p.getName();
		Comparator<Player> comp = Comparator.comparing(byName);
		team.getPlayers().sort(comp);
		
		System.out.println("f - sort using lambda with static methods and less code...");
		Comparator<Player> comp1 = Comparator.comparing(p -> p.getName());
		team.getPlayers().sort(comp1);
		
		System.out.println("g - sort using lambda, static methods and less code yet ...");
		team.getPlayers().sort(Comparator.comparing(p -> p.getName()));
		List<String> legends = Arrays.asList("Pelé", "Maradona", "Eusébio", "Garrincha");
		
		System.out.println("h - sort before java8...");
		Collections.sort(legends);
		legends.forEach(s -> System.out.println(s));
		
		System.out.println("i - sort with natural/reverse order...");
		legends.sort(Comparator.naturalOrder());
		legends.forEach(s -> System.out.println(s));
		legends.sort(Comparator.reverseOrder());
		legends.forEach(s -> System.out.println(s));
		
		System.out.println("j - sort and autoboxing...");
		ToIntFunction<Player> number= p -> p.getNumber();
		team.getPlayers().sort(Comparator.comparingInt(number));
		
		System.out.println("k - sort and autboxing with less code...");
		team.getPlayers().sort(Comparator.comparingInt(p -> p.getNumber()));
	}

}

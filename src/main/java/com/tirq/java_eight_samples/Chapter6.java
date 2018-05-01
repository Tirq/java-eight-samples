package com.tirq.java_eight_samples;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class Chapter6 {

	public static void main(String[] args) {
		Team team = Team.getImmutableTeam();
		System.out.println("a - using lambda expression");
		team.getPlayers().forEach(p -> p.printName());

		System.out.println("b - using method references");
		team.getPlayers().forEach(Player::printName);

		System.out.println("c - sort lambda expression");
		team.getPlayers().sort(Comparator.comparing(p -> p.getName()));

		System.out.println("d - sort method references");
		team.getPlayers().sort(Comparator.comparing(Player::getName));
		
		System.out.println("e - multi sorts method references");
		team.getPlayers().sort(Comparator.comparing(Player::getName).thenComparingInt(Player::getNumber));
		
		System.out.println("f - handle null on sorts");
		team.getPlayers().sort(Comparator.nullsFirst(Comparator.comparing(Player::getName)));

		System.out.println("g - handle null on sorts");
		team.getPlayers().sort(Comparator.comparing(Player::getName).reversed());

		System.out.println("h - instance object");
		Player seedorf = new Player("Clarence Seedorf");
		Runnable r = seedorf::printName;
		r.run();
		
		System.out.println("i - contructor empty");
		Supplier<Player> supplier = Player::new;
		Player player = supplier.get();
		System.out.println(player);
		
		System.out.println("j - contructor one parameter");
		Function<String, Player> function = Player::new;
		Player cr7 = function.apply("Cristiano Ronaldo");
		System.out.println(cr7);
		
		System.out.println("k - contructor two parameters");
		BiFunction<String, Integer, Player> biFunction = Player::new;
		Player m10 = biFunction.apply("Leonel Messi", 10);
		System.out.println(m10);
		
		System.out.println("l - static method ");
		BiFunction<Integer, Integer, Integer> max = Math::max;
		System.out.println(max.apply(100, 50));
		
		System.out.println("m - static method avoid return autoboxing");
		ToIntBiFunction<Integer, Integer> max1 = Math::max;
		System.out.println(max1.applyAsInt(10, 5));
		
		System.out.println("n - static method avoid all autoboxing");
		IntBinaryOperator max2 = Math::max;
		System.out.println(max2.applyAsInt(10, 5));
	}
}

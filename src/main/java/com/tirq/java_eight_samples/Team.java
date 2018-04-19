package com.tirq.java_eight_samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Team {

	private List<Player> players;

	public static Team getImmutableTeam() {
		Player p1 = new Player("Marcelo Grohe", 1, false);
		Player p3 = new Player("Pedro Geromel", 3, true);
		Player p4 = new Player("Walter Kanneman", 4, false);
		return new Team(Arrays.asList(p1, p3, p4));
	}

	public static Team getMutableTeam() {
		Player p29 = new Player("Arthur", 29, false);
		Player p7 = new Player("Luan", 7, true);
		Player p11 = new Player("Everton", 11, false);
		List<Player> players = new ArrayList<>();
		players.add(p29);
		players.add(p7);
		players.add(p11);
		return new Team(players);
	}

}

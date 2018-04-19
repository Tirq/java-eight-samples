package com.tirq.java_eight_samples;

import java.util.function.Consumer;

public class ShowerPlayer implements Consumer<Player> {

	@Override
	public void accept(Player p) {
		p.printName();
	}

}

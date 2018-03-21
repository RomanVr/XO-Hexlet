package ru.roman.xoproject.model;

import java.util.LinkedList;

public class Game<F> {
	
	private final LinkedList<Player<F>> players;
	
	private final String name;
	
	private final Field<F> field;

	public Game(LinkedList<Player<F>> players, String name, Field<F> field) {
		super();
		this.players = players;
		this.name = name;
		this.field = field;
	}

	public LinkedList<Player<F>> getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}

	public Field<F> getField() {
		return field;
	}
	
}

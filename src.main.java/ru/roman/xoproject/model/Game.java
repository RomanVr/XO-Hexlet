package ru.roman.xoproject.model;

public class Game<F> {
	
	private final Player<F>[] players;
	
	private final String name;
	
	private final Field<F> field;

	public Game(Player<F>[] players, String name, Field<F> field) {
		super();
		this.players = players;
		this.name = name;
		this.field = field;
	}

	public Player<F>[] getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}

	public Field<F> getField() {
		return field;
	}
	
	

}

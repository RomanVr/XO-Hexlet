package ru.roman.xoproject.model;

import static org.hamcrest.CoreMatchers.nullValue;

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
	
	public String getNameToFigure(final FigureXO figureXO) {
		//TODO получить имя игрока по фигуре
		return null;
	}

	public Field<F> getField() {
		return field;
	}
	
}

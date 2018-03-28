package ru.roman.xoproject.model;

import java.util.Iterator;
import java.util.List;

public class Game<F> implements Iterable<Player<F>>{
	
	private final List<Player<F>> players;
	
	private final String name;
	
	private final Field<F> field;

	public Game(List<Player<F>> players, String name, Field<F> field) {
		super();
		this.players = players;
		this.name = name;
		this.field = field;
	}

	public List<Player<F>> getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}
	
	public String getNameToFigure(final FigureXO figureXO) {
		//TODO получить имя игрока по фигуре
		for (Player<F> player : players) {
			if(player.getFigure() == figureXO) return player.getName();
		}
		return null;
	}

	public Field<F> getField() {		
		return field;
	}

	@Override
	public Iterator<Player<F>> iterator() {		
		return players.iterator();
	}	
	
}

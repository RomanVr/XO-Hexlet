package ru.roman.xoproject.model;

public class Player {
	
	private final String name;
	
	private final Figure figure;

	public Player(final String name, 
				  final Figure figure) {
		super();
		this.name = name;
		this.figure = figure;
	}

	public String getName() {
		return name;
	}

	public Figure getFigure() {
		return figure;
	}
	
	

}

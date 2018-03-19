package ru.roman.xoproject.model;

public class Field<T> {
	
	private final T[][] figures;
	
	private final int size;

	public Field(int size) {
		super();
		this.size = size;
		this.figures = (T[][])new Object[size][size];
	}

	public T getFigure(final Point point) {
		return figures[point.getX()][point.getY()];
	}
	
	public void setFigure(final Point point, final T figure) {
		figures[point.getX()][point.getY()] = figure;
	}

	public int getSize() {
		return size;
	}
}

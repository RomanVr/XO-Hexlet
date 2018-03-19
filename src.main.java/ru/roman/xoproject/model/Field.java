package ru.roman.xoproject.model;

import ru.roman.xoproject.model.exceptions.InvalidPointException;

public class Field<T> {
	
	private static final int MIN_COORDINATE = 0;
	
	private final T[][] figures;
	
	private final int size;

	public Field(int size) {
		super();
		this.size = size;
		this.figures = (T[][])new Object[size][size];
	}

	public T getFigure(final Point point) throws InvalidPointException {
		if (!checkPoint(point)) {
		             throw new InvalidPointException();
		}
		return figures[point.getX()][point.getY()];
	}
	
	

	public void setFigure(final Point point, final T figure) throws InvalidPointException {
		figures[point.getX()][point.getY()] = figure;
	}

	public int getSize() {
		return size;
	}
	
	private boolean checkPoint(Point point) {
		return checkCoordinate(point.getX(), figures.length) 
	        && checkCoordinate(point.getY(), figures[point.getX()].length);
	}
	
	private boolean checkCoordinate (final int coordinate, final int maxCoordinate) {
		return coordinate >= MIN_COORDINATE 
				&& 
				coordinate < maxCoordinate;
	}
}

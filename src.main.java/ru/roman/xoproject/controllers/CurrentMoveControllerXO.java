package ru.roman.xoproject.controllers;

import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;

public class CurrentMoveControllerXO {
	
	public FigureXO	currentMove(final Field<FigureXO> field) {
		final int fieldSize = field.getSize();
		int countFigure = 0;
		
		for (int x = 0; x < fieldSize; x++ ) {
			countFigure += countFigureInRow(field, x);
		}
		
		if(countFigure == fieldSize*fieldSize) return null;
		if(countFigure %2 == 0) return FigureXO.X;
		
		return FigureXO.O;		
	}
	
	private int countFigureInRow(final Field<FigureXO> field, final int row) {
		int countFigure = 0;
		final int fieldSize = field.getSize();
		for (int x = 0; x < fieldSize; x++ ) {
			try {
				if(field.getFigure(new Point(row, x)) != null) countFigure++;
			} catch (InvalidPointException e) {
				e.printStackTrace();
			}
		}
		return countFigure;
	}

}

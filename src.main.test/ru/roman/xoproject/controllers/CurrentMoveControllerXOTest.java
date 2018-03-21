package ru.roman.xoproject.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;

public class CurrentMoveControllerXOTest {

	@Test
	public void testCurrentMoveNextMoveIs_O() throws InvalidPointException {
		final CurrentMoveControllerXO currentMoveControllerXO = new CurrentMoveControllerXO();
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field<FigureXO> field = new Field<>(fieldSize);
			field.setFigure(new Point(i, 0), FigureXO.X);
			field.setFigure(new Point(i, 1), FigureXO.O);
			field.setFigure(new Point(i, 2), FigureXO.X);
			assertEquals(FigureXO.O, currentMoveControllerXO.currentMove(field));
		}
	}
	
	@Test
	public void testCurrentMoveNextMoveIs_X() throws InvalidPointException {
		final CurrentMoveControllerXO currentMoveControllerXO = new CurrentMoveControllerXO();
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field<FigureXO> field = new Field<>(fieldSize);
			field.setFigure(new Point(i, 0), FigureXO.X);
			field.setFigure(new Point(i, 1), FigureXO.O);			
			assertEquals(FigureXO.X, currentMoveControllerXO.currentMove(field));
		}
	}
	
	@Test
	public void testCurrentMoveNextMoveIs_X_FirstMove() throws InvalidPointException {
		final CurrentMoveControllerXO currentMoveControllerXO = new CurrentMoveControllerXO();
		final int fieldSize = 3;
		
		final Field<FigureXO> field = new Field<>(fieldSize);			
		assertEquals(FigureXO.X, currentMoveControllerXO.currentMove(field));		
	}
	
	@Test
	public void testCurrentMoveNextNoMove() throws InvalidPointException {
		final CurrentMoveControllerXO currentMoveControllerXO = new CurrentMoveControllerXO();
		final int fieldSize = 3;
		
		final Field<FigureXO> field = new Field<>(fieldSize);
		field.setFigure(new Point(0, 0), FigureXO.X);
		field.setFigure(new Point(0, 1), FigureXO.O);
		field.setFigure(new Point(0, 2), FigureXO.X);
		field.setFigure(new Point(1, 0), FigureXO.O);
		field.setFigure(new Point(1, 1), FigureXO.O);
		field.setFigure(new Point(1, 2), FigureXO.X);
		field.setFigure(new Point(2, 0), FigureXO.X);
		field.setFigure(new Point(2, 1), FigureXO.O);
		field.setFigure(new Point(2, 2), FigureXO.X);
		assertNull(currentMoveControllerXO.currentMove(field));		
	}

}

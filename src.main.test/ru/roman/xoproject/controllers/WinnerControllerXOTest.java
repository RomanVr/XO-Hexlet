package ru.roman.xoproject.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;

public class WinnerControllerXOTest {

	@Test
	public void testGetWinnerPointChangerJava8Row() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		for (int i = 0; i < 3; i++) {
			final Field<FigureXO> field = new Field<>(3);
			field.setFigure(new Point(i, 0), FigureXO.X);
			field.setFigure(new Point(i, 1), FigureXO.X);
			field.setFigure(new Point(i, 2), FigureXO.X);
			assertEquals(FigureXO.X, winnerControllerXO.getWinnerPointChangerJava8(field));
		}	
	}
	
	@Test
	public void testGetWinnerPointChangerJava8NoWinnerRow() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		for (int i = 0; i < 3; i++) {
			final Field<FigureXO> field = new Field<>(3);
			field.setFigure(new Point(i, 0), FigureXO.X);
			field.setFigure(new Point(i, 1), FigureXO.O);
			field.setFigure(new Point(i, 2), FigureXO.X);
			assertNull(winnerControllerXO.getWinnerPointChangerJava8(field));
		}	
	}
	
	@Test
	public void testGetWinnerPointChangerJava8Column() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		for (int i = 0; i < 3; i++) {
			final Field<FigureXO> field = new Field<>(3);
			field.setFigure(new Point(0, i), FigureXO.X);
			field.setFigure(new Point(1, i), FigureXO.X);
			field.setFigure(new Point(2, i), FigureXO.X);
			assertEquals(FigureXO.X, winnerControllerXO.getWinnerPointChangerJava8(field));
		}	
	}
	
	@Test
	public void testGetWinnerPointChangerJava8NoWinnerColumn() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		for (int i = 0; i < 3; i++) {
			final Field<FigureXO> field = new Field<>(3);
			field.setFigure(new Point(0, i), FigureXO.X);
			field.setFigure(new Point(0, i), FigureXO.O);
			field.setFigure(new Point(0, i), FigureXO.X);
			assertNull(winnerControllerXO.getWinnerPointChangerJava8(field));
		}	
	}
	
	@Test
	public void testGetWinnerPointChangerJava8Diag1() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		
		final Field<FigureXO> field = new Field<>(3);
		field.setFigure(new Point(0, 0), FigureXO.X);
		field.setFigure(new Point(1, 1), FigureXO.X);
		field.setFigure(new Point(2, 2), FigureXO.X);
		assertEquals(FigureXO.X, winnerControllerXO.getWinnerPointChangerJava8(field));			
	}
	
	@Test
	public void testGetWinnerPointChangerJava8Diag1NoWinner() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		
		final Field<FigureXO> field = new Field<>(3);
		field.setFigure(new Point(0, 0), FigureXO.X);
		field.setFigure(new Point(1, 1), FigureXO.O);
		field.setFigure(new Point(2, 2), FigureXO.X);
		assertNull(winnerControllerXO.getWinnerPointChangerJava8(field));			
	}
	
	@Test
	public void testGetWinnerPointChangerJava8Diag2() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		
		final Field<FigureXO> field = new Field<>(3);
		field.setFigure(new Point(0, 2), FigureXO.X);
		field.setFigure(new Point(1, 1), FigureXO.X);
		field.setFigure(new Point(2, 0), FigureXO.X);
		assertEquals(FigureXO.X, winnerControllerXO.getWinnerPointChangerJava8(field));			
	}
	
	@Test
	public void testGetWinnerPointChangerJava8Diag2NoWinner() throws InvalidPointException {
		
		final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
		
		final Field<FigureXO> field = new Field<>(3);
		field.setFigure(new Point(0, 2), FigureXO.O);
		field.setFigure(new Point(1, 1), FigureXO.O);
		field.setFigure(new Point(2, 0), FigureXO.X);
		assertNull(winnerControllerXO.getWinnerPointChangerJava8(field));			
	}

}

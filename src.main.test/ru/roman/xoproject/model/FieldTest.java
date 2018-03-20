package ru.roman.xoproject.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ru.roman.xoproject.model.exceptions.InvalidPointException;

public class FieldTest {
	
	private Field<FigureXO> field;

	@Before
	public void setUp() throws Exception {
		field = new Field<>(3);	
	}

	@Test
	public void testSetFigure() throws InvalidPointException {		
		final Point inputPoint = new Point(0, 0);
		final FigureXO inputFigure = FigureXO.X;
		
		field.setFigure(inputPoint, inputFigure);
		FigureXO actualFigure = field.getFigure(inputPoint);
		
		assertEquals(inputFigure, actualFigure);			
	}

	@Test
	public void testGetSize() {		
		assertEquals(3, field.getSize());
	}

}

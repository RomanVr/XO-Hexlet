package ru.roman.xoproject.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import ru.roman.xoproject.model.exceptions.InvalidPointException;

@RunWith(value = Parameterized.class)
public class FieldTestParameters {	
	
	private Field<FigureXO> field;
	
	@Parameter(value = 0)
    public int numberA;
	
	@Parameter(value = 1)
    public int numberB;

	@Before
	public void setUp() throws Exception {
		field = new Field<>(3);	
	}	
	
	@Parameters(name = "{index}: test(Point ({0}, {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-1, 0},
                {0, -1},
                {3, 0},
                {0, 3},
                {3, 3},
                {-1, 5}
                
        });
    }
		
	@Test(expected = InvalidPointException.class)
	public void testInvalidPointException() throws InvalidPointException {		
		final Point inputDataPoint = new Point(numberA, numberB);	
		final FigureXO inputFigure = FigureXO.X;
		
		field.setFigure(inputDataPoint, inputFigure);	
		fail("not IvalidPointException");
	}
}

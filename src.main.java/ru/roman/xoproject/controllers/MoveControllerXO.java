package ru.roman.xoproject.controllers;

import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;
import ru.roman.xoproject.model.exceptions.OccupiedPlaceException;

public class MoveControllerXO {
	
	public <T>void applayFigure(final Field<T> field, 
								final T figure, 
								final Point point) throws OccupiedPlaceException, 
														  InvalidPointException {
		if(field.getFigure(point) != null) throw new OccupiedPlaceException();
		field.setFigure(point, figure);	
	}

}

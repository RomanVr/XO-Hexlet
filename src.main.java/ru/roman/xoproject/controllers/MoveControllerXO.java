package ru.roman.xoproject.controllers;

import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;
import ru.roman.xoproject.model.exceptions.OccupiedPlaceException;

public class MoveControllerXO {
	
	public void applayFigure(final Field<FigureXO> field, 
								final FigureXO figure, 
								final Point point) throws OccupiedPlaceException, 
														  InvalidPointException {
		if(field.getFigure(point) != null) throw new OccupiedPlaceException();
		field.setFigure(point, figure);	
	}

}

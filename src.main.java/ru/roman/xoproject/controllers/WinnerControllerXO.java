package ru.roman.xoproject.controllers;

import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;

public class WinnerControllerXO {
	
	public FigureXO getWinner(final Field<FigureXO> field) {
		try {
			for(int i = 0; i < field.getSize(); i++)
				if (check(field, new Point(i, 0), new Point(i, 1), new Point(i, 2)))
					return field.getFigure(new Point(i, 0));
			for(int i = 0; i < field.getSize(); i++)
				if (check(field, new Point(0, i), new Point(1, i), new Point(2, i)))
					return field.getFigure(new Point(0, i));
			if (check(field, new Point(0, 0), new Point(1, 1), new Point(2, 2)))
				return field.getFigure(new Point(0, 0));
			if (check(field, new Point(2, 0), new Point(1, 1), new Point(0, 2)))
				return field.getFigure(new Point(0, 0));
		} catch (InvalidPointException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean check(final Field<FigureXO> field, 
						  final Point p1,
						  final Point p2,
						  final Point p3) {
		try {
			if (field.getFigure(p1) == null) return false;
			if (field.getFigure(p1) == field.getFigure(p2)
				&& 
				field.getFigure(p1) == field.getFigure(p3)) return true;		
		} catch (InvalidPointException e) {
			e.printStackTrace();
		}
		return false;			
	}
	
	public FigureXO getWinnerPointChanger(final Field<FigureXO> field) {
		try {
			for(int i = 0; i < field.getSize(); i++)
				if (checkPointChanger(field, 
									  new Point(i, 0), 
									  new IPointChanger() {
										
										@Override
										public Point next(Point p) {											
											return new Point(p.getX(), p.getY() + 1);
										}
									}))
					return field.getFigure(new Point(i, 0));
			for(int i = 0; i < field.getSize(); i++)
				if (checkPointChanger(field, 
									  new Point(0, i), 
									  new IPointChanger() {
										
										@Override
										public Point next(Point p) {											
											return new Point(p.getX() + 1, p.getY());
										}
									}))
					return field.getFigure(new Point(0, i));
			if (checkPointChanger(field, 
					  			  new Point(0, 0), 
					  			  new IPointChanger() {
						
									@Override
									public Point next(Point p) {											
										return new Point(p.getX() + 1, p.getY() + 1);
									}
								}))
				return field.getFigure(new Point(0, 0));
			if (checkPointChanger(field, 
					  			  new Point(0, 2), 
					  			  new IPointChanger() {
						
									@Override
									public Point next(Point p) {											
										return new Point(p.getX() + 1, p.getY() - 1);
									}
								}))
				return field.getFigure(new Point(0, 2));
		} catch (InvalidPointException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean checkPointChanger(final Field<FigureXO> field, 
			  final Point startPoint,
			  final IPointChanger pointChanger) {
		final Point p1 = startPoint;
		final Point p2 = pointChanger.next(p1);
		final Point p3 = pointChanger.next(p2);
		
		try {
		if (field.getFigure(p1) == null) return false;
		if (field.getFigure(p1) == field.getFigure(p2)
			&& 
			field.getFigure(p1) == field.getFigure(p3)) return true;		
		} catch (InvalidPointException e) {
		e.printStackTrace();
		}
		return false;			
	}
	
	public FigureXO getWinnerPointChangerJava8(final Field<FigureXO> field) {
		try {
			for(int i = 0; i < field.getSize(); i++)
				if (checkJava8(field, new Point(i, 0), p->new Point(p.getX(), p.getY() + 1)))
					return field.getFigure(new Point(i, 0));
			for(int i = 0; i < field.getSize(); i++)
				if (checkJava8(field, new Point(0, i), p->new Point(p.getX() + 1, p.getY())))
					return field.getFigure(new Point(0, i));
			if (checkJava8(field, new Point(0, 0), p->new Point(p.getX() + 1, p.getY() + 1)))
				return field.getFigure(new Point(0, 0));
			if (checkJava8(field, new Point(0, 2), p->new Point(p.getX() + 1, p.getY() - 1)))
				return field.getFigure(new Point(0, 2));
		} catch (InvalidPointException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean checkJava8(final Field<FigureXO> field, 
			  final Point currentPoint,
			  final IPointChanger pointChanger) {
		final FigureXO currentFigure;
		final FigureXO nextFigure;
		final Point nextPoint = pointChanger.next(currentPoint);
		try {
			currentFigure = field.getFigure(currentPoint);
			if (currentFigure == null) return false;
			nextFigure = field.getFigure(nextPoint);				
		} catch (InvalidPointException e) {
			return true; //дошли до конца поля и currentFigure nextFigure одинаковые все время
		}
					
		if (currentFigure != nextFigure) return false;
		
		return checkJava8(field, nextPoint, pointChanger);		
	}	
	
	private interface IPointChanger {
		public Point next(final Point point);
	}

}

package ru.roman.xoproject.view;

import static org.junit.Assert.assertFalse;

import java.util.InputMismatchException;
import java.util.Scanner;

import ru.roman.xoproject.controllers.CurrentMoveControllerXO;
import ru.roman.xoproject.controllers.MoveControllerXO;
import ru.roman.xoproject.controllers.WinnerControllerXO;
import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Game;
import ru.roman.xoproject.model.Point;
import ru.roman.xoproject.model.exceptions.InvalidPointException;
import ru.roman.xoproject.model.exceptions.OccupiedPlaceException;

public class ConsoleViewXO {
	
	private final CurrentMoveControllerXO currentMoveControllerXO = new CurrentMoveControllerXO();		
	
	private final WinnerControllerXO winnerControllerXO = new WinnerControllerXO();
	
	private final MoveControllerXO moveControllerXO = new MoveControllerXO();
	
	public void show(final Game<FigureXO> game) {
		System.out.format("Game name: %s\n", game.getName());
		final Field<FigureXO> field = game.getField();
		for (int x = 0; x < field.getSize(); x++) {
			if(x != 0)
				printSeparator();
			printLine(field, x);
		}
		
	}
	
	public boolean move(final Game<FigureXO> game) {
		final Field<FigureXO> field = game.getField();
		final FigureXO winner = winnerControllerXO.getWinner(field);
		if(winner != null) {	
			
			System.out.format("Winner is: %s\n", game.getNameToFigure(winner));
			return false;
		}
		final FigureXO currentFigure = currentMoveControllerXO.currentMove(field);
		if (currentFigure == null) {			
			if(winner == null) {
				System.out.println("No winner and no moves left!");				
			}
			return false;
		}		
		System.out.format("Please enter coordinate point for: %s\n", currentFigure);
		final Point point = askPoint();
		try {
			moveControllerXO.applayFigure(field, currentFigure, point);
		} catch (OccupiedPlaceException | InvalidPointException e) {
			//e.printStackTrace();
			System.out.println("Point is Invalid!!!");
		}
		return true;
	}
	
	private Point askPoint() {
		return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
	}
	
	private int askCoordinate(final String coordinateName) {
		System.out.format("Please input %s:", coordinateName);
		final Scanner in = new Scanner(System.in);
		try {
			return in.nextInt();
		} catch (final InputMismatchException e) {
			System.out.println("0_0 olololo!!!!!");
			return askCoordinate(coordinateName);
		}		
	}
	
	private void printLine(final Field<FigureXO> field, 
						   final int x) {
		//printSeparator();
		//System.out.print("|");
		for (int y = 0; y < field.getSize(); y++) {
			if (y != 0)
				System.out.print("|");
			System.out.print(" ");
			final FigureXO figureXO;
			try {
				figureXO = field.getFigure(new Point(x, y));
			} catch (final InvalidPointException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
			System.out.print(figureXO != null ? figureXO : " ");
			System.out.print(" ");
		}
		System.out.println();
	}

	private void printSeparator() {
		System.out.println("~~~~~~~~~~~");		
	}

}

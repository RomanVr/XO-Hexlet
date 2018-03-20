package ru.roman.xoproject.model;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGetPlayers() {
		final String name1 = "Slava";
		final String name2 = "Gleb";
		final Player<FigureXO> player1 = new Player<>(name1, FigureXO.O);
		final Player<FigureXO> player2 = new Player<>(name2, FigureXO.X);
		
		final LinkedList<Player<FigureXO>> inputValue = new LinkedList<>();
		inputValue.add(player1);
		inputValue.add(player2);
	
		final int expectedValue = 2;		
		
		final Game<FigureXO> game = new Game<>(inputValue, null, null);
		
		final int actualValue = game.getPlayers().size();
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetName() {
		final String name = "NewGame";		
		final String inputValue = name;	
		final String expectedValue = "NewGame";		
		
		final Game<FigureXO> game = new Game<>(null, inputValue, null);
		
		final String actualValue = game.getName();
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetField() {
		final Field<FigureXO> field = new Field<>(3);		
		final Field<FigureXO> inputValue = field;	
		final Field<FigureXO> expectedValue = field;		
		
		final Game<FigureXO> game = new Game<>(null, null, inputValue);
		
		final Field<FigureXO> actualValue = game.getField();
		
		assertEquals(expectedValue, actualValue);
	}

}

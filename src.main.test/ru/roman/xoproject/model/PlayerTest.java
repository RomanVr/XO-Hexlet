package ru.roman.xoproject.model;

import static org.junit.Assert.*;

import org.junit.Test;

import sun.net.www.content.text.plain;

public class PlayerTest {

	@Test
	public void testGetName() {
		final String inputValue = "Slava";
		final String expectedValue = inputValue;
		
		final Player<FigureXO> player = new Player<>(inputValue, null);
		
		final String actualValue = player.getName();
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetFigure() {
		final FigureXO inputValue = FigureXO.O;
		final FigureXO expectedValue = inputValue;
		
		final Player<FigureXO> player = new Player<>(null, inputValue);
		
		final FigureXO actualValue = player.getFigure();
		
		assertEquals(expectedValue, actualValue);
	}

}

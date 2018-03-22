package ru.roman.xoproject;

import java.util.LinkedList;
import ru.roman.xoproject.model.Field;
import ru.roman.xoproject.model.FigureXO;
import ru.roman.xoproject.model.Game;
import ru.roman.xoproject.model.Player;
import ru.roman.xoproject.view.ConsoleViewXO;

public class XOCLI {

	public static void main(String[] args) {		
		final String name1 = "Gleb";
		final String name2 = "Slava";
		final Player<FigureXO> player1 = new Player<FigureXO>(name1, FigureXO.X);
		final Player<FigureXO> player2 = new Player<FigureXO>(name2, FigureXO.O);
		
		final LinkedList<Player<FigureXO>> players = new LinkedList<>();
		players.add(player1);
		players.add(player2);
		
		final Game<FigureXO> gameXO = new Game<>(players, "XO", new Field<>(3));
		
		final ConsoleViewXO consoleViewXO = new ConsoleViewXO();
		consoleViewXO.show(gameXO);	
		while (consoleViewXO.move(gameXO)) {			
			consoleViewXO.show(gameXO);			
		}
			
	}

}

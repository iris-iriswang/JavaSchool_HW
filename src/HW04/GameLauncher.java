package HW04;

import java.util.Scanner;

public class GameLauncher {
	public static void main(String[] args) {
		
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		
		do{
			game.setSettings();
			game.StartGame();
			game.showHistory();
			System.out.println("再玩一次(Y/N)?");
		}while(!scanner.next().equals("N"));
	}

}

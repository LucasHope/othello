package othello;

import javafx.scene.layout.Pane;

public class Manager {
	private final OthelloPreferences preferences;
	private final Board board;
	private final OthelloMenu menu;
	private final Othello application;

	public Manager(Othello application, Pane menuPane, Pane boardPane) {
		this.application = application;

		this.preferences = new OthelloPreferences();
		this.board = new Board(this, preferences);
		this.menu = new OthelloMenu(this, preferences);

		menuPane.getChildren().add(menu.getMenuPane());
		boardPane.getChildren().add(board.getBoardPane());
	}

	public void showMenu() {
		application.setMenuScene();
	}

	public void showBoard() {
		application.setBoardScene();
	}

}

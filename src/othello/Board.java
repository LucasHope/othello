package othello;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Board {
	private static final double TOOLBAR_SPACING = 0;
	private static final Insets BOARD_PADDING = new Insets(5);
	private static final double GAMEBOARD_WIDTH = 798;
	private static final double TOOLBAR_HEIGHT = 30;

	private final OthelloPreferences preferences;

	private GridPane boardPane;
	private HBox toolBar;
	private GridPane gameBoard;

	private ArrayList<Tile> tileList = new ArrayList<>();

	private Manager manager;

	public Board(Manager manager, OthelloPreferences preferences) {
		this.manager = manager;
		this.preferences = preferences;

		boardPane = new GridPane();

		createToolBar();
		createGameBoard();
	}

	private void createToolBar() {
		toolBar = new HBox(TOOLBAR_SPACING);
		toolBar.setPadding(BOARD_PADDING);
		toolBar.setPrefSize(GAMEBOARD_WIDTH, TOOLBAR_HEIGHT);
		toolBar.setAlignment(Pos.CENTER);

		Button toMenuButton = new Button("back to menu");
		toMenuButton.setOnAction(e -> manager.showMenu());
		toolBar.getChildren().add(toMenuButton);

		boardPane.add(toolBar, 0, 0);
	}

	private void createGameBoard() {
		gameBoard = new GridPane();
		gameBoard.setPadding(BOARD_PADDING);
		gameBoard.setPrefSize(GAMEBOARD_WIDTH, GAMEBOARD_WIDTH);

		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				Tile tile = new Tile(col, row);
				tileList.add(tile);
				gameBoard.add(tile, col, row);
				// TODO emptyTilesArray
			}
		}

		boardPane.add(gameBoard, 0, 1);
	}

	public Node getBoardPane() {
		return boardPane;
	}

}

package othello;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class OthelloMenu {
	private static final double MENU_SPACING = 20;
	private static final double MENU_WIDTH = 300;

	private final OthelloPreferences preferences;

	private BorderPane menuPane;
	private Manager manager;

	public OthelloMenu(Manager manager, OthelloPreferences preferences) {
		this.manager = manager;
		this.preferences = preferences;

		createMenuPane();
	}

	private void createMenuPane() {
		menuPane = new BorderPane();
		HBox buttons = new HBox(MENU_SPACING);
		buttons.setPrefSize(MENU_WIDTH, MENU_WIDTH);
		buttons.setAlignment(Pos.CENTER);
		menuPane.setCenter(buttons);

		Button showBoardButton = new Button("show board");
		showBoardButton.setOnAction(e -> manager.showBoard());
		Button quitButton = new Button("quit");
		quitButton.setOnAction(e -> System.exit(0));

		buttons.getChildren().addAll(showBoardButton, quitButton);

	}

	public Node getMenuPane() {
		return menuPane;
	}

}

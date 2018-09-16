package othello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Othello extends Application {
	private Stage primaryStage;
	private Scene menuScene;
	private Scene boardScene;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        primaryStage.setTitle("Othello");
                
		StackPane menuPane = new StackPane();
		menuScene = new Scene(menuPane, 300, 250);
		StackPane boardPane = new StackPane();
		boardScene = new Scene(boardPane, 798, 828);

		primaryStage.setScene(menuScene);
        
		new Manager(this, menuPane, boardPane);
        
        primaryStage.show();
    }

	public void setMenuScene() {
		primaryStage.setScene(menuScene);
	}

	public void setBoardScene() {
		primaryStage.setScene(boardScene);
	}
}
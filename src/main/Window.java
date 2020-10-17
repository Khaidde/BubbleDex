package main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import graphics.ResizableCanvas;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import res.Assets;

public class Window extends Application {
	
	private static final String TITLE = "BubbleDex";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public void begin(String[] args) {
		launch(args);
	}
    
    public void start(Stage primaryStage) {
    	Assets assets = new Assets();
    	
    	StackPane content = new StackPane();
    	content.setStyle("-fx-background-color: #111111");
    	
    	Scene scene = new Scene(content, WIDTH, HEIGHT);
    	scene.getStylesheets().add(assets.STYLESHEETS_CSS.toExternalForm());
    	primaryStage.setScene(scene);
    	primaryStage.setTitle(TITLE);
    	primaryStage.show();
    	
    	/*
	    GridPane grid = new GridPane();
	    grid.setPadding(new Insets(10));
	    grid.setVgap(10);
	    grid.setHgap(10);
	    */
    	BorderPane borderPane = new BorderPane();
    	borderPane.setPadding(new Insets(10));
    	borderPane.setOnMouseClicked(event -> borderPane.requestFocus());

	    JFXTextField txtField = new JFXTextField();
	    txtField.setMaxWidth(200);
	    //GridPane.setConstraints(txtField, 0, 0);
	    borderPane.setTop(txtField);
    	//grid.getChildren().add(txtField);
    	
    	JFXButton btn = new JFXButton();
    	btn.setText("Hello World");
    	btn.setOnAction(event -> System.out.println("Hello World!"));
//    	GridPane.setConstraints(btn, 1, 0);
//    	grid.getChildren().add(btn);
    	//borderPane.setBottom(btn);
    	
    	JFXSlider slider = new JFXSlider();
    	GridPane.setConstraints(slider, 0, 3);
    	borderPane.setBottom(slider);
    	
    	ResizableCanvas canvas = new ResizableCanvas();
    	canvas.widthProperty().bind(content.widthProperty());
    	canvas.heightProperty().bind(content.heightProperty());
        
    	content.getChildren().add(canvas);
    	content.getChildren().add(borderPane);
	      
	    AnimationTimer timer = new AnimationTimer() {
	    	float c = 0;
			public void handle(long now) {
				canvas.render();

				c += 0.1;
				btn.setTranslateX(10 * Math.cos(c));
				btn.setTranslateY(10 * Math.sin(c));
			}
    	};
        timer.start();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

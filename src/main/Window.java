package main;

import com.jfoenix.controls.JFXButton;

import graphics.ResizableCanvas;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application {
	private static final String TITLE = "HackGT7";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public void begin(String[] args) {
		launch(args);
		System.out.println("ASDSDSDAS");
	}
    
    public void start(Stage primaryStage) {
    	StackPane content = new StackPane();
    	primaryStage.setScene(new Scene(content, WIDTH, HEIGHT));
    	primaryStage.setTitle(TITLE);
    	primaryStage.show();
    	
	    GridPane grid = new GridPane();
	    grid.setPadding(new Insets(10));
	    grid.setVgap(10);
	    grid.setHgap(10);

	    TextField txtField = new TextField();
	    GridPane.setConstraints(txtField, 0, 0);
    	grid.getChildren().add(txtField);
    	
    	JFXButton btn = new JFXButton();
    	btn.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
    	btn.setText("Say 'Hello World'");
    	btn.setOnAction(event -> System.out.println("Hello World!"));
    	GridPane.setConstraints(btn, 0, 1);
    	grid.getChildren().add(btn);
    	
    	ResizableCanvas canvas = new ResizableCanvas();
    	canvas.widthProperty().bind(content.widthProperty());
    	canvas.heightProperty().bind(content.heightProperty());
        
	    content.getChildren().add(canvas);
	    content.getChildren().add(grid);
	    
	    this.thread = new Thread(() -> {
	    	running = true;
        	long delta = 0;
    	    long now = System.currentTimeMillis(); 
    	    float c = 0;
        	while (running) {
        		delta += System.currentTimeMillis() - now;
        		now = System.currentTimeMillis();
        		while (delta >= 20) {
        			c += 0.1;
        			delta -= 20;
        			btn.setTranslateX(10 * Math.cos(c));
        			btn.setTranslateY(10 * Math.sin(c));
        		}
        	}
        });
	    thread.start();
    }
    
    boolean running = false;
    Thread thread;
    
    public void stop() {
    	try {
    		running = false;
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

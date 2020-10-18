package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import graphics.GraphManager;
import graphics.ResizableCanvas;
import input.FileReader;
import input.Group;
import input.Person;
import input.Trait;
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
	public ArrayList<Person> allPeople;
	public Set<Group> allGroups;

	private GraphManager graphManager = new GraphManager();
	
	public void begin(String[] args) {
		launch(args);
		
		Group group = new Group("test", new ArrayList<>());
		
		Person p = new Person("Joe Smoe");
		p.addTrait(new Trait(group, null));
		for (int i = 0; i < 100; i++) {
			graphManager.createNode(new Person("Joe Smoe"));
		}
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
    	
    	BorderPane borderPane = new BorderPane();
    	borderPane.setPadding(new Insets(10));
    	borderPane.setOnMouseClicked(event -> borderPane.requestFocus());

	    JFXTextField searchInput = new JFXTextField();
	    searchInput.setMaxWidth(200);
	    searchInput.setPromptText("Search");
	    borderPane.setTop(searchInput);
    	
    	JFXSlider slider = new JFXSlider();
    	GridPane.setConstraints(slider, 0, 3);
    	borderPane.setBottom(slider);
    	
    	ResizableCanvas canvas = new ResizableCanvas(graphManager);
    	canvas.widthProperty().bind(content.widthProperty());
    	canvas.heightProperty().bind(content.heightProperty());
        
    	content.getChildren().add(canvas);
    	content.getChildren().add(borderPane);
	      
	    AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				canvas.render();
			}
    	};
        timer.start();

		try {
			allGroups = new LinkedHashSet<>();
			allPeople = FileReader.read("Test.xlsx", allGroups);
		} catch (IOException e) {
			System.out.println("File not found");
		}
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

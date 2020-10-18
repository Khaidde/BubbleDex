package graphics;

import input.Person;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Node {
	
	private static final int SIZE = 2;
	
	int id;
	
	private final Person person;
	double x = 800 * Math.random();
	double y= 800 * Math.random();
	
	public Node(Person person) {
		this.person = person;
	}
	
	public void render(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillArc(x, y, SIZE, SIZE, 0, 360, ArcType.ROUND);
	}

}

package graphics;

import input.Person;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Node {
	
	private static final int SIZE = 10;
	
	int id;
	
	private final Person person;
	private int x;
	private int y;
	
	public Node(Person person) {
		this.person = person;
	}
	
	private float c; 
	public void render(GraphicsContext gc) {
		c += 0.1;
		gc.setFill(Color.WHITE);
		gc.fillArc(10 * Math.sin(c) + x, 10 * Math.cos(c) + y, SIZE, SIZE, 0, 360, ArcType.ROUND);
	}

}

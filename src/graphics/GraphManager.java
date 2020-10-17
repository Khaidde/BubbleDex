package graphics;

import input.Person;
import javafx.scene.canvas.GraphicsContext;
import utils.collections.Bag;
import utils.collections.DynamicAllocArray;

public class GraphManager {
	
	private final DynamicAllocArray<Node> nodes = new DynamicAllocArray<>();
	private Bag<NodeGrouping> groupings = new Bag<>();
	
	public void createNode(Person person) {
		Node newNode = new Node(person);
		newNode.id = nodes.allocate(newNode);
	}
	
	public void clear() {
		nodes.clear();
	}
	
	public void render(GraphicsContext gc) {
		
	}
}

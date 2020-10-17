package graphics;

import input.Group;
import input.Person;
import javafx.scene.canvas.GraphicsContext;
import utils.collections.Bag;
import utils.collections.DynamicAllocArray;

public class GraphManager {
	
	private final DynamicAllocArray<Node> nodes = new DynamicAllocArray<>();
	private Bag<NodeGrouping> groupings = new Bag<>();
	
	private int currentMonth = 0;
	private int currentYear = 0;
	
	public void createNode(Person person) {
		Node newNode = new Node(person);
		newNode.id = nodes.allocate(newNode);
	}
	
	public void createGrouping(Group group) {
		NodeGrouping grouping = new NodeGrouping();
	}
	
	public Node getNode(int nodeID) {
		return nodes.get(nodeID);
	}
	
	public void updateDate(int month, int year) {
		this.currentMonth = month;
		this.currentYear = year;
	}
	
	public void clear() {
		nodes.clear();
	}
	
	public void render(GraphicsContext gc) {
		groupings.iterate(grouping -> {
			grouping.render(gc);
		});
	}
}

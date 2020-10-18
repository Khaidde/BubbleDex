package graphics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import input.Date;
import input.Group;
import input.Person;
import input.Trait;
import javafx.scene.canvas.GraphicsContext;
import utils.collections.DynamicAllocArray;

public class GraphManager {
	
	private final DynamicAllocArray<Node> nodes = new DynamicAllocArray<>();
	private Map<String, NodeGrouping> groupings = new HashMap<>();
	
	private double width;
	private double height;
	
	private int currentMonth = 1;
	private int currentYear = 1;
	
	public GraphManager(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	public void createNode(Person person) {
		Node newNode = new Node(person);
		newNode.id = nodes.allocate(newNode);
		
		List<Trait> traits = person.getTraits();
		for (Trait t: traits) {
			Group group = t.getGroup();
			groupings.computeIfAbsent(group.getEvent(), key -> new NodeGrouping(groupings.size(), group, this));
		}
		
		//Insert node into current group associate with current time
		Group currentGroup = person.getGroup(new Date(currentMonth, currentYear, currentMonth, currentYear));
		groupings.get(currentGroup.getEvent()).insertNode(newNode);
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

	private static final int MAX_CHANGE = 5;
	public void update(long delta) {
		
		for (NodeGrouping nodeGrouping: groupings.values()) {
			double distCenterX = (width / 2 - nodeGrouping.centerX);
			double distCenterY = (height / 2 - nodeGrouping.centerY);
			 
			nodeGrouping.centerX += distCenterX * 0.01;
			nodeGrouping.centerY += distCenterY * 0.01;
			

			for (NodeGrouping otherGrouping: groupings.values()) {
				if (nodeGrouping.id == otherGrouping.id) continue;
				double dx = nodeGrouping.centerX - otherGrouping.centerX;
				double dy = nodeGrouping.centerY - otherGrouping.centerY;
				double distance = Math.sqrt(dx * dx + dy * dy);
				int doubleRadius = nodeGrouping.radius + otherGrouping.radius;
				if (distance < doubleRadius) {
					double changeX = -dx + dx / distance * (doubleRadius);
					double changeY = -dy + dy / distance * (doubleRadius);
					nodeGrouping.centerX += Math.max(-MAX_CHANGE, Math.min(MAX_CHANGE, changeX * 0.9));
					nodeGrouping.centerY += Math.max(-MAX_CHANGE, Math.min(MAX_CHANGE, changeY * 0.9));
				}
			}
			
			nodeGrouping.update(delta);
		}
	}
	
	public void render(GraphicsContext gc) {
		for (NodeGrouping nodeGrouping: groupings.values()) {
			nodeGrouping.render(gc);
		}
	}
}

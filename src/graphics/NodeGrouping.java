package graphics;

import javafx.scene.canvas.GraphicsContext;
import utils.collections.Bag;

public final class NodeGrouping {
	
	private final Bag<Node> nodes = new Bag<>();
	
	private int radius;
	
	public void addNode(Node node) {
		nodes.add(node);
		
		//TODO Compute positions and stuff
	}
	
	public void render(GraphicsContext gc) {
		//TODO render big circle grouping;
		
		nodes.iterate(node -> {
			node.render(gc);
		});
	}
	

}

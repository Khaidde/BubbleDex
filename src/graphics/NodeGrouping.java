package graphics;

import javafx.scene.canvas.GraphicsContext;
import utils.collections.Bag;
import utils.collections.IntBag;

public final class NodeGrouping {
	
	private final IntBag nodeIDs = new IntBag();
	
	private final GraphManager graphManager;
	
	private int radius;
	
	public NodeGrouping(GraphManager graphManager) {
		this.graphManager = graphManager;
	}
	
	public void insertNode(Node node) {
		nodeIDs.add(node.id);
		
		//TODO Compute positions and stuff
	}
	
	public void render(GraphicsContext gc) {
		//TODO render big circle grouping;
		
		nodeIDs.iterate(nodeID -> {
			graphManager.getNode(nodeID).render(gc);
		});
	}
	

}

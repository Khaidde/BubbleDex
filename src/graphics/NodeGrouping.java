package graphics;

import input.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import utils.collections.IntBag;

public final class NodeGrouping {
	
	private final IntBag nodeIDs = new IntBag();
	
	private final GraphManager graphManager;
	
	int id;
	private Group group;
	
	double centerX = 800 * Math.random();
	double centerY = 800 * Math.random();
	int radius = (int) (50 * Math.random()) + 25;
	
	public NodeGrouping(int id, Group group, GraphManager graphManager) {
		this.id = id;
		this.group = group;
		this.graphManager = graphManager;
	}
	
	public void insertNode(Node node) {
		nodeIDs.add(node.id);
	}

	public void update(long delta) {
		int[] ids = nodeIDs.data();
		for (int i = 0; i < nodeIDs.size(); i++) {
			Node node = graphManager.getNode(ids[i]); 
			
			double distCenterX = (centerX - node.x);
			double distCenterY = (centerY - node.y);
			
			node.x += distCenterX * 0.05;
			node.y += distCenterY * 0.05;
			
			final int MAX_CHANGE = 1000;
			for (int j = 0; j < nodeIDs.size(); j++) {
				if (i == j) continue;
				Node otherNode = graphManager.getNode(ids[j]); 
				double dx = node.x - otherNode.x;
				double dy = node.y - otherNode.y;
				
				double distance = Math.sqrt(dx * dx + dy * dy);
				int doubleRadius = 10;
				if (distance < doubleRadius) {
					double changeX = -dx + dx / distance * (doubleRadius);
					double changeY = -dy + dy / distance * (doubleRadius);
					node.x += Math.max(-MAX_CHANGE, Math.min(MAX_CHANGE, changeX * 1.1));
					node.y += Math.max(-MAX_CHANGE, Math.min(MAX_CHANGE, changeY * 1.1));
				}
			}
		}
		
		this.radius = 20 * nodeIDs.size();
	}
	
	public void render(GraphicsContext gc) {
		//TODO render big circle grouping
		gc.setLineWidth(1);
        gc.setStroke(Color.WHITE);
        gc.setLineCap(StrokeLineCap.BUTT);
        gc.strokeArc(centerX - ((double) radius) / 2, centerY - radius / 2, radius, radius, 0, 360, ArcType.OPEN);
	
		int[] ids = nodeIDs.data();
		for (int i = 0; i < nodeIDs.size(); i++) {
			graphManager.getNode(ids[i]).render(gc);
		}
	}
	

}

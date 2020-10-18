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
		
		//TODO Compute positions and stuff
	}

	public void update(long delta) {
		int[] ids = nodeIDs.data();
		for (int i = 0; i < nodeIDs.size(); i++) {
			Node node = graphManager.getNode(ids[i]); 
		
			double distCenterX = (centerX - node.x);
			double distCenterY = (centerY - node.y);
			
			double fx = distCenterX * 0.01;
			double fy = distCenterY * 0.01;
			
			int[] otherIDs = nodeIDs.data();
			for (int j = 0; j < nodeIDs.size(); j++) {
				if (i == j) continue;
				Node otherNode = graphManager.getNode(otherIDs[j]); 
				double dx = node.x - otherNode.y;
				double dy = node.y - otherNode.x;
				
				//fx += 0.1 / dx;
				//fy += 0.1 / dy;
			}
			
			node.x += fx;
			node.y += fy;
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

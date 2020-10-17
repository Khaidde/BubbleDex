package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ResizableCanvas extends Canvas {
	
	private GraphManager graphManager;
	
	public ResizableCanvas(GraphManager graphManager) {
		this.graphManager = graphManager;
    }

    public void render() {
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        
        graphManager.render(gc);
    }

    public boolean isResizable() {
        return true;
    }

    public double prefWidth(double height) {
        return getWidth();
    }

    public double prefHeight(double width) {
        return getHeight();
    }
}

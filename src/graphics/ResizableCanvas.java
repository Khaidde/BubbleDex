package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ResizableCanvas extends Canvas {
	
	public ResizableCanvas() {
        widthProperty().addListener(evt -> render());
        heightProperty().addListener(evt -> render());
    }

    public void render() {
    	//TODO do all rendering in here
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        
        /*
        gc.setStroke(Color.RED);
        gc.strokeLine(0, 0, width, height);
        gc.strokeLine(0, height, width, 0);
        */
        
        for (int i = 0; i < 100; i++) {
        	//gc.setFill(Color.BLUE);
            //gc.fillRect(Math.random() * 500, Math.random() * 500, 100, 100);
        }
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

package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ResizableCanvas extends Canvas {
	
	public ResizableCanvas() {
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    private void draw() {
    	//TODO do all rendering in here
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);

        gc.setStroke(Color.RED);
        gc.strokeLine(0, 0, width, height);
        gc.strokeLine(0, height, width, 0);
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

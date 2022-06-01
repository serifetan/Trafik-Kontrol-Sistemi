package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
public class TrafficLight {

	public Rectangle trafficLight;
	public Circle red, yellow, green;
	Color color;
	public int x, y, width, height;
	public Boolean active = false;
	public Road road;

	public TrafficLight(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		trafficLight = new Rectangle();
		red = new Circle();
		yellow = new Circle();
		green = new Circle();
	}

	public Rectangle drawTrafficLight() {
		trafficLight.setX(x);
		trafficLight.setY(y);
		trafficLight.setWidth(width / 2);
		trafficLight.setHeight(height / 2);
		trafficLight.setStroke(Color.GRAY);
		trafficLight.setFill(Color.BLACK);
		trafficLight.setStrokeWidth(5);
		trafficLight.setArcHeight(15);
		trafficLight.setArcWidth(15);
		return trafficLight;
	}

	public Circle drawRedCircle() {
			red.setCenterX(trafficLight.getX() + (trafficLight.getHeight() / 2));
			red.setCenterY(trafficLight.getY() + (trafficLight.getHeight() / 2));
			red.setRadius(trafficLight.getWidth() / 9);
				red.setStroke(Color.BLACK);
				red.setStrokeWidth(2);
				color = Color.rgb(71, 0, 2);
		return red;
	}

	public Circle drawYellowCircle() {

			yellow.setCenterX(red.getCenterX() + 25);
			yellow.setCenterY(red.getCenterY());
			yellow.setRadius(trafficLight.getWidth() / 9);
				yellow.setStroke(Color.BLACK);
				yellow.setStrokeWidth(2);
				color = Color.rgb(48, 34, 0);

		return yellow;
	}

	public Circle drawGreenCircle() {

			green.setCenterX(red.getCenterX() + 50);
			green.setCenterY(red.getCenterY());
			green.setRadius(trafficLight.getWidth() / 9);

				green.setStroke(Color.BLACK);
				green.setStrokeWidth(2);
				color = Color.rgb(2, 46, 2);


		return green;
	}



}

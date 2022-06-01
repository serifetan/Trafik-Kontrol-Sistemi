package Model;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.File;

public class Car {
	public int xposition;
	public int yposition;
	public Road road;
	public ImageView imageView;

	public Car() {
		final File images = new File("src/View/image/car.png");
		imageView = new ImageView(new Image(String.valueOf(images.toURI())));
	}

	public void AddRoad(Road road) {
		this.road = road;
		this.road.cars.add(this);
	}

	public void Move(int Xs, int Ys) {
		Path path = new Path();
		MoveTo move = new MoveTo(Xs, Ys);
		LineTo line = new LineTo(road.XFirst[2] + road.distance1[0], road.YFirst[2]);
		path.getElements().add(move);
		path.getElements().add(line);
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.seconds(4));
		pathTransition.setNode(imageView);
		pathTransition.setPath(path);
		pathTransition.setAutoReverse(false);
		pathTransition.play();
		road.distance1[0] -= 110;
	}

	public void Stop() {
			Path path = new Path();
			MoveTo move = new MoveTo(road.XFirst[0], road.YFirst[0]);
			LineTo line = new LineTo(road.XFirst[1] - road.distance1[0], road.YFirst[1]);
			this.xposition = road.XFirst[1] - road.distance1[0];
			this.yposition = road.YFirst[1];
			path.getElements().add(move);
			path.getElements().add(line);
			PathTransition pathTransition = new PathTransition();
			pathTransition.setDuration(Duration.millis(3000));
			pathTransition.setNode(imageView);
			pathTransition.setPath(path);
			pathTransition.setAutoReverse(false);
			pathTransition.play();
			road.distance1[0] += 110;
	}
}

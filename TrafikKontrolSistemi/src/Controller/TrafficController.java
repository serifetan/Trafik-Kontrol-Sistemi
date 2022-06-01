package Controller;

import Model.Car;
import Model.Road;
import Model.TrafficLight;
import Threads.LightThread;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficController {

    public TrafficLight light1;
    public TrafficLight light2;
    public TrafficLight light3;
    Road road1;
    Road road2;
    Road road3;
    TimerTask task;
    Timer timerCounter;
    int numbersOfCars = 0;

    @FXML
    private Circle lightGreen;

    @FXML
    private Circle lightRed;

    @FXML
    private Circle lightYellow;

    @FXML
    private Text timer;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void startTraffic(ActionEvent event) {
        LightThread trafficThread = new LightThread(this);
        trafficThread.start();
    }

    public void startTrafficSimulation(){
        drawGUI();
        createCars();
        controlLights();
    }

    public void setFillGreen() {
        lightGreen.setFill(Color.GREEN);
    }

    public void setFillYellow() {
        lightYellow.setFill(Color.YELLOW);
    }

    public void setFillRed() {
        lightRed.setFill(Color.RED);
    }

    public void setFillGreenBlack() {
        lightGreen.setFill(Color.rgb(2, 46, 2));
    }
    public void setFillYellowBlack() {
        lightYellow.setFill(Color.rgb(48, 34, 0));
    }
    public void setFillRedBlack() {
        lightRed.setFill(Color.rgb(71, 0, 2));
    }

    public void setTimer(String timer) {
        this.timer.setText(timer);
    }
    public void setFillTimer(String color) {
        switch (color){
            case "red" : timer.setFill(Color.RED); break;
            case "yellow" : timer.setFill(Color.RED); break;
            case "green" : timer.setFill(Color.RED); break;
            default: break;
        }
    }

    private void controlLights(){

        ColorController colorController1 = new ColorController(light1,1);
        colorController1.start();

        ColorController colorController2 = new ColorController(light2,2);
        colorController2.start();

        ColorController colorController3 = new ColorController(light3,3);
        colorController3.start();

    }

    public void drawGUI() {
        road1 = new Road();
        road2 = new Road();
        road3 = new Road();

        light1 = new TrafficLight(780, 0, 200, 100);
        light2 = new TrafficLight(715, 340, 200, 100);
        light3 = new TrafficLight(298, 340, 200, 100);

        light1.road = road1;
        light2.road = road2;
        light3.road = road3;

        anchorPane.getChildren().add(light1.drawTrafficLight());
        anchorPane.getChildren().add(light1.drawRedCircle());
        anchorPane.getChildren().add(light1.drawYellowCircle());
        anchorPane.getChildren().add(light1.drawGreenCircle());

        anchorPane.getChildren().add(light2.drawTrafficLight());
        anchorPane.getChildren().add(light2.drawRedCircle());
        anchorPane.getChildren().add(light2.drawYellowCircle());
        anchorPane.getChildren().add(light2.drawGreenCircle());

        anchorPane.getChildren().add(light3.drawTrafficLight());
        anchorPane.getChildren().add(light3.drawRedCircle());
        anchorPane.getChildren().add(light3.drawYellowCircle());
        anchorPane.getChildren().add(light3.drawGreenCircle());

    }

    public void manageWay() {
        numbersOfCars++;
        Car car = new Car();
        car.AddRoad(light3.road);
        if (light3.active) {
            while ((car = light3.road.cars.poll()) != null) {
                car.Move(car.xposition, car.yposition);
            }
            light3.road.distance[0] = 0;
            light3.road.distance[1] = 0;
        } else {
            car.Stop();
            anchorPane.getChildren().add(car.imageView);
        }

    }

    public void createCars() {
        timerCounter = new Timer();
        task  = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        manageWay();
                    }
                });
            }
        };
        timerCounter.scheduleAtFixedRate(task,0,2000);

    }
}

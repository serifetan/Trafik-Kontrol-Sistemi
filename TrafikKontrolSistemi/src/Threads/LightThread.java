package Threads;

import Controller.TrafficController;

import java.util.Timer;
import java.util.TimerTask;

public class LightThread extends Thread{
    private TrafficController TrafficController;
    public LightThread(TrafficController trafficController) {
        this.TrafficController = trafficController;
    }
    private Timer timerRed;
    private Timer timerYellow;
    private Timer timerGreen;
    int redTimer = 30;
    int yellowTimer = 5;
    int greenTimer = 60;
    TimerTask redTask;
    TimerTask greenTask;
    TimerTask yellowTask;
    public void run() {

        timerRed = new Timer();
        timerYellow = new Timer();
        timerGreen = new Timer();
        redTask  = new TimerTask() {
            @Override
            public void run() {
                redTimer--;
                //red
                TrafficController.setFillRed();
                TrafficController.setFillGreenBlack();
                TrafficController.setFillYellowBlack();
                TrafficController.setTimer(String.valueOf(redTimer));
                TrafficController.setFillTimer("red");
                if(redTimer == 0){
                    TrafficController.setFillRedBlack();
                    timerYellow.schedule(yellowTask,0,1000);
                    timerRed.cancel();
                }
            }

        };
        yellowTask  = new TimerTask() {
            @Override
            public void run() {
                yellowTimer--;
                //yellow
                TrafficController.setFillYellow();
                TrafficController.setFillRedBlack();
                TrafficController.setFillGreenBlack();
                TrafficController.setTimer(String.valueOf(yellowTimer));
                TrafficController.setFillTimer("yellow");
                if(yellowTimer == 0){
                    TrafficController.setFillYellowBlack();
                    timerGreen.schedule(greenTask,0,1000);
                    timerYellow.cancel();
                }
            }
        };
        greenTask  = new TimerTask() {
            @Override
            public void run() {
                greenTimer--;
                //green
                TrafficController.setFillGreen();
                TrafficController.setFillRedBlack();
                TrafficController.setFillYellowBlack();
                TrafficController.setTimer(String.valueOf(greenTimer));
                TrafficController.setFillTimer("green");
                if(greenTimer == 0){
                    TrafficController.setFillGreenBlack();
                    timerGreen.cancel();
                }
            }
        };
        timerRed.schedule(redTask,0,1000);
    }

}

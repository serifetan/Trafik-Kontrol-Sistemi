package Controller;

import Model.TrafficLight;
import javafx.scene.paint.Color;

import java.util.Timer;
import java.util.TimerTask;

public class ColorController extends Thread {
	private Timer timerRed;
	private Timer timerYellow;
	private Timer timerGreen;
	int redTimer = 2;
	int yellowTimer = 2;
	int greenTimer = 2;
	TimerTask redTask;
	TimerTask greenTask;
	TimerTask yellowTask;
	TrafficLight trafficLight;
	int light;

	ColorController(TrafficLight trafficLight, int light) {
		this.trafficLight = trafficLight;
		this.light = light;
	}

	@Override
	public void run() {
		timerRed = new Timer();
		timerYellow = new Timer();
		timerGreen = new Timer();
		if(light == 1){
			redTask = new TimerTask() {
				@Override
				public void run() {
					redTimer--;
					redOpen();
					if(redTimer == 0){
						timerYellow.schedule(yellowTask,0,2000);
						timerRed.cancel();
					}
				}
			};
			yellowTask = new TimerTask() {
				@Override
				public void run() {
					yellowTimer--;
					yellowOpen();
					if(yellowTimer == 0){
						timerGreen.schedule(greenTask,0,2000);
						timerYellow.cancel();
					}
				}
			};
			greenTask = new TimerTask() {
				@Override
				public void run() {
					greenTimer--;
					greenOpen();
					if(greenTimer == 0){
						timerGreen.cancel();
					}
				}
			};
			timerRed.schedule(redTask,0,2000);
		}
		if(light == 2){
			redTask = new TimerTask() {
				@Override
				public void run() {
					redTimer--;
					greenOpen();
					if(redTimer == 0){
						timerYellow.schedule(yellowTask,0,2000);
						timerRed.cancel();
					}
				}
			};
			yellowTask = new TimerTask() {
				@Override
				public void run() {
					yellowTimer--;
					yellowOpen();
					if(yellowTimer == 0){
						timerGreen.schedule(greenTask,0,2000);
						timerYellow.cancel();
					}
				}
			};
			greenTask = new TimerTask() {
				@Override
				public void run() {
					greenTimer--;
					redOpen();
					if(greenTimer == 0){
						timerGreen.cancel();
					}
				}
			};
			timerRed.schedule(redTask,0,2000);
		}
		if(light == 3){
			redTask = new TimerTask() {
				@Override
				public void run() {
					redTimer--;
					redOpen();
					if(redTimer == 0){
						timerYellow.schedule(yellowTask,0,2000);
						timerRed.cancel();
					}
				}
			};
			yellowTask = new TimerTask() {
				@Override
				public void run() {
					yellowTimer--;
					yellowOpen();
					if(yellowTimer == 0){
						timerGreen.schedule(greenTask,0,2000);
						timerYellow.cancel();
					}
				}
			};
			greenTask = new TimerTask() {
				@Override
				public void run() {
					greenTimer--;
					greenOpen();
					if(greenTimer == 0){
						timerGreen.cancel();
					}
				}
			};
			timerRed.schedule(redTask,0,2000);
		}

	}

	void greenOpen(){
		trafficLight.active = true;
		trafficLight.red.setFill(Color.rgb(71, 0, 2));
		trafficLight.yellow.setFill(Color.rgb(48, 34, 0));
		trafficLight.green.setFill(Color.GREEN);
	}
	void yellowOpen(){
		trafficLight.active = false;
		trafficLight.red.setFill(Color.rgb(71, 0, 2));
		trafficLight.yellow.setFill(Color.YELLOW);
		trafficLight.green.setFill(Color.rgb(2, 46, 2));
	}
	void redOpen(){
		trafficLight.active = false;
		trafficLight.red.setFill(Color.RED);
		trafficLight.yellow.setFill(Color.rgb(48, 34, 0));
		trafficLight.green.setFill(Color.rgb(2, 46, 2));
	}

}

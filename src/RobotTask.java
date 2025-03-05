import java.util.concurrent.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import becker.robots.*;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City waterloo = new City(100, 100);
		updateTime();
		
	}

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public void updateTime(){
		final Runnable getTime = new Runnable(){
			public void run(){
				LocalDateTime date = LocalDateTime.now();
				display(date);
			}
		};
		final ScheduledFuture<?> refresh = scheduler.scheduleAtFixedRate(getTime, 0, 1, TimeUnit.MINUTES);
		scheduler.schedule(new Runnable() {
			public void run(){
				refresh.cancel(true);
			}
		}, 10, TimeUnit.MINUTES);
	}

	public void display(LocalDateTime date){
		int num = 1;
		
		int hour = date.getHour();
		int minute = date.getMinute();

		printOneBlock(num, hour/10);
		num++;
		printOneBlock(num, hour%10);
		num++;
		printColon();
		printOneBlock(num, minute/10);
		printOneBlock(num, minute%10);
		
	}

	public void printOneBlock(int num, int digit){
		
	}

	public void printColon(){

	}
}

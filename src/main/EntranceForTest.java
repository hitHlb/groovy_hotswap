package main;

import groovy_support.HttpListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * for test
 */
public class EntranceForTest {
	private static int num = 0;
	public static void main(String[] args){
		HttpListener.getInstance().begin();
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(num);
			}
		}, 1, 2, TimeUnit.SECONDS);
	}
}

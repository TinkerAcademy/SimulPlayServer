package com.tinkeracademy;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SimulPlay {

	private static long MILLISECONDS = 1000;
	
	private static long FIVE_SECONDS = MILLISECONDS * 5;
	
	private static SimulPlay instance = new SimulPlay();
	
	public static SimulPlay getInstance()
	{
		return instance;
	}
	
	private SimulPlay()
	{
		 timer = new Timer(true);
		 timer.schedule(new NextUidTimerTask(), 0, FIVE_SECONDS);
	}
	
	private Timer timer;
	
	private ArrayList<String> userUids = new ArrayList<String>();
	
	private int score;
	
	private String nextUid;
	
	public synchronized int getScore() {
		return score;
	}

	public synchronized void setScore(int score) {
		this.score = score;
	}
		
	public synchronized void registerUserId(String userUid)
	{
		if (!userUids.contains(userUid))
		{
			userUids.add(userUid);	
		}
	}
	
	public synchronized String nextUserId()
	{
		return this.nextUid;
	}
	
	void regenerateNextUid()
	{
		System.out.println("regenerateNextUid enter");
		int size = userUids.size();
		if (size > 0)
		{
			int randomIdx = (int) Math.round(Math.random() * size);
			randomIdx = randomIdx % userUids.size();
			this.nextUid = userUids.get(randomIdx);
			System.out.println("regenerateNextUid nextUid=" + nextUid);			
		}
		else
		{
			System.out.println("regenerateNextUid waiting for registered userIds");						
		}
		System.out.println("regenerateNextUid exit");
	}
	
	class NextUidTimerTask extends TimerTask
	{
		boolean cancelled;		
		@Override
		public void run() 
		{
			regenerateNextUid();
		}
		public boolean cancel()
		{
			return cancelled;
		}
	}

}

package com.tinkeracademy;

import java.util.ArrayList;

public class SimulPlay {

	private static SimulPlay instance = new SimulPlay();
	
	public static SimulPlay getInstance()
	{
		return instance;
	}
	
	private ArrayList<String> userUids = new ArrayList<String>();
	
	private int score;
	
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
		int randomIdx = (int) Math.round(Math.random() * userUids.size());
		randomIdx = randomIdx % userUids.size();
		String nextUid = userUids.get(randomIdx);
		return nextUid;
	}

}

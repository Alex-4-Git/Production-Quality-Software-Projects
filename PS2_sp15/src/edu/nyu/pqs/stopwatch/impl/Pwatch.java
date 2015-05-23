package edu.nyu.pqs.stopwatch.impl;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.nyu.pqs.stopwatch.api.IStopwatch;

public class Pwatch implements IStopwatch{
	private String id;
	private boolean running;
	private List<Long> laps;
	private long current_start;
	private long lap;
	private Object lock = new Object();
	

	public Pwatch(String id){
		this.id = id;
		running = false;
		laps = new ArrayList<Long>();
		current_start = 0L;
		lap = 0L;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void start() {
		synchronized(lock){
			if(running) throw new IllegalStateException("this watch is running");
			else{
				running = true;
				current_start = System.currentTimeMillis();
			}
		}
	}

	@Override
	public void lap() {
		synchronized(lock){
			if(!running) throw new IllegalStateException("this watch isn't running");
			else{
				long current_time = System.currentTimeMillis();
				lap = current_time-current_start;
				current_start = current_time;
				laps.add(lap);
			}
		}
	}

	@Override
	public void stop() {
		synchronized(lock){
			if(!running) throw new IllegalStateException("this watch isn't running");
			else{
				long current_time = System.currentTimeMillis();
				lap = current_time-current_start;
				laps.add(lap);
				running = false;
			}
		}		
	}

	@Override
	public void reset() {
		synchronized(lock){
			running = false;
			laps = new ArrayList<Long>();
			current_start = 0L;
			lap = 0L;
		}
	}

	@Override
	public List<Long> getLapTimes() {
		synchronized(lock){
			return Collections.unmodifiableList(laps);
		}
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Pwatch))
			return false;
		Pwatch p = (Pwatch)o;
		if(p.id== this.id) return true;
		return false;
	}
	
	@Override
	public String toString(){
		synchronized(lock){
			StringBuilder sb = new StringBuilder();
			String s = "Watch "+ id + "'s laps :\n";
			sb.append(s);
			if(laps.size()==0){
				sb.append("Nothing");
			}else{
				for(long l:laps){
					sb.append(l+" ");
				}
			}
			sb.append("\n");
			return sb.toString();
		}
	}
}

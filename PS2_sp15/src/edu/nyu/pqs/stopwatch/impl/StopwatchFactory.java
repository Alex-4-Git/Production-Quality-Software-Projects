package edu.nyu.pqs.stopwatch.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.nyu.pqs.stopwatch.api.IStopwatch;

/**
 * The StopwatchFactory is a thread-safe factory class for IStopwatch objects.
 * It maintains references to all created IStopwatch objects and provides a
 * convenient method for getting a list of those objects.
 *
 */
public class StopwatchFactory {
	private static List<IStopwatch> watchLists = Collections.synchronizedList(new ArrayList<IStopwatch>());
	private static Set<String> names = Collections.synchronizedSet(new HashSet<String>()); 
	private static Object lock= new Object();
	/**
	 * Creates and returns a new IStopwatch object
	 * @param id The identifier of the new object
	 * @return The new IStopwatch object
	 * @throws IllegalArgumentException if <code>id</code> is empty, null, or already
   *     taken.
	 */
	
	public static IStopwatch getStopwatch(String id) {
		synchronized(lock){
			if(id == null){
			    throw new IllegalArgumentException("id is null");
			  }
			if(id.length() == 0){
			    throw new IllegalArgumentException("id is empty");
			  }
			if(names.contains(id)){
			    throw new IllegalArgumentException("id is already taken");
			  }
			IStopwatch stopWatch = new Pwatch(id);
			watchLists.add(stopWatch);
			return stopWatch;
		}
	}

	/**
	 * Returns a list of all created stopwatches
	 * @return a List of all creates IStopwatch objects.  Returns an empty
	 * list if no IStopwatches have been created.
	 */
	public static List<IStopwatch> getStopwatches() {
		synchronized(lock){
			return Collections.unmodifiableList(watchLists);
		}	
	}
}

package edu.nyu.cs.qps.canvasModel;
import java.util.ArrayList;
import java.util.List;
import edu.nyu.cs.qps.canvasView.*;

/**
 * @author ALEX
 *	This model represent a canvas and can fire event to listeners.
 */
public class CanvasModel {
	private List<CanvasListener> listeners = new ArrayList<CanvasListener>();
	
	/**
	 * @param listener
	 * add listeners to model to receive the events
	 */ 
	public void addListener(CanvasListener listener){
		listeners.add(listener);
	}
	
	/**
	 * draw a new line in canvas
	 * @param line
	 * @param isRightButton
	 */
	public void addLine(Line line, boolean isRightButton){
		fireAddLineEvent(line,isRightButton);
	}

	/**
	 * fire drawing line event to every listener
	 * @param line
	 * @param isRightButton
	 */
	private void fireAddLineEvent( Line line, boolean isRightButton) {
		for(CanvasListener l:listeners){
			l.addLine(line, isRightButton);
		}
	}
}

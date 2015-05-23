package edu.nyu.cs.qps.canvasView;
import edu.nyu.cs.qps.canvasModel.Line;


/**This is a listener interface for CanvasModel. When model fire an event listener will call 
 * corresponding method.
 * @author ALEX
 */

public interface CanvasListener {
	/**
	 * draw a new line in canvas
	 * @param line 
	 * 			the new line
	 * @param isRightButton
	 * 			if the user use rightButton it is true
	 */
	public void addLine(Line line, boolean isRightButton);

}

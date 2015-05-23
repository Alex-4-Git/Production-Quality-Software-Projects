package edu.nyu.cs.pqs.canvasApp;

import edu.nyu.cs.qps.canvasModel.CanvasModel;
import edu.nyu.cs.qps.canvasView.CanvasView;

/**
 * @author ALEX
 * This APP generate a canvas. User can draw anything on the canvas. If user uses mouse's left
 * button, he can draw thin line. If the user uses mouse's right button, he can draw thick line.
 */
public class CanvasApp {
	private void go(){
		CanvasModel model = new CanvasModel();
		CanvasView view1 = new CanvasView(model);
		CanvasView view2 = new CanvasView(model);
	}
	
	public static void main(String[] args){
		new CanvasApp().go();
	}

}

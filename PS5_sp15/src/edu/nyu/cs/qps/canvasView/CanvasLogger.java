package edu.nyu.cs.qps.canvasView;

import edu.nyu.cs.qps.canvasModel.CanvasModel;
import edu.nyu.cs.qps.canvasModel.Line;



public class CanvasLogger implements CanvasListener{
	private CanvasModel model;

	StringBuilder sb = new StringBuilder();
	
	public CanvasLogger(CanvasModel model){
		this.model = model;
		model.addListener(this);
	}

	
	@Override
	public void addLine(Line line,boolean isRightButton) {
		String s = null;
		if(isRightButton){
			s = "Using Right Button: " +"lineAdded(" + line + ")";
		}else{
			s = "Using left Button: " +"lineAdded(" + line + ")";
		}
		sb.append("lineAdded(" + line + ")");
		System.out.println(s);
	}

	/**
	 * Get the contents of this log.
	 * 
	 * @return the log contents
	 */
	public String toString() {
		return sb.toString();
	}
}

package edu.nyu.cs.pqs.canvasModel;
import edu.nyu.cs.qps.canvasModel.*;
//import edu.nyu.cs.qps.canvasModel.Line;
import edu.nyu.cs.qps.canvasView.CanvasLogger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.junit.Test;




public class CanvasModelTest {
	@Test
	public void testFiresEvent() {
		CanvasModel model = new CanvasModel();
		CanvasLogger logger = new CanvasLogger(model);

		model.addListener(logger);

		Line line = new Line(new Point(0, 4), new Point(3, 0));
		model.addLine(line,true);

		String expectedString = "lineAdded((0, 4) -> (3, 0))";
		assertThat(logger.toString(), containsString(expectedString));
		
		line = new Line(new Point(0, 4), new Point(3, 0));
		model.addLine(line,false);

		expectedString = "lineAdded((0, 4) -> (3, 0))";
		assertThat(logger.toString(), containsString(expectedString));
		
	}
}

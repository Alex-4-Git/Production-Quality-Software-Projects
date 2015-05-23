package edu.nyu.cs.pqs.canvasModel;
import edu.nyu.cs.qps.canvasModel.Line;
import static org.junit.Assert.assertEquals;

import java.awt.Point;
import org.junit.Test;

public class LineTest {
	@Test
	public void testToString() {
		Line line = new Line(new Point(100, 0), new Point(200, 3));

		assertEquals("(100, 0) -> (200, 3)", line.toString());
	}

	@Test
	public void testConstructor_setsNegativeX1() {
		Line line = new Line(new Point(-2, 0), new Point(0, 5));

		assertEquals("(0, 0) -> (0, 5)", line.toString());
	}

	@Test
	public void testConstructor_setsNegativeY1() {
		Line line = new Line(new Point(3, -2), new Point(0, 5));

		assertEquals("(3, 0) -> (0, 5)", line.toString());
	}

	@Test
	public void testConstructor_setsNegativeX2() {
		Line line = new Line(new Point(3, 5), new Point(-100, 3));

		assertEquals("(3, 5) -> (0, 3)", line.toString());
	}

	@Test
	public void testConstructor_setsNegativeY2() {
		Line line = new Line(new Point(6, 7), new Point(1, -100));

		assertEquals("(6, 7) -> (1, 0)", line.toString());
	}

	@Test
	public void testGetX1() {
		Line line = new Line(new Point(5, 4), new Point(2, 1));

		assertEquals(5, line.getX1());
	}

	@Test
	public void testGetY1() {
		Line line = new Line(new Point(5, 4), new Point(2, 1));

		assertEquals(4, line.getY1());
	}

	@Test
	public void testGetX2() {
		Line line = new Line(new Point(5, 4), new Point(2, 1));

		assertEquals(2, line.getX2());
	}

	@Test
	public void testGetY2() {
		Line line = new Line(new Point(5, 4), new Point(2, 1));

		assertEquals(1, line.getY2());
	}
}

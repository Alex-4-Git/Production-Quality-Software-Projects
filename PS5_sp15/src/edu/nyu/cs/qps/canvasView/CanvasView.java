package edu.nyu.cs.qps.canvasView;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;



import edu.nyu.cs.qps.canvasModel.CanvasModel;
import edu.nyu.cs.qps.canvasModel.Line;

/**
 * @author ALEX
 * implement a swing view of CanvasListener. 
 * When the user uses left button, he will draw a thin black line.
 * If the user uses right button, he will draw a thick black line.
 */
public class CanvasView implements CanvasListener{
	private CanvasModel model;
	private Point startPoint;
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private float font = 5.5f;
		 
	/**
	 * Construct a CanvasSwingView
	 * 
	 * @param model
	 *          the canvas model this view subscribed to
	 */
	public CanvasView(CanvasModel model){
		this.model = model;
		model.addListener(this);
		
		frame.add(panel);
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				startPoint = e.getPoint();
			}
			
			public void mouseReleased(MouseEvent e){
				startPoint = null;
			}
		});
		
		panel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e){
				if((e.getModifiers()&InputEvent.BUTTON3_MASK)!=0){
					drawLine(e.getPoint(),true);
				}else{
					drawLine(e.getPoint(),false);
				}
			}

			public void mouseMoved(MouseEvent e){
				mouseDragged(e);
			}
		});
	}
	
	private void drawLine(Point point, boolean isRightButton) {
		if (null == startPoint) {
			return;
		}
		model.addLine(new Line(startPoint, point), isRightButton);
		startPoint = point;
	}
	
	

	/* (non-Javadoc)
	 * @see edu.nyu.cs.qps.canvasView.CanvasListener#addLine(edu.nyu.cs.qps.canvasModel.Line, boolean)
	 */
	@Override
	public void addLine(Line line, boolean isRightButton) {
		Graphics g = panel.getGraphics();
		int x1 = line.getX1();
		int y1 = line.getY1();
		int x2 = line.getX2();
		int y2 = line.getY2();
		

		if(isRightButton){
			((Graphics2D) g).setStroke(new BasicStroke(font));
		}
		g.drawLine(x1, y1, x2, y2);

		panel.paintComponents(g);
		
	}
	
	

}

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import org.math.plot.Plot2DPanel;  // plots your 2d graph
import org.math.plot.plotObjects.BaseLabel; // this is for the title of my plot

public class PlotParabola {
	public static void main(String[] args) {
		// configure arrays of double numbers for your x and y values
		double[] x = new double[21];
		double[] y = new double[21];
		// fill the data for a parabola
		for (int i = -10; i <= 10; i++) {
			x[i+10] = i;
			y[i+10] = i * i;
		}
		Plot2DPanel plot = new Plot2DPanel();
		plot.addLinePlot("parabola", x, y);
		plot.setAxisLabels("x","y");
		plot.addLegend("SOUTH");
		plot.setFixedBounds(1, 0, 100);
		BaseLabel title = new BaseLabel("Parabola",Color.RED,0.5,1.1);  // 50% of the width, 110% of height
		plot.addPlotable(title);
		// create a frame to house the plot
		JFrame frm = new JFrame();
		frm.setTitle("Plot of a Parabola");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100,100,500,500);
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
}

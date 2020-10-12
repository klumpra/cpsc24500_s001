import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

public class InvestmentPlotter {
	public static LinkedHashMap<String, double[]> readData(Scanner fsc) {
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		String line = fsc.nextLine();
		String[] parts = line.split("\t");
		String name;
		int dayCount = parts.length - 1;
		double[] investmentValues;
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			name = parts[0];
			investmentValues = new double[dayCount];
			for (int i = 1; i < parts.length; i++) {
				investmentValues[i-1] = Double.parseDouble(parts[i]);
			}
			result.put(name,investmentValues);
		}
		return result;
	}
	public static void main(String[] args) {
		// this will hold the data
		LinkedHashMap<String,double[]> accounts;
		try {
			Scanner fsc = new Scanner(new File("investments.txt"));
			accounts = readData(fsc);
			double[] raysInvestments = accounts.get("Ray");
			for (double value : raysInvestments) {
				System.out.println(value);
			}
			Plot2DPanel plot = new Plot2DPanel();
			plot.addLinePlot("ray's data", raysInvestments);
			JFrame frm = new JFrame();
			frm.setBounds(100,100,500,500);
			frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = frm.getContentPane();
			c.setLayout(new BorderLayout());
			c.add(plot,BorderLayout.CENTER);
			frm.setVisible(true);
		} catch (Exception ex) {
			System.out.println("I couldn't open the file. Drats.");
		}
	}
}

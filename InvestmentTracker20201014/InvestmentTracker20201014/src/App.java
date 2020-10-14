import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;
import java.awt.BorderLayout;

public class App {
    public static LinkedHashMap<String,double[]> readData(Scanner fsc) {
        // declare the data structure I'll return
        LinkedHashMap<String,double[]> result = new LinkedHashMap<String,double[]>();
        fsc.nextLine();  // grab the header line
        String[] parts;
        String line; 
        double[] values;   // the values I read from each line
        String name; // the name from the line
        while (fsc.hasNextLine()) {
            line = fsc.nextLine();
            parts = line.split("\t");
            name = parts[0];
            // the rest of the line are the values
            values = new double[parts.length-1];
            for (int i = 1; i < parts.length; i++) {
                values[i-1] = Double.parseDouble(parts[i]);
            }
            result.put(name,values);
        }
        return result;
    }
    /**
     * This function builds an array of day numbers that I can use to plot
     * investment values vs. days down below
     */
    public static double[] getDays(int howMany) {
        double[] result = new double[howMany];
        for (int i = 0; i < howMany; i++) {
            result[i] = i;
        }
        return result;
    }
    public static void setUpAndShowFrame(Plot2DPanel plot) {
        JFrame frm = new JFrame();
        frm.setTitle("Investment Values");
        frm.setBounds(100,100,500,500);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // just get rid of frame
        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(plot,BorderLayout.CENTER);
        frm.setVisible(true);
    }
    public static void main(String[] args) {
        LinkedHashMap<String,double[]> accounts = null;
        String names;
        String[] parts;
        double[] data; // each person's invesment data retrieved from the accounts map
        Scanner sc = new Scanner(System.in);
        try {
            Scanner fsc = new Scanner(new File("investments.txt"));
            accounts = readData(fsc);
            fsc.close();
        } catch (Exception ex) {
            accounts = null;
        }
        if (accounts == null) {
            System.out.println("Boo. Couldn't read the account data.");
        } else {
            // the data has been successfully loaded in. Let's work with it.
            do {
                System.out.print("Enter names of people separated by commas: ");
                names = sc.nextLine();
                if (!names.equalsIgnoreCase("exit")) {
                    Plot2DPanel plot = new Plot2DPanel(); // will contain the investment curves
                    plot.addLegend("SOUTH");
                    parts = names.split(",");
                    // add line plots for each person the user named
                    for (String part : parts) {
                        part = part.trim();  // get rid of leading and trailing spaces
                        if (accounts.containsKey(part) == false) {
                            System.out.printf("%s was not found.\n",part);
                        } else {
                            data = accounts.get(part); // grab the investment values
                            // now plot the data
                            plot.addLinePlot(part,getDays(data.length),data);
                        }
                    }
                    // plot will have the investement curves. Let's show it.
                    setUpAndShowFrame(plot);
                }
            } while (!names.equalsIgnoreCase("exit"));
        }
    }
}

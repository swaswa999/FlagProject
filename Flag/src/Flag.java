// Flag starter kit

/*
 * Gaivn
 * Swayam
 * OTHER PARTNER'S NAME (if group of three)
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JApplet;

public class Flag extends JApplet {
	private final int STRIPES = 13;

	// SCALE FACTORS (A through L)
	//
	// Note: Constants in Java should always be ALL_CAPS, even
	// if we are using single letters to represent them
	//
	// NOTE 2: Do not delete or change the names of any of the
	// variables given here
	//
	// Set the constants to exactly what is specified in the documentation
	// REMEMBER: These are scale factors.  They are not numbers of pixels.
	// You will use these and the width and height of the Applet to figure
	// out how to draw the parts of the flag (stripes, stars, field).
	private final double A = 1.0;  // Hoist (width) of flag
	private final double B = 1.9;  // Fly (length) of flag
	private final double C = 7.0/STRIPES;  // Hoist of Union
	private final double D = 0.76;  // Fly of Union
	private final double E = 0.054;  // See flag specification
	private final double F = 0.054;  // See flag specification
	private final double G = 0.063;  // See flag specification
	private final double H = 0.063;  // See flag specification
	private final double K = 0.0616;  // Diameter of star
	private final double L = 1.0/STRIPES;  // Width of stripe

	// You will need to set values for these in paint()
	private double flag_width;// width of flag in pixels
	private double flag_height; // height of flag in pixels
	private double stripe_height;// height of an individual stripe in pixels

	// init() will automatically be called when an applet is run
	public void init() {
		
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setVisible(true); 
		setSize(760, 400);
		repaint();
	}

	// paint() will be called every time a resizing of an applet occurs
	
	public void paint(Graphics g) {
		
		
		flag_width = getWidth();
		flag_height = getHeight();

		if ((B/A) * flag_height > flag_width) {  // change height
			flag_height = (flag_width / (B / A));
		} else { //change width
			flag_width = (flag_height * (B / A));
		}
		
		stripe_height = flag_height / STRIPES;
		
		drawBackground(g);
		drawStripes(g);
		drawUnion(g);
		
		
		
	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void drawStripes(Graphics g) {
		final int x = 0;
		int y = 0;
		int curCol = 1; //red = 1, white = 2
		
		for(int n = 0; n < STRIPES; n++) {
			if (curCol == 1){ // 1 = red
				System.out.println("CURRENT COL: red");
				g.setColor(Color.red);
				g.fillRect(x, y, (int) flag_width,(int) stripe_height);
				
				curCol = 2;
				y += stripe_height;
				
				System.out.println("Y POS: " + y);
						
			}
			else if (curCol == 2){ // 2 = white	
				
				g.setColor(Color.white);
				g.fillRect(x, y, (int) flag_width,(int) stripe_height);
				curCol = 1;
				y += stripe_height;
			}
		}
			
	}

	public void drawUnion(Graphics g) {
		g.setColor(Color.blue);
		
		double unionHeight = flag_height*C;
		double unionWidth =  flag_height*D; //0.76
		
		g.fillRect(0, 0, (int) unionWidth, (int) unionHeight);
	}

	public void drawStars(Graphics g) {
	}
}
 
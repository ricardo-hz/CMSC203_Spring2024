/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class is used to represent a Plot object. This is where code is written
 * to check for overlapping plots, as well as for modifying the different aspects of a plot.
 * Due: 04/01/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Plot {
	private int width;
	private int depth;
	private int x;
	private int y;
	
	/**
	 * Creates a default Plot with width and depth of 1
	 */
	public Plot() {
		width = 1;
		depth = 1;
	}
	
	/**
	 * Creates a plot using the given values
	 * @param x the x coordinate of the plot
	 * @param y the y coordinate of the plot
	 * @param width the width coordinate of the plot
	 * @param depth the depth coordinate of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	/**
	 * Creates a new plot given another plot. This constructor calls an
	 * appropriate existing constructor
	 * @param otherPlot the plot to make a copy of
	 */
	public Plot(Plot otherPlot) {
		this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
	}
	
	/**
	 * Determines if the given plot is overlapped by the current plot
	 * @param plot the plot to test against and check if overlaps
	 * @return true if the two plots overlap, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		boolean overlaps = false;
		//Right side overlap
		
		/*if(this.x + this.width > plot.x && this.y < plot.y && this.x >= plot.x) {
			overlaps = true;
		}*/
		
		//Left side overlap
		if(this.x < plot.x + plot.width && this.y < plot.y + plot.depth && this.x + this.width >= plot.x) {
			overlaps = true;
		}
		
		/*
		 * When JUnit testing, I received failures when plot 1's right side and when plot 2's left side
		 * were touching but not overlapping. This if statement is meant to fix that.
		 */
		if(this.x + this.width == plot.x){
			overlaps = false;
		}
		
		/*
		 * When JUnit testing, I received failures when plot 1's bottom side and when plot 2's top side
		 * were touching but not overlapping. This if statement is meant to fix that.
		 */
		if(this.y + this.depth == plot.y){
			overlaps = false;
		}
		
		return overlaps;
	}
	
	/**
	 * Determines if the given plot is encompassed by (is contained by) this plot. 
	 * Note that the determination should be inclusive, in other words, if an edge 
	 * lies on the edge of the current plot, this is acceptable.
	 * @param plot The plot to test against and check if encompasses
	 * @return True if the given plot is encompassed by this plot, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		boolean encompasses = false;
		
		if(this.x <= plot.x && this.y <= plot.y &&
			this.x + this.width >= plot.x + plot.width && 
			this.y + this.depth >= plot.y + plot.depth) {
				encompasses = true;
		}
		return encompasses;
	}
	
	//Setters
	/**
	 * Sets the x
	 * @param x The new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y
	 * @param y The new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Sets the width
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Sets the depth
	 * @param depth The new depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Change all attributes of an already defined plot
	 * @param x The new x
	 * @param y The new y
	 * @param width The new width
	 * @param depth The new depth
	 */
	public void setAll(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//Getters
	/**
	 * Gets the x
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y
	 * @return The new y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Gets the depth
	 * @return The new depth
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Gets the width
	 * @return The new width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Represents a Plot object in the following String format. x,y,width,depth
	 */
	public String toString() {
		return(x + "," + y + "," + width + "," + depth);
	}
}

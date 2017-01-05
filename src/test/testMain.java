package test;

public class testMain {
	public static void main(String args[]) {
		double m[][] = { { 0, 0, 0.8 }, { 0, 0, 0.2 }, { 0, 0, 0 } };
		DependGraph g = new DependGraph(m, 2);
		ProbalityCompution c = new ProbalityCompution(g);
		c.ComputeOutput();
	}

}

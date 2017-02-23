package test;

public class testMain {
	public static void main(String args[]) {

		// test for 3 nodes
		// double m[][] = { { 0, 0, 0, 0.2 }, { 0, 0, 0, 0.3 }, { 0, 0, 0, 0.5
		// },
		// { 0, 0, 0, 0 } };
		// DependGraph g = new DependGraph(m, 3, 1);

		// test for 2 nodes
		double m[][] = { { 0, 0, 0.5 }, { 0, 0, 0.5 }, { 0, 0, 0 } };
		DependGraph g = new DependGraph(m, 2, 1);

		// double m[][] = { { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		// { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		// DependGraph g = new DependGraph(m, 5, 2);
		ProbalityCompution c = new ProbalityCompution(g);
		c.computeScore();
	}

}

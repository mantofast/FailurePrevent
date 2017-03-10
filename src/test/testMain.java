package test;

public class testMain {
	public static void main(String args[]) {

		// test for 3 nodes
		// double m[][] = { { 0, 0, 0, 0.2 }, { 0, 0, 0, 0.3 }, { 0, 0, 0, 0.5
		// },
		// { 0, 0, 0, 0 } };
		// DependGraph g = new DependGraph(m, 3, 1);

		// test for 2 nodes
		// double m[][] = { { 0, 0, 0.5 }, { 0, 0, 0.5 }, { 0, 0, 0 } };
		// DependGraph g = new DependGraph(m, 2, 1);

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
		// ProbalityCompution c = new ProbalityCompution(g);
		// c.computeScore();

		DependLinkGraph g = new DependLinkGraph();
		ProbalityCompution c = new ProbalityCompution(g);
		c.computeScore();

		// compute the enhance amount of different rest resource deploy ways
		double Q[] = { 8.361, 6.283, 6.156, 6.142, 7.075, 6.891, 6.778 };
		double percent[] = new double[6];
		for (int i = 1; i < 7; i++) {
			percent[i - 1] = (Q[0] - Q[i]) / Q[0];
			System.out.print(percent[i - 1] + "  ");
		}

	}

}

package test;

public class DependGraph {
	public Node[] nodes;
	public Node[] rootNodes;
	public int rootNum;

	public DependGraph(double[][] m, int rootNum) {
		int i, j;
		if (m == null) {
			System.out.println("empty graph,erro");
			return;
		} else
			System.out.println("m length: " + m[0].length);

		nodes = new Node[m[0].length];
		rootNodes = new Node[rootNum];
		this.rootNum = rootNum;

		// root cause ½Úµã¸³Öµ½×¶Î£¬ almost k down

		// for (i = 1; i <= rootNum; i++) {
		// Node n = new Node(0, i, 0, 1, 0);
		// rootNodes[i - 1] = n;
		// nodes[i - 1] = n;
		// }

		// test for two parents
		Node n1 = new Node(0, 1, 1, 0, 0);
		rootNodes[0] = n1;
		nodes[0] = n1;
		Node n2 = new Node(0, 2, 1, 0, 0);
		rootNodes[1] = n2;
		nodes[1] = n2;
		// Node n3 = new Node(0, 3, 0, 0, 1);
		// rootNodes[2] = n3;
		// nodes[2] = n3;

		for (i = rootNum + 1; i <= m[0].length; i++) {
			Node n = new Node(2, i, 1, 0, 0);
			nodes[i - 1] = n;
		}
		for (i = 1; i <= m[0].length; i++)
			for (j = 1; j <= m[0].length; j++) {

				if (m[i - 1][j - 1] > 0.0) {
					nodes[i - 1].children.put(nodes[j - 1], m[i - 1][j - 1]);
					// System.out.println("put into children node id: "
					// + nodes[j - 1].id);
				}

			}

	}
}

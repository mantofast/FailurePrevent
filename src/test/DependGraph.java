package test;

public class DependGraph {
	public Node[] nodes;
	public Node[] rootNodes;
	public Node[] obsNodes;
	public int rootNum;
	public int obsNum;

	public DependGraph(double[][] m, int rootNum, int obsNum) {
		int i, j;
		if (m == null) {
			System.out.println("empty graph,erro");
			return;
		} else
			System.out.println("m length: " + m[0].length);

		nodes = new Node[m[0].length];
		rootNodes = new Node[rootNum];
		this.rootNum = rootNum;
		this.obsNum = obsNum;
		obsNodes = new Node[obsNum];

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
		Node n2 = new Node(0, 2, 0.8, 0.2, 0);
		rootNodes[1] = n2;
		nodes[1] = n2;
		Node n3 = new Node(0, 3, 1, 0, 0);
		rootNodes[2] = n3;
		nodes[2] = n3;
		Node n4 = new Node(0, 4, 1, 0, 0);
		rootNodes[3] = n4;
		nodes[3] = n4;
		Node n5 = new Node(0, 5, 1, 0, 0);
		rootNodes[4] = n5;
		nodes[4] = n5;

		for (i = rootNum + 1; i <= m[0].length - obsNum; i++) {
			Node n = new Node(1, i, 1, 0, 0);
			nodes[i - 1] = n;
		}
		for (i = m[0].length - obsNum + 1; i <= m[0].length; i++) {
			Node n = new Node(1, i, 1, 0, 0);
			obsNodes[i - (m[0].length - obsNum) - 1] = n;
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

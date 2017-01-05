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

		for (i = 1; i <= rootNum; i++) {
			Node n = new Node(0, i, 0, 1, 0);
			rootNodes[i - 1] = n;
			nodes[i - 1] = n;
		}
		for (i = rootNum + 1; i <= m[0].length; i++) {
			Node n = new Node(1, i, 0, 1, 0);
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

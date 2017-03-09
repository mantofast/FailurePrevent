package test;

import java.util.LinkedList;

public class DependLinkGraph {

	public LinkedList<Node> nodes;
	public LinkedList<Node> rootNodes;
	public LinkedList<Node> obsNodes;
	public int rootNum;
	public int obsNum;

	public DependLinkGraph() {
		int i;
		int totalNum = 14;
		rootNum = 9;
		obsNum = 3;
		nodes = new LinkedList<Node>();
		rootNodes = new LinkedList<Node>();
		obsNodes = new LinkedList<Node>();
		// root-cause node initial
		// link type
		for (i = 1; i < 5; i++) {
			Node n = new Node(0, i, 0.6, 0.35, 0.05);
			nodes.add(n);
			rootNodes.add(n);
		}
		// cpu type
		for (; i < 5 + 2; i++) {
			Node n = new Node(0, i, 0.7, 0.25, 0.05);
			nodes.add(n);
			rootNodes.add(n);
		}
		// net card type
		for (; i < 5 + 2 + 3; i++) {
			Node n = new Node(0, i, 0.8, 0.1, 0.1);
			nodes.add(n);
			rootNodes.add(n);
		}

		// meta-nodes
		Node m1 = new Node(2, 10, 1, 0, 0);
		nodes.add(m1);
		Node m2 = new Node(3, 11, 1, 0, 0);
		nodes.add(m2);

		// observation
		Node o1 = new Node(1, 12, 1, 0, 0);
		nodes.add(o1);
		obsNodes.add(o1);
		Node o2 = new Node(1, 13, 1, 0, 0);
		nodes.add(o2);
		obsNodes.add(o2);
		Node o3 = new Node(1, 14, 1, 0, 0);
		nodes.add(o3);
		obsNodes.add(o3);

		Node tmpNodes[] = new Node[15];
		int j = 1;
		for (Node n : nodes) {

			tmpNodes[j] = n;
			j++;
		}

		tmpNodes[1].children.put(tmpNodes[10], 0.5);
		tmpNodes[2].children.put(tmpNodes[10], 0.5);
		tmpNodes[3].children.put(tmpNodes[12], 1.0);
		tmpNodes[3].children.put(tmpNodes[14], 1.0);
		tmpNodes[4].children.put(tmpNodes[13], 1.0);
		tmpNodes[4].children.put(tmpNodes[14], 1.0);
		tmpNodes[5].children.put(tmpNodes[12], 1.0);
		tmpNodes[5].children.put(tmpNodes[13], 1.0);
		tmpNodes[6].children.put(tmpNodes[14], 1.0);
		tmpNodes[7].children.put(tmpNodes[11], 1.0);
		tmpNodes[8].children.put(tmpNodes[11], 1.0);
		tmpNodes[9].children.put(tmpNodes[14], 1.0);
		tmpNodes[10].children.put(tmpNodes[12], 0.8);
		tmpNodes[10].children.put(tmpNodes[13], 0.8);
		tmpNodes[11].children.put(tmpNodes[12], 1.0);
		tmpNodes[11].children.put(tmpNodes[13], 1.0);

	}
}

package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ProbalityCompution {
	public DependGraph inputGraph;
	public DependGraph outputGraph;

	public ProbalityCompution(DependGraph inputGraph) {
		this.inputGraph = inputGraph;
	}

	public void ComputeOutput() {
		Queue<Node> q = new LinkedList<Node>();
		for (Node n : this.inputGraph.rootNodes)
			q.add(n);
		while (!q.isEmpty()) {
			Node n = q.element();
			HashMap<Node, Double> map = n.children;
			for (Map.Entry<Node, Double> entry : map.entrySet()) {
				Node c = entry.getKey();
				Double v = entry.getValue();

				if (!q.contains(c)) {
					q.add(c);
					// System.out.println("children node id: " + c.id);
				}
				c.setpUp(c.getpUp()
						* ((1 - v) * (n.pDown + n.pTrouble) + n.pUp));
				c.setpDown(1 - (1 - c.getpDown())
						* ((1 - n.getpDown()) + (1 - v) * n.getpDown()));
				c.setpTrouble(1 - c.getpDown() - c.getpUp());
			}
			System.out.println("Node id:" + n.id + " pUp: " + n.pUp + " pDown:"
					+ n.pDown + " pTrouble:" + n.pTrouble);
			q.remove();
		}
	}
}

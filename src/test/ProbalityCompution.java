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
					// ��selector�ڵ�ʱ�������ʼ��c�ĸ���ֵ
					if (c.type == 2) {
						c.setpUp(n.pUp);
						c.setpDown(n.pDown);
						c.setpTrouble(n.pTrouble);
						continue;
					}

				}
				switch (c.type) {
				case 0:// root-node
					break;
				case 1:// noisy-meta node
				{
					c.setpUp(c.getpUp()
							* ((1 - v) * (n.pDown + n.pTrouble) + n.pUp));
					c.setpDown(1 - (1 - c.getpDown())
							* ((1 - n.getpDown()) + (1 - v) * n.getpDown()));
					c.setpTrouble(1 - c.getpDown() - c.getpUp());
				}
					break;
				case 2:// selector meta-node
				{
					double pU = (c.getpUp() * (n.pUp + (1 - v) * (1 - n.pUp)) + n.pUp
							* v * (1 - c.getpUp()));
					double pD = (c.getpDown()
							* (n.pDown + (1 - v) * (1 - n.pDown)) + n.pDown * v
							* (1 - c.getpDown()));
					double pT = (c.getpTrouble()
							* (n.pTrouble + (1 - n.pTrouble) * (1 - v)) + n.pTrouble
							* v * (1 - c.pTrouble));

					c.setpUp(pU);
					c.setpDown(pD);
					c.setpTrouble(pT);
					// System.out.println("!!!up��tr��do:  " + c.getpUp() + " "
					// + c.getpTrouble() + " " + c.getpDown());
				}
					break;
				case 3:// failover meta-node
				{
					c.setpUp(n.getpUp() + n.getpDown() * c.getpUp());
					c.setpDown(n.getpDown() * c.getpDown());
					c.setpTrouble(n.getpTrouble() + n.getpDown()
							* c.getpTrouble());
					// System.out.println("up��tr��do:  " + c.getpUp() + " "
					// + c.getpTrouble() + " " + c.getpDown());
				}
					break;
				default:
					break;

				}

			}
			System.out.println("Node id:" + n.id + " pUp: " + n.pUp
					+ " pTrouble:" + n.pTrouble + " pDown:" + n.pDown);
			q.remove();
		}
	}
}

package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ProbalityCompution {
	public DependLinkGraph inputGraph;
	public DependGraph outputGraph;

	public ProbalityCompution(DependLinkGraph inputGraph) {
		this.inputGraph = inputGraph;
	}

	public void ComputeOutput() {
		Queue<Node> q = new LinkedList<Node>();
		for (Node n : this.inputGraph.rootNodes)
			q.add(n);
		HashMap<Node, Double> selctTmpS = new HashMap<Node, Double>();
		while (!q.isEmpty()) {
			Node n = q.element();
			HashMap<Node, Double> map = n.children;
			for (Map.Entry<Node, Double> entry : map.entrySet()) {
				Node c = entry.getKey();
				Double v = entry.getValue();

				if (!q.contains(c)) {
					q.add(c);
					// System.out.println("children node id: " + c.id);
					// 当selector节点时，计算初始化c的概率值
					if (c.type == 2) {
						c.setpUp(n.pUp);
						c.setpDown(n.pDown);
						c.setpTrouble(n.pTrouble);
						selctTmpS.put(c, v);
						continue;
					} else if (c.type == 3) {
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
					double dpC = selctTmpS.get(c);
					double tmpS = dpC + v;
					v = v / tmpS;
					selctTmpS.put(c, tmpS);

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
					// System.out.println("!!!up、tr、do:  " + c.getpUp() + " "
					// + c.getpTrouble() + " " + c.getpDown());
				}
					break;
				case 3:// failover meta-node
				{
					// c.setpUp(n.getpUp() + n.getpDown() * c.getpUp());
					// c.setpDown(n.getpDown() * c.getpDown());
					// c.setpTrouble(n.getpTrouble() + n.getpDown()
					// * c.getpTrouble());
					// System.out.println("up、tr、do:  " + c.getpUp() + " "
					// + c.getpTrouble() + " " + c.getpDown());

					// compare with the pre process, we can find the order is
					// changed,now the first node is the primary node
					double pU = c.getpUp() + c.getpDown() * n.getpUp();
					double pT = c.getpTrouble() + c.getpDown()
							* n.getpTrouble();
					double pD = c.getpDown() * n.getpDown();
					c.setpUp(pU);
					c.setpDown(pD);
					c.setpTrouble(pT);
					// System.out.println("hahhah");
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

	public void computeScore() {
		ComputeOutput();
		double score = 0.0;
		for (Node n : this.inputGraph.obsNodes) {
			score += n.pDown * (10.0) + n.pTrouble * (1.0);
			// System.out.println("score is: " + score);
		}
		System.out.println("score is: " + score);
	}
}

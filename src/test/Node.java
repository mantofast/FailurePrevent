package test;

import java.util.HashMap;

public class Node {
	public int type;
	public int id;
	public double pDown;
	public double pUp;
	public double pTrouble;
	public HashMap<Node, Double> children;

	public Node(int type, int id, double pDown, double pUp, double pTrouble) {
		this.type = type;
		this.id = id;
		this.pDown = pDown;
		this.pUp = pUp;
		this.pTrouble = pTrouble;
		this.children = new HashMap<Node, Double>();

	}

	public double getpDown() {
		return pDown;
	}

	public double getpUp() {
		return pUp;
	}

	public double getpTrouble() {
		return pTrouble;
	}

	public void setpDown(double pDown) {
		this.pDown = pDown;
	}

	public void setpUp(double pUp) {
		this.pUp = pUp;
	}

	public void setpTrouble(double pTrouble) {
		this.pTrouble = pTrouble;
	}

}

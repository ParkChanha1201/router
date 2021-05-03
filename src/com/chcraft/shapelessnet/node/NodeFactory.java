package com.chcraft.shapelessnet.node;

public class NodeFactory {
	public static Node createAndRun(String name, String ipAddress, NodeType nodeType) {
		switch(nodeType) {
			case COMPUTER:
				Node computer = new Computer(name, ipAddress);
				new Thread(computer, computer.getName()).start();
				return computer;
		}
		return null;
	}
}

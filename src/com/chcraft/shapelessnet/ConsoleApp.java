package com.chcraft.shapelessnet;

import com.chcraft.shapelessnet.node.Computer;
import com.chcraft.shapelessnet.node.NodeFactory;
import com.chcraft.shapelessnet.node.NodeType;

public class ConsoleApp {
	public static void main(String[] args) {
		//-서로 연결된 노드끼리는 메시지큐를 사용함
		//-일단은 노드를 1대1로 연결해보기.
		Computer com1 = (Computer)NodeFactory.createAndRun("com1", "com1.ipv4.1.1", NodeType.COMPUTER);
		Computer com2 = (Computer)NodeFactory.createAndRun("com2", "com2.ipv4.1.1", NodeType.COMPUTER);




	}
}

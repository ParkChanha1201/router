package com.chcraft.shapelessnet.node;

import java.util.List;

import com.chcraft.shapelessnet.message.RequestQueue;
import com.chcraft.shapelessnet.message.ResponseQueue;

public class Computer implements Node {
	private String name;
	private String ipAddress;
	private List<Node> directConnectedNodes;
	private RequestQueue requestQueue;
	private ResponseQueue responseQueue;

	public Computer(String name, String ipAddress) {
		this.name = name;
		this.ipAddress = ipAddress;
	}

	@Override
	public void run() {
		System.out.println(name + " is powered on.");
		System.out.println(name + "'s ip address is " + ipAddress);
		while(true) {
			//Request 생산 thread
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			if(directConnectedNodes.size() == 0) {
				System.out.println("there is no connected node.");
				continue;
			}

			System.out.println(name + " create request");
			//Response 생산 thread
			System.out.println(name + " create response");
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public RequestQueue getRequestQueue() {
		return requestQueue;
	}

	@Override
	public ResponseQueue getResponseQueue() {
		return responseQueue;
	}

	@Override
	public List<Node> getDirectConnectedNodes() {
		return directConnectedNodes;
	}

}

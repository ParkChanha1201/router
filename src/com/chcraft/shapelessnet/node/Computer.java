package com.chcraft.shapelessnet.node;

import java.util.ArrayList;
import java.util.List;

import com.chcraft.shapelessnet.message.Request;
import com.chcraft.shapelessnet.message.RequestQueue;
import com.chcraft.shapelessnet.message.Response;
import com.chcraft.shapelessnet.message.ResponseQueue;

public class Computer implements Node {
	private String name;
	private String ipAddress;
	private List<Node> connectedNodes;
	private RequestQueue requestQueue;
	private ResponseQueue responseQueue;

	private Thread sendRequest;
	private Thread sendResponse;

	public Computer(String name, String ipAddress) {
		this.name = name;
		this.ipAddress = ipAddress;

		requestQueue = new RequestQueue();
		responseQueue = new ResponseQueue();
		connectedNodes = new ArrayList<>();

		sendRequest = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					for (Node node : connectedNodes) {
						Request request = Request.builder().sourceAddress(ipAddress)
								.destinationAddress(node.getIpAddress())
								.message(name + " send request " + (int) (Math.random() * 10)).build();
						node.getRequestQueue().add(request);
					}
				}
			}
		}, name + "_sendRequest");

		sendResponse = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Response response = requestQueue.processRequest();

					connectedNodes.forEach(node -> {
						if (node.getIpAddress().equals(response.getDestinationAddress())) {
							node.getResponseQueue().add(response);
						}
					});
				}
			}
		}, name + "_sendResponse");
	}

	@Override
	public void run() {
		System.out.println(name + " is powered on.");
		System.out.println(name + "'s ip address is " + ipAddress);

		// 각각 쓰레드에서 처리하기
		/*
		 * SEND REQUEST for(Node node : connectedNodes){
		 * node.getRequestQueue().add(Request); }
		 */
		System.out.println("request send thread start");
		sendRequest.start();

		// 각각 쓰레드에서 처리하기
		/*
		 * SEND RESPONSE for(Request request : requestQueue){ node =
		 * connectedNodes.find(request.source); node.getResponseQueue().add(response); }
		 */
		System.out.println("response send thread start");
		sendResponse.start();

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			if (connectedNodes.size() == 0) {
				System.out.println("there is no connected node.");
				continue;
			}

			responseQueue.processResponse();
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
	public List<Node> getConnectedNodes() {
		return connectedNodes;
	}

	@Override
	public void connectTo(Node node) {
		connectedNodes.add(node);
	}
}

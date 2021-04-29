package com.chcraft;

import com.chcraft.shapelessnet.message.Request;
import com.chcraft.shapelessnet.message.Response;
import com.chcraft.shapelessnet.node.Node;
import com.chcraft.shapelessnet.node.NodeImpl;
import com.chcraft.shapelessnet.router.VirtualRouter;

public class ConsoleApp {
	public static void main(String[] args) {
		System.out.println("HI");

		Node node = new NodeImpl(new VirtualRouter() {
			@Override
			public boolean staticConnect(VirtualRouter router, String ipAddress) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setGateway(VirtualRouter router) {
				// TODO Auto-generated method stub

			}

			@Override
			public Response sendRequest(int sourcePort, String destinationAddress, int destinationPort, String message) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Response sendRequest(Request request) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void responseToRequest(Request requset) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getUid() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getIpAddress() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Node getGateway() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean dhcpConnect(VirtualRouter router) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String addNodeByStatic(Node node, String ipAddress) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String addNodeByDHCP(Node node) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		node.run();
	}
}

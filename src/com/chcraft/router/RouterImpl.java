package com.chcraft.router;

import com.chcraft.node.Node;
import com.chcraft.node.Request;
import com.chcraft.node.Response;

public class RouterImpl implements VirtualRouter {

	private String uid;
	private String ipAddress;

	@Override
	public String getUid() {
		return uid;
	}

	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public boolean dhcpConnect(VirtualRouter router) {
		//does router use it?
		return false;
	}

	@Override
	public boolean staticConnect(VirtualRouter router, String ipAddress) {
		//does router use it?
		return false;
	}

	@Override
	public Node getGateway() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGateway(VirtualRouter router) {
		// TODO Auto-generated method stub

	}

	@Override
	public Response sendRequest(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response sendRequest(int sourcePort, String destinationAddress, int destinationPort, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void responseToRequest(Request requset) {
		// TODO Auto-generated method stub

	}

	@Override
	public String addNodeByDHCP(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNodeByStatic(Node node, String ipAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}

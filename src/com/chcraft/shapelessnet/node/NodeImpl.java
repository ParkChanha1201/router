package com.chcraft.shapelessnet.node;

import java.util.ArrayList;
import java.util.List;

import com.chcraft.shapelessnet.message.Request;
import com.chcraft.shapelessnet.message.Response;
import com.chcraft.shapelessnet.router.VirtualRouter;

public class NodeImpl implements Node {
	private static List<String> uidList;

	static {
		uidList = new ArrayList<>();
	}

	private String uid;
	private VirtualRouter gateway;
	private String ipAddress;

	public NodeImpl(VirtualRouter gateway) {
		//set uid
		StringBuilder sb = new StringBuilder("NODE_UID_");
		sb.append((int)(Math.random() * 10));
		while(uidList.contains(sb.toString())) {
			sb.append((int)(Math.random() * 10));
		}
		uid = sb.toString();
		uidList.add(sb.toString());

		setGateway(gateway);
		dhcpConnect(gateway);
	}

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
		router.addNodeByDHCP(this);
		return true;
	}

	@Override
	public boolean staticConnect(VirtualRouter router, String ipAddress) {
		router.addNodeByStatic(this, ipAddress);
		return true;
	}

	@Override
	public Node getGateway() {
		return gateway;
	}

	@Override
	public void setGateway(VirtualRouter router) {
		this.gateway = router;
	}

	@Override
	public Response sendRequest(int sourcePort, String destinationAddress, int destinationPort, String message) {
		Request request = Request.builder()
								.sourceAddress(this.getIpAddress())
								.sourcePort(sourcePort)
								.destinationAddress(destinationAddress)
								.destinationPort(destinationPort)
								.message(message)
								.build();

		return gateway.sendRequest(request);
	}

	@Override
	public Response sendRequest(Request request) {
		return gateway.sendRequest(request);
	}

	@Override
	public void responseToRequest(Request requset) {
		// TODO Auto-generated method stub

	}

}

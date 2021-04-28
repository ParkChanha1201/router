package com.chcraft.node;

import com.chcraft.router.VirtualRouter;

//dhcp서버 안쓰고 공유기가 dhcp서버 역할을 하게 구현함
public interface Node {
	public default void run() {
		System.out.println(getUid() + "'s Ip address : " + getIpAddress());
		System.out.println(getUid() + "'s Gateway : " + getGateway().getIpAddress());

		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("Make request and send request");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getUid();
	public String getIpAddress();

	public boolean dhcpConnect(VirtualRouter router);
	public boolean staticConnect(VirtualRouter router, String ipAddress);

	public Node getGateway();
	public void setGateway(VirtualRouter router);

	public Response sendRequest(Request request);
	public Response sendRequest(int sourcePort, String destinationAddress, int destinationPort, String message);
	public void response(Request requset);
}

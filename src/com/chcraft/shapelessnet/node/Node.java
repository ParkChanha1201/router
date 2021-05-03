package com.chcraft.shapelessnet.node;

import java.util.List;

import com.chcraft.shapelessnet.message.RequestQueue;
import com.chcraft.shapelessnet.message.ResponseQueue;

public interface Node extends Runnable{
	public String getName();
	public String getIpAddress();
	public RequestQueue getRequestQueue();
	public ResponseQueue getResponseQueue();
	public List<Node> getConnectedNodes();
}

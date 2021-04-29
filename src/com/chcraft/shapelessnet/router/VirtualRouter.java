package com.chcraft.shapelessnet.router;

import com.chcraft.shapelessnet.node.Node;

/*
 * 공유기가 할 일
 * 1. 연결된 노드가 dhcp요청을 보내면 ip하나 할당해주기.
 * 2. 연결된 노드가 static으로 ip를 요청하면 이미 존재하는지 확인해주고 ip할당하기.
 * 3. 연결된 노드에서 외부로 요청을 보내면 테이블에 어떤 노드의 어떤 포트에서 요청을 보냈는지 적어두고 리퀘스트 보내고 외부 응답 대기하다가 응답 오면 노드로 보내주기
 */

public interface VirtualRouter extends Node {
	/***
	 * @param node want to connect this router
	 * @return node's ip address
	 */
	public String addNodeByDHCP(Node node);
	/***
	 * @param node want to connect this router
	 * @return node's ip address
	 */
	public String addNodeByStatic(Node node, String ipAddress);
}

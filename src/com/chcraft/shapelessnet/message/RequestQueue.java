package com.chcraft.shapelessnet.message;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	Queue<Request> requestQueue = new LinkedList<Request>();

	public synchronized void add(Request request) {
		//다른 노드가 요청을 보내서 request queue에 채워넣음
		requestQueue.add(request);
		//요청이 들어왔으니까 처리하라고 wait인 녀석들 호출함
		//1개만 처리하고 매번 다시 잠들면 안좋을거 같으니까 size가 좀 더 커지면 깨울까?
		notifyAll();
	}

	public synchronized Response processRequest() {
		//request queue에 들어온 요청을 처리함
		if(requestQueue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		//요청이 들어왔으면 요청에 알맞는 응답을 생성해서 리턴함.

		return null;
	}
}

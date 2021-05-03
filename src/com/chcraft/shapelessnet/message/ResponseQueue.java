package com.chcraft.shapelessnet.message;

import java.util.LinkedList;
import java.util.Queue;

public class ResponseQueue {
	Queue<Response> responseQueue = new LinkedList<Response>();

	public synchronized void add(Response response) {
		//request에 대한 response가 도착함
		responseQueue.add(response);

		//이거는 바로 바로 깨우는게 맞음.
		//원하는 응답이 돌아온거니까 돌아왔으면 바로 처리해야함.
		notifyAll();
	}

	public synchronized void processResponse() {
		//전달된 response를 처리합시다.

		//response가 없으면 처리할것도 없지
		if(responseQueue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		//response 처리
		System.out.println(Thread.currentThread().getName() + "가 response 처리한다.");
	}
}

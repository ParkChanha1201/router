package com.chcraft.node;

public class RequestBuilder {
	private String sourceAddress;
	private int sourcePort;
	private String destinationAddress;
	private int destinationPort;
	private String message;

	public Request build() {
		return new Request(sourceAddress, sourcePort, destinationAddress, destinationPort, message);
	}

	public RequestBuilder sourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
		return this;
	}

	public RequestBuilder sourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
		return this;
	}

	public RequestBuilder destinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
		return this;
	}

	public RequestBuilder destinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
		return this;
	}

	public RequestBuilder message(String message) {
		this.message = message;
		return this;
	}
}

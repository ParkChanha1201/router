package com.chcraft.shapelessnet.message;

public class ResponseBuilder {
	private String sourceAddress;
	private int sourcePort;
	private String destinationAddress;
	private int destinationPort;
	private String message;

	public Response build() {
		return new Response(sourceAddress, sourcePort, destinationAddress, destinationPort, message);
	}

	public ResponseBuilder sourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
		return this;
	}

	public ResponseBuilder sourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
		return this;
	}

	public ResponseBuilder destinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
		return this;
	}

	public ResponseBuilder destinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
		return this;
	}

	public ResponseBuilder message(String message) {
		this.message = message;
		return this;
	}
}

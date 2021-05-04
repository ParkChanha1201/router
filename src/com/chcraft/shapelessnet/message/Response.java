package com.chcraft.shapelessnet.message;

public class Response {
	private String sourceAddress;
	private int sourcePort;
	private String destinationAddress;
	private int destinationPort;
	private String message;

	public Response() {
	}

	public Response(String sourceAddress, int sourcePort, String destinationAddress, int destinationPort,
			String message) {
		this.sourceAddress = sourceAddress;
		this.sourcePort = sourcePort;
		this.destinationAddress = destinationAddress;
		this.destinationPort = destinationPort;
		this.message = message;
	}

	public static ResponseBuilder builder() {
		return new ResponseBuilder();
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public int getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package com.osf.academyosf.entities.enums;

public enum OrderStatus {

	Awaiting_shipment(1), In_transit(2), Delivered(3), Canceled(4);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	} 

	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}

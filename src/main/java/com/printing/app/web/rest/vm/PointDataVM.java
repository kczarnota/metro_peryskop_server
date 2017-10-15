package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;

public class PointDataVM {
	private String data;
	private String type;
	private String exitType;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExitType() {
		return exitType;
	}

	public void setExitType(String exitType) {
		this.exitType = exitType;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("data", data)
				.add("type", type)
				.add("exitType", exitType)
				.toString();
	}
}

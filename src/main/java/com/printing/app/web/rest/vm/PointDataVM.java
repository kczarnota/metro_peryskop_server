package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;
import com.printing.app.domain.Type;

public class PointDataVM {
	private String data;
	private Type type;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("data", data)
				.add("type", type)
				.toString();
	}
}

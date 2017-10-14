package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;
import java.util.HashSet;
import java.util.Set;

public class QrCodeVM {

	private Set<PointDataVM> pointData = new HashSet<>();

	public Set<PointDataVM> getPointData() {
		return pointData;
	}

	public void setPointData(Set<PointDataVM> pointData) {
		this.pointData = pointData;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("pointData", pointData)
				.toString();
	}
}

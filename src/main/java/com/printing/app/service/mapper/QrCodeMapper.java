package com.printing.app.service.mapper;

import com.printing.app.domain.PointData;
import com.printing.app.domain.QrCode;
import com.printing.app.domain.Type;
import com.printing.app.web.rest.vm.PointDataVM;
import com.printing.app.web.rest.vm.QrCodeVM;
import java.util.Base64;
import java.util.stream.Collectors;

public class QrCodeMapper {

	public static QrCodeVM map(QrCode qrCode) {
		QrCodeVM qrCodeVM = new QrCodeVM();

		qrCodeVM.setPointData(qrCode.getPointData().stream()
				.map(QrCodeMapper::mapPointData)
				.collect(Collectors.toSet()));

		return qrCodeVM;
	}

	private static PointDataVM mapPointData(PointData pointData) {
		PointDataVM pointDataVM = new PointDataVM();
		Type type = pointData.getType();
		String data = Type.IMAGE == type ? Base64.getEncoder().encodeToString(pointData.getImage()) : pointData.getText();

		pointDataVM.setType(type);
		pointDataVM.setData(data);
		return pointDataVM;
	}
}

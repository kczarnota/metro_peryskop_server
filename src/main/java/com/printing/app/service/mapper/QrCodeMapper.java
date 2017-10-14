package com.printing.app.service.mapper;

import com.google.common.base.Preconditions;
import com.printing.app.domain.PointData;
import com.printing.app.domain.QrCode;
import com.printing.app.web.rest.vm.QrCodeVM;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QrCodeMapper {

	public static QrCodeVM map(QrCode qrCode) {
		QrCodeVM qrCodeVM = new QrCodeVM();
		Map<String, List<PointData>> qrCodeData = qrCode.getPointData().stream()
				.collect(Collectors.groupingBy(PointData::getType));

		qrCodeVM.setText(getData(qrCodeData.getOrDefault("TEXT", Collections.emptyList()), PointData::getText));
		qrCodeVM.setUrl(getData(qrCodeData.getOrDefault("URL", Collections.emptyList()), PointData::getText));
		qrCodeVM.setImage(getData(qrCodeData.getOrDefault("IMAGE", Collections.emptyList()),
				p -> Base64.getEncoder().encodeToString(p.getImage())));

		return qrCodeVM;
	}

	private static String getData(List<PointData> data, Function<PointData, String> extractor) {
		if (data.isEmpty()) {
			return null;
		}

		Preconditions.checkArgument(data.size() < 2,
				String.format("Each QrCode should have only one type od %s", data.get(0).getType()));
		return data.stream().
				map(extractor)
				.findAny()
				.orElse(null);
	}
}

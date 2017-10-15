package com.printing.app.service.mapper;

import com.google.common.base.Preconditions;
import com.printing.app.domain.PointData;
import com.printing.app.domain.QrCode;
import com.printing.app.domain.Type;
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
		Map<Type, List<PointData>> qrCodeData = qrCode.getPointData().stream()
				.collect(Collectors.groupingBy(PointData::getType));

		qrCodeVM.setText(getData(qrCodeData.getOrDefault(Type.TEXT, Collections.emptyList()), PointData::getText));
		qrCodeVM.setUrl(getData(qrCodeData.getOrDefault(Type.URL, Collections.emptyList()), PointData::getText));
		qrCodeVM.setImage(getData(qrCodeData.getOrDefault(Type.IMAGE, Collections.emptyList()),
				p -> Base64.getEncoder().encodeToString(p.getImage())));
		qrCodeVM.setAddress(getData(qrCodeData.getOrDefault(Type.ADDRESS, Collections.emptyList()), PointData::getText));
		qrCodeVM.setAds(getCollectionData(qrCodeData.getOrDefault(Type.AD, Collections.emptyList()),
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

	private static List<String> getCollectionData(List<PointData> data, Function<PointData, String> extractor) {
		return data.stream().
				map(extractor)
				.collect(Collectors.toList());
	}
}

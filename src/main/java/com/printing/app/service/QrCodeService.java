package com.printing.app.service;

import com.printing.app.domain.QrCode;
import com.printing.app.repository.QrCodeRepository;
import com.printing.app.service.mapper.QrCodeMapper;
import com.printing.app.web.rest.vm.QrCodeVM;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QrCodeService {

	private final QrCodeRepository qrCodeRepository;

	public QrCodeService(QrCodeRepository qrCodeRepository) {
		this.qrCodeRepository = qrCodeRepository;
	}

	@Transactional(readOnly = true)
	public QrCodeVM getQrCodeData(long stationId, long pointId) {
		return qrCodeRepository.findOneByStationIdAndPointId(stationId, pointId)
				.map(QrCodeMapper::map)
				.orElseThrow(() -> new IllegalArgumentException
						(String.format("Cannot find qrCode for station id = %d and pointId = %d", stationId, pointId)));
	}

	@Transactional(readOnly = true)
	public Map<Long, Boolean> getActiveExits(long stationId) {
		return qrCodeRepository.findByStationId(stationId).stream()
				.collect(Collectors.toMap(QrCode::getPointId, QrCode::isOpen));
	}
}

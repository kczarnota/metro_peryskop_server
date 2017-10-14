package com.printing.app.service;

import com.printing.app.repository.QrCodeRepository;
import com.printing.app.service.mapper.QrCodeMapper;
import com.printing.app.web.rest.vm.QrCodeVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QrCodeService {

	private final QrCodeRepository qrCodeRepository;

	public QrCodeService(QrCodeRepository qrCodeRepository) {
		this.qrCodeRepository = qrCodeRepository;
	}

	@Transactional
	public QrCodeVM getQrCodeData(long stationId, long pointId) {
		QrCodeVM qrCode = qrCodeRepository.findOneByStationIdAndPointId(stationId, pointId)
				.map(QrCodeMapper::map)
				.orElseThrow(() -> new IllegalArgumentException
						(String.format("Cannot find qrCode for station id = %d and pointId = %d", stationId, pointId)));
		return qrCode;
	}
}

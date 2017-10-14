package com.printing.app.web.rest;

import com.printing.app.service.QrCodeService;
import com.printing.app.web.rest.vm.QrCodeVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StationResource {

	private final QrCodeService qrCodeService;

	public StationResource(QrCodeService qrCodeService) {
		this.qrCodeService = qrCodeService;
	}

	@GetMapping("/station/{stationId}/point/{pointId}")
	public QrCodeVM getQrCodeData(@PathVariable Long stationId, @PathVariable Long pointId) {
		return qrCodeService.getQrCodeData(stationId, pointId);
	}
}

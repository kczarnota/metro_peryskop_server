package com.printing.app.web.rest;

import com.google.common.base.Preconditions;
import com.printing.app.service.QrCodeService;
import com.printing.app.web.rest.vm.ExitDataVM;
import com.printing.app.web.rest.vm.ExitVM;
import com.printing.app.web.rest.vm.QrCodeVM;

import java.util.List;
import java.util.Map;
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

	@GetMapping("/station/{stationId}")
	public Map< String, List<ExitVM>> getQrCodeData(@PathVariable Long stationId) {
		return qrCodeService.getExitData(stationId);
	}

	@GetMapping("/change/station/{stationId}/point/{pointId}/state/{state}")
	public Map<String, List<ExitVM>> changeState(@PathVariable Long stationId, @PathVariable Long pointId, @PathVariable Boolean state) {
		Preconditions.checkNotNull(stationId, "Station id should not be null");
		Preconditions.checkNotNull(pointId, "Point id should not be null");
		Preconditions.checkNotNull(state, "State to change should not be null");

		return qrCodeService.changeState(stationId, pointId, state);
	}
}

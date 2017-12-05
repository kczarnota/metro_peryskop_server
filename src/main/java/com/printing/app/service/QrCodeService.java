package com.printing.app.service;

import com.printing.app.domain.QrCode;
import com.printing.app.repository.QrCodeRepository;
import com.printing.app.service.mapper.QrCodeMapper;
import com.printing.app.web.rest.vm.ExitDataVM;
import com.printing.app.web.rest.vm.ExitVM;
import com.printing.app.web.rest.vm.QrCodeVM;

import java.util.*;
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
	public Map<String, List<ExitVM>> getExitData(long stationId) {
        Set<QrCode> codes =  qrCodeRepository.findAllByStationId(stationId);
        List<ExitVM> list = new ArrayList<>();
        for (QrCode c :codes)
        {
            list.add(ExitVM.fromQrCode(c));
        }
        Map<String, List<ExitVM>> map = new HashMap<>();
		map.put("exits", list);
        return map;
	}

    @Transactional
    public Map<String, List<ExitVM>> changeState(long stationId, long pointId, boolean state) {
        qrCodeRepository.findOneByStationIdAndPointId(stationId, pointId)
                .ifPresent(qrCode -> qrCode.setOpen(state));

        return getExitData(stationId);
    }
}

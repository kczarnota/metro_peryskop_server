package com.printing.app.repository;

import com.printing.app.domain.QrCode;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, Long> {

	Optional<QrCode> findOneByStationIdAndPointId(long stationId, long pointId);

	Set<QrCode> findAllByStationId(long stationId);
}

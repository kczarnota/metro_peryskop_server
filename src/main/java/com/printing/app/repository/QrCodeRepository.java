package com.printing.app.repository;

import com.printing.app.domain.QrCode;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, Long> {

	@Query("select q from QrCode q left join fetch q.pointData  where q.stationId = ?1 and q.pointId= ?2")
	Optional<QrCode> findOneByStationIdAndPointId(long stationId, long pointId);

	@Query("select q from QrCode q where q.stationId = ?1")
	Set<QrCode> findAllByStationId(long stationId);
}

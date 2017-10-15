package com.printing.app.domain;

import com.google.common.base.MoreObjects;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "qr_code")
public class QrCode {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;

	@Column(name = "station_id")
	private long stationId;

	@Column(name = "point_id")
	private long pointId;

	@Column(name = "open")
	private boolean open;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "qrCode", fetch = FetchType.LAZY)
	private Set<PointData> pointData = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(name = "exit_type")
	private ExitType exitType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
		this.stationId = stationId;
	}

	public long getPointId() {
		return pointId;
	}

	public void setPointId(long pointId) {
		this.pointId = pointId;
	}

	public Set<PointData> getPointData() {
		return pointData;
	}

	public void setPointData(Set<PointData> pointData) {
		this.pointData = pointData;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public ExitType getExitType() {
		return exitType;
	}

	public void setExitType(ExitType exitType) {
		this.exitType = exitType;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("stationId", stationId)
				.add("pointId", pointId)
				.add("open", open)
				.add("pointData", pointData)
				.add("exitType", exitType)
				.toString();
	}
}

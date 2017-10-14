package com.printing.app.domain;

import com.google.common.base.MoreObjects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "point_data")
public class PointData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;

	@ManyToOne
	private QrCode qrCode;

	@Lob
	@Column(name = "text")
	private String text;

	@Column(name = "image")
	private byte[] image;

	@Column(name = "type")
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QrCode getQrCode() {
		return qrCode;
	}

	public void setQrCode(QrCode qrCode) {
		this.qrCode = qrCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("qrCode", qrCode)
				.add("text", text)
				.add("image", image)
				.add("type", type)
				.toString();
	}
}

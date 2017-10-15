package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;
import java.util.List;

public class QrCodeVM {

	private String address;
	private String image = null;
	private String text = null;
	private String url = null;
	private List<String> ads;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getAds() {
		return ads;
	}

	public void setAds(List<String> ads) {
		this.ads = ads;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("address", address)
				.add("image", image)
				.add("text", text)
				.add("url", url)
				.toString();
	}
}

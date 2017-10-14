package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;

public class QrCodeVM {

	private String image = null;
	private String text = null;
	private String url = null;

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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("image", image)
				.add("text", text)
				.add("url", url)
				.toString();
	}
}

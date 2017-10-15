package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;
import com.printing.app.domain.ExitType;
import com.printing.app.domain.QrCode;

public class ExitDataVM {

	public static ExitDataVM fromQrCode(QrCode qrCode) {
		ExitDataVM exitDataVM = new ExitDataVM();
		exitDataVM.setOpen(qrCode.isOpen());
		exitDataVM.setExitType(qrCode.getExitType());

		return exitDataVM;
	}

	private ExitType exitType;
	private boolean open;

	public ExitType getExitType() {
		return exitType;
	}

	public void setExitType(ExitType exitType) {
		this.exitType = exitType;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("exitType", exitType)
				.add("open", open)
				.toString();
	}
}

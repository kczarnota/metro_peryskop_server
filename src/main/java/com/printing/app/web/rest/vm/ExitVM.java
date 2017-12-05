package com.printing.app.web.rest.vm;

import com.google.common.base.MoreObjects;
import com.printing.app.domain.ExitType;
import com.printing.app.domain.QrCode;

public class ExitVM
{
    public static ExitVM fromQrCode(QrCode qrCode) {
        ExitVM exitVM = new ExitVM();
        exitVM.setPointId(qrCode.getId());
        exitVM.setOpen(qrCode.isOpen());
        exitVM.setExitType(qrCode.getExitType());

        return exitVM;
    }

    private long pointId;
    private ExitType exitType;
    private boolean open;

    public void setExitType(ExitType exitType) {
        this.exitType = exitType;
    }

    public ExitType getExitType(){return this.exitType;}

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen(){return this.open;}

    public void setPointId(long id) {
        this.pointId = id;
    }

    public long getPointId(){return this.pointId;}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pointId", pointId)
                .add("exitType", exitType)
                .add("open", open)
                .toString();
    }
}

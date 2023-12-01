package com.blued.android.module.yy_china.model;

import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.YYConstants;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYClickApplyEvent.class */
public class YYClickApplyEvent {
    private String seatNumber;
    private boolean showApplicationDialog = true;
    private YYConstants.ApplyFromSource source;

    public YYClickApplyEvent(YYConstants.ApplyFromSource applyFromSource, String str) {
        this.source = applyFromSource;
        this.seatNumber = str;
    }

    public int getSeatNumber() {
        return StringUtils.a(this.seatNumber, 0);
    }

    public YYConstants.ApplyFromSource getSource() {
        return this.source;
    }

    public boolean isShowApplicationDialog() {
        return this.showApplicationDialog;
    }

    public void setShowApplicationDialog(boolean z) {
        this.showApplicationDialog = z;
    }

    public String toString() {
        return "YYClickApplyEvent{source=" + this.source + ", seatNumber='" + this.seatNumber + "'}";
    }
}

package com.blued.android.module.yy_china.model;

import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.YYConstants;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYClickGiftEvent.class */
public class YYClickGiftEvent {
    private String seatNumber;
    private YYConstants.ApplyFromSource source;

    public YYClickGiftEvent(YYConstants.ApplyFromSource applyFromSource, String str) {
        this.source = applyFromSource;
        this.seatNumber = str;
    }

    public int getSeatNumber() {
        return StringUtils.a(this.seatNumber, 0);
    }

    public YYConstants.ApplyFromSource getSource() {
        return this.source;
    }
}

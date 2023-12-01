package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.ProgressButton;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cs.class */
public class cs extends cw<ProgressButton> {
    public cs(ProgressButton progressButton) {
        super(progressButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "fixedWidth";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ((ProgressButton) this.Code).setFixedWidth(Boolean.parseBoolean(str2));
        } catch (IllegalArgumentException e) {
            ge.I("ProgressButtonFixedWithHandler", "processAttribute - parse fixedWidth error", e);
        }
    }
}

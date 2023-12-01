package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cm.class */
public class cm extends cw<TextView> {
    public cm(TextView textView) {
        super(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "maxLines";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ((TextView) this.Code).setMaxLines(Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            ge.I("MaxLineHandler", "parse NumberFormatException");
        }
    }
}

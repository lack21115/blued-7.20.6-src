package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cz.class */
public class cz extends cw<TextView> {
    public cz(TextView textView) {
        super(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "gravity";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((TextView) this.Code).setGravity(com.huawei.hms.ads.template.util.a.V(str2));
    }
}

package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/co.class */
public class co extends cw<TextView> {
    public co(TextView textView) {
        super(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "minWidth";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((TextView) this.Code).setMinWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((TextView) this.Code).getContext()));
    }
}

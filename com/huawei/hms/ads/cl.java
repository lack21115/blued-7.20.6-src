package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cl.class */
public class cl extends cw<TextView> {
    public cl(TextView textView) {
        super(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "lineSpacingExtra";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((TextView) this.Code).setLineSpacing(com.huawei.hms.ads.template.util.a.Code(str2, ((TextView) this.Code).getContext()), ((TextView) this.Code).getLineSpacingMultiplier());
    }
}

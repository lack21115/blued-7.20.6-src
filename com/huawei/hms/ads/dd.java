package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dd.class */
public class dd extends cw {
    public dd(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "visibility";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.Code.setVisibility(com.huawei.hms.ads.template.util.a.Code(str2));
    }
}

package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cj.class */
public class cj extends cw {
    public cj(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "id";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.Code.setId(com.huawei.hms.ads.template.util.a.Code(str2.hashCode()));
    }
}

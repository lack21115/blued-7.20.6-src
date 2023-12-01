package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.ProgressButton;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ct.class */
public class ct extends cw<ProgressButton> {
    public ct(ProgressButton progressButton) {
        super(progressButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "maxWidth";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((ProgressButton) this.Code).setMaxWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((ProgressButton) this.Code).getContext()));
    }
}

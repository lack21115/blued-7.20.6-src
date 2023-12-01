package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.ProgressButton;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cu.class */
public class cu extends cw<ProgressButton> {
    public cu(ProgressButton progressButton) {
        super(progressButton);
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
        ((ProgressButton) this.Code).setMinWidth(com.huawei.hms.ads.template.util.a.Code(str2, ((ProgressButton) this.Code).getContext()));
    }
}

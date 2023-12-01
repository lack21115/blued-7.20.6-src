package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.LinearLayout;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cq.class */
public class cq extends cw<LinearLayout> {
    public cq(LinearLayout linearLayout) {
        super(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "orientation";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        LinearLayout linearLayout;
        int i;
        if (TextUtils.equals(str2, "vertical")) {
            linearLayout = (LinearLayout) this.Code;
            i = 1;
        } else {
            linearLayout = (LinearLayout) this.Code;
            i = 0;
        }
        linearLayout.setOrientation(i);
    }
}

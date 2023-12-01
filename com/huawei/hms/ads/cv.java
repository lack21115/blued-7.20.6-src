package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.view.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cv.class */
public class cv extends cw<View> {
    public cv(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "rectRadius";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && (this.Code instanceof b)) {
            ((b) this.Code).setRectRoundCornerRadius(com.huawei.hms.ads.template.util.a.Code(str2, this.Code.getContext()));
        }
    }
}

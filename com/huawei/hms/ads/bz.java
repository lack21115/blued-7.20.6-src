package com.huawei.hms.ads;

import android.graphics.Color;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.a;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bz.class */
public class bz extends cw<com.huawei.openalliance.ad.views.AppDownloadButton> {
    public bz(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        super(appDownloadButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "textColor";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            int parseColor = Color.parseColor(str2);
            com.huawei.openalliance.ad.views.a style = ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).getStyle();
            a.C0272a Code = style.Code();
            a.C0272a V = style.V();
            Code.Code(parseColor);
            V.Code(parseColor);
        } catch (IllegalArgumentException e) {
            ge.I("AppDownloadButtonTextColorHandler", "processAttribute - parse color error", e);
        }
    }
}

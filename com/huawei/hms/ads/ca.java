package com.huawei.hms.ads;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.a;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ca.class */
public class ca extends cw<com.huawei.openalliance.ad.views.AppDownloadButton> {
    public ca(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        super(appDownloadButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "textSize";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int Code = com.huawei.hms.ads.template.util.a.Code(str2, ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).getContext());
        com.huawei.openalliance.ad.views.a style = ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).getStyle();
        a.C0272a Code2 = style.Code();
        a.C0272a V = style.V();
        Code2.V(Code);
        V.V(Code);
        ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).setTextSize(Code);
    }
}

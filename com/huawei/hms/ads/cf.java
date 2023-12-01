package com.huawei.hms.ads;

import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cf.class */
public class cf extends cw {
    public cf(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "clickEvent";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.Code.setTag(R.id.hiad_pps_view_store_click_event, str2);
    }
}

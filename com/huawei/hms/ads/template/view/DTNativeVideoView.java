package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.cc;
import com.huawei.openalliance.ad.views.NativeVideoView;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTNativeVideoView.class */
public class DTNativeVideoView extends NativeVideoView implements a {
    private cc S;

    public DTNativeVideoView(Context context) {
        super(context);
    }

    public DTNativeVideoView(Context context, AttributeSet attributeSet) {
        super(context);
        cc ccVar = new cc(this);
        this.S = ccVar;
        ccVar.Code(attributeSet);
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cc ccVar = this.S;
        if (ccVar != null) {
            ccVar.Code(jSONObject);
        }
    }
}

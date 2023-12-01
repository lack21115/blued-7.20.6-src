package com.huawei.hms.ads;

import android.util.AttributeSet;
import android.view.View;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cw.class */
public abstract class cw<V extends View> extends ce<V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(V v) {
        super(v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String Code();

    @Override // com.huawei.hms.ads.ci
    public final void Code(AttributeSet attributeSet) {
    }

    @Override // com.huawei.hms.ads.ce
    public /* bridge */ /* synthetic */ void Code(JSONObject jSONObject) {
        super.Code(jSONObject);
    }
}

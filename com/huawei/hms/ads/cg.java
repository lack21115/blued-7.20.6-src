package com.huawei.hms.ads;

import android.util.AttributeSet;
import android.view.View;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cg.class */
public class cg extends cp<View> {
    private cd I;
    private cd V;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(View view) {
        super(view);
        this.V = new cd(view);
        this.I = new cd(view);
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue(null, "background");
        String attributeValue2 = attributeSet.getAttributeValue(null, "defaultBackground");
        if (this.V.Code(attributeValue)) {
            return;
        }
        this.V = null;
        this.I.Code(attributeValue2);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.ce
    public void Code(JSONObject jSONObject) {
        cd cdVar = this.V;
        if (cdVar != null) {
            cdVar.Code(jSONObject);
        }
        cd cdVar2 = this.I;
        if (cdVar2 != null) {
            cdVar2.Code(jSONObject);
        }
    }
}

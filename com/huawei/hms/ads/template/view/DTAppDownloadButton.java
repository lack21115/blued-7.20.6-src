package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.bz;
import com.huawei.hms.ads.ca;
import com.huawei.hms.ads.cb;
import com.huawei.hms.ads.cc;
import com.huawei.hms.ads.ci;
import com.huawei.hms.ads.cs;
import com.huawei.hms.ads.ct;
import com.huawei.hms.ads.cu;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTAppDownloadButton.class */
public class DTAppDownloadButton extends AppDownloadButton implements com.huawei.hms.ads.template.view.a {
    private cc B;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTAppDownloadButton$a.class */
    public static class a extends com.huawei.openalliance.ad.views.a {
        public a(Context context) {
            super(context);
        }

        protected a.C0442a Code(Context context) {
            return this.V;
        }

        @Override // com.huawei.openalliance.ad.views.a
        public a.C0442a Code(Context context, k kVar) {
            return Code(context);
        }
    }

    public DTAppDownloadButton(Context context) {
        super(context);
        Code(context);
    }

    public DTAppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context);
        Code(context);
        if (attributeSet != null) {
            cc ccVar = new cc(this);
            this.B = ccVar;
            ccVar.Code((ci) new cs(this));
            this.B.Code((ci) new bz(this));
            this.B.Code((ci) new ca(this));
            this.B.Code((ci) new cu(this));
            this.B.Code((ci) new ct(this));
            this.B.Code((ci) new cb(this));
            this.B.Code(attributeSet);
        }
    }

    private void Code(Context context) {
        setIsSetProgressDrawable(false);
        setAppDownloadButtonStyle(new a(context));
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cc ccVar = this.B;
        if (ccVar != null) {
            ccVar.Code(jSONObject);
        }
    }
}

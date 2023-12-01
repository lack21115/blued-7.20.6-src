package com.huawei.openalliance.ad.feedback;

import android.view.View;
import com.huawei.hms.ads.AdFeedbackListener;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/a.class */
public class a {
    private View Code;
    private AdFeedbackListener I;
    private AdFeedbackListener V;

    public View Code() {
        return this.Code;
    }

    public void Code(View view) {
        this.Code = view;
    }

    public void Code(AdFeedbackListener adFeedbackListener) {
        this.V = adFeedbackListener;
    }

    public AdFeedbackListener I() {
        return this.I;
    }

    public AdFeedbackListener V() {
        return this.V;
    }

    public void V(AdFeedbackListener adFeedbackListener) {
        this.I = adFeedbackListener;
    }
}

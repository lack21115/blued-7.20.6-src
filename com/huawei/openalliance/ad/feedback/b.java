package com.huawei.openalliance.ad.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/b.class */
public class b {
    private List<FeedbackInfo> B;
    private FeedbackInfo C;
    private AdContentData I;
    private Context S;
    private d V;
    private List<FeedbackInfo> Z;

    public b(FeedbackView feedbackView) {
        this.V = feedbackView;
    }

    public List<FeedbackInfo> Code() {
        return this.Z;
    }

    public void Code(Context context, AdContentData adContentData) {
        List<FeedbackInfo> list;
        this.S = context;
        if (adContentData == null || aa.Code(adContentData.ax())) {
            return;
        }
        this.I = adContentData;
        List<FeedbackInfo> ax = adContentData.ax();
        this.B = new ArrayList();
        this.Z = new ArrayList();
        for (FeedbackInfo feedbackInfo : ax) {
            if (feedbackInfo != null) {
                int V = feedbackInfo.V();
                if (V == 1) {
                    list = this.B;
                } else if (V == 2) {
                    list = this.Z;
                } else if (V != 3) {
                    ge.Code("FeedbackPresenter", "invalid feedback type");
                } else {
                    this.C = feedbackInfo;
                }
                list.add(feedbackInfo);
            }
        }
        this.V.Code();
    }

    public boolean Code(Context context) {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return false;
        }
        String X = adContentData.X();
        String str = X;
        if (TextUtils.isEmpty(X)) {
            str = this.I.W();
        }
        return v.Code(context, str);
    }

    public FeedbackInfo I() {
        return this.C;
    }

    public List<FeedbackInfo> V() {
        return this.B;
    }

    public boolean Z() {
        ge.V("FeedbackPresenter", "click complain");
        if (this.C == null || this.S == null || this.I == null) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("package_name", this.S.getPackageName());
            intent.putExtra(at.ac, this.I.C());
            intent.putExtra("content_id", this.I.S());
            intent.putExtra(at.S, this.I.aA());
            intent.putExtra(at.as, this.C.Code());
            intent.setAction(t.cL);
            intent.setPackage(v.Z(this.S));
            if (!(this.S instanceof Activity)) {
                intent.addFlags(268435456);
            }
            ay.Code(this.S, intent);
            return true;
        } catch (Throwable th) {
            ge.I("FeedbackPresenter", "start ac failed: %s", th.getClass().getSimpleName());
            return true;
        }
    }
}

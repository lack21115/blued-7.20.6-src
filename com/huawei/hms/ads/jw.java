package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.inter.listeners.b;
import com.huawei.openalliance.ad.utils.c;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jw.class */
public class jw extends hg<lh> implements ki<lh> {
    private Context B;
    private SplashView.SplashAdLoadListener C;
    private fk I;
    private b Z;

    public jw(Context context, lh lhVar) {
        Code((jw) lhVar);
        this.B = context.getApplicationContext();
        this.I = fk.Code(context);
    }

    private void S() {
        ge.I("SplashPresenter", "notifyNotSupport");
        b bVar = this.Z;
        if (bVar != null) {
            bVar.Code(1001);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(dq.Code(1001));
        }
    }

    @Override // com.huawei.hms.ads.ki
    public boolean B() {
        return c.L(this.B);
    }

    @Override // com.huawei.hms.ads.ki
    public void C() {
        ge.Code("SplashPresenter", "notifyAdDismissed");
        b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        com.huawei.openalliance.ad.utils.ax.V(this.B);
    }

    @Override // com.huawei.hms.ads.ki
    public void Code() {
        I().Code(((Integer) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.jw.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code */
            public Integer call() {
                return Integer.valueOf(jw.this.I.I());
            }
        }, 1)).intValue());
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.C = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(b bVar) {
        this.Z = bVar;
    }

    @Override // com.huawei.hms.ads.ki
    public void Code(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.at.ac, str);
            jSONObject.put("adType", i);
            com.huawei.openalliance.ad.ipc.g.V(this.B).Code("rptSplashDismissForExSplash", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            ge.I("SplashPresenter", "onSplashDismissForExsplash JSONException");
        }
    }

    @Override // com.huawei.hms.ads.ki
    public boolean V() {
        if (com.huawei.openalliance.ad.utils.v.Code(this.B)) {
            return true;
        }
        S();
        C();
        return false;
    }
}

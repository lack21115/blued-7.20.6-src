package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dk.class */
public class dk extends bf implements y {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6582a = "preload_end";
    private AdSize q;
    private String r;
    private boolean s;
    private boolean t;
    private RelativeLayout u;
    private InterstitialAd v;
    private InterstitialAdListener w;

    public dk(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        this.s = false;
        this.t = false;
        this.v = interstitialAd;
        this.u = relativeLayout;
        this.q = adSize;
        this.r = str;
    }

    public dk(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.u);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "0");
            jSONObject.put("h", "0");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if (AdSize.InterstitialGame.equals(this.q)) {
                jSONObject2.put("ABILITY", "PAUSE,");
            }
            jSONObject2.put("APT", this.q.getValue());
            jSONObject2.put("onlyLoadAd", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(int i, int i2) {
        if (this.k == null || this.s || this.t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put("h", i2);
        } catch (JSONException e) {
        }
        a(jSONObject);
        this.k.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(RelativeLayout relativeLayout) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.putOpt("event_type", "interstitial_set_video_parent");
            hashMap.put("interstitial_video_parent", relativeLayout);
        } catch (JSONException e) {
            bq.a().a(e);
        }
        a(jSONObject, hashMap);
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        if (f6582a.equals(iOAdEvent.getMessage())) {
            this.s = true;
            InterstitialAdListener interstitialAdListener = this.w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(InterstitialAdListener interstitialAdListener) {
        this.w = interstitialAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(String str) {
        super.g(str);
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a_() {
        if (this.s && !this.t) {
            this.t = true;
            this.s = false;
            if (this.k != null) {
                this.k.showAd();
            }
        } else if (this.t) {
            this.i.b("interstitial ad is showing now");
        } else if (this.s) {
        } else {
            this.i.b("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void b() {
        if (this.k != null) {
            this.k.showAd();
        }
    }

    @Deprecated
    public void b(Activity activity) {
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i) {
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public boolean c() {
        return this.s;
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void f() {
        a();
    }

    public void g() {
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void g(IOAdEvent iOAdEvent) {
        this.t = false;
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdClick(this.v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPresent();
        }
    }
}

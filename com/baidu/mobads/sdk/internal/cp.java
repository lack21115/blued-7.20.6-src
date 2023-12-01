package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cp.class */
public class cp extends bf {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f9397a;
    private String q;
    private boolean r;
    private AdViewListener s;
    private int t;
    private int u;
    private AdView v;
    private RequestParameters w;

    public cp(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        this.v = adView;
        this.f9397a = relativeLayout;
        this.q = str;
        this.r = z;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "banner");
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.f9397a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "banner");
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.r);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.t);
            jSONObject.put("h", "" + this.u);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if (this.w != null) {
                a(this.w.getExtras());
            }
            jSONObject2 = b(this.m);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(AdViewListener adViewListener) {
        this.s = adViewListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.v);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.w = requestParameters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    public void c(int i) {
        this.u = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.s.onAdShow(new JSONObject());
        }
    }
}

package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dm.class */
public class dm extends bf {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6584a;
    private int q;
    private String r;
    private ScreenVideoAdListener s;
    private final String t;
    private int u;
    private int v;
    private String w;
    private String x;
    private a y;
    private RequestParameters z;

    public dm(Context context, String str, boolean z) {
        this(context, str, z, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public dm(Context context, String str, boolean z, String str2) {
        super(context);
        this.q = 3;
        this.r = str;
        this.f6584a = z;
        this.t = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        this.k.loadAd(k(), l());
    }

    public void a(int i) {
        this.q = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        super.a(i, str);
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        List<a> a2;
        if (iOAdEvent != null && (a2 = b.a(iOAdEvent.getMessage()).a()) != null && a2.size() > 0) {
            this.y = a2.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    public void a(RequestParameters requestParameters) {
        this.z = requestParameters;
        a(requestParameters.getExt());
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.s = screenVideoAdListener;
    }

    public void a(String str) {
        this.w = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        try {
            this.m = j.a(map);
        } catch (Throwable th) {
            this.m = new HashMap<>();
        }
    }

    public void a(boolean z, String str) {
        a(z, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z, String str, HashMap<String, Object> hashMap) {
        a aVar = this.y;
        if (aVar != null) {
            a(aVar.G(), z, str, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        super.b(str, i);
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(boolean z) {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void f() {
        if (this.k != null) {
            this.k.showAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    public boolean g() {
        if (this.k != null) {
            return this.k.isAdReady();
        }
        return false;
    }

    public String h() {
        a aVar = this.y;
        return aVar != null ? aVar.z() : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void i(String str) {
        this.x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.t);
            this.k.createProdHandler(jSONObject3);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(10);
            jSONObject.put("at", sb.toString());
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            Rect a2 = ax.a(this.h);
            this.u = a2.width();
            this.v = a2.height();
            if (this.h.getResources().getConfiguration().orientation == 2) {
                this.u = a2.height();
                this.v = a2.width();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.u);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(this.v);
            jSONObject.put("h", sb3.toString());
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.t)) {
                jSONObject.put("msa", 5285);
            }
            JSONObject a3 = j.a(jSONObject, b(this.m));
            jSONObject2 = a3;
            b(a3);
            return a3;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject2;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.f6584a);
            jSONObject.put("downloadConfirmPolicy", this.q);
            jSONObject.put("userid", this.w);
            jSONObject.put("extra", this.x);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void s() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }
}

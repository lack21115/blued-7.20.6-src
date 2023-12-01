package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dn.class */
public class dn extends bf {
    private static int E;
    private static dn J;
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private SplashAdListener F;
    private SplashAd.OnFinishListener G;
    private SplashAd.SplashFocusAdListener H;
    private RequestParameters I;
    private a K;
    private SplashAd.SplashAdDownloadDialogListener L;
    private HashMap<String, String> M;

    /* renamed from: a  reason: collision with root package name */
    public boolean f9425a;
    public boolean q;
    public boolean r;
    public boolean s;
    private RelativeLayout t;
    private String u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    public dn(Context context, String str, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.D = 60;
        this.q = false;
        this.r = false;
        this.s = false;
        this.u = str;
        this.v = i;
        this.w = i2;
        this.x = i3;
        this.y = i4;
        this.z = z;
        this.A = z2;
        this.B = z4;
        this.C = z3;
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dn dnVar = J;
        if (dnVar != null) {
            dnVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    J.a(jSONObject2, hashMap);
                } catch (JSONException e) {
                    bq.a().c(e);
                    J = null;
                } catch (Throwable th) {
                    bq.a().c(th);
                    J = null;
                }
                J = null;
            } catch (Throwable th2) {
                J = null;
                throw th2;
            }
        }
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        if (this.h == null || intent == null) {
            return;
        }
        if (!(this.h instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
        } else if (this.h instanceof Activity) {
            ((Activity) this.h).finish();
        }
    }

    public static void c(int i) {
        E = i;
    }

    private String i(String str) {
        if (this.I == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.I.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.i.d(bf.b, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        if (!this.f9425a) {
            this.k.setAdContainer(this.t);
        }
        this.k.loadAd(k(), l());
    }

    public void a(int i) {
        this.D = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        this.s = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i, str);
    }

    public void a(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        try {
            if (this.q || intent == null || this.k == null || this.s || !(this.h instanceof Activity)) {
                b(intent, onFinishListener);
                return;
            }
            this.G = onFinishListener;
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.putOpt("event_type", "splash_focus_start_activity");
                hashMap.put("splash_focus_user_intent", intent);
            } catch (JSONException e) {
                bq.a().a(e);
            }
            this.k.removeAllListeners();
            this.k.addEventListener(w.Z, this.j);
            this.k.addEventListener(w.N, this.j);
            this.k.addEventListener(w.H, this.j);
            this.k.addEventListener(w.W, this.j);
            this.k.addEventListener(w.X, this.j);
            a(jSONObject, hashMap);
            this.F = null;
            J = this;
            ba.a().a(new Cdo(this), 3L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    public void a(RelativeLayout relativeLayout) {
        this.t = relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        List<a> a2;
        if (iOAdEvent != null && (a2 = b.a(iOAdEvent.getMessage()).a()) != null && a2.size() > 0) {
            this.K = a2.get(0);
        }
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    public void a(RequestParameters requestParameters) {
        this.I = requestParameters;
        c(requestParameters.getExt());
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.L = splashAdDownloadDialogListener;
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.H = splashFocusAdListener;
    }

    public void a(SplashAdListener splashAdListener) {
        this.F = splashAdListener;
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e) {
                bq.a().a(e);
            }
            a(jSONObject, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(boolean z, String str) {
        a(z, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z, String str, HashMap<String, Object> hashMap) {
        a aVar = this.K;
        if (aVar != null) {
            a(aVar.G(), z, str, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        this.s = true;
        if (this.F != null) {
            a(i + "==" + str);
            this.F.onAdFailed(str);
        }
        super.b(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    public void c(Map<String, String> map) {
        try {
            this.M = j.a(map);
        } catch (Throwable th) {
            this.M = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.H;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        if (this.H == null || data == null || !data.containsKey("splash_show_reason")) {
            return;
        }
        this.H.onAdIconShow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    public void f() {
        if (this.f9425a || this.k == null) {
            return;
        }
        this.k.setAdContainer(this.t);
        this.k.showAd();
    }

    public a g() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        if (this.H != null && data != null && data.containsKey("splash_close_reason")) {
            this.H.onAdClose();
        } else if (this.r) {
        } else {
            super.g(iOAdEvent);
            SplashAdListener splashAdListener = this.F;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
            this.r = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        this.q = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.H;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        Object obj = "1";
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.k.createProdHandler(jSONObject3);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.u);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(26);
            jSONObject.put("at", sb.toString());
            jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.v);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(this.w);
            jSONObject.put("h", sb3.toString());
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            String i = i(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(i)) {
                if (!Boolean.parseBoolean(i)) {
                    obj = "0";
                }
                jSONObject.put("adtv", obj);
            }
            JSONObject a2 = j.a(jSONObject, b(this.M));
            jSONObject2 = a2;
            b(a2);
            return a2;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject2;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.y);
            jSONObject.put("splashTipStyle", this.x);
            jSONObject.put("bitmapDisplayMode", E);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.z);
            jSONObject.put("popDialogIfDl", "" + this.A);
            jSONObject.put("limitRegionClick", "" + this.B);
            jSONObject.put("displayClickButton", "" + this.C);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.f9425a);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.D);
            if (this.I != null) {
                a(this.I.getExtras());
            }
            return j.a(jSONObject, b(this.m));
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdPresent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void t() {
        SplashAd.OnFinishListener onFinishListener = this.G;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.G = null;
        } else if (this.h instanceof Activity) {
            ((Activity) this.h).finish();
        }
        this.h = null;
        this.t = null;
        super.t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }
}

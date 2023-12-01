package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/dc.class */
public class dc extends bf {
    private boolean A;
    private BaiduNativeAdPlacement B;

    /* renamed from: a  reason: collision with root package name */
    a f9413a;
    private String q;
    private String r;
    private int s;
    private int t;
    private BaiduNativeH5AdView u;
    private int v;
    private int w;
    private int x;
    private BaiduNativeH5AdView.BaiduNativeH5EventListner y;
    private boolean z;

    public dc(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.z = false;
        this.f9413a = null;
        this.A = false;
        this.u = baiduNativeH5AdView;
        this.r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.q = str;
        this.g = baiduNativeH5AdView.getAdPlacement().getAdView();
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.q);
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.q);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.s);
            jSONObject.put("h", "" + this.t);
            jSONObject = j.a(jSONObject, b(this.m));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    public void a(int i) {
        this.v = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        r();
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.B = baiduNativeAdPlacement;
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.y = baiduNativeH5EventListner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        this.A = true;
        this.u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.s = width;
        this.t = height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void c(int i) {
        this.w = i;
    }

    public void c(boolean z) {
        this.z = z;
    }

    public void d(int i) {
        this.x = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        this.B.setWinSended(true);
    }

    public boolean f() {
        return this.z;
    }

    public boolean g() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        this.B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        this.z = true;
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }
}

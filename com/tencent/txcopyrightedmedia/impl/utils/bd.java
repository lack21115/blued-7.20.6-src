package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.BuildConfig;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.impl.utils.i;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/bd.class */
public final class bd implements aw {

    /* renamed from: a  reason: collision with root package name */
    public String f40090a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f40091c;
    public String d;
    public String e;
    public String f;
    public long g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public String q;
    public String r;
    public long s;
    public String t;
    public String u;
    public String v;
    private long w;

    public bd() {
    }

    public bd(String str, String str2) {
        Context applicationContext = TXCopyrightedMedia.instance().getApplicationContext();
        this.b = TXCopyrightedMedia.instance().getAppID();
        this.f40091c = str;
        this.d = "";
        this.e = str2;
        this.f = aj.b(applicationContext);
        this.g = System.currentTimeMillis();
        this.h = BuildConfig.VERSION_NAME;
        this.i = "Android";
        this.j = aj.c(applicationContext);
        this.k = aj.b();
        this.l = aj.a();
        this.m = aj.e(applicationContext);
        this.n = "";
        this.o = "";
        this.p = 0;
        this.q = "";
        this.r = "";
        this.s = 0L;
        this.t = applicationContext.getPackageName();
        this.u = "";
        this.f40090a = this.j + System.currentTimeMillis() + ((int) (Math.random() * 10000.0d));
        this.v = aj.d(TXCopyrightedMedia.instance().getApplicationContext());
    }

    public final bd a(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        if (!TextUtils.isEmpty(this.r)) {
            str = this.r + " | " + str;
        }
        this.r = str;
        return this;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Action", "ReportKTVPlay");
            jSONObject.put("ReqId", this.f40090a);
            jSONObject.put(com.alipay.sdk.packet.e.f, this.b);
            jSONObject.put("MusicId", this.f40091c);
            jSONObject.put("MusicType", this.d);
            jSONObject.put("BitrateType", this.e);
            jSONObject.put("AppName", this.f);
            jSONObject.put("ReqTime", this.g);
            jSONObject.put("SDKVersion", this.h);
            jSONObject.put("DeviceType", this.i);
            jSONObject.put("DeviceId", this.j);
            jSONObject.put("DeviceSystem", this.k);
            jSONObject.put("OSType", this.l);
            jSONObject.put("NetType", this.m);
            jSONObject.put("EventType", this.n);
            jSONObject.put("MusicUrl", this.o);
            jSONObject.put("ClientErrCode", this.p);
            jSONObject.put("SvrErrCode", this.q);
            jSONObject.put("ErrMsg", this.r);
            jSONObject.put("CostTime", this.s);
            jSONObject.put("PackageName", this.t);
            jSONObject.put("BundleID", this.u);
            jSONObject.put("AppVersion", this.v);
            jSONObject.put("SDKVersion", TXCopyrightedMedia.getSDKVersion());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final void a(int i) {
        if (i == 100) {
            this.s = 0L;
            this.w = System.currentTimeMillis();
        } else if (i == 102) {
            this.s = System.currentTimeMillis() - this.w;
        }
    }

    public final void a(i.a aVar) {
        this.p = aVar.f40102a;
        this.q = aVar.b;
        this.r = aVar.f40103c;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final String b() {
        return "https://ugc.ame.qcloud.com/ugcapi";
    }

    public final void c() {
        this.d = "";
        this.g = System.currentTimeMillis();
        this.h = BuildConfig.VERSION_NAME;
        this.n = "";
        this.o = "";
        this.p = 0;
        this.q = "";
        this.r = "";
        this.s = 0L;
        this.u = "";
        this.f40090a = this.j + System.currentTimeMillis() + ((int) (Math.random() * 10000.0d));
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new bd();
        }
    }

    public final void d() {
        c();
        this.n = "Download";
    }

    public final void e() {
        c();
        this.n = "Play";
    }

    public final String toString() {
        return "ErrorTraceInfo{mReqId='" + this.f40090a + "', mAppId='" + this.b + "', mMusicId='" + this.f40091c + "', mMusicType='" + this.d + "', mBitrateType='" + this.e + "', mAppName='" + this.f + "', mReqTime='" + this.g + "', mSdkVersion='" + this.h + "', mDeviceType='" + this.i + "', mDeviceId='" + this.j + "', mDeviceSystem='" + this.k + "', mOSType='" + this.l + "', mNetType='" + this.m + "', mEventType='" + this.n + "', mMusicUrl='" + this.o + "', mClientErrCode='" + this.p + "', mSvrErrCode='" + this.q + "', mErrMsg='" + this.r + "', mCostTime='" + this.s + "', mPackageName='" + this.t + "', mBundleID='" + this.u + "'}";
    }
}

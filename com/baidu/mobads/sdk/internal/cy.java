package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.pd.ExHandler;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cy.class */
public class cy implements t {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cv f6567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cv cvVar) {
        this.f6567a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h = this.f6567a.h("get_cuid");
        String h2 = this.f6567a.h("get_imei");
        String h3 = this.f6567a.h("get_oaid");
        try {
            jSONObject.put("cuid", h);
            jSONObject.put(ExHandler.JSON_REQUEST_IMEI, h2);
            jSONObject.put("oaid", h3);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(long j) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f6567a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f6567a.H;
            cpuNovelListener2.onReadTime(j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6567a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
        hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
        hashMap.put("novel_id", this.f6567a.F);
        this.f6567a.a(cv.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6567a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6567a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
        hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
        hashMap.put("novel_id", this.f6567a.F);
        hashMap.put("count_down", Integer.valueOf(i));
        this.f6567a.a(cv.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6567a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6567a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
        hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
        hashMap.put("novel_id", this.f6567a.F);
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.f6567a.a(cv.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6567a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6567a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
        hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
        hashMap.put("novel_id", this.f6567a.F);
        hashMap.put("novel_info", jSONObject);
        this.f6567a.a(cv.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f6567a.I;
        if (softReference != null) {
            softReference2 = this.f6567a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f6567a.h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
                hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
                hashMap.put("novel_id", this.f6567a.F);
                hashMap.put("isnight", Boolean.valueOf(this.f6567a.w()));
                this.f6567a.a(cv.w, hashMap);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
        hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
        hashMap.put("novel_id", this.f6567a.F);
        hashMap.put("isnight", Boolean.valueOf(this.f6567a.w()));
        this.f6567a.a(cv.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6567a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6567a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f6567a.D));
        hashMap.put("channelId", Integer.valueOf(this.f6567a.E));
        hashMap.put("novel_id", this.f6567a.F);
        hashMap.put("novel_info", jSONObject);
        this.f6567a.a(cv.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }
}

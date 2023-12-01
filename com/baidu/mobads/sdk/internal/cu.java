package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cu.class */
class cu implements t {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f9402a;
    final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f9403c;
    final /* synthetic */ cq d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cq cqVar, int i, int i2, String str) {
        this.d = cqVar;
        this.f9402a = i;
        this.b = i2;
        this.f9403c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h = this.d.h("get_cuid");
        String h2 = this.d.h("get_imei");
        String h3 = this.d.h("get_oaid");
        try {
            jSONObject.put("cuid", h);
            jSONObject.put("imei", h2);
            jSONObject.put("oaid", h3);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(long j) {
        bq bqVar = this.d.i;
        bqVar.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f9402a));
        hashMap.put("channelId", Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f9403c);
        this.d.a(cv.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f9402a));
        hashMap.put("channelId", Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f9403c);
        hashMap.put("count_down", Integer.valueOf(i));
        this.d.a(cv.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f9402a));
        hashMap.put("channelId", Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f9403c);
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.d.a(cv.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f9402a));
        hashMap.put("channelId", Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f9403c);
        hashMap.put("novel_info", jSONObject);
        this.d.a(cv.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f9402a));
        hashMap.put("channelId", Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f9403c);
        this.d.a(cv.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.d.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.d.g()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.f9402a));
        hashMap.put("channelId", Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f9403c);
        hashMap.put("novel_info", jSONObject);
        this.d.a(cv.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }
}

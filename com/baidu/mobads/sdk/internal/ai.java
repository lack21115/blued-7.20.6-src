package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.anythink.pd.ExHandler;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ai.class */
public class ai implements t {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f6465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ad adVar) {
        this.f6465a = adVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h = this.f6465a.h("get_cuid");
        String h2 = this.f6465a.h("get_imei");
        String h3 = this.f6465a.h("get_oaid");
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
        bq bqVar = this.f6465a.i;
        bqVar.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6465a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, 2);
        iArr = this.f6465a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        this.f6465a.a(cv.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6465a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6465a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, 2);
        iArr = this.f6465a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("count_down", Integer.valueOf(i));
        this.f6465a.a(cv.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6465a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6465a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, 2);
        iArr = this.f6465a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.f6465a.a(cv.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6465a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6465a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, 2);
        iArr = this.f6465a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f6465a.a(cv.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, 2);
        iArr = this.f6465a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        this.f6465a.a(cv.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6465a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6465a.h()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, 2);
        iArr = this.f6465a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f6465a.a(cv.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }
}

package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/aj.class */
public class aj extends bf {

    /* renamed from: a  reason: collision with root package name */
    private CPUAggregationManager.CPUAggregationListener f9306a;
    private String q;
    private int r;
    private int s;
    private int t;
    private int[] u;
    private HashMap<String, Object> v;

    public aj(Context context, String str) {
        super(context);
        this.u = new int[]{1098};
        this.q = str;
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
        JSONObject jSONObject3 = jSONObject2;
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            this.k.createProdHandler(jSONObject4);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            jSONObject.put("appsid", this.q);
            jSONObject.put("pageIndex", this.s);
            jSONObject.put("pageSize", this.r);
            jSONObject.put("channels", this.u);
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            jSONObject2.put("timeout", this.t);
            JSONObject a2 = j.a(this.v);
            jSONObject3 = a2;
            a2.put("listScene", 503);
            jSONObject3 = a2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject3);
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        this.s = i;
        this.r = i2;
        this.v = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        super.a(i, str);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f9306a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i);
        }
    }

    public void a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        this.f9306a = cPUAggregationListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        if (this.f9306a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (List) iOAdEvent.getData().get("cpuHotList")) {
                    arrayList.add(new NativeCPUAggregationData(this.h, obj, this.v));
                }
                this.f9306a.onHotContentLoaded(arrayList);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        super.b(str, i);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f9306a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f9306a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onExitLp();
        }
    }
}

package com.huawei.hms.framework.network.grs.g.k;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.mapsdk.internal.k2;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/k/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f22717a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f22718c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f22717a = grsBaseInfo;
        this.b = context;
    }

    private String e() {
        Set<String> b = com.huawei.hms.framework.network.grs.f.b.a(this.b.getPackageName(), this.f22717a).b();
        if (b.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : b) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put(k2.d, jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : this.f22718c) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put(k2.d, jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    public Context a() {
        return this.b;
    }

    public void a(String str) {
        this.f22718c.add(str);
    }

    public GrsBaseInfo b() {
        return this.f22717a;
    }

    public String c() {
        return this.f22718c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f22718c;
    }
}

package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/vchannel/b.class */
public class b {
    private String b;

    /* renamed from: a  reason: collision with root package name */
    private String f40971a = "_$unknown";

    /* renamed from: c  reason: collision with root package name */
    private long f40972c = 0;
    private long d = 0;
    private String e = a.j;
    private Map<String, Object> f = null;

    public b(Context context) {
        this.b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f40971a;
    }

    public void a(long j) {
        this.f40972c = j;
    }

    public void a(String str) {
        this.f40971a = str;
    }

    public void a(Map<String, Object> map) {
        this.f = map;
    }

    public long b() {
        return this.f40972c;
    }

    public Map<String, Object> c() {
        return this.f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f40971a);
            jSONObject.put("pn", this.b);
            jSONObject.put("ds", this.d);
            jSONObject.put("ts", this.f40972c);
            if (this.f != null && this.f.size() > 0) {
                for (String str : this.f.keySet()) {
                    jSONObject.put(str, this.f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable th) {
            return null;
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f40971a + ",");
        sb.append("pn:" + this.b + ",");
        sb.append("ts:" + this.f40972c + ",");
        Map<String, Object> map = this.f;
        if (map != null && map.size() > 0) {
            for (String str : this.f.keySet()) {
                sb.append(this.f.get(str) == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.d + "]");
        return sb.toString();
    }
}

package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.r  reason: case insensitive filesystem */
/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/r.class */
public class C0955r implements s {

    /* renamed from: a  reason: collision with root package name */
    public List<q> f9182a;
    public o b;

    /* renamed from: c  reason: collision with root package name */
    public p f9183c;
    public s d;
    public String e = "";
    public String f;

    public C0955r(String str) {
        this.f = str;
    }

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        String str;
        List<q> list = this.f9182a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.b == null || this.f9183c == null || this.d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a2 = this.d.a();
            a2.put("properties", this.f9183c.a());
            try {
                a2.put("events_global_properties", new JSONObject(this.e));
            } catch (JSONException e) {
                a2.put("events_global_properties", this.e);
            }
            jSONObject2.put("events_common", a2);
            JSONArray jSONArray = new JSONArray();
            for (q qVar : this.f9182a) {
                JSONObject a3 = qVar.a();
                if (a3 != null) {
                    jSONArray.put(a3);
                } else {
                    z.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(com.umeng.analytics.pro.d.f27025ar, jSONArray);
            try {
                String a4 = d.a(u0.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                if (TextUtils.isEmpty(a4)) {
                    z.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a4);
                return jSONObject;
            } catch (UnsupportedEncodingException e2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        z.e("hmsSdk", str);
        return null;
    }

    public void a(f1 f1Var) {
        this.d = f1Var;
    }

    public void a(o oVar) {
        this.b = oVar;
    }

    public void a(p pVar) {
        this.f9183c = pVar;
    }

    public void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(List<q> list) {
        this.f9182a = list;
    }
}

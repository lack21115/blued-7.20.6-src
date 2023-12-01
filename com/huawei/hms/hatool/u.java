package com.huawei.hms.hatool;

import android.content.IntentFilter;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public String f9186a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f9187c;
    public List<q> d;
    public String e;

    public u(String str, String str2, String str3, List<q> list, String str4) {
        this.f9186a = str;
        this.b = str2;
        this.f9187c = str3;
        this.d = list;
        this.e = str4;
    }

    public final String a(String str, String str2) {
        String str3;
        String f = c.f(str, str2);
        if (TextUtils.isEmpty(f)) {
            z.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f);
    }

    public void a() {
        o0 m0Var;
        p0 c2;
        String str;
        String a2 = a(this.f9186a, this.b);
        if (!TextUtils.isEmpty(a2) || "preins".equals(this.b)) {
            if (!"_hms_config_tag".equals(this.f9186a) && !"_openness_config_tag".equals(this.f9186a)) {
                b();
            }
            C0955r d = d();
            if (d != null) {
                byte[] a3 = a(d);
                if (a3.length == 0) {
                    str = "request body is empty";
                } else {
                    m0Var = new j0(a3, a2, this.f9186a, this.b, this.e, this.d);
                    c2 = p0.b();
                }
            } else {
                m0Var = new m0(this.d, this.f9186a, this.e, this.b);
                c2 = p0.c();
            }
            c2.a(m0Var);
            return;
        }
        str = "collectUrl is empty";
        z.e("hmsSdk", str);
    }

    public final byte[] a(C0955r c0955r) {
        String str;
        try {
            JSONObject a2 = c0955r.a();
            if (a2 == null) {
                z.e("hmsSdk", "uploadEvents is null");
                return new byte[0];
            }
            return u0.a(a2.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            z.e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException e2) {
            str = "uploadEvents to json error";
            z.e("hmsSdk", str);
            return new byte[0];
        }
    }

    public final void b() {
        if (r0.a(b.i(), "backup_event", (int) IntentFilter.MATCH_CATEGORY_PATH)) {
            z.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c2 = c();
        String a2 = v0.a(this.f9186a, this.b, this.e);
        z.c("hmsSdk", "Update data cached into backup,spKey: " + a2);
        h0.b(b.i(), "backup_event", a2, c2.toString());
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (q qVar : this.d) {
            try {
                jSONArray.put(qVar.d());
            } catch (JSONException e) {
                z.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    public final C0955r d() {
        return e1.a(this.d, this.f9186a, this.b, this.e, this.f9187c);
    }
}

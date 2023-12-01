package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdtracker.z2;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/n0.class */
public class n0 {
    public static final String[] l = {"channel", "package", "app_version"};

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f7658a;
    public final Context b;

    /* renamed from: c  reason: collision with root package name */
    public final m0 f7659c;
    public final SharedPreferences f;
    public final r2 g;
    public final c h;
    public boolean j;
    public boolean k;
    public final ArrayList<i0> e = new ArrayList<>(32);
    public int i = 0;
    public volatile JSONObject d = new JSONObject();

    public n0(c cVar, Context context, m0 m0Var) {
        this.k = false;
        this.h = cVar;
        this.b = context;
        this.f7659c = m0Var;
        this.f = m0Var.e;
        this.g = cVar.d.a(this.b, this.f7659c);
        this.k = this.f.getBoolean("forbid_report_phone_detail_info", false);
    }

    public static /* synthetic */ String a(i0 i0Var, boolean z) {
        return "needSyncFromSub " + i0Var + " " + z;
    }

    public static /* synthetic */ String a(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        return "saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + str4 + ", " + str5 + ", " + jSONObject;
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String q() {
        StringBuilder a2 = a.a("loadHeader, ");
        a2.append(this.f7658a);
        a2.append(", ");
        a2.append(this.i);
        a2.append(", ");
        a2.append(this.d.toString());
        return a2.toString();
    }

    public <T> T a(String str, T t, Class<T> cls) {
        return (T) this.h.i.a(this.d, str, (String) t, (Class<String>) cls);
    }

    public String a() {
        return this.f7659c.b.getAid();
    }

    public final String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public final void a(String str) {
        synchronized (this) {
            String optString = this.d.optString("ab_sdk_version");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        str = optString + "," + str;
                        break;
                    }
                    String str2 = split[i2];
                    if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                        z2.a("addExposedVid ready added: " + optString);
                        return;
                    }
                    i = i2 + 1;
                }
            }
            e(str);
            a(str, this.f7659c.e());
        }
    }

    public final void a(String str, String str2) {
        if (this.f7659c.e.getBoolean("bav_ab_config", false) && this.f7659c.b.isAbEnable()) {
            Set<String> c2 = c(str);
            c2.removeAll(c(str2));
            d0 d0Var = this.h.w;
            if (d0Var != null) {
                d0Var.onAbVidsChange(a(c2), str2);
            }
        }
    }

    public void a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject;
        if (hashMap == null || hashMap.isEmpty()) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject c2 = c();
            if (c2 != null) {
                j1.a(jSONObject2, c2);
            }
            try {
                Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
                while (true) {
                    jSONObject = jSONObject2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Object> next = it.next();
                    if (!TextUtils.isEmpty(next.getKey())) {
                        jSONObject2.put(next.getKey(), next.getValue());
                    }
                }
            } catch (Exception e) {
                z2.a(e);
                jSONObject = jSONObject2;
            }
        }
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        if (a(WbCloudFaceContant.CUSTOM, jSONObject)) {
            this.f7659c.f7651c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
        }
    }

    public final boolean a(final i0 i0Var) {
        boolean z = !this.f7659c.i() && i0Var.d;
        final boolean z2 = z;
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$w5emHRzZakhW4pLFQbOEXD1lT4s
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return n0.a(i0.this, z2);
            }
        });
        return z;
    }

    public final boolean a(String str, Object obj) {
        boolean z;
        Object opt = this.d.opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    j1.a(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.d = jSONObject2;
                } catch (JSONException e) {
                    z2.c("U SHALL NOT PASS!", e);
                }
            }
            z = true;
        }
        z2.a("updateHeader, " + str + ", " + opt + ", " + obj + ", changed:" + z);
        return z;
    }

    public boolean a(final JSONObject jSONObject, final String str, final String str2, final String str3, final String str4, final String str5) {
        boolean z;
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$RQDJq2PxighBvtUJatr2zHmTgKo
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return n0.a(str, str2, str3, str4, str5, jSONObject);
            }
        });
        this.j = jSONObject.optInt("new_user", 0) > 0;
        String optString = jSONObject.optString(RemoteMessageConst.DEVICE_TOKEN, "");
        boolean a2 = j1.a(str);
        boolean a3 = j1.a(str2);
        boolean a4 = j1.a(str4);
        boolean a5 = j1.a(str5);
        try {
            boolean a6 = j1.a(str3);
            int i = this.f.getInt("version_code", 0);
            int optInt = this.d.optInt("version_code", 0);
            SharedPreferences.Editor edit = this.f.edit();
            if (i != optInt) {
                edit.putInt("version_code", optInt);
            }
            String string = this.f.getString("channel", "");
            String optString2 = this.d.optString("channel", "");
            if (!TextUtils.equals(string, optString2)) {
                edit.putString("channel", optString2);
            }
            edit.putString(RemoteMessageConst.DEVICE_TOKEN, optString);
            if ((a2 || (a4 && a5)) && a3) {
                long currentTimeMillis = System.currentTimeMillis();
                edit.putLong("register_time", currentTimeMillis);
                a("register_time", Long.valueOf(currentTimeMillis));
            } else if (!a2 && (!a4 || !a5)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                this.h.onEventV3("tt_fetch_did_error", jSONObject2, 0);
            }
            String b = ((n2) this.g).b();
            String string2 = this.f.getString("bd_did", null);
            z2.a("device: od=" + b + " nd=" + str + " ck=" + a2);
            if (a2) {
                if (str.equals(this.d.optString("device_id"))) {
                    z = false;
                } else {
                    JSONObject jSONObject3 = this.d;
                    JSONObject jSONObject4 = new JSONObject();
                    j1.a(jSONObject4, jSONObject3);
                    jSONObject4.put("device_id", str);
                    this.d = jSONObject4;
                    ((n2) this.g).b(str);
                    z = true;
                }
                if (!str.equals(b)) {
                    z = true;
                }
            } else {
                z = false;
            }
            boolean z2 = z;
            if (a4) {
                z2 = z;
                if (a("bd_did", (Object) str4)) {
                    edit.putString("bd_did", str4);
                    z2 = true;
                }
            }
            String optString3 = this.d.optString("install_id", "");
            boolean z3 = z2;
            if (a3) {
                z3 = z2;
                if (a("install_id", (Object) str2)) {
                    edit.putString("install_id", str2);
                    z3 = true;
                }
            }
            String optString4 = this.d.optString("ssid", "");
            if (a6 && a("ssid", (Object) str3)) {
                edit.putString(this.f7659c.h(), str3);
                z3 = true;
            }
            if (this.h.w != null) {
                try {
                    this.h.w.onRemoteIdGet(z3, string2, str4, optString3, str2, optString4, str3);
                } catch (JSONException e) {
                    e = e;
                    z2.a("U SHALL NOT PASS!", e);
                    if (a2) {
                    }
                }
            }
            edit.apply();
        } catch (JSONException e2) {
            e = e2;
        }
        return (!a2 || (a4 && a5)) && a3;
    }

    public String b() {
        return this.d.optString("bd_did", "");
    }

    public void b(String str) {
        r2 r2Var = this.g;
        if (r2Var instanceof n2) {
            ((n2) r2Var).a(this.b, str);
        }
        this.f7659c.e.edit().remove(RemoteMessageConst.DEVICE_TOKEN).commit();
    }

    public final void b(JSONObject jSONObject) {
        synchronized (this) {
            if (jSONObject == null) {
                z2.b("null abconfig", (Throwable) null);
            }
            String optString = this.d.optString("ab_sdk_version");
            if (!TextUtils.isEmpty(optString)) {
                Set<String> c2 = c(optString);
                HashSet hashSet = new HashSet();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next instanceof String) {
                            String str = next;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    hashSet.add(jSONObject.getJSONObject(str).optString(OapsKey.KEY_VERID));
                                } catch (JSONException e) {
                                    z2.c("U SHALL NOT PASS!", e);
                                }
                            }
                        }
                    }
                }
                String e2 = this.f7659c.e();
                hashSet.addAll(c(e2));
                c2.retainAll(hashSet);
                String a2 = a(c2);
                e(a2);
                if (!TextUtils.equals(optString, a2)) {
                    a(a2, e2);
                }
            }
        }
    }

    public final Set<String> c(String str) {
        String[] split;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length > 0) {
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
                i = i2 + 1;
            }
        }
        return hashSet;
    }

    public final JSONObject c() {
        JSONObject jSONObject = null;
        if (this.f7658a) {
            return this.d.optJSONObject(WbCloudFaceContant.CUSTOM);
        }
        m0 m0Var = this.f7659c;
        if (m0Var != null) {
            try {
                jSONObject = new JSONObject(m0Var.f7651c.getString("header_custom_info", null));
            } catch (Exception e) {
                return null;
            }
        }
        return jSONObject;
    }

    public JSONObject d() {
        if (this.f7658a) {
            return this.d;
        }
        return null;
    }

    public void d(String str) {
        JSONObject c2;
        if (TextUtils.isEmpty(str) || (c2 = c()) == null || !c2.has(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        j1.a(jSONObject, c2);
        jSONObject.remove(str);
        a(jSONObject);
    }

    public String e() {
        return this.d.optString("install_id", "");
    }

    public void e(String str) {
        if (a("ab_sdk_version", (Object) str)) {
            a.a(this.f7659c.f7651c, "ab_sdk_version", str);
        }
    }

    public int f() {
        return this.f.getInt("version_code", 0);
    }

    public void f(String str) {
        synchronized (this) {
            Set<String> c2 = c(this.f7659c.e());
            Set<String> c3 = c(this.d.optString("ab_sdk_version"));
            c3.removeAll(c2);
            c3.addAll(c(str));
            this.f7659c.a(str);
            e(a(c3));
        }
    }

    public String g() {
        return this.d.optString("openudid", "");
    }

    public boolean g(String str) {
        if (a("user_unique_id", (Object) str)) {
            a.a(this.f7659c.f7651c, "user_unique_id", str);
            return true;
        }
        return false;
    }

    public int h() {
        String optString = this.d.optString("device_id", "");
        String optString2 = this.d.optString("install_id", "");
        String optString3 = this.d.optString("bd_did", "");
        if ((j1.a(optString) || j1.a(optString3)) && j1.a(optString2)) {
            return this.f.getInt("version_code", 0) == this.d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public String i() {
        return this.d.optString("ssid", "");
    }

    public String j() {
        return this.d.optString("udid", "");
    }

    public String k() {
        if (this.f7658a) {
            return this.d.optString("user_unique_id", "");
        }
        m0 m0Var = this.f7659c;
        return m0Var != null ? m0Var.f7651c.getString("user_unique_id", null) : "";
    }

    public int l() {
        int optInt = this.f7658a ? this.d.optInt("version_code", -1) : -1;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3 || optInt != -1) {
                break;
            }
            o();
            optInt = this.f7658a ? this.d.optInt("version_code", -1) : -1;
            i = i2 + 1;
        }
        return optInt;
    }

    public String m() {
        String optString = this.f7658a ? this.d.optString("app_version", null) : null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3 || optString != null) {
                break;
            }
            o();
            optString = this.f7658a ? this.d.optString("app_version", null) : null;
            i = i2 + 1;
        }
        return optString;
    }

    public boolean n() {
        return this.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x01c9, code lost:
        if (a(r0) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean o() {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.n0.o():boolean");
    }

    public boolean p() {
        return !this.k;
    }
}

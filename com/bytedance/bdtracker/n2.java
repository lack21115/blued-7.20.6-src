package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.bdtracker.z2;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/n2.class */
public class n2 implements r2 {
    public static String f;
    public static String g;
    public static String h;
    public static JSONArray i;
    public static volatile String j;
    public static String[] k;
    public static String l;

    /* renamed from: a  reason: collision with root package name */
    public final Context f7664a;
    public u1 b;

    /* renamed from: c  reason: collision with root package name */
    public final s1 f7665c;
    public final String d;
    public final m0 e;

    public n2(Context context, m0 m0Var, s1 s1Var) {
        this.e = m0Var;
        this.d = m0Var.b.getLocalTest() ? "_local" : "";
        this.f7664a = context.getApplicationContext();
        m2 m2Var = new m2();
        this.f7665c = s1Var;
        e2 e2Var = new e2(this.f7664a, "snssdk_openudid", m0Var.b.getSpName());
        this.b = e2Var;
        e2Var.f7708a = this.f7665c;
        if (!m0Var.b.getAnonymous()) {
            new Thread(new l2(m2Var)).start();
        }
        a(m0Var.b.getAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String c(String str) {
        return "DeviceParamsProvider#clear clearKey=" + str + " sDeviceId=" + j + " mCacheHandler.loadDeviceId()=" + this.b.c("", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String d(String str) {
        return "DeviceParamsProvider#clearDidAndIid clearKey=" + str + " sDeviceId=" + j + " mCacheHandler.loadDeviceId()=" + this.b.c("", "");
    }

    public String a() {
        if (TextUtils.isEmpty(g)) {
            try {
                SharedPreferences a2 = e2.a(this.f7664a, "snssdk_openudid", 0);
                String string = a2.getString("clientudid", null);
                if (j1.c(string)) {
                    this.f7665c.b(string, null);
                } else {
                    string = UUID.randomUUID().toString();
                    SharedPreferences.Editor edit = a2.edit();
                    edit.putString("clientudid", string);
                    edit.apply();
                }
                String str = string;
                if (!TextUtils.isEmpty(string)) {
                    str = string + this.d;
                }
                g = str;
                return str;
            } catch (Exception e) {
                z2.a(e);
                return "";
            }
        }
        return g;
    }

    public void a(Account account) {
        s1 s1Var = this.f7665c;
        if (s1Var != null) {
            s1Var.a(account);
        }
    }

    public void a(Context context, final String str) {
        StringBuilder sb;
        String str2;
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$n2$SnIi7GS7ZnOoAYaPcgPmTiGJ8rg
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                String d;
                d = n2.this.d(str);
                return d;
            }
        });
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j = null;
        String str3 = "clear_key_prefix" + str;
        SharedPreferences a2 = e2.a(context, this.e.b.getSpName(), 0);
        if (a2.getBoolean(str3, false)) {
            sb = new StringBuilder();
            sb.append("clearKey : ");
            sb.append(str);
            str2 = " : is already cleared";
        } else {
            SharedPreferences.Editor edit = a2.edit();
            edit.putBoolean(str3, true);
            if (a2.contains("device_id")) {
                edit.remove("device_id");
            }
            if (a2.contains("install_id")) {
                edit.remove("install_id");
            }
            edit.apply();
            this.b.a("device_id");
            sb = new StringBuilder();
            sb.append("clearKey : ");
            sb.append(str);
            str2 = " :clear installId and deviceId finish";
        }
        sb.append(str2);
        z2.a(sb.toString());
    }

    public void a(final String str) {
        this.b.a(str);
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$n2$uOGofAH42kklwMzDYtdJ0mnEbgA
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                String c2;
                c2 = n2.this.c(str);
                return c2;
            }
        });
    }

    public String b() {
        if (TextUtils.isEmpty(j)) {
            j = this.b.c("", "");
            return j;
        }
        return j;
    }

    public void b(String str) {
        if (!j1.a(str) || j1.a(str, j)) {
            return;
        }
        j = this.b.c(str, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.n2.c():java.lang.String");
    }

    public String d() {
        if (TextUtils.isEmpty(l)) {
            try {
                String e = this.b.e(null, SensitiveUtils.getSerialNumber(this.f7664a));
                String str = e;
                if (!TextUtils.isEmpty(e)) {
                    str = e + this.d;
                }
                l = str;
                return str;
            } catch (Exception e2) {
                z2.a(e2);
                return null;
            }
        }
        return l;
    }

    public String[] e() {
        String[] strArr = k;
        if (strArr == null || strArr.length <= 0) {
            try {
                String[] a2 = this.b.a((String[]) null, SensitiveUtils.getSimSerialNumbers(this.f7664a));
                String[] strArr2 = a2;
                int i2 = 0;
                if (a2 == null) {
                    strArr2 = new String[0];
                    i2 = 0;
                }
                while (i2 < strArr2.length) {
                    strArr2[i2] = strArr2[i2] + this.d;
                    i2++;
                }
                k = strArr2;
                return strArr2;
            } catch (Exception e) {
                z2.a(e);
                return null;
            }
        }
        return strArr;
    }

    public String f() {
        if (TextUtils.isEmpty(h)) {
            try {
                String f2 = this.b.f(null, this.e.b.isImeiEnable() ? SensitiveUtils.getDeviceId(this.f7664a) : this.e.b.getAppImei());
                String str = f2;
                if (!TextUtils.isEmpty(f2)) {
                    str = f2 + this.d;
                }
                h = str;
                return str;
            } catch (Exception e) {
                z2.a(e);
                return null;
            }
        }
        return h;
    }

    public JSONArray g() {
        JSONArray jSONArray = i;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            if (this.e.b.isImeiEnable()) {
                JSONArray multiImeiFromSystem = SensitiveUtils.getMultiImeiFromSystem(this.f7664a);
                JSONArray jSONArray2 = multiImeiFromSystem;
                if (multiImeiFromSystem == null) {
                    jSONArray2 = SensitiveUtils.getMultiImeiFallback(this.f7664a);
                }
                JSONArray jSONArray3 = new JSONArray(this.b.g(null, jSONArray2.toString()));
                if (!TextUtils.isEmpty(this.d)) {
                    String str = this.d;
                    if (jSONArray3.length() != 0) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= jSONArray3.length()) {
                                break;
                            }
                            JSONObject optJSONObject = jSONArray3.optJSONObject(i3);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    optJSONObject.remove("id");
                                    optJSONObject.put("id", optString + str);
                                }
                            }
                            i2 = i3 + 1;
                        }
                    }
                }
                i = jSONArray3;
                return jSONArray3;
            }
            return new JSONArray();
        } catch (Exception e) {
            z2.a(e);
            return null;
        }
    }
}

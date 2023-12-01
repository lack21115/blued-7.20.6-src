package com.igexin.push.core.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23503a = "MsgSPManager";
    private static final String b = "gx_msg_sp";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23504c = "taskIdList";
    private static final String d = "gx_vendor_token";
    private static final String e = "tokeninfo";
    private static final String f = "usfdl";
    private static final Object h = new Object();
    private static final Object i = new Object();
    private static volatile d j;
    private SharedPreferences g;

    private d(Context context) {
        if (context != null) {
            this.g = context.getSharedPreferences(b, 0);
        }
    }

    public static d a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (j == null) {
            synchronized (d.class) {
                try {
                    if (j == null) {
                        j = new d(applicationContext);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    private void a(String str, Object obj) {
        SharedPreferences.Editor edit = this.g.edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        }
        edit.apply();
    }

    private Object b(String str, Object obj) {
        return obj instanceof String ? this.g.getString(str, (String) obj) : obj;
    }

    private static void b(JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 150) {
                return;
            }
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            String str = null;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                long j3 = jSONObject.getLong(next);
                long j4 = j2;
                String str2 = str;
                if (j2 > j3) {
                    str2 = next;
                    j4 = j3;
                }
                j2 = j4;
                str = str2;
                if (j3 < System.currentTimeMillis() - 432000000) {
                    keys.remove();
                    z = true;
                    j2 = j4;
                    str = str2;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void c(String str) {
        try {
            a(d, str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void c(JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 20) {
                return;
            }
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            String str = null;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                long parseLong = Long.parseLong(jSONObject.getJSONObject(next).getString("timestamp"));
                long j3 = j2;
                String str2 = str;
                if (j2 > parseLong) {
                    str2 = next;
                    j3 = parseLong;
                }
                j2 = j3;
                str = str2;
                if (parseLong < System.currentTimeMillis() - 432000000) {
                    keys.remove();
                    z = true;
                    j2 = j3;
                    str = str2;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private JSONObject d() {
        try {
            String str = (String) b(f23504c, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private JSONObject e() {
        try {
            String str = (String) b(f, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private String f() {
        try {
            return (String) b(d, null);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final JSONObject a() {
        synchronized (h) {
            String str = (String) b(f, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(keys.next());
                if (jSONObject2.has("timestamp")) {
                    if (Long.parseLong(jSONObject2.getString("timestamp")) < System.currentTimeMillis() - 432000000) {
                    }
                }
                keys.remove();
            }
            return jSONObject;
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (h) {
            try {
                JSONObject e2 = e();
                JSONObject jSONObject2 = e2;
                if (e2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject2.length() > 0) {
                    c(jSONObject2);
                }
                jSONObject2.put(str, jSONObject);
                a(f, jSONObject2.toString());
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(e, jSONObject.toString());
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final boolean a(String str) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject d2 = d();
            if (d2 == null || !d2.has(str)) {
                return false;
            }
            com.igexin.c.a.c.a.a("sp task " + str + " already exists", new Object[0]);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public final void b() {
        synchronized (h) {
            try {
                if (this.g != null) {
                    a(f, "");
                }
            }
        }
    }

    public final void b(String str) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (i) {
            try {
                JSONObject d2 = d();
                JSONObject jSONObject = d2;
                if (d2 == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject.length() > 0) {
                    b(jSONObject);
                }
                jSONObject.put(str, System.currentTimeMillis());
                a(f23504c, jSONObject.toString());
            }
        }
    }

    public final JSONObject c() {
        try {
            String valueOf = String.valueOf(b(e, ""));
            return valueOf.isEmpty() ? new JSONObject() : new JSONObject(valueOf);
        } catch (JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            return new JSONObject();
        }
    }
}

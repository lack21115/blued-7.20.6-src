package com.tencent.qimei.o;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qimei.sdk.Qimei;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24687a = com.tencent.qimei.a.b.a(2);
    public static final String b = com.tencent.qimei.a.b.a(3);

    /* renamed from: c  reason: collision with root package name */
    public static final String f24688c = com.tencent.qimei.a.b.a(4);

    public static com.tencent.qimei.i.e a(Context context) {
        com.tencent.qimei.i.e eVar;
        synchronized (k.class) {
            try {
                try {
                    eVar = com.tencent.qimei.i.e.a(context, "Q_V3");
                } catch (Exception e) {
                    e.getMessage();
                    eVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public static Qimei a() {
        String str;
        String a2;
        HashMap hashMap;
        synchronized (k.class) {
            try {
                Context J = com.tencent.qimei.u.d.b().J();
                if (J == null) {
                    a2 = "";
                } else {
                    com.tencent.qimei.i.e a3 = a(J);
                    if (a3 != null) {
                        str = (String) a3.a("Q_V3", "");
                        a3.a();
                        if (!TextUtils.isEmpty(str)) {
                            a2 = str;
                        }
                    }
                    com.tencent.qimei.i.b b2 = com.tencent.qimei.i.b.b();
                    String a4 = b2.a(f24687a, f24688c, "");
                    String str2 = a4;
                    if (TextUtils.isEmpty(a4)) {
                        str2 = b2.a(b, "");
                    }
                    str = str2;
                    if (TextUtils.isEmpty(str2)) {
                        a2 = b2.a(f24687a, "");
                    }
                    a2 = str;
                }
                if (a2 != null && !a2.isEmpty()) {
                    if (TextUtils.isEmpty(a2)) {
                        hashMap = null;
                    } else {
                        HashMap hashMap2 = new HashMap(3);
                        try {
                            JSONObject jSONObject = new JSONObject(a2);
                            Iterator<String> keys = jSONObject.keys();
                            hashMap = hashMap2;
                            if (keys != null) {
                                while (true) {
                                    hashMap = hashMap2;
                                    if (!keys.hasNext()) {
                                        break;
                                    }
                                    String next = keys.next();
                                    hashMap2.put(next, jSONObject.getString(next));
                                }
                            }
                        } catch (JSONException e) {
                            e.getMessage();
                            hashMap2.put("A3", a2);
                            hashMap = hashMap2;
                        }
                    }
                    if (hashMap == null) {
                        return null;
                    }
                    String str3 = (String) hashMap.get("A3");
                    String str4 = (String) hashMap.get("A153");
                    if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                        return null;
                    }
                    Qimei qimei = new Qimei();
                    if (!TextUtils.isEmpty(str3)) {
                        qimei.a(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        qimei.b(str4);
                    }
                    return qimei;
                }
                return null;
            } finally {
            }
        }
    }
}

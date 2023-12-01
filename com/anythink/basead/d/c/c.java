package com.anythink.basead.d.c;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/c/c.class */
public class c {
    private static volatile c b;

    /* renamed from: a  reason: collision with root package name */
    ConcurrentHashMap<String, ArrayList<String>> f5956a = new ConcurrentHashMap<>();

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public final void a(Context context, String str, i iVar, k kVar) {
        synchronized (this) {
            if (iVar.d() == 3 && (kVar instanceof ab)) {
                if (((ab) kVar).X() <= 0) {
                    return;
                }
                ab abVar = (ab) kVar;
                ArrayList<String> arrayList = this.f5956a.get(str);
                ArrayList<String> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<>();
                    try {
                        JSONArray jSONArray = new JSONArray(p.b(context, g.z, str, ""));
                        if (jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= jSONArray.length()) {
                                    break;
                                }
                                arrayList2.add(jSONArray.optString(i2));
                                i = i2 + 1;
                            }
                        }
                    } catch (Exception e) {
                    }
                    this.f5956a.put(str, arrayList2);
                }
                if (arrayList2.size() >= abVar.X()) {
                    arrayList2.remove(arrayList2.size() - 1);
                }
                arrayList2.add(0, iVar.p());
                p.a(context, g.z, str, new JSONArray((Collection) arrayList2).toString());
            }
        }
    }

    public final String[] a(Context context, String str) {
        ArrayList<String> arrayList = this.f5956a.get(str);
        ArrayList<String> arrayList2 = arrayList;
        if (arrayList == null) {
            try {
                JSONArray jSONArray = new JSONArray(p.b(context, g.z, str, ""));
                arrayList2 = arrayList;
                if (jSONArray.length() > 0) {
                    arrayList2 = new ArrayList<>();
                    int i = 0;
                    while (true) {
                        try {
                            int i2 = i;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            arrayList2.add(jSONArray.optString(i2));
                            i = i2 + 1;
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Exception e2) {
                arrayList2 = arrayList;
            }
        }
        if (arrayList2 != null) {
            this.f5956a.put(str, arrayList2);
            String[] strArr = new String[arrayList2.size()];
            arrayList2.toArray(strArr);
            return strArr;
        }
        return null;
    }
}

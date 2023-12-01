package com.tramini.plugin.a.f;

import com.tramini.plugin.a.a.c;
import com.tramini.plugin.a.d.e;
import com.tramini.plugin.b.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26837a = a.class.getSimpleName();
    private static a b;

    /* renamed from: c  reason: collision with root package name */
    private Map<Integer, Runnable> f26838c;

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void a(final int i, final String str, final JSONObject jSONObject, final JSONObject jSONObject2) {
        synchronized (this) {
            com.tramini.plugin.b.a b2 = b.a(c.a().b()).b();
            if (b2 == null) {
                return;
            }
            com.tramini.plugin.a.c.c cVar = b2.e().get(str);
            int i2 = 5000;
            if (cVar != null) {
                int i3 = cVar.b;
                int i4 = cVar.f26812c;
                if (i3 == 0 && i4 == 0) {
                    i2 = 0;
                } else {
                    i2 = i3;
                    if (i3 != i4) {
                        i2 = i3 + new Random().nextInt(i4 - i3);
                    }
                }
            }
            c.a().a(new Runnable() { // from class: com.tramini.plugin.a.f.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    new e(c.a().b(), str, jSONObject, jSONObject2).a(i, new com.tramini.plugin.a.d.b() { // from class: com.tramini.plugin.a.f.a.1.1
                        @Override // com.tramini.plugin.a.d.b
                        public final void a() {
                        }

                        @Override // com.tramini.plugin.a.d.b
                        public final void a(int i5, Object obj) {
                            Runnable runnable;
                            if (2 == i5 && a.this.f26838c != null && (runnable = (Runnable) a.this.f26838c.remove(Integer.valueOf(i5))) != null) {
                                runnable.run();
                            }
                            c.a().b(c.a().b());
                        }

                        @Override // com.tramini.plugin.a.d.b
                        public final void b() {
                            c.a().b(c.a().b());
                        }
                    });
                }
            }, i2);
        }
    }

    public final void a(Runnable runnable) {
        if (this.f26838c == null) {
            this.f26838c = new HashMap(3);
        }
        this.f26838c.put(2, runnable);
    }

    public final void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 14);
            jSONObject.put("setting_id", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(0, str, (JSONObject) null, jSONObject);
    }

    public final void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject2.put("sdk_time", System.currentTimeMillis());
            jSONObject2.put("type", 17);
            jSONObject2.put("setting_id", str2);
        } catch (Throwable th) {
        }
        a(3, str, jSONObject, jSONObject2);
    }

    public final void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        JSONObject jSONObject5 = new JSONObject();
        try {
            jSONObject5.put("sdk_time", System.currentTimeMillis());
            jSONObject5.put("type", 16);
            jSONObject5.put("setting_id", str2);
            jSONObject5.put("it_lps", jSONObject2);
            jSONObject5.put("it_lvn", jSONObject3);
            jSONObject5.put("it_lvc", jSONObject4);
        } catch (Throwable th) {
        }
        a(2, str, jSONObject, jSONObject5);
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        synchronized (this) {
            a(1, str, jSONObject, jSONObject2);
        }
    }
}

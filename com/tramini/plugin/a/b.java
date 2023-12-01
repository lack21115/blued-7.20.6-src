package com.tramini.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tramini.plugin.a.g.a;
import com.tramini.plugin.a.g.h;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b.class */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26796a = b.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        List<String> d;
        intent.getAction();
        final com.tramini.plugin.b.a b = com.tramini.plugin.b.b.a(context).b();
        if (b == null) {
            return;
        }
        com.tramini.plugin.a.g.b.a().a(b);
        if (!(h.a(context) && b.n() == 0) && (d = b.d()) != null && d.size() > 0 && d.contains(intent.getAction())) {
            try {
                final String stringExtra = intent.getStringExtra(b.f());
                final String stringExtra2 = intent.getStringExtra(b.g());
                intent.getStringExtra(b.h());
                final String stringExtra3 = intent.getStringExtra(b.i());
                String stringExtra4 = intent.getStringExtra(b.j());
                String stringExtra5 = intent.getStringExtra(b.l());
                final int intExtra = intent.getIntExtra(b.m(), 0);
                com.tramini.plugin.a.g.a.a(b, stringExtra3, stringExtra5, stringExtra4, new a.InterfaceC0902a() { // from class: com.tramini.plugin.a.b.1
                    @Override // com.tramini.plugin.a.g.a.InterfaceC0902a
                    public final void a(final com.tramini.plugin.a.c.a aVar) {
                        int i;
                        if (aVar != null || (i = intExtra) == 18 || i == 19 || i == 20) {
                            com.tramini.plugin.a.a.c.a();
                            com.tramini.plugin.a.a.c.a(new Runnable() { // from class: com.tramini.plugin.a.b.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        JSONObject jSONObject = new JSONObject(stringExtra2);
                                        if (aVar != null && aVar.f26807a != null) {
                                            JSONObject jSONObject2 = aVar.f26807a;
                                            Iterator<String> keys = jSONObject2.keys();
                                            while (keys.hasNext()) {
                                                String next = keys.next();
                                                jSONObject.put(next, jSONObject2.optString(next));
                                            }
                                            jSONObject.put("setting_id", b.b());
                                        } else if (aVar != null && aVar.b != null) {
                                            jSONObject.put("type", 10001);
                                            jSONObject.put("i_t", aVar.b.f26808a);
                                            if (!TextUtils.isEmpty(aVar.b.b)) {
                                                jSONObject.put("i_al", com.tramini.plugin.a.g.c.a(aVar.b.b.getBytes()));
                                            }
                                        } else if (intExtra != 18 && intExtra != 19 && intExtra != 20) {
                                            return;
                                        }
                                        com.tramini.plugin.a.f.a.a().a(stringExtra3, new JSONObject(stringExtra), jSONObject);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                });
            } catch (Throwable th) {
            }
        }
    }
}

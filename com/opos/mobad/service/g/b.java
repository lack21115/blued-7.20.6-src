package com.opos.mobad.service.g;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/g/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.opos.mobad.provider.monitor.a f27372a;

    public static final a a() {
        return new a();
    }

    public static final String a(Context context, String str, a aVar) {
        return com.opos.cmn.biz.monitor.a.a().b(context.getApplicationContext(), str, aVar.a());
    }

    public static final void a(Context context, List<String> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        b(context, list, null);
    }

    public static final void a(Context context, List<String> list, MonitorEvent monitorEvent) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        b(context, list, monitorEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.opos.mobad.provider.monitor.a b(Context context) {
        com.opos.mobad.provider.monitor.a aVar;
        com.opos.mobad.provider.monitor.a aVar2 = f27372a;
        if (aVar2 == null) {
            synchronized (b.class) {
                try {
                    com.opos.mobad.provider.monitor.a aVar3 = f27372a;
                    aVar = aVar3;
                    if (aVar3 == null) {
                        aVar = new com.opos.mobad.provider.monitor.a(context.getApplicationContext());
                        f27372a = aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    private static final void b(final Context context, final List<String> list, final MonitorEvent monitorEvent) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.g.b.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : List.this) {
                    try {
                        b.b(context).a(str, monitorEvent);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("", "monitor fail");
                    }
                }
            }
        });
    }
}

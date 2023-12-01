package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.fw;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/b.class */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private String value;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/b$a.class */
    static final class a {
        private static final b axP = new b((byte) 0);
    }

    private b() {
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b Ck() {
        return a.axP;
    }

    private static com.kwad.sdk.ranger.a.kwai.c X(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.ranger.a.kwai.c cVar = new com.kwad.sdk.ranger.a.kwai.c();
        cVar.name = str;
        cVar.ayF = str2;
        return cVar;
    }

    static /* synthetic */ com.kwad.sdk.ranger.a.kwai.c a(b bVar, String str, String str2) {
        return X(str, str2);
    }

    private static Object a(com.kwad.sdk.ranger.kwai.a aVar, boolean z, Class<?> cls) {
        Object[] Cu = aVar.ays.Cu();
        return (Cu == null || Cu.length == 0) ? z ? s.b(cls, aVar.ays.name, new Object[0]) : s.a(aVar.ayn, aVar.ays.name, new Object[0]) : z ? s.b(cls, aVar.ays.name, Cu) : s.a(aVar.ayn, aVar.ays.name, Cu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.ranger.kwai.a aVar) {
        com.kwad.sdk.ranger.kwai.a aVar2;
        Object b;
        if (aVar.ayt != null && !aVar.ayt.Cr()) {
            if (TextUtils.isEmpty(aVar.ayp)) {
                if (aVar.ays != null && !aVar.ays.Cr()) {
                    aVar2 = aVar.ayt;
                    b = b(aVar);
                }
                a(aVar.ayt);
            }
            aVar2 = aVar.ayt;
            b = c(aVar);
            aVar2.ayn = b;
            a(aVar.ayt);
        } else if (!TextUtils.isEmpty(aVar.ayp)) {
            g(c(aVar));
        } else if (aVar.ays != null && !aVar.ays.Cr()) {
            g(b(aVar));
        } else {
            String str = TAG;
            com.kwad.sdk.core.d.b.d(str, "node.nodeClassName:" + aVar.ayo);
            this.value = s.ez(aVar.ayo) ? fw.Code : "false";
        }
    }

    private Object b(com.kwad.sdk.ranger.kwai.a aVar) {
        Object obj = null;
        if (aVar.ays.ayB) {
            try {
                Class<?> cls = !TextUtils.isEmpty(aVar.ayo) ? Class.forName(aVar.ayo) : aVar.ayn != null ? aVar.ayn.getClass() : null;
                if (cls != null) {
                    return a(aVar, true, cls);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.w(TAG, Log.getStackTraceString(e));
                return null;
            }
        } else if (aVar.ayn != null) {
            obj = a(aVar, false, (Class<?>) null);
        }
        return obj;
    }

    private static Object c(com.kwad.sdk.ranger.kwai.a aVar) {
        if (!aVar.ayq) {
            if (aVar.ayn != null) {
                return s.d(aVar.ayn, aVar.ayp);
            }
            return null;
        }
        try {
            return s.c(Class.forName(aVar.ayo), aVar.ayp);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.w(TAG, Log.getStackTraceString(e));
            return null;
        }
    }

    private void g(Object obj) {
        String str;
        if (obj != null) {
            str = String.valueOf(obj);
        } else {
            com.kwad.sdk.core.d.b.w(TAG, "value is null by ob null");
            str = "";
        }
        this.value = str;
    }

    public final void b(d dVar) {
        if (dVar == null || dVar.axX == null || dVar.axX.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.ranger.kwai.a> list = dVar.axX;
        g.schedule(new aw() { // from class: com.kwad.sdk.ranger.b.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.ranger.kwai.a aVar : list) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.ayr)) {
                        String str = aVar.ayr;
                        b.this.a(aVar);
                        b bVar = b.this;
                        com.kwad.sdk.ranger.a.kwai.c a2 = b.a(bVar, str, bVar.value);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.ranger.a.kwai.d dVar2 = new com.kwad.sdk.ranger.a.kwai.d();
                dVar2.ayG = arrayList;
                com.kwad.sdk.ranger.a.a.a(dVar2);
            }
        }, 120L, TimeUnit.SECONDS);
    }
}

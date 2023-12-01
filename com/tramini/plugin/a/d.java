package com.tramini.plugin.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tramini.plugin.a.g.g;
import com.tramini.plugin.a.g.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40506a = d.class.getSimpleName();
    private static volatile d b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f40507c;
    private final int d = 500;
    private Map<String, com.tramini.plugin.a.c.d> e;
    private Set<com.tramini.plugin.a.c.d> f;
    private PackageManager g;

    private d(Context context) {
        this.f40507c = context;
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                try {
                    if (b == null) {
                        b = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    static /* synthetic */ void a(d dVar, Set set, Set set2) {
        if (dVar.f40507c == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            com.tramini.plugin.a.c.d dVar2 = (com.tramini.plugin.a.c.d) it.next();
            dVar2.f40505c = System.currentTimeMillis();
            com.tramini.plugin.a.b.e.b(com.tramini.plugin.a.b.d.a(dVar.f40507c)).a(dVar2);
            dVar.e.put(dVar2.f40504a, dVar2);
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            com.tramini.plugin.a.c.d dVar3 = (com.tramini.plugin.a.c.d) it2.next();
            com.tramini.plugin.a.b.e.b(com.tramini.plugin.a.b.d.a(dVar.f40507c)).b(dVar3);
            dVar.e.remove(dVar3.f40504a);
        }
        int size = dVar.e.size() - 500;
        if (size <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.tramini.plugin.a.c.d> entry : dVar.e.entrySet()) {
            arrayList.add(entry.getValue());
        }
        Collections.sort(arrayList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            com.tramini.plugin.a.c.d dVar4 = (com.tramini.plugin.a.c.d) arrayList.get(i2);
            com.tramini.plugin.a.b.e.b(com.tramini.plugin.a.b.d.a(dVar.f40507c)).b(dVar4);
            dVar.e.remove(dVar4.f40504a);
            i = i2 + 1;
        }
    }

    private void a(com.tramini.plugin.b.a aVar, final Set<com.tramini.plugin.a.c.d> set, final Set<com.tramini.plugin.a.c.d> set2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        for (com.tramini.plugin.a.c.d dVar : set) {
            try {
                jSONObject.put(dVar.f40504a, 1);
            } catch (JSONException e) {
            }
            try {
                PackageInfo packageInfo = this.g.getPackageInfo(com.tramini.plugin.a.g.c.a(dVar.b), 0);
                String str = packageInfo.versionName;
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                jSONObject2.put(dVar.f40504a, str);
                jSONObject3.put(dVar.f40504a, String.valueOf(longVersionCode));
            } catch (Throwable th) {
            }
        }
        for (com.tramini.plugin.a.c.d dVar2 : set2) {
            try {
                jSONObject.put(dVar2.f40504a, 2);
            } catch (JSONException e2) {
            }
        }
        String a2 = g.a(aVar);
        com.tramini.plugin.a.f.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this, set, set2);
            }
        });
        com.tramini.plugin.a.f.a.a().a(a2, aVar.b(), com.tramini.plugin.a.g.d.f40545a, jSONObject, jSONObject2, jSONObject3);
    }

    private void a(Set<com.tramini.plugin.a.c.d> set) {
        if (set == null) {
            return;
        }
        for (com.tramini.plugin.a.c.d dVar : set) {
            dVar.f40505c = System.currentTimeMillis();
            com.tramini.plugin.a.b.c.a(com.tramini.plugin.a.b.d.a(this.f40507c)).a(dVar);
            this.f.add(dVar);
        }
    }

    private void a(Set<com.tramini.plugin.a.c.d> set, Set<com.tramini.plugin.a.c.d> set2, Set<com.tramini.plugin.a.c.d> set3, Set<String> set4) {
        for (com.tramini.plugin.a.c.d dVar : set) {
            if (a(com.tramini.plugin.a.g.c.a(dVar.b))) {
                if (!set4.contains(dVar.f40504a)) {
                    set2.add(dVar);
                    set4.add(dVar.f40504a);
                }
            } else if (set4.contains(dVar.f40504a)) {
                set3.add(dVar);
                set4.remove(dVar.f40504a);
            }
        }
    }

    private boolean a(String str) {
        if (this.g == null) {
            this.g = this.f40507c.getPackageManager();
        }
        try {
            this.g.getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public final void a() {
        int c2 = com.tramini.plugin.a.a.c.a().c() + 1;
        com.tramini.plugin.a.a.c.a().a(c2);
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Context context = this.f40507c;
        i.a(context, "tramini", "P_IL_O", format + "-" + c2);
    }

    public final void a(com.tramini.plugin.b.a aVar, Set<com.tramini.plugin.a.c.d> set) {
        if (this.f40507c == null || com.tramini.plugin.a.g.d.f40545a == null) {
            return;
        }
        String k = aVar.k();
        if (TextUtils.isEmpty(k)) {
            return;
        }
        String[] split = k.split(":");
        if (split.length >= 2 && i.a(this.f40507c, split[0], split[1]) != 1) {
            if (this.e == null) {
                this.e = new HashMap();
            }
            if (this.f == null) {
                this.f = new HashSet();
            }
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet(this.e.keySet());
            a(set);
            a(this.f, hashSet, hashSet2, hashSet3);
            if (hashSet.size() == 0 && hashSet2.size() == 0) {
                return;
            }
            a(aVar, hashSet, hashSet2);
        }
    }

    public final void a(boolean z) {
        Context context = this.f40507c;
        if (context == null) {
            return;
        }
        if (this.e == null) {
            this.e = com.tramini.plugin.a.b.e.b(com.tramini.plugin.a.b.d.a(context)).e();
        }
        if (z || this.f != null) {
            com.tramini.plugin.a.b.c.a(com.tramini.plugin.a.b.d.a(this.f40507c)).d();
        } else {
            this.f = com.tramini.plugin.a.b.c.a(com.tramini.plugin.a.b.d.a(this.f40507c)).c();
        }
    }
}

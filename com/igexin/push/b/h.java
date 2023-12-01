package com.igexin.push.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.security.KeyChain;
import android.text.TextUtils;
import com.igexin.push.b.a;
import com.igexin.push.b.b;
import com.igexin.push.b.e;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.d;
import com.tencent.tendinsv.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/h.class */
public abstract class h {
    private static final String e = b.f23300a + h.class.getName();

    /* renamed from: a  reason: collision with root package name */
    protected long f23315a;
    private Handler i;
    protected final Map<String, e> b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    protected final Map<String, d> f23316c = new HashMap();
    private final Object f = new Object();
    private final Object g = new Object();
    protected a d = new a();
    private final Comparator<Map.Entry<String, d>> h = new Comparator<Map.Entry<String, d>>() { // from class: com.igexin.push.b.h.1
        private static int a(Map.Entry<String, d> entry, Map.Entry<String, d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Map.Entry<String, d> entry, Map.Entry<String, d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.h.<init>(java.lang.String, java.lang.String):void");
    }

    private static d a(JSONObject jSONObject) throws Exception {
        if (jSONObject.has("domain")) {
            d dVar = new d();
            dVar.a(jSONObject.getString("domain"));
            if (jSONObject.has(KeyChain.EXTRA_PORT)) {
                dVar.b = jSONObject.getInt(KeyChain.EXTRA_PORT);
            }
            if (jSONObject.has(b.a.q)) {
                dVar.f23308a = jSONObject.getString(b.a.q);
            }
            if (jSONObject.has("consumeTime")) {
                dVar.f23309c = jSONObject.getLong("consumeTime");
            }
            if (jSONObject.has("detectSuccessTime")) {
                dVar.d = jSONObject.getLong("detectSuccessTime");
            }
            if (jSONObject.has("isDomain")) {
                dVar.e = jSONObject.getBoolean("isDomain");
            }
            return dVar;
        }
        return null;
    }

    private static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                arrayList.add(jSONArray.getJSONObject(i2).getString("domain"));
                i = i2 + 1;
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        return arrayList;
    }

    private void a() {
        this.f23315a = 0L;
        if (r()) {
            if (com.igexin.push.core.e.ap != null) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.l, true);
            }
        } else if (com.igexin.push.core.e.aq != null) {
            com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.l, false);
        }
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        ArrayList arrayList = new ArrayList();
        for (String str : defaultXfrList) {
            d dVar = new d(str, Integer.parseInt(com.igexin.c.a.b.g.a(str)[2]));
            if (defaultXfrList.size() > 1) {
                b(dVar);
            }
            arrayList.add(dVar);
        }
        this.d.b(arrayList);
        defaultXfrList.clear();
    }

    private static List<String> b() {
        return SDKUrlConfig.getDefaultXfrList();
    }

    private void b(d dVar) {
        e eVar = new e();
        eVar.d = c() == b.EnumC0449b.f23304a;
        eVar.a(d());
        eVar.b = dVar;
        synchronized (this.g) {
            this.b.put(dVar.a(), eVar);
        }
    }

    private void b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            a();
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            a();
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.f23315a = jSONObject.getLong("lastDetectTime");
            } catch (JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (Math.abs(System.currentTimeMillis() - this.f23315a) >= b.f23301c) {
            a();
            return;
        }
        JSONArray jSONArray = null;
        if (jSONObject.has("list")) {
            try {
                jSONArray = jSONObject.getJSONArray("list");
            } catch (JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
                jSONArray = null;
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            a();
            return;
        }
        List<String> a2 = a(jSONArray);
        if (a2.isEmpty()) {
            a();
            return;
        }
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        ArrayList arrayList = new ArrayList(defaultXfrList);
        arrayList.retainAll(a2);
        if (arrayList.size() == a2.size()) {
            com.igexin.c.a.c.a.a(e, "db cache xfr == default, use cache");
            com.igexin.c.a.c.a.a(e + " | db cache xfr == default, use cache", new Object[0]);
            b(jSONArray);
            return;
        }
        com.igexin.c.a.c.a.a(e, "db cache xfr != default, use default");
        com.igexin.c.a.c.a.a(e + " | db cache xfr != default, use default", new Object[0]);
        arrayList.clear();
        defaultXfrList.clear();
        a2.clear();
        a();
    }

    private void b(JSONArray jSONArray) {
        d dVar;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    this.d.b(arrayList);
                    return;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.has("domain")) {
                    d dVar2 = new d();
                    dVar2.a(jSONObject.getString("domain"));
                    if (jSONObject.has(KeyChain.EXTRA_PORT)) {
                        dVar2.b = jSONObject.getInt(KeyChain.EXTRA_PORT);
                    }
                    if (jSONObject.has(b.a.q)) {
                        dVar2.f23308a = jSONObject.getString(b.a.q);
                    }
                    if (jSONObject.has("consumeTime")) {
                        dVar2.f23309c = jSONObject.getLong("consumeTime");
                    }
                    if (jSONObject.has("detectSuccessTime")) {
                        dVar2.d = jSONObject.getLong("detectSuccessTime");
                    }
                    dVar = dVar2;
                    if (jSONObject.has("isDomain")) {
                        dVar2.e = jSONObject.getBoolean("isDomain");
                        dVar = dVar2;
                    }
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    this.f23316c.put(dVar.a(), dVar);
                } else {
                    try {
                        dVar = d(jSONObject.getString("domain"));
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e2.toString(), new Object[0]);
                        this.f23316c.clear();
                        a();
                        return;
                    }
                }
                if (dVar != null) {
                    b(dVar);
                    arrayList.add(dVar);
                }
                i = i2 + 1;
            } catch (Exception e3) {
                com.igexin.c.a.c.a.a(e3);
                com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e3.toString(), new Object[0]);
                return;
            }
        }
    }

    private void c(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("loginFailedlCnt")) {
            try {
                this.d.g = jSONObject.getInt("loginFailedlCnt");
            } catch (JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (jSONObject.has("lastChange2BackupTime")) {
            try {
                this.d.h = jSONObject.getLong("lastChange2BackupTime");
            } catch (JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONObject.has("lastOfflineTime")) {
            try {
                this.d.i = jSONObject.getLong("lastOfflineTime");
            } catch (JSONException e5) {
                com.igexin.c.a.c.a.a(e5);
            }
        }
        if (jSONObject.has("domainType")) {
            try {
                this.d.e = a.EnumC0448a.a(jSONObject.getInt("domainType"));
                if (this.d.e == a.EnumC0448a.BACKUP) {
                    this.d.f.set(true);
                }
            } catch (JSONException e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
    }

    private static d d(String str) {
        d dVar = new d();
        String[] a2 = com.igexin.c.a.b.g.a(str);
        dVar.a(str);
        dVar.b = Integer.parseInt(a2[2]);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void k() {
        com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.l, true);
        com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.l, false);
    }

    private void p() {
        synchronized (this.f) {
            this.f23316c.clear();
        }
    }

    private boolean q() {
        long abs = Math.abs(System.currentTimeMillis() - this.f23315a);
        if (abs >= (b.f23301c * 2) - com.anythink.expressad.d.a.b.P) {
            long j = b.f23301c;
            com.igexin.c.a.c.a.a(e + "|current time - last detect time > " + (b.f23301c / 1000) + " s, detect = true", new Object[0]);
            f.f23313a.set(true);
            return true;
        } else if (f.f23313a.getAndSet(true)) {
            return false;
        } else {
            long abs2 = Math.abs(b.f23301c - abs);
            f.g().a(abs2, TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(e + "|set next detect time = " + abs2, new Object[0]);
            return false;
        }
    }

    private boolean r() {
        return c() == b.EnumC0449b.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e a(String str) {
        Map.Entry<String, e> next;
        synchronized (this.g) {
            Iterator<Map.Entry<String, e>> it = this.b.entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!next.getKey().equals(str));
            return next.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(d dVar) {
        synchronized (this.f) {
            this.f23316c.put(dVar.a(), dVar);
        }
        a aVar = this.d;
        synchronized (aVar.d) {
            aVar.b = 0;
            Collections.sort(aVar.f23294c, aVar.k);
        }
    }

    public abstract int c();

    public abstract i d();

    public final void e() {
        long abs = Math.abs(System.currentTimeMillis() - this.f23315a);
        boolean z = true;
        if (abs >= (b.f23301c * 2) - com.anythink.expressad.d.a.b.P) {
            long j = b.f23301c;
            com.igexin.c.a.c.a.a(e + "|current time - last detect time > " + (b.f23301c / 1000) + " s, detect = true", new Object[0]);
            f.f23313a.set(true);
        } else {
            if (!f.f23313a.getAndSet(true)) {
                long abs2 = Math.abs(b.f23301c - abs);
                f.g().a(abs2, TimeUnit.MILLISECONDS);
                com.igexin.c.a.c.a.a(e + "|set next detect time = " + abs2, new Object[0]);
            }
            z = false;
        }
        if (!z) {
            com.igexin.c.a.c.a.a(e + "|startDetect detect = false, return !!!", new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a(e + "|startDetect detect = true, start detect !!!", new Object[0]);
        i();
    }

    public final void f() {
        synchronized (this.g) {
            for (Map.Entry<String, e> entry : this.b.entrySet()) {
                entry.getValue().a((i) null);
                entry.getValue().a();
            }
        }
    }

    public final void g() {
        f();
        p();
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            int size = this.b.size();
            if (defaultXfrList.size() < size) {
                int size2 = defaultXfrList.size();
                Iterator<Map.Entry<String, e>> it = this.b.entrySet().iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (!it.hasNext() || i2 >= size - size2) {
                        break;
                    }
                    it.next().getValue().b();
                    it.remove();
                    i = i2 + 1;
                }
            }
            ArrayList arrayList = new ArrayList(this.b.values());
            this.b.clear();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < defaultXfrList.size()) {
                    d dVar = new d();
                    String[] a2 = com.igexin.c.a.b.g.a(defaultXfrList.get(i4));
                    dVar.a(defaultXfrList.get(i4));
                    dVar.b = Integer.parseInt(a2[2]);
                    if (i4 < size) {
                        e eVar = (e) arrayList.get(i4);
                        eVar.b = dVar;
                        this.b.put(dVar.a(), eVar);
                    } else {
                        b(dVar);
                    }
                    arrayList2.add(dVar);
                    i3 = i4 + 1;
                } else {
                    this.d.b(arrayList2);
                }
            }
        }
    }

    public final void h() {
        f();
        p();
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            for (Map.Entry<String, e> entry : this.b.entrySet()) {
                entry.getValue().b();
            }
            this.b.clear();
            ArrayList arrayList = new ArrayList();
            d dVar = new d();
            String[] a2 = com.igexin.c.a.b.g.a(defaultXfrList.get(0));
            dVar.a(defaultXfrList.get(0));
            dVar.b = Integer.parseInt(a2[2]);
            arrayList.add(dVar);
            this.d.b(arrayList);
            arrayList.clear();
        }
    }

    public final void i() {
        this.f23315a = System.currentTimeMillis();
        synchronized (this.g) {
            for (Map.Entry<String, e> entry : this.b.entrySet()) {
                entry.getValue().a(d());
                if (entry.getValue().b != null) {
                    entry.getValue().b.b();
                }
                e value = entry.getValue();
                synchronized (i.class) {
                    if (value.f23311c != null) {
                        value.f23310a = com.igexin.b.a.a().f23194a.submit(new e.AnonymousClass1());
                    }
                }
            }
        }
    }

    public final void j() {
        synchronized (this) {
            this.f23315a = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.g) {
                try {
                    jSONObject.put("lastDetectTime", this.f23315a);
                    jSONObject.put("list", jSONArray);
                    for (Map.Entry<String, e> entry : this.b.entrySet()) {
                        JSONObject f = entry.getValue().b.f();
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    }
                } catch (Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
            if (jSONObject.length() > 0) {
                if (r()) {
                    com.igexin.push.core.e.f.a().b(jSONObject.toString(), true);
                    return;
                }
                com.igexin.push.core.e.f.a().b(jSONObject.toString(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        synchronized (this) {
            a aVar = this.d;
            a.EnumC0448a enumC0448a = aVar.e;
            com.igexin.c.a.c.a.a(a.f23293a + "|detect success, current type = " + aVar.e, new Object[0]);
            if (aVar.e == a.EnumC0448a.BACKUP) {
                aVar.a(a.EnumC0448a.TRY_NORMAL);
                com.igexin.push.core.d unused = d.a.f23474a;
                com.igexin.push.d.a.a(true);
            }
        }
    }

    public final void m() {
        synchronized (h.class) {
            try {
                if (this.i == null) {
                    HandlerThread handlerThread = new HandlerThread("NetDetect-T");
                    handlerThread.start();
                    this.i = new Handler(handlerThread.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.i.removeCallbacksAndMessages("detToken");
        this.i.postAtTime(new Runnable() { // from class: com.igexin.push.b.h.2
            @Override // java.lang.Runnable
            public final void run() {
                String unused = h.e;
                try {
                    h.this.j();
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
            }
        }, "detToken", SystemClock.uptimeMillis() + 5000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loginFailedlCnt", this.d.g);
                jSONObject.put("lastChange2BackupTime", this.d.h);
                jSONObject.put("lastOfflineTime", this.d.i);
                jSONObject.put("domainType", this.d.e.d);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            if (jSONObject.length() > 0) {
                if (r()) {
                    com.igexin.push.core.e.f.a().a(jSONObject.toString(), true);
                    return;
                }
                com.igexin.push.core.e.f.a().a(jSONObject.toString(), false);
            }
        }
    }
}

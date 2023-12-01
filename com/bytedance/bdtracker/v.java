package com.bytedance.bdtracker;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.util.UriConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/v.class */
public class v implements Handler.Callback, Comparator<t1> {
    public final f A;
    public final h0 B;

    /* renamed from: a  reason: collision with root package name */
    public s f21324a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public c f21325c;
    public m0 d;
    public u e;
    public volatile w1 g;
    public n0 h;
    public volatile Handler i;
    public x j;
    public y k;
    public volatile r l;
    public UriConfig n;
    public Handler o;
    public long p;
    public volatile boolean q;
    public t r;
    public volatile w s;
    public volatile boolean u;
    public volatile long v;
    public volatile a0 x;
    public volatile InitConfig.IpcDataChecker y;
    public final n1 z;
    public final ArrayList<t1> f = new ArrayList<>(32);
    public CopyOnWriteArrayList<t> t = new CopyOnWriteArrayList<>();
    public final List<a> w = new ArrayList();
    public z m = new z(this);

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/v$a.class */
    public abstract class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f21326a;

        public a(v vVar, T t) {
            this.f21326a = t;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/v$b.class */
    public class b extends a<String> {
        public b(String str) {
            super(v.this, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public v(com.bytedance.bdtracker.c r7, com.bytedance.bdtracker.m0 r8, com.bytedance.bdtracker.n0 r9, com.bytedance.bdtracker.h0 r10) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.v.<init>(com.bytedance.bdtracker.c, com.bytedance.bdtracker.m0, com.bytedance.bdtracker.n0, com.bytedance.bdtracker.h0):void");
    }

    public Context a() {
        return this.f21325c.m;
    }

    public void a(t1 t1Var) {
        int size;
        if (t1Var.b == 0) {
            z2.c("U SHALL NOT PASS!", (Throwable) null);
        }
        synchronized (this.f) {
            size = this.f.size();
            this.f.add(t1Var);
        }
        boolean z = t1Var instanceof c2;
        if (size % 10 == 0 || z) {
            this.o.removeMessages(4);
            if (z || size != 0) {
                this.o.sendEmptyMessage(4);
            } else {
                this.o.sendEmptyMessageDelayed(4, 300L);
            }
        }
    }

    public final void a(t tVar) {
        if (this.i == null || tVar == null || this.f21325c.v) {
            return;
        }
        tVar.i();
        if (Looper.myLooper() == this.i.getLooper()) {
            tVar.a();
            return;
        }
        this.i.removeMessages(6);
        this.i.sendEmptyMessage(6);
    }

    public void a(String str) {
        String k = this.h.k();
        if ((!TextUtils.isEmpty(str) || TextUtils.isEmpty(k)) && (TextUtils.isEmpty(str) || TextUtils.equals(str, k))) {
            return;
        }
        if (this.i == null) {
            synchronized (this.w) {
                this.w.add(new b(str));
            }
            return;
        }
        c2 a2 = o.a();
        c2 c2Var = a2;
        if (a2 != null) {
            c2Var = (c2) a2.m5742clone();
            c2Var.k = this.f21325c.l;
        }
        Message obtainMessage = this.i.obtainMessage(12, new Object[]{str, c2Var});
        this.i.removeMessages(12);
        if (c2Var == null || TextUtils.isEmpty(this.m.m)) {
            this.i.sendMessageDelayed(obtainMessage, 300L);
        } else {
            obtainMessage.sendToTarget();
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.z.a(jSONObject);
    }

    public void a(String[] strArr, boolean z) {
        ArrayList arrayList;
        ArrayList<t1> a2;
        x xVar;
        InitConfig initConfig;
        m0 m0Var = this.d;
        boolean z2 = (m0Var == null || (initConfig = m0Var.b) == null || initConfig.isTrackEventEnabled()) ? false : true;
        if (this.f21325c.v || z2) {
            return;
        }
        synchronized (this.f) {
            arrayList = (ArrayList) this.f.clone();
            this.f.clear();
        }
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                arrayList.add(t1.a(strArr[i2]));
                i = i2 + 1;
            }
        }
        if (!arrayList.isEmpty()) {
            boolean isEventFilterEnable = this.d.b.isEventFilterEnable();
            a0 a0Var = this.x;
            a0 a0Var2 = this.f21325c.u;
            if ((isEventFilterEnable && a0Var != null) || a0Var2 != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    t1 t1Var = (t1) it.next();
                    if (t1Var instanceof z1) {
                        z1 z1Var = (z1) t1Var;
                        String str = z1Var.r;
                        String d = z1Var.d();
                        if (a0Var2 != null) {
                            if (!a0Var2.a(str, d)) {
                                it.remove();
                            }
                        }
                        if (a0Var != null && !a0Var.a(str, d)) {
                            it.remove();
                        }
                    } else if (t1Var instanceof x1) {
                        x1 x1Var = (x1) t1Var;
                        if (a0Var2 != null && !a0Var2.a(x1Var.q, x1Var.s)) {
                            it.remove();
                        }
                    }
                }
            }
        }
        boolean a3 = this.d.a((List<t1>) arrayList);
        if (arrayList.size() > 0) {
            if (!this.d.i()) {
                Intent intent = new Intent(this.f21325c.m, Collector.class);
                int size = arrayList.size();
                String[] strArr2 = new String[size];
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= size) {
                        break;
                    }
                    strArr2[i5] = ((t1) arrayList.get(i5)).g().toString();
                    i3 += strArr2[i5].length();
                    i4 = i5 + 1;
                }
                boolean z3 = true;
                if (i3 >= 307200) {
                    z3 = true;
                    if (this.y != null) {
                        try {
                            z3 = this.y.checkIpcData(strArr2);
                        } catch (Throwable th) {
                            z2.b("check ipc data", th);
                            z3 = true;
                        }
                        z2.c("U SHALL NOT PASS!", (Throwable) null);
                    }
                }
                if (z3) {
                    intent.putExtra("K_DATA", strArr2);
                    this.f21325c.m.sendBroadcast(intent);
                }
            } else if (a3 || arrayList.size() > 100) {
                Collections.sort(arrayList, this);
                ArrayList<t1> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator it2 = arrayList.iterator();
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                while (it2.hasNext()) {
                    t1 t1Var2 = (t1) it2.next();
                    boolean a4 = z4 | this.m.a(this.f21325c, t1Var2, arrayList2);
                    boolean z7 = z5;
                    boolean z8 = z6;
                    if (t1Var2 instanceof c2) {
                        z8 = z.a(t1Var2);
                        z7 = true;
                    }
                    if (t1Var2 != null && (xVar = this.j) != null) {
                        String str2 = xVar.g;
                        if (!j1.a(t1Var2.f, str2)) {
                            JSONObject jSONObject = t1Var2.e() == null ? new JSONObject() : t1Var2.e();
                            try {
                                jSONObject.put("applog_pending_ssid_uuid", str2);
                                t1Var2.b(jSONObject);
                            } catch (Throwable th2) {
                                z2.a(th2);
                            }
                        }
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        z4 = a4;
                        z5 = z7;
                        z6 = z8;
                        if (this.i != null) {
                            this.i.obtainMessage(16, t1Var2).sendToTarget();
                            z4 = a4;
                            z5 = z7;
                            z6 = z8;
                        }
                    } else {
                        b(t1Var2);
                        z4 = a4;
                        z5 = z7;
                        z6 = z8;
                    }
                }
                String[] realUris = c().getRealUris();
                if (this.i != null && realUris != null && realUris.length > 0 && System.currentTimeMillis() - this.p > 900000 && (a2 = this.d.a(arrayList2)) != null && a2.size() > 0) {
                    this.i.obtainMessage(8, a2).sendToTarget();
                }
                b().b(arrayList2);
                if (z5) {
                    Handler handler = this.o;
                    if (z6) {
                        handler.removeMessages(7);
                    } else {
                        handler.sendEmptyMessageDelayed(7, this.d.g());
                    }
                }
                if (z4) {
                    a(this.k);
                }
                if (!this.b && this.m.i && this.i != null && this.d.b.isAutoActive()) {
                    a(false);
                }
            } else {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    a((t1) it3.next());
                }
            }
        }
        if (z && this.d.i()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.v) > 10000) {
                this.v = currentTimeMillis;
                a(this.k);
            }
        }
    }

    public final boolean a(ArrayList<t1> arrayList) {
        boolean z = true;
        String[] a2 = this.f21325c.i.a(this, this.h.d(), true, 0);
        JSONObject a3 = j1.a(this.h.d());
        if (a2.length > 0) {
            c cVar = this.f21325c;
            int a4 = cVar.j.a(a2, b2.a(cVar, arrayList, a3), this.d);
            if (a4 == 200) {
                this.p = 0L;
                z2.a("sendRealTime, " + z);
                return z;
            } else if (q1.a(a4)) {
                this.p = System.currentTimeMillis();
            }
        }
        z = false;
        z2.a("sendRealTime, " + z);
        return z;
    }

    public boolean a(boolean z) {
        if ((!this.b || z) && this.i != null) {
            this.b = true;
            this.i.removeMessages(11);
            this.i.sendEmptyMessage(11);
        }
        return this.b;
    }

    public w1 b() {
        if (this.g == null) {
            synchronized (this) {
                w1 w1Var = this.g;
                w1 w1Var2 = w1Var;
                if (w1Var == null) {
                    w1Var2 = new w1(this, this.d.b.getDbName());
                }
                this.g = w1Var2;
            }
        }
        return this.g;
    }

    public void b(t1 t1Var) {
        w wVar = this.s;
        if (((t1Var instanceof z1) || (t1Var instanceof d2)) && wVar != null) {
            this.f21325c.j.a(t1Var.h(), wVar.g);
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.z.b(jSONObject);
    }

    public UriConfig c() {
        if (this.n == null) {
            UriConfig uriConfig = this.d.b.getUriConfig();
            this.n = uriConfig;
            if (uriConfig == null) {
                this.n = UriConstants.createUriConfig(0);
            }
        }
        return this.n;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.z.c(jSONObject);
    }

    @Override // java.util.Comparator
    public int compare(t1 t1Var, t1 t1Var2) {
        int i = ((t1Var.b - t1Var2.b) > 0L ? 1 : ((t1Var.b - t1Var2.b) == 0L ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.z.d(jSONObject);
    }

    public boolean d() {
        m0 m0Var = this.d;
        return m0Var.q == 1 && m0Var.b.isAutoTrackEnabled();
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.z.e(jSONObject);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}

package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.igexin.sdk.PushConsts;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.t;
import com.vivo.push.util.w;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f27400a;
    private Context h;
    private com.vivo.push.util.b j;
    private String k;
    private String l;
    private Boolean o;
    private Long p;
    private boolean q;
    private int s;
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f27401c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private boolean i = true;
    private SparseArray<a> m = new SparseArray<>();
    private int n = 0;
    private IPushClientFactory r = new d();

    /* loaded from: source-8829756-dex2jar.jar:com/vivo/push/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private IPushActionListener f27403a;
        private com.vivo.push.b.c b;

        /* renamed from: c  reason: collision with root package name */
        private IPushActionListener f27404c;
        private Runnable d;
        private Object[] e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.f27403a = iPushActionListener;
        }

        public final void a() {
            Runnable runnable = this.d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(int i, Object... objArr) {
            this.e = objArr;
            IPushActionListener iPushActionListener = this.f27404c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.f27403a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f27404c = iPushActionListener;
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public final Object[] b() {
            return this.e;
        }
    }

    private e() {
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a2 = a(aVar);
        bVar.b(a2);
        aVar.a(new h(this, bVar, a2));
        return aVar;
    }

    public static e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f27400a == null) {
                    f27400a = new e();
                }
                eVar = f27400a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    private String a(a aVar) {
        String num;
        synchronized (this) {
            this.m.put(this.n, aVar);
            int i = this.n;
            this.n = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
    }

    private void c(String str) {
        m.c(new f(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a d(String str) {
        synchronized (this) {
            if (str != null) {
                try {
                    int parseInt = Integer.parseInt(str);
                    a aVar = this.m.get(parseInt);
                    this.m.delete(parseInt);
                    return aVar;
                } catch (Exception e) {
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        m.a(new k(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.l = null;
        this.j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.o == null) {
            this.o = Boolean.valueOf(l() >= 1230 && z.d(this.h));
        }
        return this.o.booleanValue();
    }

    public final void a(Context context) {
        synchronized (this) {
            if (this.h == null) {
                this.h = ContextDelegate.getContext(context);
                this.q = t.c(context, context.getPackageName());
                w.b().a(this.h);
                a(new com.vivo.push.b.g());
                com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                this.j = bVar;
                bVar.a(this.h, "com.vivo.push_preferences.appconfig_v1");
                this.k = f();
                this.l = this.j.b("APP_ALIAS", (String) null);
            }
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        o createReceiverCommand = this.r.createReceiverCommand(intent);
        Context context = a().h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.d.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
        if (createReceiveTask != null) {
            if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
                com.vivo.push.util.p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
            }
            createReceiveTask.a(pushMessageCallback);
            m.a((l) createReceiveTask);
            return;
        }
        com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
        if (context != null) {
            com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IPushActionListener iPushActionListener) {
        a aVar;
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        String f = f();
        this.k = f;
        if (!TextUtils.isEmpty(f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!a(this.b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.b = SystemClock.elapsedRealtime();
            String packageName = this.h.getPackageName();
            if (this.h == null) {
                aVar = null;
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    aVar = null;
                }
            } else {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                bVar.g();
                bVar.d();
                bVar.e();
                bVar.a(100);
                if (this.q) {
                    if (!n()) {
                        aVar = null;
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            aVar = null;
                        }
                    }
                    aVar = a(bVar, iPushActionListener);
                } else {
                    if (bVar.a(this.h) != 2) {
                        a(bVar);
                        aVar = null;
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(0);
                            aVar = null;
                        }
                    }
                    aVar = a(bVar, iPushActionListener);
                }
            }
            if (aVar == null) {
                return;
            }
            aVar.a(new g(this, aVar));
            aVar.a();
        }
    }

    public final void a(o oVar) {
        Context context = a().h;
        if (oVar == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        l createTask = this.r.createTask(oVar);
        if (createTask != null) {
            com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(oVar)));
            m.a(createTask);
            return;
        }
        com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(oVar)));
        if (context != null) {
            com.vivo.push.util.p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
        }
    }

    public final void a(String str) {
        this.k = str;
        this.j.a("APP_TOKEN", str);
    }

    public final void a(String str, int i) {
        a d = d(str);
        if (d != null) {
            d.a(i, new Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    public final void a(String str, int i, Object... objArr) {
        a d = d(str);
        if (d != null) {
            d.a(i, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (!TextUtils.isEmpty(this.l) && this.l.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.h.getPackageName(), arrayList);
            aVar.a(100);
            if (!this.q) {
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (!a(this.d)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.d = SystemClock.elapsedRealtime();
                String a2 = a(new a(aVar, iPushActionListener));
                aVar.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, PushConsts.ALIAS_ERROR_FREQUENCY);
                } else if (TextUtils.isEmpty(str)) {
                    a(a2, PushConsts.ALIAS_OPERATE_PARAM_ERROR);
                } else if (str.length() > 70) {
                    a(a2, PushConsts.ALIAS_REQUEST_FILTER);
                } else {
                    a(aVar);
                    e(a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
        zVar.a(500);
        if (!this.q) {
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!n()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
            }
        } else if (!a(this.f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f = SystemClock.elapsedRealtime();
            String a2 = a(new a(zVar, iPushActionListener));
            zVar.b(a2);
            if (TextUtils.isEmpty(this.k)) {
                a(a2, PushConsts.SETTAG_ERROR_COUNT);
            } else if (arrayList.size() < 0) {
                a(a2, 20002);
            } else {
                if (arrayList.size() + c().size() > 500) {
                    a(a2, PushConsts.SETTAG_ERROR_UNBIND);
                    return;
                }
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().length() > 70) {
                        a(a2, PushConsts.SETTAG_ERROR_REPEAT);
                        return;
                    }
                }
                a(zVar);
                e(a2);
            }
        }
    }

    public final void a(List<String> list) {
        try {
            if (list.size() <= 0) {
                return;
            }
            String b = this.j.b("APP_TAGS", (String) null);
            JSONObject jSONObject = TextUtils.isEmpty(b) ? new JSONObject() : new JSONObject(b);
            for (String str : list) {
                jSONObject.put(str, System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.j.b("APP_TAGS");
            } else {
                this.j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        Context context = this.h;
        if (context != null) {
            z.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(IPushActionListener iPushActionListener) {
        a aVar;
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.k)) {
            iPushActionListener.onStateChanged(0);
        } else if (!a(this.f27401c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f27401c = SystemClock.elapsedRealtime();
            String packageName = this.h.getPackageName();
            if (this.h == null) {
                aVar = null;
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    aVar = null;
                }
            } else {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                bVar.d();
                bVar.e();
                bVar.g();
                bVar.a(100);
                if (this.q) {
                    if (n()) {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new j(this, bVar, a2));
                    } else {
                        aVar = null;
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            aVar = null;
                        }
                    }
                } else if (bVar.a(this.h) == 2) {
                    aVar = a(bVar, iPushActionListener);
                } else {
                    a(bVar);
                    aVar = null;
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                        aVar = null;
                    }
                }
            }
            if (aVar == null) {
                return;
            }
            aVar.a(new i(this));
            aVar.a();
        }
    }

    public final void b(String str) {
        this.l = str;
        this.j.a("APP_ALIAS", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (TextUtils.isEmpty(this.l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.h.getPackageName(), arrayList);
            aVar.a(100);
            if (!this.q) {
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (!a(this.e)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.e = SystemClock.elapsedRealtime();
                String a2 = a(new a(aVar, iPushActionListener));
                aVar.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, PushConsts.ALIAS_ERROR_FREQUENCY);
                } else if (TextUtils.isEmpty(str)) {
                    a(a2, PushConsts.ALIAS_OPERATE_PARAM_ERROR);
                } else if (str.length() > 70) {
                    a(a2, PushConsts.ALIAS_REQUEST_FILTER);
                } else {
                    a(aVar);
                    e(a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
        zVar.a(500);
        if (!this.q) {
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!n()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
            }
        } else if (!a(this.g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.g = SystemClock.elapsedRealtime();
            String a2 = a(new a(zVar, iPushActionListener));
            zVar.b(a2);
            if (TextUtils.isEmpty(this.k)) {
                a(a2, PushConsts.SETTAG_ERROR_COUNT);
            } else if (arrayList.size() < 0) {
                a(a2, 20002);
            } else if (arrayList.size() > 500) {
                a(a2, PushConsts.SETTAG_ERROR_UNBIND);
            } else {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().length() > 70) {
                        a(a2, PushConsts.SETTAG_ERROR_REPEAT);
                        return;
                    }
                }
                a(zVar);
                e(a2);
            }
        }
    }

    public final void b(List<String> list) {
        try {
            if (list.size() <= 0) {
                return;
            }
            String b = this.j.b("APP_TAGS", (String) null);
            JSONObject jSONObject = TextUtils.isEmpty(b) ? new JSONObject() : new JSONObject(b);
            for (String str : list) {
                jSONObject.remove(str);
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.j.b("APP_TAGS");
            } else {
                this.j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    public final List<String> c() {
        String b = this.j.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException e) {
            this.j.b("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(b)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(b).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    public final void c(List<String> list) {
        if (list.contains(this.l)) {
            m();
        }
    }

    public final boolean d() {
        if (this.h == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(n());
        this.o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.q;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.k)) {
            com.vivo.push.util.b bVar = this.j;
            String b = bVar != null ? bVar.b("APP_TOKEN", (String) null) : "";
            c(b);
            return b;
        }
        return this.k;
    }

    public final boolean g() {
        return this.i;
    }

    public final Context h() {
        return this.h;
    }

    public final void i() {
        this.j.a();
    }

    public final String j() {
        return this.l;
    }

    public final int k() {
        return this.s;
    }

    public final long l() {
        Context context = this.h;
        if (context == null) {
            return -1L;
        }
        if (this.p == null) {
            this.p = Long.valueOf(z.a(context));
        }
        return this.p.longValue();
    }
}

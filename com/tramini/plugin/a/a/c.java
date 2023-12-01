package com.tramini.plugin.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tramini.plugin.a.d;
import com.tramini.plugin.a.g.f;
import com.tramini.plugin.a.g.h;
import com.tramini.plugin.a.g.i;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/a/c.class */
public class c {
    private static c b;

    /* renamed from: c  reason: collision with root package name */
    private Context f40479c;
    private BroadcastReceiver e;
    private BroadcastReceiver f;
    private boolean h;
    private String[] i;
    private int g = -1;

    /* renamed from: a  reason: collision with root package name */
    boolean f40478a = false;
    private Handler d = new Handler(Looper.getMainLooper());

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    b = new c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.tramini.plugin.a.a.c r5, android.content.Context r6) {
        /*
            r0 = r5
            android.content.Context r0 = r0.f40479c
            java.lang.String r1 = "tramini"
            java.lang.String r2 = "P_IL_O"
            java.lang.String r3 = ""
            java.lang.String r0 = com.tramini.plugin.a.g.i.b(r0, r1, r2, r3)
            r9 = r0
            r0 = r5
            r1 = 0
            r0.h = r1
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r1 = r0
            java.lang.String r2 = "yyyyMMdd"
            r1.<init>(r2)
            java.util.Date r1 = new java.util.Date
            r2 = r1
            r2.<init>()
            java.lang.String r0 = r0.format(r1)
            r8 = r0
            r0 = r9
            if (r0 == 0) goto L70
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L3a
        L35:
            r0 = 1
            r7 = r0
            goto L72
        L3a:
            r0 = r9
            java.lang.String r1 = "-"
            java.lang.String[] r0 = r0.split(r1)
            r9 = r0
            r0 = r9
            r1 = 0
            r0 = r0[r1]
            r1 = r8
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 != 0) goto L56
            r0 = r5
            r1 = 1
            r0.h = r1
            goto L35
        L56:
            r0 = r5
            r1 = r9
            r2 = 1
            r1 = r1[r2]     // Catch: java.lang.NumberFormatException -> L64
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L64
            r0.g = r1     // Catch: java.lang.NumberFormatException -> L64
            goto L70
        L64:
            r9 = move-exception
            r0 = r9
            r0.printStackTrace()
            r0 = r5
            r1 = 1
            r0.g = r1
        L70:
            r0 = 0
            r7 = r0
        L72:
            r0 = r7
            if (r0 == 0) goto La7
            r0 = r5
            android.content.Context r0 = r0.f40479c
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = "-1"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r1 = "tramini"
            java.lang.String r2 = "P_IL_O"
            r3 = r10
            java.lang.String r3 = r3.toString()
            com.tramini.plugin.a.g.i.a(r0, r1, r2, r3)
            r0 = r5
            r1 = 1
            r0.g = r1
        La7:
            r0 = r6
            com.tramini.plugin.a.d r0 = com.tramini.plugin.a.d.a(r0)
            r1 = r5
            boolean r1 = r1.h
            r0.a(r1)
            r0 = r5
            r1 = 0
            r0.h = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.a.c.a(com.tramini.plugin.a.a.c, android.content.Context):void");
    }

    public static void a(Runnable runnable) {
        com.tramini.plugin.a.g.b.a.a().a(runnable);
    }

    static /* synthetic */ void b(c cVar, Context context) {
        cVar.b(com.tramini.plugin.b.b.a(context).b());
        cVar.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.tramini.plugin.b.a aVar) {
        b(new Runnable() { // from class: com.tramini.plugin.a.a.c.4
            @Override // java.lang.Runnable
            public final void run() {
                int size;
                try {
                    if (c.this.f40479c == null) {
                        return;
                    }
                    List<String> list = null;
                    try {
                        if (c.this.e != null) {
                            b.a(c.this.f40479c).a(c.this.e);
                            c.this.e = null;
                        }
                    } catch (Throwable th) {
                    }
                    c.this.e = new com.tramini.plugin.a.b();
                    IntentFilter intentFilter = new IntentFilter();
                    if (aVar != null) {
                        list = aVar.d();
                    }
                    if (list != null && (size = list.size()) > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            }
                            intentFilter.addAction(list.get(i2));
                            i = i2 + 1;
                        }
                    }
                    b.a(c.this.f40479c).a(c.this.e, intentFilter);
                } catch (Throwable th2) {
                }
            }
        });
    }

    private void b(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.d.post(runnable);
        }
    }

    public final void a(int i) {
        this.g = i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009a -> B:13:0x0081). Please submit an issue!!! */
    public final void a(final Context context) {
        if (context == null) {
            return;
        }
        try {
            this.f40479c = context.getApplicationContext();
            if (h.a(context)) {
                return;
            }
            try {
                if (this.f != null) {
                    b.a(this.f40479c).a(this.f);
                    this.f = null;
                }
            } catch (Throwable th) {
            }
            try {
                this.f = new com.tramini.plugin.a.c();
                IntentFilter intentFilter = new IntentFilter();
                String packageName = this.f40479c.getPackageName();
                intentFilter.addAction(f.a(packageName + packageName));
                b.a(this.f40479c).a(this.f, intentFilter);
            } catch (Throwable th2) {
            }
            com.tramini.plugin.a.g.b.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.a(c.this, context);
                }
            }, 1000L);
        } catch (Throwable th3) {
        }
    }

    public final void a(final com.tramini.plugin.b.a aVar) {
        synchronized (this) {
            if (this.f40478a) {
                return;
            }
            if (aVar != null) {
                this.f40478a = true;
                com.tramini.plugin.a.g.b.a().a(aVar);
                a().a(new Runnable() { // from class: com.tramini.plugin.a.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tramini.plugin.a.g.b.a().a(aVar);
                    }
                }, com.igexin.push.config.c.l);
            }
        }
    }

    public final void a(Runnable runnable, long j) {
        this.d.postDelayed(runnable, j);
    }

    public final void a(String[] strArr) {
        this.i = strArr;
    }

    public final boolean a(String str) {
        String[] strArr = this.i;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (TextUtils.equals(strArr[i2], str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final Context b() {
        return this.f40479c;
    }

    public final void b(final Context context) {
        com.tramini.plugin.a.g.b.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                if (com.tramini.plugin.b.b.a(context).a()) {
                    com.tramini.plugin.b.b.a(context).a(new com.tramini.plugin.a.d.c() { // from class: com.tramini.plugin.a.a.c.3.1
                        @Override // com.tramini.plugin.a.d.c
                        public final void a(com.tramini.plugin.b.a aVar) {
                            c.this.b(aVar);
                            d.a(c.this.f40479c).a();
                            d.a(c.this.f40479c).a(aVar, aVar.o());
                        }
                    });
                }
            }
        });
    }

    public final void b(final String str) {
        com.tramini.plugin.a.g.b.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.a.c.5
            @Override // java.lang.Runnable
            public final void run() {
                i.a(c.this.f40479c, "tramini", "P_CE_PE", "");
                com.tramini.plugin.a.g.c.c(str);
                c cVar = c.this;
                c.b(cVar, cVar.f40479c);
            }
        });
    }

    public final int c() {
        return this.g;
    }

    public final void c(final String str) {
        com.tramini.plugin.a.g.b.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.a.c.6
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.tramini.plugin.a.g.d.f40545a = new JSONObject(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}

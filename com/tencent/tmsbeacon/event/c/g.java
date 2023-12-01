package com.tencent.tmsbeacon.event.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.event.open.EventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, g> f25873a = new ConcurrentHashMap(5);
    private static volatile Handler b;
    private final Context g;
    private final String h;
    private String j;
    private SharedPreferences n;

    /* renamed from: c  reason: collision with root package name */
    private final String f25874c = "normal_log_id";
    private final String d = "realtime_log_id";
    private final String e = "immediate_log_id";
    private final String f = "on_date";
    private final List<String> i = new ArrayList();
    private AtomicLong k = new AtomicLong(0);
    private AtomicLong l = new AtomicLong(0);
    private AtomicLong m = new AtomicLong(0);
    private final Runnable o = new a();
    private boolean p = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/g$a.class */
    public class a implements Runnable {
        private volatile long b = 0;

        /* renamed from: c  reason: collision with root package name */
        private volatile long f25875c = 0;
        private volatile long d = 0;

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.this) {
                long j = g.this.l.get();
                long j2 = g.this.k.get();
                long j3 = g.this.m.get();
                if (this.b == j && this.f25875c == j2 && this.d == j3) {
                    return;
                }
                this.b = j;
                this.f25875c = j2;
                this.d = j3;
                g gVar = g.this;
                SharedPreferences.Editor edit = gVar.a(gVar.g).edit();
                if (com.tencent.tmsbeacon.base.util.b.a(edit)) {
                    edit.putString("on_date", g.this.j).putLong("realtime_log_id", this.b).putLong("normal_log_id", this.f25875c).putLong("immediate_log_id", this.d).apply();
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/g$b.class */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25876a;

        static {
            EventType.values();
            int[] iArr = new int[6];
            f25876a = iArr;
            try {
                EventType eventType = EventType.NORMAL;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f25876a;
                EventType eventType2 = EventType.DT_NORMAL;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f25876a;
                EventType eventType3 = EventType.REALTIME;
                iArr3[1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f25876a;
                EventType eventType4 = EventType.DT_REALTIME;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f25876a;
                EventType eventType5 = EventType.IMMEDIATE_MSF;
                iArr5[5] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f25876a;
                EventType eventType6 = EventType.IMMEDIATE_WNS;
                iArr6[4] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private g(Context context, String str) {
        this.g = context;
        this.h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences a(Context context) {
        if (this.n == null) {
            this.n = context.getSharedPreferences("b_log_ID_tmsbeacon_" + com.tencent.tmsbeacon.a.c.b.c(context) + "_" + this.h, 0);
        }
        return this.n;
    }

    public static g a(Context context, String str) {
        g gVar;
        synchronized (g.class) {
            try {
                Map<String, g> map = f25873a;
                g gVar2 = map.get(str);
                gVar = gVar2;
                if (gVar2 == null) {
                    gVar = new g(context, str);
                    map.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private String a(EventType eventType) {
        switch (b.f25876a[eventType.ordinal()]) {
            case 1:
            case 2:
                return String.valueOf(this.k.incrementAndGet());
            case 3:
            case 4:
                return String.valueOf(this.l.incrementAndGet());
            case 5:
            case 6:
                return String.valueOf(this.m.incrementAndGet());
            default:
                return "";
        }
    }

    private void b() {
        synchronized (g.class) {
            try {
                if (b == null) {
                    b = com.tencent.tmsbeacon.a.b.a.a().a(113);
                }
            } finally {
            }
        }
    }

    private void c() {
        SharedPreferences a2 = a(this.g);
        this.j = a2.getString("on_date", "");
        this.l.set(a2.getLong("realtime_log_id", 0L));
        this.k.set(a2.getLong("normal_log_id", 0L));
        this.m.set(a2.getLong("immediate_log_id", 0L));
        c.a("[LogID " + this.h + "]", " load LogID from sp, date: %s , realtime: %d, normal: %d, immediate: %d", this.j, Long.valueOf(this.l.get()), Long.valueOf(this.k.get()), Long.valueOf(this.m.get()));
    }

    public String a(String str, EventType eventType) {
        synchronized (this) {
            if (!this.p) {
                a();
                this.p = true;
            }
            if (this.i.contains(str)) {
                return "";
            }
            String a2 = a(eventType);
            c.a("[stat " + this.h + "]", "type: %s, code: %s, logID: %s.", eventType, str, a2);
            b.post(this.o);
            return a2;
        }
    }

    public void a() {
        b();
        this.i.add("rqd_model");
        this.i.add("rqd_appresumed");
        c();
    }
}

package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fu.class */
public abstract class fu {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f41420a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f481a;

    /* renamed from: a  reason: collision with other field name */
    protected fv f484a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f486a;

    /* renamed from: a  reason: collision with other field name */
    protected int f482a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f483a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f491b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f494c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f489a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fx> f488a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fz, a> f490a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fz, a> f493b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected gg f485a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f487a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f492b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f41421c = 2;
    protected final int b = f41420a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fu$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private fz f41422a;

        /* renamed from: a  reason: collision with other field name */
        private gh f495a;

        public a(fz fzVar, gh ghVar) {
            this.f41422a = fzVar;
            this.f495a = ghVar;
        }

        public void a(fj fjVar) {
            this.f41422a.a(fjVar);
        }

        public void a(gl glVar) {
            gh ghVar = this.f495a;
            if (ghVar == null || ghVar.mo11780a(glVar)) {
                this.f41422a.a(glVar);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x001c -> B:4:0x0017). Please submit an issue!!! */
    static {
        f481a = false;
        try {
            f481a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        ga.m11807a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fu(XMPushService xMPushService, fv fvVar) {
        this.f484a = fvVar;
        this.f486a = xMPushService;
        m11788b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m11782a(int i) {
        synchronized (this.f489a) {
            if (i == 1) {
                this.f489a.clear();
            } else {
                this.f489a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f489a.size() > 6) {
                    this.f489a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f482a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m11783a() {
        return this.f494c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fv m11784a() {
        return this.f484a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String mo11785a() {
        return this.f484a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public Map<fz, a> m11786a() {
        return this.f490a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.f41421c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m11394a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
        }
        if (bh.b(this.f486a)) {
            m11782a(i);
        }
        if (i == 1) {
            this.f486a.a(10);
            if (this.f41421c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("try set connected while not connecting.");
            }
            this.f41421c = i;
            for (fx fxVar : this.f488a) {
                fxVar.b(this);
            }
        } else if (i == 0) {
            if (this.f41421c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("try set connecting while not disconnected.");
            }
            this.f41421c = i;
            for (fx fxVar2 : this.f488a) {
                fxVar2.a(this);
            }
        } else if (i == 2) {
            this.f486a.a(10);
            int i4 = this.f41421c;
            if (i4 == 0) {
                for (fx fxVar3 : this.f488a) {
                    fxVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fx fxVar4 : this.f488a) {
                    fxVar4.a(this, i2, exc);
                }
            }
            this.f41421c = i;
        }
    }

    public void a(fx fxVar) {
        if (fxVar == null || this.f488a.contains(fxVar)) {
            return;
        }
        this.f488a.add(fxVar);
    }

    public void a(fz fzVar, gh ghVar) {
        if (fzVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f490a.put(fzVar, new a(fzVar, ghVar));
    }

    public abstract void a(gl glVar);

    public abstract void a(bg.b bVar);

    public void a(String str) {
        synchronized (this) {
            if (this.f41421c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("ignore setChallenge because connection was disconnected");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("setChallenge hash = " + bm.a(str).substring(0, 8));
            this.f487a = str;
            a(1, 0, null);
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fj[] fjVarArr);

    /* renamed from: a */
    public boolean mo11775a() {
        return false;
    }

    public boolean a(long j) {
        boolean z;
        synchronized (this) {
            z = this.e >= j;
        }
        return z;
    }

    public int b() {
        return this.f41421c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m11787b() {
        return this.f484a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m11788b() {
        String str;
        if (this.f484a.m11793a() && this.f485a == null) {
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable th) {
                str = null;
            }
            Class<?> cls = null;
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    cls = null;
                }
            }
            if (cls == null) {
                this.f485a = new fs(this);
                return;
            }
            try {
                this.f485a = (gg) cls.getConstructor(fu.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fj fjVar);

    public void b(fx fxVar) {
        this.f488a.remove(fxVar);
    }

    public void b(fz fzVar, gh ghVar) {
        if (fzVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f493b.put(fzVar, new a(fzVar, ghVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11789b() {
        return this.f41421c == 0;
    }

    public void c() {
        synchronized (this) {
            this.e = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11790c() {
        return this.f41421c == 1;
    }

    public void d() {
        synchronized (this.f489a) {
            this.f489a.clear();
        }
    }
}

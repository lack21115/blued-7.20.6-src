package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.efs.sdk.base.core.util.NetworkUtil;
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
    private static final AtomicInteger f27729a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f434a;

    /* renamed from: a  reason: collision with other field name */
    protected fv f437a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f439a;

    /* renamed from: a  reason: collision with other field name */
    protected int f435a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f436a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f444b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f447c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f442a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fx> f441a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fz, a> f443a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fz, a> f446b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected gg f438a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f440a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f445b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f27730c = 2;
    protected final int b = f27729a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fu$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private fz f27731a;

        /* renamed from: a  reason: collision with other field name */
        private gh f448a;

        public a(fz fzVar, gh ghVar) {
            this.f27731a = fzVar;
            this.f448a = ghVar;
        }

        public void a(fj fjVar) {
            this.f27731a.a(fjVar);
        }

        public void a(gl glVar) {
            gh ghVar = this.f448a;
            if (ghVar == null || ghVar.mo8730a(glVar)) {
                this.f27731a.a(glVar);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x001c -> B:4:0x0017). Please submit an issue!!! */
    static {
        f434a = false;
        try {
            f434a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        ga.m8757a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fu(XMPushService xMPushService, fv fvVar) {
        this.f437a = fvVar;
        this.f439a = xMPushService;
        m8738b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? NetworkUtil.NETWORK_CLASS_DISCONNECTED : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m8732a(int i) {
        synchronized (this.f442a) {
            if (i == 1) {
                this.f442a.clear();
            } else {
                this.f442a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f442a.size() > 6) {
                    this.f442a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f435a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m8733a() {
        return this.f447c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fv m8734a() {
        return this.f437a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String mo8735a() {
        return this.f437a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public Map<fz, a> m8736a() {
        return this.f443a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.f27730c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
        }
        if (bh.b(this.f439a)) {
            m8732a(i);
        }
        if (i == 1) {
            this.f439a.a(10);
            if (this.f27730c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("try set connected while not connecting.");
            }
            this.f27730c = i;
            for (fx fxVar : this.f441a) {
                fxVar.b(this);
            }
        } else if (i == 0) {
            if (this.f27730c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("try set connecting while not disconnected.");
            }
            this.f27730c = i;
            for (fx fxVar2 : this.f441a) {
                fxVar2.a(this);
            }
        } else if (i == 2) {
            this.f439a.a(10);
            int i4 = this.f27730c;
            if (i4 == 0) {
                for (fx fxVar3 : this.f441a) {
                    fxVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fx fxVar4 : this.f441a) {
                    fxVar4.a(this, i2, exc);
                }
            }
            this.f27730c = i;
        }
    }

    public void a(fx fxVar) {
        if (fxVar == null || this.f441a.contains(fxVar)) {
            return;
        }
        this.f441a.add(fxVar);
    }

    public void a(fz fzVar, gh ghVar) {
        if (fzVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f443a.put(fzVar, new a(fzVar, ghVar));
    }

    public abstract void a(gl glVar);

    public abstract void a(bg.b bVar);

    public void a(String str) {
        synchronized (this) {
            if (this.f27730c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("ignore setChallenge because connection was disconnected");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("setChallenge hash = " + bm.a(str).substring(0, 8));
            this.f440a = str;
            a(1, 0, null);
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fj[] fjVarArr);

    /* renamed from: a */
    public boolean mo8725a() {
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
        return this.f27730c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m8737b() {
        return this.f437a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m8738b() {
        String str;
        if (this.f437a.m8743a() && this.f438a == null) {
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
                this.f438a = new fs(this);
                return;
            }
            try {
                this.f438a = (gg) cls.getConstructor(fu.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fj fjVar);

    public void b(fx fxVar) {
        this.f441a.remove(fxVar);
    }

    public void b(fz fzVar, gh ghVar) {
        if (fzVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f446b.put(fzVar, new a(fzVar, ghVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8739b() {
        return this.f27730c == 0;
    }

    public void c() {
        synchronized (this) {
            this.e = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8740c() {
        return this.f27730c == 1;
    }

    public void d() {
        synchronized (this.f442a) {
            this.f442a.clear();
        }
    }
}

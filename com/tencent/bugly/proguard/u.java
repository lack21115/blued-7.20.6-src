package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/u.class */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static u f21715a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f21716c;
    private long e;
    private long f;
    private Map<Integer, Long> d = new HashMap();
    private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<>();
    private final Object i = new Object();
    private int j = 0;
    private final p b = p.a();

    private u(Context context) {
        this.f21716c = context;
    }

    public static u a() {
        u uVar;
        synchronized (u.class) {
            try {
                uVar = f21715a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    public static u a(Context context) {
        u uVar;
        synchronized (u.class) {
            try {
                if (f21715a == null) {
                    f21715a = new u(context);
                }
                uVar = f21715a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            a(runnable, z);
            c(0);
        } else if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        } else {
            x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Thread a2 = z.a(runnable, "BUGLY_SYNC_UPLOAD");
            if (a2 == null) {
                x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
                a(runnable, true);
                return;
            }
            try {
                a2.join(j);
            } catch (Throwable th) {
                x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
                a(runnable, true);
                c(0);
            }
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.i) {
                if (z) {
                    this.g.put(runnable);
                } else {
                    this.h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    static /* synthetic */ int b(u uVar) {
        int i = uVar.j - 1;
        uVar.j = i;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r8) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.c(int):void");
    }

    public final long a(int i) {
        long j;
        synchronized (this) {
            if (i >= 0) {
                Long l = this.d.get(Integer.valueOf(i));
                if (l != null) {
                    return l.longValue();
                }
                List<r> a2 = this.b.a(i);
                j = 0;
                if (a2 != null) {
                    j = 0;
                    if (a2.size() > 0) {
                        if (a2.size() > 1) {
                            j = 0;
                            for (r rVar : a2) {
                                if (rVar.e > j) {
                                    j = rVar.e;
                                }
                            }
                            this.b.b(i);
                        } else {
                            j = a2.get(0).e;
                        }
                    }
                }
            } else {
                x.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
                j = 0;
            }
            return j;
        }
    }

    public final long a(boolean z) {
        long j;
        long j2;
        long b = z.b();
        int i = z ? 5 : 3;
        List<r> a2 = this.b.a(i);
        if (a2 == null || a2.size() <= 0) {
            j = z ? this.f : this.e;
        } else {
            long j3 = 0;
            try {
                r rVar = a2.get(0);
                j2 = 0;
                if (rVar.e >= b) {
                    j2 = z.b(rVar.g);
                    if (i == 3) {
                        this.e = j2;
                    } else {
                        this.f = j2;
                    }
                    j3 = j2;
                    a2.remove(rVar);
                }
            } catch (Throwable th) {
                x.a(th);
                j2 = j3;
            }
            j = j2;
            if (a2.size() > 0) {
                this.b.a(a2);
                j = j2;
            }
        }
        x.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    public final void a(int i, long j) {
        synchronized (this) {
            if (i < 0) {
                x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
                return;
            }
            this.d.put(Integer.valueOf(i), Long.valueOf(j));
            r rVar = new r();
            rVar.b = i;
            rVar.e = j;
            rVar.f21712c = "";
            rVar.d = "";
            rVar.g = new byte[0];
            this.b.b(i);
            this.b.a(rVar);
            x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), z.a(j));
        }
    }

    public final void a(int i, am amVar, String str, String str2, t tVar, long j, boolean z) {
        try {
            a(new v(this.f21716c, i, amVar.g, a.a((Object) amVar), str, str2, tVar, true, z), true, true, j);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i, am amVar, String str, String str2, t tVar, boolean z) {
        try {
            a(new v(this.f21716c, i, amVar.g, a.a((Object) amVar), str, str2, tVar, 0, 0, false, null), z, false, 0L);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(long j, boolean z) {
        synchronized (this) {
            int i = z ? 5 : 3;
            r rVar = new r();
            rVar.b = i;
            rVar.e = z.b();
            rVar.f21712c = "";
            rVar.d = "";
            rVar.g = z.c(j);
            this.b.b(i);
            this.b.a(rVar);
            if (z) {
                this.f = j;
            } else {
                this.e = j;
            }
            x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
        }
    }

    public final boolean b(int i) {
        if (com.tencent.bugly.b.f21418c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i);
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis < 30000) {
            x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }
}

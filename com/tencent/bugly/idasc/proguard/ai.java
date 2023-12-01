package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ai.class */
public final class ai {
    private static ai b;

    /* renamed from: a  reason: collision with root package name */
    public ah f21537a;
    private final Context d;
    private long f;
    private long g;
    private Map<Integer, Long> e = new HashMap();
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue<>();
    private final Object j = new Object();
    private long k = 0;
    private int l = 0;

    /* renamed from: c  reason: collision with root package name */
    private final w f21538c = w.a();

    private ai(Context context) {
        this.d = context;
    }

    public static ai a() {
        ai aiVar;
        synchronized (ai.class) {
            try {
                aiVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aiVar;
    }

    public static ai a(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            try {
                if (b == null) {
                    b = new ai(context);
                }
                aiVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aiVar;
    }

    private void a(int i, int i2, byte[] bArr, String str, String str2, ah ahVar, boolean z) {
        try {
            a(new aj(this.d, i, i2, bArr, str, str2, ahVar, 0, 0, false), z, false, 0L);
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        final Runnable poll;
        ak a2 = ak.a();
        if (i > 0) {
            al.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i || (poll = linkedBlockingQueue.poll()) == null) {
                return;
            }
            synchronized (this.j) {
                if (this.l < 2 || a2 == null) {
                    al.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (ap.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ai.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            poll.run();
                            synchronized (ai.this.j) {
                                ai.b(ai.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.j) {
                            this.l++;
                        }
                    } else {
                        al.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                        a(poll, true);
                    }
                } else {
                    a2.a(poll);
                }
            }
            i2 = i3 + 1;
        }
    }

    private void a(Runnable runnable, long j) {
        if (runnable == null) {
            al.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        al.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a2 = ap.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a2 == null) {
            al.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a2.join(j);
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            b();
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j) {
        al.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            a(runnable, j);
            return;
        }
        a(runnable, z);
        b();
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i) {
        Runnable peek;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i || (peek = linkedBlockingQueue.peek()) == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                al.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
            i2 = i3 + 1;
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            al.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            al.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.j) {
                (z ? this.h : this.i).put(runnable);
            }
            return true;
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    static /* synthetic */ int b(ai aiVar) {
        int i = aiVar.l - 1;
        aiVar.l = i;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.ai.b():void");
    }

    public final long a(int i) {
        synchronized (this) {
            if (i >= 0) {
                Long l = this.e.get(Integer.valueOf(i));
                if (l != null) {
                    return l.longValue();
                }
            } else {
                al.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
            }
            return 0L;
        }
    }

    public final long a(boolean z) {
        long j;
        long j2;
        long b2 = ap.b();
        int i = z ? 5 : 3;
        List<y> a2 = this.f21538c.a(i);
        if (a2 == null || a2.size() <= 0) {
            j = z ? this.g : this.f;
        } else {
            long j3 = 0;
            try {
                y yVar = a2.get(0);
                j2 = 0;
                if (yVar.e >= b2) {
                    j2 = ap.d(yVar.g);
                    if (i == 3) {
                        this.f = j2;
                    } else {
                        this.g = j2;
                    }
                    j3 = j2;
                    a2.remove(yVar);
                }
            } catch (Throwable th) {
                al.a(th);
                j2 = j3;
            }
            j = j2;
            if (a2.size() > 0) {
                this.f21538c.a(a2);
                j = j2;
            }
        }
        al.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    public final void a(int i, long j) {
        synchronized (this) {
            if (i < 0) {
                al.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
                return;
            }
            this.e.put(Integer.valueOf(i), Long.valueOf(j));
            y yVar = new y();
            yVar.b = i;
            yVar.e = j;
            yVar.f21663c = "";
            yVar.d = "";
            yVar.g = new byte[0];
            this.f21538c.b(i);
            this.f21538c.a(yVar);
            al.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), ap.a(j));
        }
    }

    public final void a(int i, bq bqVar, String str, String str2, ah ahVar, long j, boolean z) {
        try {
            a(new aj(this.d, i, bqVar.g, ae.a((Object) bqVar), str, str2, ahVar, z), true, true, j);
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i, bq bqVar, String str, String str2, ah ahVar, boolean z) {
        a(i, bqVar.g, ae.a((Object) bqVar), str, str2, ahVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(long j, boolean z) {
        synchronized (this) {
            int i = z ? 5 : 3;
            y yVar = new y();
            yVar.b = i;
            yVar.e = ap.b();
            yVar.f21663c = "";
            yVar.d = "";
            yVar.g = ap.c(j);
            this.f21538c.b(i);
            this.f21538c.a(yVar);
            if (z) {
                this.g = j;
            } else {
                this.f = j;
            }
            al.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
        }
    }

    public final boolean b(int i) {
        if (p.f21637c) {
            al.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i);
        al.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis < 30000) {
            al.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }
}

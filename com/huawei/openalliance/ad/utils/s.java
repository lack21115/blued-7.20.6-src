package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/s.class */
public class s {
    private static final String Code = "HandlerExecAgent";
    private static final long I = 60000;
    private static final String V = "handler_exec_release_task";
    private static final String Z = "handler_exec_thread";
    private final byte[] B = new byte[0];
    private final byte[] C = new byte[0];
    private HandlerThread D;
    private r F;
    private int L;
    private final String S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/s$a.class */
    public static class a {
        static final int Code = 1;
        static final int V = 2;
        String B;
        long C;
        int I;
        Runnable Z;

        a(int i, Runnable runnable, String str, long j) {
            this.I = i;
            this.Z = runnable;
            this.B = str;
            this.C = j;
        }

        public String toString() {
            return "CacheTask{taskType=" + this.I + ", id='" + this.B + "'}";
        }
    }

    public s(String str) {
        this.S = TextUtils.isEmpty(str) ? Z : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (Z()) {
            synchronized (this.C) {
                if (this.D == null) {
                    ge.V(Code, "init handler thread");
                    HandlerThread handlerThread = new HandlerThread(this.S);
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    if (looper != null) {
                        this.D = handlerThread;
                        Code(new r(new Handler(looper)));
                    } else {
                        handlerThread.quit();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r C() {
        r rVar;
        synchronized (this.B) {
            rVar = this.F;
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(r rVar) {
        synchronized (this.B) {
            this.F = rVar;
        }
    }

    private void Code(final a aVar) {
        f.Z(new Runnable() { // from class: com.huawei.openalliance.ad.utils.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.B();
                r C = s.this.C();
                if (C != null) {
                    if (aVar.I == 1) {
                        C.Code(aVar.Z, aVar.B, aVar.C);
                    } else if (aVar.I == 2) {
                        C.Code(aVar.B);
                    }
                }
            }
        });
    }

    private void I() {
        r C = C();
        if (C != null) {
            ge.V(Code, "delay quit thread");
            C.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.s.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (s.this.C) {
                        if (s.this.D != null) {
                            s.this.D.quitSafely();
                            s.this.D = null;
                        }
                        s.this.Code((r) null);
                        ge.V(s.Code, "quit thread and release");
                    }
                }
            }, V, 60000L);
        }
    }

    private boolean Z() {
        boolean z;
        synchronized (this.B) {
            z = this.L > 0;
        }
        return z;
    }

    public void Code() {
        synchronized (this.B) {
            this.L++;
            r C = C();
            if (C != null) {
                C.Code(V);
            }
            if (ge.Code()) {
                ge.Code(Code, "acquire exec agent. ref count: %d", Integer.valueOf(this.L));
            }
        }
    }

    public void Code(Runnable runnable) {
        if (Z()) {
            r C = C();
            if (C != null) {
                C.Code(runnable);
            } else {
                Code(new a(1, runnable, null, 0L));
            }
        }
    }

    public void Code(Runnable runnable, String str, long j) {
        if (Z()) {
            r C = C();
            if (C != null) {
                C.Code(runnable, str, j);
            } else {
                Code(new a(1, runnable, str, j));
            }
        }
    }

    public void Code(String str) {
        if (Z()) {
            r C = C();
            if (C != null) {
                C.Code(str);
            } else {
                Code(new a(2, null, str, 0L));
            }
        }
    }

    public void V() {
        synchronized (this.B) {
            if (!Z()) {
                ge.V(Code, "release exec agent - not working");
                return;
            }
            int i = this.L - 1;
            this.L = i;
            if (i <= 0) {
                this.L = 0;
                I();
            }
            if (ge.Code()) {
                ge.Code(Code, "release exec agent - ref count: %d", Integer.valueOf(this.L));
            }
        }
    }
}

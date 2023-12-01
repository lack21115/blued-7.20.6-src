package com.tencent.cloud.huiyansdkface.analytics;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35494a = a.class.getSimpleName();
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f35495c;
    private long d = 1;
    private long e = 0;

    private long e() {
        long currentTimeMillis;
        synchronized (this) {
            currentTimeMillis = System.currentTimeMillis();
            this.f35495c = currentTimeMillis;
        }
        return currentTimeMillis;
    }

    public final boolean a() {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.e == 0) {
                WBSLogger.d(f35494a, "new life on first:".concat(String.valueOf(currentTimeMillis)), new Object[0]);
                this.b = currentTimeMillis;
                this.d = 1L;
                WBSLogger.d(f35494a, "inn start new session.", new Object[0]);
                WBSLogger.d(f35494a, "new session:".concat(String.valueOf(e())), new Object[0]);
                return true;
            }
            return false;
        }
    }

    public final String b() {
        long j;
        synchronized (this) {
            if (this.b == 0) {
                throw new IllegalStateException("life not start");
            }
            j = this.b;
        }
        return String.valueOf(j);
    }

    public final String c() {
        long j;
        synchronized (this) {
            if (this.f35495c == 0) {
                throw new IllegalStateException("session not started");
            }
            j = this.f35495c;
        }
        return String.valueOf(j);
    }

    public final String d() {
        long j;
        synchronized (this) {
            j = this.d;
            this.d++;
        }
        return String.valueOf(j);
    }
}

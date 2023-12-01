package com.igexin.push.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/d.class */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9750a = "NormalModel";

    @Override // com.igexin.push.c.b
    public final long a() {
        long j;
        long j2;
        boolean a2 = com.igexin.push.f.c.a(System.currentTimeMillis());
        boolean a3 = com.igexin.push.f.c.a();
        com.igexin.push.core.e.n = com.igexin.push.f.c.e();
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.s;
        boolean z3 = com.igexin.push.core.e.n;
        com.igexin.c.a.c.a.a("NormalModel|isSdkOn = " + com.igexin.push.core.e.p + " isPushOn = " + com.igexin.push.core.e.s + " checkIsSilentTime = " + a2 + " isBlockEndTime = " + a3 + " isNetworkAvailable = " + com.igexin.push.core.e.n, new Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.s || a2 || !a3) {
            com.igexin.c.a.c.a.a(f9750a, "reconnect stop, interval= 20min ++++++");
            com.igexin.c.a.c.a.a("NormalModel|reconnect stop, interval= 20min ++++", new Object[0]);
            return com.igexin.push.config.c.g;
        }
        if (com.igexin.push.core.e.O <= 0) {
            j2 = 1;
        } else {
            long j3 = com.igexin.push.core.e.O;
            long j4 = com.igexin.push.core.e.O;
            if (j3 <= 300) {
                j = 150;
            } else {
                long j5 = com.igexin.push.core.e.O;
                if (j4 <= 10000) {
                    j4 = j5;
                    j = 500;
                } else {
                    j4 = com.igexin.push.core.e.O;
                    j = j5 <= 30000 ? 1500L : 120000L;
                }
            }
            j2 = j4 + j;
        }
        com.igexin.push.core.e.O = j2;
        if (com.igexin.push.core.e.O > com.igexin.push.config.c.g) {
            com.igexin.push.core.e.O = com.igexin.push.config.c.g;
        }
        long j6 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("NormalModel|after add auto reconnect delay time = ".concat(String.valueOf(j6)), new Object[0]);
        return j6;
    }
}

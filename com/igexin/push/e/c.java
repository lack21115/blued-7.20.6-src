package com.igexin.push.e;

import com.igexin.push.f.j;
import com.igexin.sdk.main.FeedbackImpl;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/c.class */
public class c implements com.igexin.push.e.b.c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10006a = c.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static final long f10007c = 3600000;
    public long b = 0;

    @Override // com.igexin.push.e.b.c
    public final void a() {
        com.igexin.c.a.c.a.a("start cron-keep task", new Object[0]);
        FeedbackImpl.getInstance().clearFeedbackMessage();
        com.igexin.push.core.e.c.a().d();
        com.igexin.push.core.e.c.a().c();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.j();
        j.j();
        j.k();
    }

    @Override // com.igexin.push.e.b.c
    public final void a(long j) {
        this.b = j;
    }

    @Override // com.igexin.push.e.b.c
    public final boolean b() {
        return System.currentTimeMillis() - this.b > 3600000;
    }
}

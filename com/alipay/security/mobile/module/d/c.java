package com.alipay.security.mobile.module.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/d/c.class */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4711a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f4711a.b();
        } catch (Exception e) {
            d.a(e);
        }
    }
}

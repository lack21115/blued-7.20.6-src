package com.xiaomi.push;

import com.xiaomi.push.al;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gy.class */
final class gy extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f41460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(Runnable runnable) {
        this.f41460a = runnable;
    }

    @Override // com.xiaomi.push.al.b
    public final void b() {
        this.f41460a.run();
    }
}

package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/r.class */
public final class r implements Listener {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ Listener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context, int i, Listener listener) {
        this.a = context;
        this.b = i;
        this.c = listener;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        DUHelper dUHelper;
        String b;
        dUHelper = DUHelper.d;
        b = dUHelper.b(this.a, this.b);
        this.c.handler(b);
    }
}

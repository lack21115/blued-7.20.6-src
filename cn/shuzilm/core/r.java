package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/r.class */
public final class r implements Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4195a;
    final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Listener f4196c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context, int i, Listener listener) {
        this.f4195a = context;
        this.b = i;
        this.f4196c = listener;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        DUHelper dUHelper;
        String b;
        dUHelper = DUHelper.d;
        b = dUHelper.b(this.f4195a, this.b);
        this.f4196c.handler(b);
    }
}

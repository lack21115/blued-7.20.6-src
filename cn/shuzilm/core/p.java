package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/p.class */
public class p implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Listener e;
    final /* synthetic */ DUHelper f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(DUHelper dUHelper, Context context, String str, String str2, String str3, Listener listener) {
        this.f = dUHelper;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String b;
        try {
            dUHelper = DUHelper.d;
            b = dUHelper.b(this.a, this.b, this.c, this.d);
            if (this.e != null) {
                this.e.handler(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

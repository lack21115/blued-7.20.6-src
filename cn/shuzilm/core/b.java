package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/b.class */
public class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ Listener e;
    final /* synthetic */ DUHelper f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DUHelper dUHelper, Context context, String str, String str2, int i, Listener listener) {
        this.f = dUHelper;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String a;
        String g;
        try {
            dUHelper = DUHelper.d;
            a = dUHelper.a(this.a, this.b, this.c, this.d);
            if (this.e != null) {
                String str = a;
                if (a == null) {
                    g = this.f.g(this.a);
                    str = g;
                }
                this.e.handler(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

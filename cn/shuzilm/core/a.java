package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/a.class */
public class a implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ DUListener d;
    final /* synthetic */ DUHelper e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DUHelper dUHelper, Context context, String str, String str2, DUListener dUListener) {
        this.e = dUHelper;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        DUHelper dUHelper2;
        int i;
        String a;
        String g;
        try {
            dUHelper = DUHelper.d;
            Context context = this.a;
            String str = this.b;
            String str2 = this.c;
            dUHelper2 = DUHelper.d;
            i = dUHelper2.v;
            a = dUHelper.a(context, str, str2, i);
            if (this.d != null) {
                String str3 = a;
                if (a == null) {
                    g = this.e.g(this.a);
                    str3 = g;
                }
                this.d.handle(str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

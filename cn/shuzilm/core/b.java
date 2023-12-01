package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4170a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4171c;
    final /* synthetic */ int d;
    final /* synthetic */ Listener e;
    final /* synthetic */ DUHelper f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DUHelper dUHelper, Context context, String str, String str2, int i, Listener listener) {
        this.f = dUHelper;
        this.f4170a = context;
        this.b = str;
        this.f4171c = str2;
        this.d = i;
        this.e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String a2;
        String g;
        try {
            dUHelper = DUHelper.d;
            a2 = dUHelper.a(this.f4170a, this.b, this.f4171c, this.d);
            if (this.e != null) {
                String str = a2;
                if (a2 == null) {
                    g = this.f.g(this.f4170a);
                    str = g;
                }
                this.e.handler(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

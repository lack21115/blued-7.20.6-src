package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4168a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4169c;
    final /* synthetic */ DUListener d;
    final /* synthetic */ DUHelper e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DUHelper dUHelper, Context context, String str, String str2, DUListener dUListener) {
        this.e = dUHelper;
        this.f4168a = context;
        this.b = str;
        this.f4169c = str2;
        this.d = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        DUHelper dUHelper2;
        int i;
        String a2;
        String g;
        try {
            dUHelper = DUHelper.d;
            Context context = this.f4168a;
            String str = this.b;
            String str2 = this.f4169c;
            dUHelper2 = DUHelper.d;
            i = dUHelper2.v;
            a2 = dUHelper.a(context, str, str2, i);
            if (this.d != null) {
                String str3 = a2;
                if (a2 == null) {
                    g = this.e.g(this.f4168a);
                    str3 = g;
                }
                this.d.handle(str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

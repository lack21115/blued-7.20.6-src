package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/o.class */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4190a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4191c;
    final /* synthetic */ String d;
    final /* synthetic */ DUListener e;
    final /* synthetic */ DUHelper f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(DUHelper dUHelper, Context context, String str, String str2, String str3, DUListener dUListener) {
        this.f = dUHelper;
        this.f4190a = context;
        this.b = str;
        this.f4191c = str2;
        this.d = str3;
        this.e = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String b;
        try {
            dUHelper = DUHelper.d;
            b = dUHelper.b(this.f4190a, this.b, this.f4191c, this.d);
            if (this.e != null) {
                this.e.handle(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

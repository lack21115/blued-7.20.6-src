package com.tencent.qimei.v;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f38420a;
    public final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f38421c;

    public c(String str, Context context, k kVar) {
        this.f38420a = str;
        this.b = context;
        this.f38421c = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f a2 = f.a(this.f38420a);
        k kVar = this.f38421c;
        j jVar = a2.d;
        jVar.d = kVar;
        jVar.a();
        com.tencent.qimei.k.a.b("QM", "开始执行Strategy请求任务(appKey: %s)", a2.f38425c);
        if (com.tencent.qimei.a.a.a()) {
            a2.b();
        } else {
            com.tencent.qimei.k.a.b("QM", "没有网络，取消Strategy请求(appKey: %s)", a2.f38425c);
        }
        com.tencent.qimei.g.b.a().a(a2.f38425c, new e(a2));
        com.tencent.qimei.k.a.b("SDK_INIT ｜ 策略", " 初始化完成 ", new Object[0]);
    }
}

package com.tencent.qimei.m;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/m/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24662a;
    public final /* synthetic */ b b;

    public a(b bVar, String str) {
        this.b = bVar;
        this.f24662a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f24662a);
    }
}

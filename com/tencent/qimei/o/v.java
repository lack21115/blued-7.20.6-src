package com.tencent.qimei.o;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/v.class */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24708a;
    public final /* synthetic */ w b;

    public v(w wVar, String str) {
        this.b = wVar;
        this.f24708a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f24708a);
    }
}

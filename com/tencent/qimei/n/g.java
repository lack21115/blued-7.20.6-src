package com.tencent.qimei.n;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/n/g.class */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24672a;
    public final /* synthetic */ Map b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24673c;
    public final /* synthetic */ String d;
    public final /* synthetic */ i e;

    public g(i iVar, String str, Map map, String str2, String str3) {
        this.e = iVar;
        this.f24672a = str;
        this.b = map;
        this.f24673c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.e) {
            this.e.a(this.f24672a, this.b, this.f24673c, this.d);
        }
    }
}

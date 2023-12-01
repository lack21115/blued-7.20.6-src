package com.tencent.qimei.n;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/n/g.class */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f38363a;
    public final /* synthetic */ Map b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38364c;
    public final /* synthetic */ String d;
    public final /* synthetic */ i e;

    public g(i iVar, String str, Map map, String str2, String str3) {
        this.e = iVar;
        this.f38363a = str;
        this.b = map;
        this.f38364c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.e) {
            this.e.a(this.f38363a, this.b, this.f38364c, this.d);
        }
    }
}

package com.tencent.qimei.o;

import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/s.class */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IAsyncQimeiListener f24704a;
    public final /* synthetic */ u b;

    public s(u uVar, IAsyncQimeiListener iAsyncQimeiListener) {
        this.b = uVar;
        this.f24704a = iAsyncQimeiListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Qimei qimei = this.b.getQimei();
        if (qimei == null || qimei.isEmpty()) {
            this.b.a(this.f24704a);
        } else {
            this.f24704a.onQimeiDispatch(qimei);
        }
    }
}

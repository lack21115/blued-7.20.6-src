package com.tencent.qimei.o;

import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/g.class */
public class g implements IAsyncQimeiListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f38373a;

    public g(j jVar) {
        this.f38373a = jVar;
    }

    @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
    public void onQimeiDispatch(Qimei qimei) {
        this.f38373a.a();
    }
}

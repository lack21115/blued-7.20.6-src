package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mtopsdk.mtop.common.MtopListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/listener/a.class */
public final class a implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private MtopFinishListenerImpl f21222a;
    private MtopProgressListenerImpl b;

    /* renamed from: c  reason: collision with root package name */
    private MtopBusiness f21223c;
    private MtopListener d;

    public a(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        this.f21222a = new MtopFinishListenerImpl(mtopBusiness, mtopListener);
        this.f21223c = mtopBusiness;
        this.d = mtopListener;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        MtopFinishListenerImpl mtopFinishListenerImpl;
        if (method.getName().equals("onFinished")) {
            mtopFinishListenerImpl = this.f21222a;
        } else if (!method.getName().equals("onDataReceived") && !method.getName().equals("onHeader")) {
            return null;
        } else {
            if (this.b == null) {
                this.b = new MtopProgressListenerImpl(this.f21223c, this.d);
            }
            mtopFinishListenerImpl = this.b;
        }
        return method.invoke(mtopFinishListenerImpl, objArr);
    }
}

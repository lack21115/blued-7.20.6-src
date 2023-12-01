package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ab.class */
public class ab implements bw.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f9297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.f9297a = zVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bw.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                if (f.f9427a != null) {
                    this.f9297a.b = f.f9427a.i();
                    iXAdContainerFactory = this.f9297a.b;
                    if (iXAdContainerFactory != null) {
                        this.f9297a.k();
                        return;
                    }
                }
            } catch (Exception e) {
                this.f9297a.a("加载dex异常");
                return;
            }
        }
        f.f9427a = null;
        this.f9297a.a("加载dex失败");
    }
}

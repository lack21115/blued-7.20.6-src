package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ab.class */
public class ab implements bw.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f6457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.f6457a = zVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bw.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                if (f.f6587a != null) {
                    this.f6457a.b = f.f6587a.i();
                    iXAdContainerFactory = this.f6457a.b;
                    if (iXAdContainerFactory != null) {
                        this.f6457a.k();
                        return;
                    }
                }
            } catch (Exception e) {
                this.f6457a.a("加载dex异常");
                return;
            }
        }
        f.f6587a = null;
        this.f6457a.a("加载dex失败");
    }
}

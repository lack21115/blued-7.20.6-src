package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/m.class */
public class m implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f6595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f6595a = lVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bf.a(new n(this, iOAdEvent));
    }
}

package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cs.class */
public class cs implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cq f6560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cq cqVar) {
        this.f6560a = cqVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6560a.h();
        }
    }
}

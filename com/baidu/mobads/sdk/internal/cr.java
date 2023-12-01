package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cr.class */
public class cr implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cq f6559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.f6559a = cqVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6559a.c(iOAdEvent.getData());
        }
    }
}

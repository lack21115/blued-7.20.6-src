package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cw.class */
public class cw implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cv f6565a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cv cvVar) {
        this.f6565a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6565a.c(iOAdEvent.getData());
        }
    }
}

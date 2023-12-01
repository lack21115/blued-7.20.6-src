package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/af.class */
public class af implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f6461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.f6461a = adVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f6461a.w();
        }
    }
}

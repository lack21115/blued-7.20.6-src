package com.hihonor.push.sdk;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.j;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/i.class */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8690a;
    public final /* synthetic */ j.a b;

    public i(j.a aVar, int i) {
        this.b = aVar;
        this.f8690a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(HonorPushErrorEnum.fromCode(this.f8690a));
    }
}

package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/p0.class */
public abstract class p0<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final String f8710a = getClass().getSimpleName();
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final IMessageEntity f8711c;
    public final g d;
    public RequestHeader e;
    public x<TResult> f;

    public p0(String str, IMessageEntity iMessageEntity) {
        this.b = str;
        this.f8711c = iMessageEntity;
        this.d = g.a(str);
    }

    public abstract void a(ApiException apiException, Object obj);

    public final void b(ApiException apiException, Object obj) {
        if (this.f != null) {
            a(apiException, obj);
        } else {
            new StringBuilder("This Task has been canceled, uri:").append(this.b);
        }
    }
}

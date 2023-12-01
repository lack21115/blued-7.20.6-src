package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/a.class */
public abstract class a implements v {

    /* renamed from: a  reason: collision with root package name */
    protected Method f4509a;
    protected byte[] b;

    /* renamed from: c  reason: collision with root package name */
    protected String f4510c;
    protected int d;
    protected String e;
    protected boolean f;

    public a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.f4509a = method;
        this.d = i;
        this.f4510c = str;
        this.b = bArr;
        this.e = str2;
        this.f = z;
    }
}

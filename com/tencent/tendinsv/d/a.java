package com.tencent.tendinsv.d;

import java.io.UnsupportedEncodingException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/d/a.class */
public abstract class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f25340a;

    public a() {
        this("utf-8");
    }

    private a(String str) {
        this.f25340a = null;
        this.f25340a = str;
    }

    protected abstract void a(String str);

    @Override // com.tencent.tendinsv.d.c
    public void a(byte[] bArr) {
        try {
            a(new String(bArr, this.f25340a));
        } catch (UnsupportedEncodingException e) {
            a(1007, e.getClass().getSimpleName());
        }
    }
}

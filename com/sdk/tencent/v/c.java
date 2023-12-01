package com.sdk.tencent.v;

import android.content.Context;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/v/c.class */
public class c<T> implements com.sdk.tencent.e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f28086a;

    public c(a aVar) {
        this.f28086a = aVar;
    }

    @Override // com.sdk.tencent.e.a
    public void a(int i, int i2, String str) {
        this.f28086a.a(i, i2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    @Override // com.sdk.tencent.e.a
    public void onSuccess(int i, String str, int i2, T t, String str2) {
        if (i == 0) {
            Context context = this.f28086a.b;
            t = com.sdk.tencent.s.a.a(String.valueOf(t));
            if (t == null) {
                this.f28086a.a(1, "SDK解密异常", 302001, t, str2);
                return;
            }
        }
        this.f28086a.a(i, str, i2, t, str2);
    }
}

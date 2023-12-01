package com.sdk.tencent.v;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/v/b.class */
public class b<T> implements com.sdk.tencent.e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f14397a;

    public b(a aVar) {
        this.f14397a = aVar;
    }

    @Override // com.sdk.tencent.e.a
    public void a(int i, int i2, String str) {
        this.f14397a.a(i, i2, str);
    }

    @Override // com.sdk.tencent.e.a
    public void onSuccess(int i, String str, int i2, T t, String str2) {
        this.f14397a.a(i, str, i2, t, str2);
    }
}

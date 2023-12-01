package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bz.class */
class bz implements ck.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f9367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar) {
        this.f9367a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(String str) {
        try {
            this.f9367a.b();
            this.f9367a.a(str);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }
}

package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bz.class */
public class bz implements ck.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f6527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar) {
        this.f6527a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(String str) {
        try {
            this.f6527a.b();
            this.f6527a.a(str);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }
}

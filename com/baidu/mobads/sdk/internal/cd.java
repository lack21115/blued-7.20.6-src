package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cd.class */
public class cd implements an.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f6533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bw bwVar) {
        this.f6533a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.an.a
    public void a() {
        boolean z;
        z = this.f6533a.A;
        if (z) {
            this.f6533a.A = false;
            this.f6533a.a(false, "remote update Network access failed");
        }
    }
}

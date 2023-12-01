package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bt.class */
public class bt implements cf.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f9359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.f9359a = bsVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cf.a
    public void a(bu buVar) {
        this.f9359a.a(bw.k, buVar, "download apk successfully, downloader exit");
        bs unused = bs.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.cf.a
    public void b(bu buVar) {
        this.f9359a.a(bw.l, buVar, "downloadApk failed");
    }
}

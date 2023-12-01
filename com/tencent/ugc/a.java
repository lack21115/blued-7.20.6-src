package com.tencent.ugc;

import com.tencent.liteav.sdk.common.LicenseChecker;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/a.class */
final /* synthetic */ class a implements LicenseChecker.b {

    /* renamed from: a  reason: collision with root package name */
    private static final a f26522a = new a();

    private a() {
    }

    public static LicenseChecker.b a() {
        return f26522a;
    }

    @Override // com.tencent.liteav.sdk.common.LicenseChecker.b
    public final void a(int i, String str) {
        TXUGCBase.lambda$setListener$0(i, str);
    }
}

package com.blued.login.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/model/OneLoginData.class */
public final class OneLoginData {

    /* renamed from: a  reason: collision with root package name */
    private String f6954a = "";
    private String b = "";

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f6954a = str;
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }
}

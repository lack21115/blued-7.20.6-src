package com.squareup.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/Internal__InternalKt$sanitize$2.class */
public final /* synthetic */ class Internal__InternalKt$sanitize$2 extends FunctionReference implements Function1<String, String> {
    public static final Internal__InternalKt$sanitize$2 INSTANCE = new Internal__InternalKt$sanitize$2();

    Internal__InternalKt$sanitize$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "sanitize";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.a(Internal__InternalKt.class, "wire-runtime");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "sanitize(Ljava/lang/String;)Ljava/lang/String;";
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String p0) {
        Intrinsics.e(p0, "p0");
        return Internal.sanitize(p0);
    }
}

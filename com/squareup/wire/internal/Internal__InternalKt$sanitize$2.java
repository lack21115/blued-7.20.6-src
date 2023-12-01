package com.squareup.wire.internal;

import com.kuaishou.weapon.p0.bp;
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

    public final String getName() {
        return "sanitize";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.a(Internal__InternalKt.class, "wire-runtime");
    }

    public final String getSignature() {
        return "sanitize(Ljava/lang/String;)Ljava/lang/String;";
    }

    public final String invoke(String str) {
        Intrinsics.e(str, bp.g);
        return Internal.sanitize(str);
    }
}

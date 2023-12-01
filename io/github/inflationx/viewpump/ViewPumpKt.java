package io.github.inflationx.viewpump;

import io.github.inflationx.viewpump.Interceptor;
import io.github.inflationx.viewpump.ViewPump;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPumpKt.class */
public final class ViewPumpKt {
    public static final ViewPump.Builder addInterceptor(ViewPump.Builder builder, Function1<? super Interceptor.Chain, InflateResult> function1) {
        Intrinsics.d(builder, "receiver$0");
        Intrinsics.d(function1, "block");
        Interceptor.Companion companion = Interceptor.Companion;
        builder.addInterceptor(new Interceptor$Companion$invoke$1(function1));
        return builder;
    }
}

package io.github.inflationx.viewpump;

import io.github.inflationx.viewpump.Interceptor;
import io.github.inflationx.viewpump.ViewPump;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPumpKt.class */
public final class ViewPumpKt {
    public static final ViewPump.Builder addInterceptor(ViewPump.Builder receiver$0, Function1<? super Interceptor.Chain, InflateResult> block) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(block, "block");
        Interceptor.Companion companion = Interceptor.Companion;
        receiver$0.addInterceptor(new Interceptor$Companion$invoke$1(block));
        return receiver$0;
    }
}

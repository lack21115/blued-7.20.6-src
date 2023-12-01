package io.github.inflationx.viewpump;

import io.github.inflationx.viewpump.Interceptor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/Interceptor$Companion$invoke$1.class */
public final class Interceptor$Companion$invoke$1 implements Interceptor {
    final /* synthetic */ Function1 $block;

    public Interceptor$Companion$invoke$1(Function1 function1) {
        this.$block = function1;
    }

    @Override // io.github.inflationx.viewpump.Interceptor
    public InflateResult intercept(Interceptor.Chain chain) {
        Intrinsics.d(chain, "chain");
        return (InflateResult) this.$block.invoke(chain);
    }
}

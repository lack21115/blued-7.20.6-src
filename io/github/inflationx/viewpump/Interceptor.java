package io.github.inflationx.viewpump;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/Interceptor.class */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/Interceptor$Chain.class */
    public interface Chain {
        InflateResult proceed(InflateRequest inflateRequest);

        InflateRequest request();
    }

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/Interceptor$Companion.class */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* renamed from: -deprecated_Interceptor  reason: not valid java name */
        public final Interceptor m9360deprecated_Interceptor(Function1<? super Chain, InflateResult> function1) {
            Intrinsics.d(function1, "block");
            return new Interceptor$Companion$invoke$1(function1);
        }
    }

    InflateResult intercept(Chain chain);
}

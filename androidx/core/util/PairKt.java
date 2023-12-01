package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/PairKt.class */
public final class PairKt {
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        Intrinsics.e(pair, "<this>");
        return pair.first;
    }

    public static final <F, S> F component1(Pair<F, S> pair) {
        Intrinsics.e(pair, "<this>");
        return pair.first;
    }

    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        Intrinsics.e(pair, "<this>");
        return pair.second;
    }

    public static final <F, S> S component2(Pair<F, S> pair) {
        Intrinsics.e(pair, "<this>");
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> pair) {
        Intrinsics.e(pair, "<this>");
        return new android.util.Pair<>(pair.a(), pair.b());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(kotlin.Pair<? extends F, ? extends S> pair) {
        Intrinsics.e(pair, "<this>");
        return new Pair<>(pair.a(), pair.b());
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        Intrinsics.e(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> pair) {
        Intrinsics.e(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}

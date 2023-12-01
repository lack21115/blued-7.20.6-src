package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__StringsKt$splitToSequence$2.class */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements Function1<IntRange, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CharSequence f42750a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final String invoke(IntRange it) {
        Intrinsics.e(it, "it");
        return StringsKt.a(this.f42750a, it);
    }
}

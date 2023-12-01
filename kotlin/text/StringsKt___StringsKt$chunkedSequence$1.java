package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt___StringsKt$chunkedSequence$1.class */
final class StringsKt___StringsKt$chunkedSequence$1 extends Lambda implements Function1<CharSequence, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final StringsKt___StringsKt$chunkedSequence$1 f42753a = new StringsKt___StringsKt$chunkedSequence$1();

    StringsKt___StringsKt$chunkedSequence$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final String invoke(CharSequence it) {
        Intrinsics.e(it, "it");
        return it.toString();
    }
}

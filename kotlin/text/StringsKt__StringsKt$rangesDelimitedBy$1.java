package kotlin.text;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__StringsKt$rangesDelimitedBy$1.class */
final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ char[] a;
    final /* synthetic */ boolean b;

    public final Pair<Integer, Integer> a(CharSequence $receiver, int i) {
        Intrinsics.e($receiver, "$this$$receiver");
        int a = StringsKt.a($receiver, this.a, i, this.b);
        if (a < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(a), 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return a(charSequence, num.intValue());
    }
}

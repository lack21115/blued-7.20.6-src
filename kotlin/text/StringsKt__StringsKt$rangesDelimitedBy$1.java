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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ char[] f42747a;
    final /* synthetic */ boolean b;

    public final Pair<Integer, Integer> a(CharSequence $receiver, int i) {
        Intrinsics.e($receiver, "$this$$receiver");
        int a2 = StringsKt.a($receiver, this.f42747a, i, this.b);
        if (a2 < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(a2), 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return a(charSequence, num.intValue());
    }
}

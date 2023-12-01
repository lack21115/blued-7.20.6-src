package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt___StringsKt$windowedSequence$2.class */
final class StringsKt___StringsKt$windowedSequence$2<R> extends Lambda implements Function1<Integer, R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f42756a;
    final /* synthetic */ CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1<CharSequence, R> f42757c;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0 > r5.b.length()) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final R a(int r6) {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.f42756a
            r1 = r6
            int r0 = r0 + r1
            r8 = r0
            r0 = r8
            if (r0 < 0) goto L1a
            r0 = r8
            r7 = r0
            r0 = r8
            r1 = r5
            java.lang.CharSequence r1 = r1.b
            int r1 = r1.length()
            if (r0 <= r1) goto L24
        L1a:
            r0 = r5
            java.lang.CharSequence r0 = r0.b
            int r0 = r0.length()
            r7 = r0
        L24:
            r0 = r5
            kotlin.jvm.functions.Function1<java.lang.CharSequence, R> r0 = r0.f42757c
            r1 = r5
            java.lang.CharSequence r1 = r1.b
            r2 = r6
            r3 = r7
            java.lang.CharSequence r1 = r1.subSequence(r2, r3)
            java.lang.Object r0 = r0.invoke(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt___StringsKt$windowedSequence$2.a(int):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Integer num) {
        return a(num.intValue());
    }
}

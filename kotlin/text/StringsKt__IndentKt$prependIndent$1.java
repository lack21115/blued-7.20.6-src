package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__IndentKt$prependIndent$1.class */
final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ String a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final String invoke(String it) {
        String str;
        Intrinsics.e(it, "it");
        if (StringsKt.a((CharSequence) it)) {
            str = it;
            if (it.length() < this.a.length()) {
                return this.a;
            }
        } else {
            str = this.a + it;
        }
        return str;
    }
}

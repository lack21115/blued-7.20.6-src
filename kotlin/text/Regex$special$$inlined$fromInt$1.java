package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/Regex$special$$inlined$fromInt$1.class */
public final class Regex$special$$inlined$fromInt$1 extends Lambda implements Function1<RegexOption, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f42731a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Boolean invoke(RegexOption regexOption) {
        RegexOption regexOption2 = regexOption;
        return Boolean.valueOf((this.f42731a & regexOption2.b()) == regexOption2.a());
    }
}

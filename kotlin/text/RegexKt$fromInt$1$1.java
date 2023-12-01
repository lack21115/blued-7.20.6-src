package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/RegexKt$fromInt$1$1.class */
public final class RegexKt$fromInt$1$1<T> extends Lambda implements Function1<T, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f42739a;

    /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Boolean invoke(Enum r4) {
        FlagEnum flagEnum = (FlagEnum) r4;
        return Boolean.valueOf((this.f42739a & flagEnum.b()) == flagEnum.a());
    }
}

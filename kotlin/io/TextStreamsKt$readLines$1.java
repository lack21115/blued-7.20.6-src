package kotlin.io;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/TextStreamsKt$readLines$1.class */
final class TextStreamsKt$readLines$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList<String> f42510a;

    public final void a(String it) {
        Intrinsics.e(it, "it");
        this.f42510a.add(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(String str) {
        a(str);
        return Unit.f42314a;
    }
}

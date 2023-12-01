package androidx.core.os;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/TraceKt.class */
public final class TraceKt {
    @Deprecated
    public static final <T> T trace(String sectionName, Function0<? extends T> block) {
        Intrinsics.e(sectionName, "sectionName");
        Intrinsics.e(block, "block");
        TraceCompat.beginSection(sectionName);
        try {
            T invoke = block.invoke();
            InlineMarker.b(1);
            TraceCompat.endSection();
            InlineMarker.c(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.b(1);
            TraceCompat.endSection();
            InlineMarker.c(1);
            throw th;
        }
    }
}

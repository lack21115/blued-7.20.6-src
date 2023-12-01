package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: okio.-InflaterSourceExtensions  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-InflaterSourceExtensions.class */
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        Intrinsics.e(source, "<this>");
        Intrinsics.e(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.e(source, "<this>");
        Inflater inflater2 = inflater;
        Intrinsics.e(inflater2, "inflater");
        return new InflaterSource(source, inflater);
    }
}

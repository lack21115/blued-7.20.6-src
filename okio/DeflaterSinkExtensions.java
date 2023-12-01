package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: okio.-DeflaterSinkExtensions  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-DeflaterSinkExtensions.class */
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        Intrinsics.e(sink, "<this>");
        Intrinsics.e(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.e(sink, "<this>");
        Deflater deflater2 = deflater;
        Intrinsics.e(deflater2, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}

package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-GzipSinkExtensions.class */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        Intrinsics.e(sink, "<this>");
        return new GzipSink(sink);
    }
}

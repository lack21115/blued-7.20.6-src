package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: okio.-GzipSourceExtensions  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-GzipSourceExtensions.class */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int i, int i2) {
        return ((i >> i2) & 1) == 1;
    }

    public static final GzipSource gzip(Source source) {
        Intrinsics.e(source, "<this>");
        return new GzipSource(source);
    }
}

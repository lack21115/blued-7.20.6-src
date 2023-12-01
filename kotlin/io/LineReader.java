package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/LineReader.class */
public final class LineReader {
    private static final byte[] b;
    private static final ByteBuffer d;
    private static final CharBuffer e;
    private static final StringBuilder f;

    /* renamed from: a  reason: collision with root package name */
    public static final LineReader f42503a = new LineReader();

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f42504c = new char[32];

    static {
        byte[] bArr = new byte[32];
        b = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.c(wrap, "wrap(bytes)");
        d = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(f42504c);
        Intrinsics.c(wrap2, "wrap(chars)");
        e = wrap2;
        f = new StringBuilder();
    }

    private LineReader() {
    }
}

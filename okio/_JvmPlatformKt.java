package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/_JvmPlatformKt.class */
public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String str) {
        Intrinsics.e(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.b);
        Intrinsics.c(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m13309synchronized(Object lock, Function0<? extends R> block) {
        R invoke;
        Intrinsics.e(lock, "lock");
        Intrinsics.e(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                InlineMarker.b(1);
            } catch (Throwable th) {
                InlineMarker.b(1);
                InlineMarker.c(1);
                throw th;
            }
        }
        InlineMarker.c(1);
        return invoke;
    }

    public static final String toUtf8String(byte[] bArr) {
        Intrinsics.e(bArr, "<this>");
        return new String(bArr, Charsets.b);
    }
}

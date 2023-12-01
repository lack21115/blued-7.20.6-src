package androidx.core.util;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/AtomicFileKt.class */
public final class AtomicFileKt {
    public static final byte[] readBytes(android.util.AtomicFile atomicFile) {
        Intrinsics.e(atomicFile, "<this>");
        byte[] readFully = atomicFile.readFully();
        Intrinsics.c(readFully, "readFully()");
        return readFully;
    }

    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        Intrinsics.c(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.b;
        }
        return readText(atomicFile, charset);
    }

    public static final void tryWrite(android.util.AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> block) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(block, "block");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            Intrinsics.c(stream, "stream");
            block.invoke(stream);
            InlineMarker.b(1);
            atomicFile.finishWrite(stream);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            atomicFile.failWrite(stream);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] array) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(array, "array");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            Intrinsics.c(stream, "stream");
            stream.write(array);
            atomicFile.finishWrite(stream);
        } catch (Throwable th) {
            atomicFile.failWrite(stream);
            throw th;
        }
    }

    public static final void writeText(android.util.AtomicFile atomicFile, String text, Charset charset) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(text, "text");
        Intrinsics.e(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        Intrinsics.c(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.b;
        }
        writeText(atomicFile, str, charset);
    }
}

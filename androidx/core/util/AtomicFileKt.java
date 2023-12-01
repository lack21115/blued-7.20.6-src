package androidx.core.util;

import android.app.Instrumentation;
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

    public static final void tryWrite(android.util.AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(function1, "block");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.c(startWrite, Instrumentation.REPORT_KEY_STREAMRESULT);
            function1.invoke(startWrite);
            InlineMarker.b(1);
            atomicFile.finishWrite(startWrite);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            atomicFile.failWrite(startWrite);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(bArr, "array");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.c(startWrite, Instrumentation.REPORT_KEY_STREAMRESULT);
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) {
        Intrinsics.e(atomicFile, "<this>");
        Intrinsics.e(str, "text");
        Intrinsics.e(charset, "charset");
        byte[] bytes = str.getBytes(charset);
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

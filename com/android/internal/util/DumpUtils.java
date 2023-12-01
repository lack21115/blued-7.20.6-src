package com.android.internal.util;

import android.os.Handler;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/DumpUtils.class */
public final class DumpUtils {

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/DumpUtils$Dump.class */
    public interface Dump {
        void dump(PrintWriter printWriter);
    }

    private DumpUtils() {
    }

    public static void dumpAsync(Handler handler, final Dump dump, PrintWriter printWriter, long j) {
        final StringWriter stringWriter = new StringWriter();
        if (handler.runWithScissors(new Runnable() { // from class: com.android.internal.util.DumpUtils.1
            @Override // java.lang.Runnable
            public void run() {
                FastPrintWriter fastPrintWriter = new FastPrintWriter(StringWriter.this);
                dump.dump(fastPrintWriter);
                fastPrintWriter.close();
            }
        }, j)) {
            printWriter.print(stringWriter.toString());
        } else {
            printWriter.println("... timed out");
        }
    }
}

package com.kwad.sdk.crash.utils;

import android.os.Build;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/f.class */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/f$a.class */
    public static abstract class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        abstract Object Aj();

        abstract void println(Object obj);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/f$b.class */
    static final class b extends a {
        private final PrintWriter atc;

        b(PrintWriter printWriter) {
            super((byte) 0);
            this.atc = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final Object Aj() {
            return this.atc;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final void println(Object obj) {
            this.atc.println(obj);
        }
    }

    private static void a(Throwable th, a aVar) {
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.Aj()) {
            aVar.println(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                aVar.println("\tat " + stackTrace[i2]);
                i = i2 + 1;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                Throwable[] suppressed = th.getSuppressed();
                int length2 = suppressed.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    a(suppressed[i4], aVar, "Suppressed: ", "\t", newSetFromMap);
                    i3 = i4 + 1;
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                aVar.println(str2 + "\tat " + stackTrace[i2]);
                i = i2 + 1;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                Throwable[] suppressed = th.getSuppressed();
                int length2 = suppressed.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    a(suppressed[i4], aVar, "Suppressed: ", str2 + "\t", set);
                    i3 = i4 + 1;
                }
            }
            th = th.getCause();
            if (th == null) {
                return;
            }
            str = "Caused by: ";
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }
}

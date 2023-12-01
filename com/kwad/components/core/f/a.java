package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/f/a.class */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/f/a$a.class */
    public static final class C0351a {
        private static final a Ju = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private static File ab(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, long j) {
        File[] listFiles = ab(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.f.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(".apk");
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j2 = 0;
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            j2 = Math.max(j2, listFiles[i2].lastModified());
            i = i2 + 1;
        }
        long min = Math.min(j, j2);
        int length2 = listFiles.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            File file = listFiles[i4];
            if (file.exists() && file.lastModified() < min) {
                file.delete();
            }
            i3 = i4 + 1;
        }
    }

    public static a nA() {
        return C0351a.Ju;
    }

    public final void aa(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        g.schedule(new Runnable() { // from class: com.kwad.components.core.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.c(context, currentTimeMillis);
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }
}

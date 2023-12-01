package com.kwai.filedownloader.e;

import android.content.Context;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.y;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/c.class */
public final class c {
    private static Context aJp;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/c$a.class */
    public interface a {
        int ak(long j);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/c$b.class */
    public interface b {
        com.kwai.filedownloader.kwai.b q(String str);
    }

    /* renamed from: com.kwai.filedownloader.e.c$c  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/c$c.class */
    public interface InterfaceC0419c {
        com.kwai.filedownloader.a.a Ja();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/c$d.class */
    public interface d {
        int j(String str, String str2, boolean z);

        int k(String str, String str2, boolean z);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/c$e.class */
    public interface e {
        com.kwai.filedownloader.d.a ac(File file);
    }

    public static Context IZ() {
        return aJp;
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        int r;
        if (str2 == null || str == null || (r = yVar.r(str, i)) == 0) {
            return false;
        }
        com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(i, j, new PathConflictException(r, str, str2)));
        return true;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, y yVar, boolean z) {
        if (yVar.a(cVar)) {
            com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(i, cVar.IB(), cVar.getTotal(), z));
            return true;
        }
        return false;
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        if (z || str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(i, file, z2));
            return true;
        }
        return false;
    }

    public static void dt(Context context) {
        aJp = context;
    }
}

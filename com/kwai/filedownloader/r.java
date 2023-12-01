package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/r.class */
public class r {
    private static final Object aGh = new Object();
    private static final Object aGj = new Object();
    private w aGi;
    private volatile v aGk;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/r$a.class */
    static final class a {
        private static final r aGl = new r();
    }

    public static r Hp() {
        return a.aGl;
    }

    public static boolean Hr() {
        return n.Hh().isConnected();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwai.filedownloader.e.c.dt(context.getApplicationContext());
        com.kwai.filedownloader.download.b.HF().a(bVar);
    }

    private static void a(e eVar) {
        f.GU().a("event.service.connect.changed", eVar);
    }

    private int cE(int i) {
        List<a.InterfaceC0413a> cz = h.GW().cz(i);
        if (cz.isEmpty()) {
            com.kwai.filedownloader.e.d.h(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        for (a.InterfaceC0413a interfaceC0413a : cz) {
            interfaceC0413a.Gy().pause();
        }
        return cz.size();
    }

    public static void ds(Context context) {
        com.kwai.filedownloader.e.c.dt(context.getApplicationContext());
    }

    public static com.kwai.filedownloader.a fm(String str) {
        return new c(str);
    }

    public final void Hq() {
        if (Hr()) {
            return;
        }
        n.Hh().dr(com.kwai.filedownloader.e.c.IZ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w Hs() {
        if (this.aGi == null) {
            synchronized (aGh) {
                if (this.aGi == null) {
                    this.aGi = new ab();
                }
            }
        }
        return this.aGi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v Ht() {
        if (this.aGk == null) {
            synchronized (aGj) {
                if (this.aGk == null) {
                    this.aGk = new z();
                    a((e) this.aGk);
                }
            }
        }
        return this.aGk;
    }

    public final boolean m(int i, String str) {
        cE(i);
        if (n.Hh().cD(i)) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            File file = new File(com.kwai.filedownloader.e.f.fB(str));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
                return true;
            }
            return true;
        }
        return false;
    }
}

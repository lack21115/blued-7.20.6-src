package com.kwad.sdk.kwai.kwai;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/b.class */
public class b {
    private static volatile b YF;
    private Stack<AdTemplate> YD = new Stack<>();
    private File YE;
    private boolean mHasInit;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/b$a.class */
    public interface a {
        void gv();

        void sY();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3;
        synchronized (this) {
            boolean z = false;
            Iterator<AdTemplate> it = this.YD.iterator();
            while (it.hasNext()) {
                if (com.kwad.sdk.core.response.a.d.cl(it.next()) == com.kwad.sdk.core.response.a.d.cl(adTemplate)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.YE));
                    objectOutputStream3 = objectOutputStream2;
                } catch (Exception e) {
                    e = e;
                    objectOutputStream2 = null;
                } catch (Throwable th2) {
                    objectOutputStream = null;
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
                try {
                    try {
                        objectOutputStream2.writeObject(this.YD);
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = objectOutputStream3;
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    StringBuilder sb = new StringBuilder(" removeApkDownloadedData e");
                    ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                    sb.append(e);
                    objectOutputStream3 = objectOutputStream2;
                    com.kwad.sdk.core.d.b.d("InstallTipsDataManager", sb.toString());
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3;
        synchronized (this) {
            this.YD.add(adTemplate);
            try {
                objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(sV()));
                objectOutputStream3 = objectOutputStream2;
            } catch (Exception e) {
                e = e;
                objectOutputStream2 = null;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream2.writeObject(this.YD);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = objectOutputStream3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                objectOutputStream3 = objectOutputStream2;
                com.kwad.sdk.core.d.b.printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File ac(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.A(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        if (q.G(file)) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File sV() {
        synchronized (this) {
            if (this.YE != null) {
                return this.YE;
            }
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            String cE = av.cE(context);
            File file = new File(cE);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(cE + File.separator + "uninstall_ad");
            this.YE = file2;
            if (!file2.exists()) {
                try {
                    this.YE.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.YE;
        }
    }

    public static b sW() {
        if (YF == null) {
            synchronized (b.class) {
                try {
                    if (YF == null) {
                        YF = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return YF;
    }

    public final void a(final a aVar) {
        synchronized (this) {
            if (this.mHasInit) {
                return;
            }
            this.mHasInit = true;
            g.execute(new aw() { // from class: com.kwad.sdk.kwai.kwai.b.1
                /* JADX WARN: Can't wrap try/catch for region: R(11:(5:18|19|20|21|(6:23|24|25|(8:30|31|32|(6:34|35|36|37|38|(3:48|49|50)(5:52|53|54|55|56))(1:59)|51|26|27|28)|60|(3:61|62|(5:64|65|66|67|68)(1:69)))(0))|73|74|75|76|77|78|79|80|81|(2:83|84)(1:85)) */
                /* JADX WARN: Code restructure failed: missing block: B:101:0x01ee, code lost:
                    r5.sY();
                    r0 = r10;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:103:0x01fa, code lost:
                    com.kwad.sdk.crash.utils.b.closeQuietly(r11);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:105:0x0201, code lost:
                    com.kwad.sdk.crash.utils.b.closeQuietly(r10);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:106:0x0204, code lost:
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:107:0x0205, code lost:
                    com.kwad.sdk.crash.utils.b.closeQuietly(r10);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:113:0x021b, code lost:
                    com.kwad.sdk.crash.utils.b.closeQuietly(r9);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:114:0x0221, code lost:
                    throw r10;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:86:0x01bb, code lost:
                    r11 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:87:0x01bd, code lost:
                    r9 = r10;
                    r10 = r11;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x01c7, code lost:
                    r12 = e;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x01d1, code lost:
                    r9 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:93:0x01d2, code lost:
                    r10 = null;
                    r12 = r9;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:95:0x01dc, code lost:
                    com.kwad.sdk.core.d.b.printStackTrace(r12);
                    r0 = r10;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01e8, code lost:
                    if (r5 != null) goto L93;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:99:0x01eb, code lost:
                    r0 = r10;
                 */
                /* JADX WARN: Removed duplicated region for block: B:111:0x0211 A[Catch: all -> 0x0229, TryCatch #3 {all -> 0x0229, blocks: (B:2:0x0000, B:5:0x0007, B:8:0x000e, B:56:0x0132, B:85:0x01b5, B:109:0x020b, B:111:0x0211, B:113:0x021b, B:114:0x0221, B:105:0x0201, B:107:0x0205, B:78:0x018e, B:116:0x0224, B:117:0x0228), top: B:127:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:121:0x022f A[RETURN] */
                @Override // com.kwad.sdk.utils.aw
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void doTask() {
                    /*
                        Method dump skipped, instructions count: 564
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.kwai.kwai.b.AnonymousClass1.doTask():void");
                }
            });
        }
    }

    public final void aa(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.Z(adTemplate);
            }
        });
    }

    public final void ab(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.Y(adTemplate);
            }
        });
    }

    public final AdTemplate sX() {
        AdTemplate adTemplate;
        synchronized (this) {
            Stack stack = (Stack) this.YD.clone();
            while (true) {
                adTemplate = null;
                if (stack.isEmpty()) {
                    break;
                }
                adTemplate = (AdTemplate) stack.pop();
                if (adTemplate != null) {
                    String str = com.kwad.sdk.core.response.a.d.cb(adTemplate).adBaseInfo.appPackageName;
                    Context context = KsAdSDKImpl.get().getContext();
                    File ac = ac(adTemplate);
                    if (ac != null && ac.exists() && ac.lastModified() + 604800000 > System.currentTimeMillis() && !ak.ah(context, str)) {
                        break;
                    }
                }
            }
        }
        return adTemplate;
    }
}

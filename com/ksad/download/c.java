package com.ksad.download;

import android.content.Context;
import com.ksad.download.DownloadTask;
import com.ksad.download.f;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.av;
import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.r;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/c.class */
public final class c {
    private com.ksad.download.a br;
    private d bt;
    private Context mContext;
    private final Map<Integer, DownloadTask> bp = new ConcurrentHashMap();
    private final Map<String, Integer> bq = new ConcurrentHashMap();
    private boolean bs = false;

    /* loaded from: source-7994992-dex2jar.jar:com/ksad/download/c$a.class */
    static final class a {
        private static final c bv = new c();
    }

    public static c M() {
        return a.bv;
    }

    public static boolean P() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private void Q() {
        f.a aVar;
        try {
            aVar = new f.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwai.filedownloader.download.b.HF().b(new c.b().df(Integer.MAX_VALUE).a(aVar));
            this.bs = true;
        }
    }

    private static void R() {
        f.a aVar;
        try {
            aVar = new f.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwai.filedownloader.download.b.HF().b(new c.b().df(Integer.MAX_VALUE).a(aVar));
        }
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }

    private void a(int i, com.ksad.download.a... aVarArr) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i));
        if (downloadTask == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 2) {
                return;
            }
            com.ksad.download.a aVar = aVarArr[i3];
            if (aVar != null) {
                aVar.setId(i);
                downloadTask.addListener(aVar);
            }
            i2 = i3 + 1;
        }
    }

    private void h(DownloadTask downloadTask) {
        this.bp.remove(Integer.valueOf(downloadTask.getId()));
        this.bq.remove(downloadTask.getUrl());
    }

    private void t(int i) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public final File N() {
        return av.cB(this.mContext);
    }

    public final d O() {
        if (this.bt == null) {
            this.bt = new com.kwad.sdk.core.download.a.a();
        }
        return this.bt;
    }

    public final boolean S() {
        while (true) {
            boolean z = false;
            for (Map.Entry<Integer, DownloadTask> entry : this.bp.entrySet()) {
                DownloadTask value = entry.getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > com.igexin.push.config.c.l) {
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    public final int a(DownloadTask.DownloadRequest downloadRequest, com.ksad.download.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            Q();
        } else if (this.bs) {
            R();
        }
        if (this.bp.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            t(downloadTask.getId());
        } else {
            this.bp.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.bq.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.br);
        return downloadTask.getId();
    }

    public final void a(com.ksad.download.a aVar) {
        this.br = aVar;
    }

    public final void cancel(int i) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        if (ak.ak(this.mContext, downloadTask.getTargetFilePath())) {
            com.kwad.sdk.core.download.c.vu().bS(ad.eC(downloadTask.getUrl()));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(Context context) {
        this.mContext = context;
        r.a(context, new c.b().df(Integer.MAX_VALUE).a(new c.a() { // from class: com.ksad.download.c.1
            @Override // com.kwai.filedownloader.services.c.a
            public final c.b T() {
                try {
                    f.a aVar = new f.a(false);
                    aVar.q("");
                    return aVar;
                } catch (Throwable th) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i) {
        a(i, (DownloadTask.DownloadRequest) null);
    }

    public final DownloadTask s(int i) {
        return this.bp.get(Integer.valueOf(i));
    }

    public final void u(int i) {
        DownloadTask s = s(i);
        if (s == null) {
            return;
        }
        if (s.isUserPause()) {
            resume(i);
        } else {
            pause(i);
        }
    }
}

package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/h.class */
final class h {
    private ThreadPoolExecutor aJh;
    private int aJj;
    private SparseArray<DownloadLaunchRunnable> aJg = new SparseArray<>();
    private final String aJi = "Network";
    private int aJk = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i) {
        this.aJh = com.kwai.filedownloader.e.b.n(i, "Network");
        this.aJj = i;
    }

    private void IU() {
        synchronized (this) {
            SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
            int size = this.aJg.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    int keyAt = this.aJg.keyAt(i2);
                    DownloadLaunchRunnable downloadLaunchRunnable = this.aJg.get(keyAt);
                    if (downloadLaunchRunnable.isAlive()) {
                        sparseArray.put(keyAt, downloadLaunchRunnable);
                    }
                    i = i2 + 1;
                } else {
                    this.aJg = sparseArray;
                }
            }
        }
    }

    public final int IV() {
        int size;
        synchronized (this) {
            IU();
            size = this.aJg.size();
        }
        return size;
    }

    public final List<Integer> IW() {
        ArrayList arrayList;
        synchronized (this) {
            IU();
            arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aJg.size()) {
                    arrayList.add(Integer.valueOf(this.aJg.get(this.aJg.keyAt(i2)).getId()));
                    i = i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i;
        downloadLaunchRunnable.HO();
        synchronized (this) {
            this.aJg.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aJh.execute(downloadLaunchRunnable);
        int i2 = this.aJk;
        if (i2 >= 600) {
            IU();
            i = 0;
        } else {
            i = i2 + 1;
        }
        this.aJk = i;
    }

    public final boolean cV(int i) {
        synchronized (this) {
            if (IV() > 0) {
                com.kwai.filedownloader.e.d.h(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
                return false;
            }
            int dj = com.kwai.filedownloader.e.e.dj(i);
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aJj), Integer.valueOf(dj));
            }
            List<Runnable> shutdownNow = this.aJh.shutdownNow();
            this.aJh = com.kwai.filedownloader.e.b.n(dj, "Network");
            if (shutdownNow.size() > 0) {
                com.kwai.filedownloader.e.d.h(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
            }
            this.aJj = dj;
            return true;
        }
    }

    public final void cancel(int i) {
        IU();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.aJg.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.aJh.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.aJg.remove(i);
        }
    }

    public final boolean di(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aJg.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final int r(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.aJg.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return 0;
            }
            DownloadLaunchRunnable valueAt = this.aJg.valueAt(i3);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.HT())) {
                return valueAt.getId();
            }
            i2 = i3 + 1;
        }
    }
}

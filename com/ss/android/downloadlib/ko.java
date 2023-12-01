package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ko.class */
public class ko {
    private static volatile ko mb;
    private long u;
    private final List<com.ss.android.downloadlib.addownload.u> b = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.u> hj = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> h = new CopyOnWriteArrayList<>();
    private final Handler ox = new Handler(Looper.getMainLooper());

    private ko() {
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.u < 300000) {
            return;
        }
        this.u = currentTimeMillis;
        if (this.b.isEmpty()) {
            return;
        }
        hj();
    }

    private void b(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.h hVar = new com.ss.android.downloadlib.addownload.h();
        hVar.ox(context).ox(i, downloadStatusChangeListener).ox(downloadModel).mb();
        this.hj.put(downloadModel.getDownloadUrl(), hVar);
    }

    private void hj() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.u uVar : this.b) {
            if (!uVar.ox() && currentTimeMillis - uVar.hj() > 300000) {
                uVar.ww();
                arrayList.add(uVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.b.removeAll(arrayList);
    }

    public static ko mb() {
        if (mb == null) {
            synchronized (ko.class) {
                try {
                    if (mb == null) {
                        mb = new ko();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    private void ox(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        synchronized (this) {
            if (this.b.size() <= 0) {
                b(context, i, downloadStatusChangeListener, downloadModel);
            } else {
                com.ss.android.downloadlib.addownload.u remove = this.b.remove(0);
                remove.ox(context).ox(i, downloadStatusChangeListener).ox(downloadModel).mb();
                this.hj.put(downloadModel.getDownloadUrl(), remove);
            }
        }
    }

    public com.ss.android.downloadlib.addownload.h mb(String str) {
        Map<String, com.ss.android.downloadlib.addownload.u> map = this.hj;
        if (map == null || map.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        com.ss.android.downloadlib.addownload.u uVar = this.hj.get(str);
        if (uVar instanceof com.ss.android.downloadlib.addownload.h) {
            return (com.ss.android.downloadlib.addownload.h) uVar;
        }
        return null;
    }

    public void mb(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        com.ss.android.downloadlib.addownload.u uVar = this.hj.get(downloadModel.getDownloadUrl());
        if (uVar != null) {
            uVar.ox(context).ox(i, downloadStatusChangeListener).ox(downloadModel).mb();
        } else if (this.b.isEmpty()) {
            b(context, i, downloadStatusChangeListener, downloadModel);
        } else {
            ox(context, i, downloadStatusChangeListener, downloadModel);
        }
    }

    public void mb(final DownloadModel downloadModel, final DownloadController downloadController, final DownloadEventConfig downloadEventConfig) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ko.this.h.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) next).mb(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void mb(com.ss.android.download.api.download.mb.mb mbVar) {
        if (mbVar != null) {
            if (DownloadSetting.obtainGlobal().optBugFix("fix_listener_oom", false)) {
                this.h.add(new SoftReference(mbVar));
            } else {
                this.h.add(mbVar);
            }
        }
    }

    public void mb(final DownloadInfo downloadInfo) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ko.this.h.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) next).mb(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadInfo);
                        }
                    }
                }
            }
        });
    }

    public void mb(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ko.this.h.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) next).mb(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void mb(final DownloadInfo downloadInfo, final String str) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ko.this.h.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) next).mb(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void mb(String str, int i) {
        com.ss.android.downloadlib.addownload.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.hj.get(str)) == null) {
            return;
        }
        if (uVar.mb(i)) {
            this.b.add(uVar);
            this.hj.remove(str);
        }
        b();
    }

    public void mb(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        mb(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void mb(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        mb(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void mb(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.hj.get(str)) == null) {
            return;
        }
        uVar.mb(j).ox(downloadEventConfig).ox(downloadController).mb(onItemClickListener).mb(iDownloadButtonClickListener).ox(i);
    }

    public void mb(String str, boolean z) {
        com.ss.android.downloadlib.addownload.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.hj.get(str)) == null) {
            return;
        }
        uVar.mb(z);
    }

    public Handler ox() {
        return this.ox;
    }

    public void ox(final DownloadInfo downloadInfo, final String str) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ko.this.h.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) next).ox(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).ox(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }
}

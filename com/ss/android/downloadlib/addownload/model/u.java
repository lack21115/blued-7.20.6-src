package com.ss.android.downloadlib.addownload.model;

import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/u.class */
public class u {
    private final ConcurrentHashMap<Long, DownloadEventConfig> b;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> h;
    private final ConcurrentHashMap<Long, DownloadController> hj;
    private volatile boolean mb;
    private final ConcurrentHashMap<Long, DownloadModel> ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/u$mb.class */
    public static class mb {
        private static u mb = new u();
    }

    private u() {
        this.mb = false;
        this.ox = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.hj = new ConcurrentHashMap<>();
        this.h = new ConcurrentHashMap<>();
    }

    public static u mb() {
        return mb.mb;
    }

    public DownloadController b(long j) {
        return this.hj.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> b() {
        return this.h;
    }

    public h h(long j) {
        h hVar = new h();
        hVar.mb = j;
        hVar.ox = mb(j);
        hVar.b = ox(j);
        if (hVar.b == null) {
            hVar.b = new com.ss.android.download.api.download.b();
        }
        hVar.hj = b(j);
        if (hVar.hj == null) {
            hVar.hj = new com.ss.android.download.api.download.ox();
        }
        return hVar;
    }

    public com.ss.android.downloadad.api.mb.ox hj(long j) {
        return this.h.get(Long.valueOf(j));
    }

    public DownloadModel mb(long j) {
        return this.ox.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.mb.ox mb(int i) {
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.h.values()) {
            if (oxVar != null && oxVar.m() == i) {
                return oxVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.mb.ox mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.h.values()) {
            if (oxVar != null && oxVar.m() == downloadInfo.getId()) {
                return oxVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long mb2 = jb.mb(new JSONObject(downloadInfo.getExtra()), "extra");
                if (mb2 != 0) {
                    for (com.ss.android.downloadad.api.mb.ox oxVar2 : this.h.values()) {
                        if (oxVar2 != null && oxVar2.ox() == mb2) {
                            return oxVar2;
                        }
                    }
                    com.ss.android.downloadlib.exception.b.mb().mb("getNativeModelByInfo");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar3 : this.h.values()) {
            if (oxVar3 != null && TextUtils.equals(oxVar3.mb(), downloadInfo.getUrl())) {
                return oxVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.mb.ox mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.h.values()) {
            if (oxVar != null && str.equals(oxVar.h())) {
                return oxVar;
            }
        }
        return null;
    }

    public Map<Long, com.ss.android.downloadad.api.mb.ox> mb(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return hashMap;
            }
            for (com.ss.android.downloadad.api.mb.ox oxVar : this.h.values()) {
                if (oxVar != null && TextUtils.equals(oxVar.mb(), str)) {
                    oxVar.ox(str2);
                    hashMap.put(Long.valueOf(oxVar.ox()), oxVar);
                }
            }
        }
        return hashMap;
    }

    public void mb(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.hj.put(Long.valueOf(j), downloadController);
        }
    }

    public void mb(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.b.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void mb(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.ox.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        synchronized (this) {
            if (oxVar == null) {
                return;
            }
            this.h.put(Long.valueOf(oxVar.ox()), oxVar);
            ww.mb().mb(oxVar);
        }
    }

    public void mb(List<Long> list) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                long longValue = l.longValue();
                arrayList.add(String.valueOf(longValue));
                this.h.remove(Long.valueOf(longValue));
            }
            ww.mb().mb((List<String>) arrayList);
        }
    }

    public DownloadEventConfig ox(long j) {
        return this.b.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.mb.ox ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.h.values()) {
            if (oxVar != null && str.equals(oxVar.mb())) {
                return oxVar;
            }
        }
        return null;
    }

    public void ox() {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.addownload.model.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.mb) {
                    return;
                }
                synchronized (u.class) {
                    try {
                        if (!u.this.mb) {
                            u.this.h.putAll(ww.mb().ox());
                            u.this.mb = true;
                        }
                    } finally {
                    }
                }
            }
        }, true);
    }

    public void ox(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.ox.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void u(long j) {
        this.ox.remove(Long.valueOf(j));
        this.b.remove(Long.valueOf(j));
        this.hj.remove(Long.valueOf(j));
    }
}

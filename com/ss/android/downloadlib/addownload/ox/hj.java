package com.ss.android.downloadlib.addownload.ox;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ox/hj.class */
public class hj {
    private static volatile hj mb;
    private long ox = 0;
    private ConcurrentHashMap<String, h> b = new ConcurrentHashMap<>();
    private HashMap<String, Integer> hj = new HashMap<>();
    private List<String> h = new CopyOnWriteArrayList();

    public static hj mb() {
        if (mb == null) {
            synchronized (hj.class) {
                try {
                    if (mb == null) {
                        mb = new hj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    public static void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        DownloadInfo downloadInfo;
        if (oxVar == null || oxVar.ox() <= 0 || (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m())) == null) {
            return;
        }
        mb(downloadInfo);
    }

    public static void mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.ox = System.currentTimeMillis();
    }

    public void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }

    public void mb(String str, h hVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, hVar);
    }

    public int ox(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.hj == null) {
            this.hj = new HashMap<>();
        }
        if (this.hj.containsKey(str)) {
            i = this.hj.get(str).intValue();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ox() {
        return this.ox;
    }
}

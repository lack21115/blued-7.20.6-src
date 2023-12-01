package com.ss.android.downloadlib.addownload;

import android.net.http.Headers;
import android.os.Handler;
import com.ss.android.downloadlib.addownload.h;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/hj.class */
public class hj {
    private AtomicBoolean b = new AtomicBoolean(false);
    private AtomicBoolean hj = new AtomicBoolean(false);
    private Handler mb;
    private com.ss.android.downloadlib.addownload.model.h ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hj(Handler handler) {
        this.mb = handler;
    }

    static /* synthetic */ long b() {
        return hj();
    }

    private static long hj() {
        return com.ss.android.downloadlib.utils.jb.mb(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long mb(Map<String, String> map) {
        String key;
        String value;
        if (map == null || map.size() == 0) {
            return 0L;
        }
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    return 0L;
                }
                Map.Entry<String, String> next = it.next();
                key = next.getKey();
                value = next.getValue();
            } while (!Headers.CONTENT_LEN.equalsIgnoreCase(key));
            return Long.parseLong(value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static JSONObject mb(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.CLEAN_SPACE_INSTALL_PARAMS, str);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static void mb(int i) {
        if (com.ss.android.downloadlib.utils.hj.u(i) && x.je() != null && x.je().ox()) {
            x.je().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i, String str, long j, final com.ss.android.downloadad.api.mb.ox oxVar, long j2, final h.mb mbVar) {
        this.b.set(true);
        boolean z = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.APK_SIZE, Long.valueOf(j));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            long longValue = (Double.valueOf((com.ss.android.downloadlib.utils.hj.mb(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.utils.hj.ox(i)) - j2;
            long hj = hj();
            z = false;
            if (hj < longValue) {
                mb(oxVar, jSONObject, longValue, hj);
                mb(oxVar);
                long hj2 = hj();
                if (hj2 < longValue) {
                    oxVar.hj(true);
                    final String mb = oxVar.mb();
                    com.ss.android.downloadlib.addownload.ox.hj.mb().mb(mb, new com.ss.android.downloadlib.addownload.ox.h() { // from class: com.ss.android.downloadlib.addownload.hj.4
                    });
                    boolean mb2 = mb(i, oxVar, str, longValue);
                    z = mb2;
                    if (mb2) {
                        oxVar.h(true);
                        z = mb2;
                    }
                } else {
                    ox(oxVar, jSONObject, hj, hj2);
                    z = false;
                }
            }
        }
        if (z) {
            return;
        }
        this.mb.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hj.5
            @Override // java.lang.Runnable
            public void run() {
                mbVar.mb();
            }
        });
    }

    private static void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        long hj = hj();
        if (x.je() != null) {
            x.je().h();
        }
        com.ss.android.downloadlib.addownload.ox.b.mb();
        com.ss.android.downloadlib.addownload.ox.b.ox();
        if (com.ss.android.downloadlib.utils.hj.ko(oxVar.m())) {
            com.ss.android.downloadlib.addownload.ox.b.mb(x.getContext());
        }
        long hj2 = hj();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.QUITE_CLEAN_SIZE, Long.valueOf(hj2 - hj));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_QUITE_FINISH, jSONObject, oxVar);
    }

    private void mb(com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt(EventConstants.ExtraJson.APK_DOWNLOAD_NEED_SIZE, Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SPACE_NO_ENOUGH, jSONObject, oxVar);
    }

    private void mb(String str, com.ss.android.downloadad.api.mb.ox oxVar, final h.ox oxVar2) {
        if (oxVar2 == null) {
            return;
        }
        DownloadPreconnecter.asyncFetchHttpHeadInfo(str, new IFetchHttpHeadInfoListener() { // from class: com.ss.android.downloadlib.addownload.hj.3
            @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
            public void onFetchFinished(Map<String, String> map) {
                if (hj.this.b.get()) {
                    return;
                }
                hj.this.b.set(true);
                long mb = hj.this.mb(map);
                if (mb > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(EventConstants.ExtraJson.APK_SIZE, Long.valueOf(mb));
                        jSONObject.putOpt("available_space", Long.valueOf(hj.b()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                oxVar2.mb(mb);
            }
        });
    }

    private boolean mb(int i, com.ss.android.downloadad.api.mb.ox oxVar, String str, long j) {
        if (com.ss.android.downloadlib.utils.hj.u(i)) {
            if (x.je() != null) {
                return x.je().mb(i, str, true, j);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.CLEAN_SHOW_DIALOG_RESULT, 3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SHOW_DIALOG, jSONObject, oxVar);
            return false;
        }
        return false;
    }

    public static boolean mb(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (com.ss.android.downloadlib.utils.hj.u(id)) {
            if (x.je() != null) {
                boolean mb = x.je().mb(id, downloadInfo.getUrl(), false, j);
                z = mb;
                if (mb) {
                    com.ss.android.downloadlib.addownload.ox.hj.mb().mb(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.ox.h() { // from class: com.ss.android.downloadlib.addownload.hj.6
                    });
                    z = mb;
                }
            }
            return z;
        }
        return false;
    }

    public static long ox() {
        if (x.je() != null) {
            return x.je().mb();
        }
        return 0L;
    }

    private void ox(com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject, long j, long j2) {
        oxVar.je("1");
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.QUITE_CLEAN_SIZE, Long.valueOf(j2 - j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.DOWNLOAD_AFTER_QUITE_CLEAN, jSONObject, oxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(final int i, final long j, long j2, final h.mb mbVar) {
        long j3;
        this.hj.set(false);
        if (mbVar == null) {
            return;
        }
        if (!com.ss.android.downloadlib.utils.hj.u(i) || !com.ss.android.downloadlib.utils.hj.h(i)) {
            mbVar.mb();
            return;
        }
        long b = com.ss.android.downloadlib.utils.hj.b(i);
        this.b.set(false);
        final String downloadUrl = this.ox.ox.getDownloadUrl();
        com.ss.android.downloadad.api.mb.ox ox = com.ss.android.downloadlib.addownload.model.u.mb().ox(downloadUrl);
        com.ss.android.downloadad.api.mb.ox oxVar = ox;
        if (ox == null) {
            oxVar = new com.ss.android.downloadad.api.mb.ox(this.ox.ox, this.ox.b, this.ox.hj, 0);
            com.ss.android.downloadlib.addownload.model.u.mb().mb(oxVar);
        }
        oxVar.h(false);
        if (x.je() != null) {
            x.je().mb(oxVar.ox());
        }
        com.ss.android.downloadlib.addownload.ox.hj.mb().mb(oxVar.mb());
        boolean hj = com.ss.android.downloadlib.utils.hj.hj(i);
        if (j2 > 0) {
            mb(i, downloadUrl, j2, oxVar, j, mbVar);
            j3 = b;
        } else if (hj) {
            final com.ss.android.downloadad.api.mb.ox oxVar2 = oxVar;
            mb(downloadUrl, oxVar, new h.ox() { // from class: com.ss.android.downloadlib.addownload.hj.1
                @Override // com.ss.android.downloadlib.addownload.h.ox
                public void mb(long j4) {
                    hj.this.mb(i, downloadUrl, j4, oxVar2, j, mbVar);
                }
            });
            j3 = b;
        } else {
            j3 = 0;
        }
        this.mb.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hj.2
            @Override // java.lang.Runnable
            public void run() {
                if (hj.this.b.get()) {
                    return;
                }
                hj.this.b.set(true);
                mbVar.mb();
            }
        }, j3);
    }

    public void mb(com.ss.android.downloadlib.addownload.model.h hVar) {
        this.ox = hVar;
    }

    public void mb(boolean z) {
        this.hj.set(z);
    }

    public boolean mb() {
        return this.hj.get();
    }
}

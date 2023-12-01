package com.ss.android.downloadlib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.igexin.push.config.c;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.model.hj;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.appdownloader.ox;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb.class */
public class mb implements com.ss.android.downloadad.api.mb, ox.b, AppStatusManager.AppStatusChangeListener, IOpenInstallerListener {
    private static volatile mb hj;
    private static String mb = mb.class.getSimpleName();
    private ox b;
    private long ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb$b.class */
    public class b implements Runnable {
        private final com.ss.android.downloadad.api.mb.ox ox;

        public b(com.ss.android.downloadad.api.mb.ox oxVar) {
            this.ox = oxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.ox.x(true);
                    mb.this.b(this.ox);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.ox.x(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.downloadlib.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb$mb.class */
    public class RunnableC0873mb implements Runnable {
        private final int ox;

        public RunnableC0873mb(int i) {
            this.ox = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.model.u.mb().ox();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> b = com.ss.android.downloadlib.addownload.model.u.mb().b();
                if (b == null || b.isEmpty()) {
                    return;
                }
                mb.this.mb(b, this.ox);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb$ox.class */
    public static class ox implements Runnable {
        private long b;
        private long h;
        private int hj;
        private long mb;
        private int ox;

        private ox(long j, int i, long j2, int i2) {
            this.mb = j;
            this.ox = i;
            this.b = j2;
            this.hj = i2;
        }

        private int mb(boolean z, com.ss.android.downloadad.api.mb.ox oxVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            int i = 1;
            if (obtain.optInt("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put(EventConstants.ExtraJson.TTMD5_STATUS, checkMd5Status);
                } catch (Throwable th) {
                }
                if (!DownloadUtils.isMd5Valid(checkMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.hj;
            if (i2 != 2000) {
                return i2;
            }
            if (obtain.optInt("install_failed_check_signature", 1) == 1 && jb.hj(x.getContext(), oxVar.h())) {
                if (!jb.mb(jb.ww(x.getContext(), downloadInfo.getTargetFilePath()), jb.ko(x.getContext(), oxVar.h()))) {
                    return 2006;
                }
            }
            if (z) {
                long j = this.h;
                long j2 = this.b;
                if (j > j2) {
                    try {
                        jSONObject.put("install_time", j - j2);
                        if (oxVar.xa() <= this.b) {
                            i = 0;
                        }
                        jSONObject.put(EventConstants.ExtraJson.KEY_INSTALL_AGAIN, i);
                    } catch (Throwable th2) {
                    }
                    return !z2 ? 2003 : 2004;
                }
                return 2000;
            }
            return 2002;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ox() {
            this.h = System.currentTimeMillis();
        }

        boolean mb() {
            DownloadInfo downloadInfo;
            com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(this.mb);
            boolean z = false;
            if (hj == null || jb.ox(hj) || hj.b.get() || (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(hj.m())) == null) {
                return false;
            }
            long vy = hj.vy();
            long mb = jb.mb(Environment.getDataDirectory());
            long min = Math.min(524288000L, mb / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d = min;
            double d2 = totalBytes;
            if (vy <= -1 || totalBytes <= -1 || vy >= d + (2.5d * d2)) {
                z = true;
            }
            boolean mb2 = com.ss.android.socialbase.appdownloader.ox.mb(x.getContext());
            JSONObject jSONObject = new JSONObject();
            int mb3 = mb(z, hj, downloadInfo, mb2, jSONObject);
            this.hj = mb3;
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(mb3));
                jSONObject.putOpt("available_space", Long.valueOf(vy / 1048576));
                jSONObject.putOpt(EventConstants.ExtraJson.TOTAL_SPACE, Long.valueOf(mb / 1048576));
                int i = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
                if (i > 0) {
                    jSONObject.putOpt("package_size", Long.valueOf(totalBytes / 1048576));
                }
                jSONObject.putOpt(EventConstants.ExtraJson.SPACE_ENOUGH, Integer.valueOf(z ? 1 : 2));
                if (vy > 0 && i > 0) {
                    jSONObject.put(EventConstants.ExtraJson.KEY_AVAILABLE_SPACE_RATIO, vy / d2);
                }
                jSONObject.putOpt(EventConstants.ExtraJson.PERMISSION_UNKNOWN_SOURCE_INSTALL, Integer.valueOf(mb2 ? 1 : 2));
                int i2 = 2;
                if (hj.qa()) {
                    i2 = 1;
                }
                jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            AdEventHandler.mb().ox(EventConstants.Label.INSTALL_FAILED, jSONObject, hj);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (mb()) {
                    mb.mb().mb(this.mb, this.ox);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private mb() {
        com.ss.android.socialbase.appdownloader.ox.mb(this);
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static String b(DownloadInfo downloadInfo, com.ss.android.downloadad.api.mb.ox oxVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = x.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.b.mb());
                str = null;
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.ExtraJson.REAL_PACKAGE_NAME, str);
            jSONObject.put(EventConstants.ExtraJson.INPUT_PACKAGE_NAME, downloadInfo.getPackageName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.PACKAGE_NAME_ERROR, jSONObject, oxVar);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.ss.android.downloadad.api.mb.ox oxVar) {
        SystemClock.sleep(20000L);
        int i = 15;
        while (i > 0) {
            if (jb.ox(oxVar)) {
                mb(oxVar.h());
                return;
            }
            i--;
            if (i == 0) {
                return;
            }
            SystemClock.sleep(20000L);
        }
    }

    private int hj(com.ss.android.downloadad.api.mb.ox oxVar) {
        int realStatus;
        double optDouble = DownloadSetting.obtain(oxVar.m()).optDouble("download_failed_finally_hours", 48.0d);
        if (optDouble <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - oxVar.wn() < optDouble * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (oxVar.hj.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && oxVar.hj.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                mb(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(oxVar.fu()));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, oxVar.ep());
                jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, oxVar.on());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, oxVar.qa() ? 1 : 2);
                AdEventHandler.mb().mb(oxVar.x(), EventConstants.Label.DOWNLOAD_FAILED_FINALLY, jSONObject, oxVar);
                com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }
        return 1;
    }

    private int mb(com.ss.android.downloadad.api.mb.ox oxVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int ox2 = com.ss.android.socialbase.appdownloader.b.ox(x.getContext(), downloadInfo);
        int ox3 = jb.ox(x.getContext(), str);
        if (ox2 > 0 && ox3 > 0 && ox2 != ox3) {
            return ox3 > ox2 ? 3011 : 3010;
        } else if (DownloadSetting.obtain(oxVar.m()).optInt("install_finish_check_ttmd5", 1) == 1) {
            String string = x.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(oxVar.ox()), null);
            String str2 = string;
            if (TextUtils.isEmpty(string)) {
                str2 = string;
                if (downloadInfo != null) {
                    str2 = com.ss.android.downloadlib.utils.mb.mb(downloadInfo.getTargetFilePath());
                }
            }
            int mb2 = com.ss.android.downloadlib.utils.mb.mb(str2, com.ss.android.downloadlib.utils.mb.ox(str));
            try {
                jSONObject.put(EventConstants.ExtraJson.TTMD5_STATUS, mb2);
            } catch (Throwable th) {
            }
            if (mb2 == 0) {
                return 3000;
            }
            return mb2 == 1 ? 3002 : 3001;
        } else {
            return 3001;
        }
    }

    public static mb mb() {
        if (hj == null) {
            synchronized (mb.class) {
                try {
                    if (hj == null) {
                        hj = new mb();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return hj;
    }

    private static DownloadInfo mb(List<DownloadInfo> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (DownloadInfo downloadInfo : list) {
            if (downloadInfo != null) {
                if (str.equals(downloadInfo.getPackageName())) {
                    return downloadInfo;
                }
                if (jb.mb(x.getContext(), downloadInfo.getTargetFilePath(), str)) {
                    return downloadInfo;
                }
            }
        }
        return null;
    }

    private JSONObject mb(com.ss.android.downloadad.api.mb.ox oxVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.mb mb2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.utils.h.mb(jSONObject, oxVar.m());
            com.ss.android.downloadlib.utils.h.mb(oxVar, jSONObject);
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, oxVar.qa() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_INSTALL_AFTER_BACK_APP, oxVar.nq() ? 1 : 2);
            jSONObject.putOpt(EventConstants.ExtraJson.CLEAN_SPACE_INSTALL_PARAMS, oxVar.ot() ? "1" : "2");
            if (downloadInfo != null) {
                mb(jSONObject, downloadInfo);
                try {
                    jSONObject.put(EventConstants.ExtraJson.KEY_UNINSTALL_RESUME_COUNT, downloadInfo.getUninstallResumeCount());
                    if (oxVar.xa() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - oxVar.xa());
                    }
                } catch (Throwable th) {
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("ah_attempt"), null);
                if (!TextUtils.isEmpty(string) && (mb2 = com.ss.android.socialbase.appdownloader.mb.mb(string)) != null) {
                    mb2.mb(jSONObject);
                }
            }
            int mb3 = mb(oxVar, downloadInfo, str, jSONObject);
            jSONObject.put(EventConstants.ExtraJson.FAIL_STATUS, mb3);
            if (mb3 == 3000) {
                jSONObject.put("hijack", 2);
                return jSONObject;
            } else if (mb3 == 3001) {
                jSONObject.put("hijack", 0);
                return jSONObject;
            } else {
                jSONObject.put("hijack", 1);
                return jSONObject;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0326 -> B:58:0x0253). Please submit an issue!!! */
    public static JSONObject mb(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null) {
            if (downloadInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) != 0) {
                try {
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject.put(MonitorConstants.EXTRA_CUR_NETWORK_QUALITY, NetTrafficManager.getInstance().getCurrentNetworkQuality().name());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put(MonitorConstants.EXTRA_TOTAL_RETRY_COUNT, downloadInfo.getTotalRetryCount());
                    jSONObject.put(MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, downloadInfo.getCurRetryTimeInTotal());
                    jSONObject.put(MonitorConstants.EXTRA_REAL_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime());
                    jSONObject.put(EventConstants.ExtraJson.KEY_FIRST_SPEED_TIME, downloadInfo.getFirstSpeedTime());
                    jSONObject.put(EventConstants.ExtraJson.KEY_ALL_CONNECT_TIME, downloadInfo.getAllConnectTime());
                    jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_PREPARE_TIME, downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                    jSONObject.put(MonitorConstants.EXTRA_CHUNK_DOWNGRADE_UESD, downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                    jSONObject.put(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                    jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                    jSONObject.put(MonitorConstants.EXTRA_PRECONNECT_LEVEL, downloadInfo.getPreconnectLevel());
                    jSONObject.put("md5", downloadInfo.getMd5());
                    jSONObject.put(EventConstants.ExtraJson.EXPECT_FILE_LENGTH, downloadInfo.getExpectFileLength());
                    jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                    jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                    double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                    double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                    if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                        double d = curBytes / realDownloadTime;
                        try {
                            jSONObject.put("download_speed", d);
                        } catch (Exception e) {
                        }
                        Logger.d(mb, "download speed : " + d + "MB/s");
                    }
                    int i = 0;
                    try {
                        if (Downloader.getInstance(x.getContext()).isDownloadServiceForeground(downloadInfo.getId())) {
                            i = 1;
                        }
                        jSONObject.put(EventConstants.ExtraJson.KEY_IS_DOWNLOAD_SERVICE_FOREGROUND, i);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (downloadInfo.getBackUpUrls() != null) {
                        jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls().size());
                        jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getCurBackUpUrlIndex());
                    }
                    jSONObject.put(EventConstants.ExtraJson.KEY_CLEAR_SPACE_RESTART_TIMES, com.ss.android.downloadlib.addownload.ox.hj.mb().ox(downloadInfo.getUrl()));
                    jSONObject.put("mime_type", downloadInfo.getMimeType());
                    jSONObject.put(EventConstants.ExtraJson.NETWORK_AVAILABLE, DownloadUtils.isNetworkConnected(x.getContext()) ? 1 : 2);
                    jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                    ox(jSONObject, downloadInfo);
                    return jSONObject;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return jSONObject;
        }
        return jSONObject;
    }

    public static void mb(DownloadInfo downloadInfo, com.ss.android.downloadad.api.mb.ox oxVar) {
        synchronized (mb.class) {
            try {
                if (downloadInfo == null) {
                    com.ss.android.downloadlib.exception.b.mb().mb("onDownloadFinish info null");
                } else if (oxVar == null) {
                    com.ss.android.downloadlib.exception.b.mb().mb("onDownloadFinish nativeModel null");
                } else if (oxVar.sw() != 1) {
                } else {
                    com.ss.android.downloadlib.b.ww.mb().hj(oxVar);
                    String b2 = b(downloadInfo, oxVar);
                    com.ss.android.downloadlib.addownload.model.u.mb().ox(downloadInfo.getUrl(), b2);
                    Map<Long, com.ss.android.downloadad.api.mb.ox> mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo.getUrl(), b2);
                    oxVar.u(System.currentTimeMillis());
                    oxVar.h(2);
                    oxVar.ox(b2);
                    mb2.put(Long.valueOf(oxVar.ox()), oxVar);
                    com.ss.android.downloadlib.addownload.model.ww.mb().mb(mb2.values());
                    ox(oxVar);
                    ko.mb().mb(downloadInfo, b2);
                    if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                        mb().mb(oxVar);
                        mb().ox(downloadInfo, oxVar);
                        if (oxVar.al()) {
                            com.ss.android.downloadlib.addownload.mb.mb.mb().mb(downloadInfo.getId(), oxVar.ox(), oxVar.je(), b2, downloadInfo.getTitle(), oxVar.hj(), downloadInfo.getTargetFilePath());
                        }
                        com.ss.android.downloadlib.addownload.hj.mb.mb(downloadInfo, oxVar.ox(), oxVar.hj(), b2);
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.mb.ox oxVar : concurrentHashMap.values()) {
            if (oxVar.b.get()) {
                if (currentTimeMillis - oxVar.wn() >= DownloadSetting.obtain(oxVar.m()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(oxVar.ox()));
                }
            } else if (oxVar.sw() == 1) {
                if (hj(oxVar) <= 0 && currentTimeMillis - oxVar.wn() >= DownloadSetting.obtain(oxVar.m()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(oxVar.ox()));
                }
            } else if (oxVar.sw() != 2) {
                arrayList.add(Long.valueOf(oxVar.ox()));
            } else if (!oxVar.s()) {
                if (jb.ox(oxVar)) {
                    if (oxVar.w() == 4) {
                        i = oxVar.w();
                    }
                    AdEventHandler.mb().mb(mb(oxVar, oxVar.h(), i), oxVar);
                    arrayList.add(Long.valueOf(oxVar.ox()));
                    com.ss.android.downloadlib.addownload.ox.hj.mb(oxVar);
                } else if (currentTimeMillis - oxVar.wn() >= DownloadSetting.obtain(oxVar.m()).optInt("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(oxVar.ox()));
                } else if (TextUtils.isEmpty(oxVar.h())) {
                    arrayList.add(Long.valueOf(oxVar.ox()));
                }
            }
        }
        com.ss.android.downloadlib.addownload.model.u.mb().mb(arrayList);
    }

    private JSONObject ox(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.mb mbVar) {
        com.ss.android.downloadad.api.mb.ox mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (mb2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        mbVar.mb(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.utils.h.mb(jSONObject, downloadInfo.getId());
        AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.ANTI_HIJACK_RESULT, jSONObject, mb2);
        return jSONObject;
    }

    public static JSONObject ox(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null) {
            if (downloadInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) != 0) {
                try {
                    long mb2 = jb.mb(0L);
                    double d = mb2;
                    jSONObject.put("available_space", d / 1048576.0d);
                    long totalBytes = downloadInfo.getTotalBytes();
                    double d2 = totalBytes;
                    jSONObject.put(EventConstants.ExtraJson.APK_SIZE, d2 / 1048576.0d);
                    if (mb2 > 0 && totalBytes > 0) {
                        jSONObject.put(EventConstants.ExtraJson.KEY_AVAILABLE_SPACE_RATIO, d / d2);
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return jSONObject;
        }
        return jSONObject;
    }

    private static void ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        String z = TextUtils.isEmpty(oxVar.z()) ? "" : oxVar.z();
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m());
        oxVar.je("");
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
        JSONObject mb2 = mb(new JSONObject(), downloadInfo);
        try {
            mb2.putOpt(EventConstants.ExtraJson.DOWNLOAD_FINISH_REASON, z);
            mb2.putOpt(EventConstants.ExtraJson.FINISH_FROM_RESERVE_WIFI, Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadad.api.mb.ox mb3 = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        com.ss.android.downloadlib.utils.h.mb(mb2, downloadInfo.getId());
        try {
            mb2.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, mb3.on());
            mb2.put(EventConstants.ExtraJson.KEY_CAN_SHOW_NOTIFICATION, com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                mb2.put(EventConstants.ExtraJson.KEY_FILE_LENGTH_GAP, downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            mb2.put(EventConstants.ExtraJson.TTMD5_STATUS, downloadInfo.getTTMd5CheckStatus());
            mb2.put(EventConstants.ExtraJson.KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY, mb3.hj.get() ? 1 : 2);
            mb2.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, mb3.qa() ? 1 : 2);
            com.ss.android.downloadlib.utils.h.mb(mb3, mb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.DOWNLOAD_FINISH, mb2, oxVar);
    }

    @Override // com.ss.android.downloadad.api.mb
    public void mb(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ox < c.l) {
            return;
        }
        hj.mb().mb(new RunnableC0873mb(i), this.ox > 0 ? 2000L : 8000L);
        this.ox = currentTimeMillis;
    }

    public void mb(long j) {
        hj.mb mb2;
        int i;
        try {
            com.ss.android.downloadad.api.mb.ox hj2 = com.ss.android.downloadlib.addownload.model.u.mb().hj(j);
            if (hj2 == null || jb.ox(hj2) || hj2.b.get()) {
                return;
            }
            Pair<hj.mb, Integer> ox2 = com.ss.android.downloadlib.addownload.model.hj.mb().ox(hj2);
            if (ox2 != null) {
                mb2 = ox2.first;
                i = ox2.second.intValue();
            } else {
                mb2 = com.ss.android.downloadlib.addownload.model.hj.mb().mb(hj2);
                i = -1;
            }
            if (mb2 == null) {
                return;
            }
            com.ss.android.downloadlib.addownload.model.hj.mb().ox(mb2.mb);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EventConstants.ExtraJson.KEY_INSTALLED_APP_NAME, mb2.hj);
            jSONObject.put(EventConstants.ExtraJson.KEY_INSTALLED_PKG_NAME, mb2.mb);
            if (i == -1) {
                AdEventHandler.mb().ox(EventConstants.Label.INSTALL_FINISH_MAY_HIJACK, jSONObject, hj2);
                return;
            }
            jSONObject.put("error_code", i);
            com.ss.android.downloadlib.utils.h.mb(jSONObject, hj2.m());
            AdEventHandler.mb().ox(EventConstants.Label.INSTALL_FINISH_HIJACK, jSONObject, hj2);
        } catch (Throwable th) {
            com.ss.android.downloadlib.exception.b.mb().mb(th, "trySendInstallFinishHijack");
        }
    }

    public void mb(final long j, int i) {
        long optLong = DownloadSetting.obtain(i).optLong("check_install_finish_hijack_delay_time", 900000L);
        if (optLong < 0) {
            return;
        }
        hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.mb.2
            @Override // java.lang.Runnable
            public void run() {
                mb.mb().mb(j);
            }
        }, Math.max(optLong, 300000L));
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        hj.mb().mb(new b(oxVar));
    }

    public void mb(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.mb.ox mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (mb2 == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_SPACE_BEFORE, Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_SPACE_CLEANED, Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_CLEAN_UP_TIME_COST, Long.valueOf(j4));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_IS_DOWNLOAD_RESTARTED, Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_BYTE_REQUIRED, Long.valueOf(j3));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_BYTE_REQUIRED_AFTER, Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_CLEAR_SLEEP_TIME, Long.valueOf(j5));
            com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
            AdEventHandler.mb().mb(EventConstants.UnityLabel.OPTIMIZATION_CLEAN, jSONObject, mb2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(DownloadInfo downloadInfo, com.ss.android.downloadad.api.mb.ox oxVar, int i) {
        long max;
        if (downloadInfo == null || oxVar == null) {
            return;
        }
        ox();
        long currentTimeMillis = System.currentTimeMillis();
        oxVar.ox(currentTimeMillis);
        oxVar.ko(jb.mb(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            max = 2000;
        } else {
            long optLong = DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_failed_delay_time", c.l);
            if (optLong < 0) {
                return;
            }
            max = Math.max(optLong, 30000L);
        }
        ox oxVar2 = new ox(oxVar.ox(), downloadInfo.getId(), currentTimeMillis, i);
        hj.mb().mb(oxVar2, max);
        this.b = oxVar2;
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
    }

    @Override // com.ss.android.socialbase.appdownloader.ox.b
    public void mb(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.mb mbVar) {
        JSONObject ox2;
        if (downloadInfo == null || mbVar == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray("ah_report_config");
        if (mbVar.ox != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (optJSONArray == null || (ox2 = ox(downloadInfo, mbVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", ox2);
    }

    public void mb(final String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (jb.mb()) {
                throw new RuntimeException("handleAppInstalled in main thread.");
            }
            final com.ss.android.downloadad.api.mb.ox mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(str);
            if (mb2 == null) {
                com.ss.android.downloadlib.addownload.model.hj.mb().mb(str);
                return;
            }
            com.ss.android.downloadlib.addownload.h mb3 = ko.mb().mb(mb2.mb());
            if (mb3 != null) {
                mb3.u();
            }
            if (mb2.b.get()) {
                return;
            }
            if (DownloadSetting.obtain(mb2.m()).optInt("notification_opt_2") == 1) {
                DownloadNotificationManager.getInstance().cancelNotification(mb2.m());
            }
            new com.ss.android.downloadlib.ox.ox().mb(mb2, new com.ss.android.downloadlib.ox.ko() { // from class: com.ss.android.downloadlib.mb.1
                @Override // com.ss.android.downloadlib.ox.ko
                public void mb(boolean z) {
                    Logger.d(mb.mb, "appBackForeground->" + z);
                    if (!z) {
                        if (com.ss.android.downloadlib.ox.mb.mb(str, mb2) || mb2.w() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.mb.mb.mb().mb(mb2);
                        return;
                    }
                    boolean z2 = false;
                    if (com.ss.android.downloadlib.ox.u.b(mb2)) {
                        z2 = com.ss.android.downloadlib.ox.mb.mb(str, mb2);
                    }
                    if (!z2 && com.ss.android.downloadlib.ox.u.hj(mb2) && mb2.w() == 4) {
                        com.ss.android.downloadlib.addownload.mb.mb.mb().mb(mb2);
                    }
                }
            }, com.ss.android.downloadlib.utils.hj.mb(mb2).optInt("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.b.ww.mb().u(mb2);
            mb(str, mb2);
            com.ss.android.downloadlib.addownload.mb.mb.mb().ox(str);
            DownloadInfo mb4 = mb(Downloader.getInstance(x.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (mb4 != null) {
                if (DownloadSetting.obtain(mb4.getId()).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION) != 1) {
                    DownloadNotificationManager.getInstance().hideNotification(mb4.getId());
                }
                ko.mb().ox(mb4, str);
                com.ss.android.downloadlib.addownload.ox.hj.mb(mb4);
            } else {
                ko.mb().ox(null, str);
            }
        }
    }

    public void mb(String str, com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar != null && jb.ox(oxVar) && oxVar.b.compareAndSet(false, true)) {
            int i = 4;
            if (oxVar.w() != 4) {
                i = 3;
            }
            AdEventHandler.mb().mb(oxVar.x(), EventConstants.Label.INSTALL_FINISH, mb(oxVar, str, i), oxVar);
            com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        Logger.d(mb, "onAppBackground()");
        mb(6);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        Logger.d(mb, "onAppForeground()");
        ox();
        mb(5);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(final DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("info is null");
        } else if ((DownloadSetting.obtain(downloadInfo).optInt("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.ox.h.mb().ox(new com.ss.android.downloadlib.ox.hj() { // from class: com.ss.android.downloadlib.mb.4
                @Override // com.ss.android.downloadlib.ox.hj
                public void mb(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.b.mb(x.getContext(), intent);
                            jb.mb(jSONObject, Context.BACKUP_SERVICE, (Object) 1);
                        } else {
                            jb.mb(jSONObject, Context.BACKUP_SERVICE, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.mb.ox mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
                    if (mb2 != null) {
                        AdEventHandler.mb().mb(z ? EventConstants.UnityLabel.INSTALLER_DELAY_SUCCESS : EventConstants.UnityLabel.INSTALLER_DELAY_FAILED, jSONObject, mb2);
                    } else {
                        com.ss.android.downloadlib.exception.b.mb().ox("ah nativeModel=null");
                    }
                    if (z) {
                        x.gm().mb(x.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    void ox() {
        synchronized (this) {
            ox oxVar = this.b;
            if (oxVar != null) {
                oxVar.ox();
                this.b = null;
            }
        }
    }

    public void ox(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.mb.ox oxVar) {
        if (downloadInfo == null || oxVar == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        hj.mb().ox(new Runnable() { // from class: com.ss.android.downloadlib.mb.3
            @Override // java.lang.Runnable
            public void run() {
                String mb2 = com.ss.android.downloadlib.utils.mb.mb(targetFilePath);
                if (TextUtils.isEmpty(mb2)) {
                    return;
                }
                x.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(oxVar.ox()), mb2).apply();
            }
        });
    }
}

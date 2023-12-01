package com.ss.android.downloadlib.utils;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/hj.class */
public class hj {
    public static int b(DownloadModel downloadModel) {
        return mb(ox(downloadModel));
    }

    public static long b(int i) {
        return DownloadSetting.obtain(i).optLong("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean b() {
        return com.ss.android.downloadlib.addownload.x.lz().optInt("is_enable_start_install_again") == 1;
    }

    public static long h() {
        long optLong = com.ss.android.downloadlib.addownload.x.lz().optLong("next_install_min_interval");
        long j = optLong;
        if (optLong == 0) {
            j = 10000;
        }
        return j;
    }

    public static boolean h(int i) {
        return DownloadSetting.obtain(i).optLong("clean_space_before_download_switch", 0L) == 1;
    }

    public static long hj() {
        long optLong = com.ss.android.downloadlib.addownload.x.lz().optLong("start_install_interval");
        long j = optLong;
        if (optLong == 0) {
            j = 300000;
        }
        return j;
    }

    public static boolean hj(int i) {
        return DownloadSetting.obtain(i).optLong("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean ko(int i) {
        boolean z = false;
        if (DownloadSetting.obtain(i).optInt("clean_app_cache_dir", 0) == 1) {
            z = true;
        }
        return z;
    }

    public static double mb(int i) {
        return DownloadSetting.obtain(i).optDouble("clean_min_install_size", 0.0d);
    }

    public static int mb(DownloadSetting downloadSetting) {
        return downloadSetting.optInt("external_storage_permission_path_type", 0);
    }

    public static DownloadSetting mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        return mbVar == null ? DownloadSetting.obtainGlobal() : mbVar.m() != 0 ? DownloadSetting.obtain(mbVar.m()) : mbVar.b() ? DownloadSetting.obtain(mb()) : mbVar.l() != null ? DownloadSetting.obtain(mbVar.l()) : DownloadSetting.obtainGlobal();
    }

    public static JSONObject mb() {
        return com.ss.android.downloadlib.addownload.x.lz().optJSONObject("ad");
    }

    public static JSONObject mb(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? mb() : downloadModel.getDownloadSettings();
    }

    public static long ox(int i) {
        return DownloadSetting.obtain(i).optLong("storage_min_size", 0L);
    }

    public static DownloadSetting ox(DownloadModel downloadModel) {
        return DownloadSetting.obtain(mb(downloadModel));
    }

    public static boolean ox() {
        return DownloadSetting.obtainGlobal().optBugFix("fix_notification_anr");
    }

    public static boolean ox(com.ss.android.downloadad.api.mb.mb mbVar) {
        boolean z = false;
        if (mb(mbVar).optInt("pause_reserve_on_wifi", 0) == 1) {
            z = false;
            if (mbVar.e()) {
                z = true;
            }
        }
        return z;
    }

    public static boolean ox(DownloadSetting downloadSetting) {
        return downloadSetting != null && downloadSetting.optInt("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean u(int i) {
        boolean z = false;
        if (DownloadSetting.obtain(i).optInt("clean_space_switch", 0) == 1) {
            z = true;
        }
        return z;
    }
}

package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/utils/DownloadSettingsUtils.class */
public class DownloadSettingsUtils {
    public static boolean isOptimizeAddListener(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo == null) {
            return false;
        }
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OptimizeForError.OPTIMIZE_ADD_LISTENER) == 1) {
            z = true;
        }
        return z;
    }

    public static boolean isOptimizeHeadRequest(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo == null) {
            return false;
        }
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OptimizeForError.OPTIMIZE_HEAD_REQUEST) == 1) {
            z = true;
        }
        return z;
    }

    public static boolean isOptimizeSavePath(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo == null) {
            return false;
        }
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OptimizeForError.OPTIMIZE_SAVE_PATH) == 1) {
            z = true;
        }
        return z;
    }
}

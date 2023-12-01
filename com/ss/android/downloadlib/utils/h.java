package com.ss.android.downloadlib.utils;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/h.class */
public class h {
    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt(EventConstants.ExtraJson.FILE_NAME, downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.mb.ox mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo.getId());
                if (mb != null) {
                    jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_TIME, Long.valueOf(mb.sa()));
                    jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_SIZE, Long.valueOf(mb.sr()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.putOpt(EventConstants.ExtraJson.PERMISSION_NOTIFICATION, Integer.valueOf(com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2));
        jSONObject.putOpt(EventConstants.ExtraJson.NETWORK_AVAILABLE, Integer.valueOf(DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.x.getContext()) ? 1 : 2));
        jSONObject.putOpt(EventConstants.ExtraJson.NETWORK_IS_WIFI, Integer.valueOf(DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.x.getContext()) ? 1 : 2));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String h1672829046082dc(java.lang.String r5) {
        /*
        L0:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L0;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L85;
                case 95: goto L5f;
                case 96: goto L5f;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L85;
                case 56: goto L85;
                case 57: goto L5f;
                default: goto L5c;
            }
        L5c:
            goto L85
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.utils.h.h1672829046082dc(java.lang.String):java.lang.String");
    }

    public static JSONObject mb(JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, EventConstants.ExtraJson.OPEN_URL, jb.mb(mbVar.u(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void mb(com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject) {
        if (jSONObject == null || oxVar == null) {
            return;
        }
        try {
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_PATCH_APPLY_HANDLED, oxVar.n() ? 1 : 0);
            jSONObject.put(EventConstants.ExtraJson.KEY_ORIGIN_MIME_TYPE, oxVar.tl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void mb(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            b(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.mb.ox mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
            if (mb == null) {
                return;
            }
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, mb.qa() ? 1 : 2);
            mb(mb, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void mb(org.json.JSONObject r4, int r5) {
        /*
            r0 = r4
            if (r0 != 0) goto L5
            return
        L5:
            r0 = r5
            com.ss.android.socialbase.downloader.setting.DownloadSetting r0 = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(r0)
            java.lang.String r1 = "ah_report_config"
            org.json.JSONArray r0 = r0.optJSONArray(r1)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L76
            r0 = 0
            r5 = r0
        L15:
            r0 = r5
            r1 = r6
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L71
            if (r0 >= r1) goto L76
            r0 = r6
            r1 = r5
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L71
            r8 = r0
            r0 = r8
            com.ss.android.socialbase.appdownloader.ko$mb r0 = com.ss.android.socialbase.appdownloader.u.mb.mb(r0)     // Catch: java.lang.Throwable -> L71
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L6a
            r0 = r8
            java.lang.String r1 = "\\."
            java.lang.String r2 = "_"
            java.lang.String r0 = r0.replaceAll(r1, r2)     // Catch: java.lang.Throwable -> L71
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            r9 = r0
            r0 = r9
            r1 = r7
            int r1 = r1.u()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L71
            r0 = r9
            java.lang.String r1 = "_"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L71
            r0 = r9
            r1 = r7
            java.lang.String r1 = r1.ko()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L71
            r0 = r4
            r1 = r8
            r2 = r9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L71
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L71
        L6a:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L15
        L71:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L76:
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()     // Catch: java.lang.Throwable -> L8d
            boolean r0 = com.ss.android.socialbase.appdownloader.ox.mb(r0)     // Catch: java.lang.Throwable -> L8d
            if (r0 == 0) goto L8f
            r0 = 1
            r5 = r0
            goto L84
        L84:
            r0 = r4
            java.lang.String r1 = "is_unknown_source_enabled"
            r2 = r5
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L8d
            return
        L8d:
            r4 = move-exception
            return
        L8f:
            r0 = 2
            r5 = r0
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.utils.h.mb(org.json.JSONObject, int):void");
    }

    public static JSONObject ox(JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, com.ss.android.socialbase.appdownloader.u.hj.lz().replaceAll("\\.", BridgeUtil.UNDERLINE_STR), Integer.valueOf(jb.ox(com.ss.android.downloadlib.addownload.x.getContext(), com.ss.android.socialbase.appdownloader.u.hj.lz())));
        return jSONObject;
    }

    public static void ox(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.mb.ox mb;
        if (jSONObject == null || (mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        try {
            b(downloadInfo, jSONObject);
            jSONObject.putOpt(EventConstants.ExtraJson.TIME_AFTER_CLICK, Long.valueOf(System.currentTimeMillis() - mb.sa()));
            jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_SIZE, Long.valueOf(mb.sr()));
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_LENGTH, Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_APK_SIZE, Long.valueOf(downloadInfo.getTotalBytes()));
            mb.ng();
            com.ss.android.downloadlib.addownload.model.ww.mb().mb(mb);
            jSONObject.put(EventConstants.ExtraJson.KEY_CLICK_PAUSE_TIMES, mb.a());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long wn = mb.wn();
            if (wn > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_START_DOWNLOAD, currentTimeMillis - wn);
            }
            long ge = mb.ge();
            if (ge > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_DOWNLOAD_RESUME, currentTimeMillis - ge);
            }
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(mb.fu()));
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, mb.ep());
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, mb.on());
            jSONObject.put(EventConstants.ExtraJson.KEY_CAN_SHOW_NOTIFICATION, com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_FIRST_SPEED_TIME, downloadInfo.getFirstSpeedTime());
            jSONObject.put(EventConstants.ExtraJson.KEY_ALL_CONNECT_TIME, downloadInfo.getAllConnectTime());
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_PREPARE_TIME, downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

package com.ss.android.socialbase.downloader.monitor;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/monitor/DownloadMonitorHelper.class */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    private static JSONObject getMonitorJson(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str2;
        String str3;
        int i2;
        String str4;
        String str5;
        String str6;
        String str7;
        try {
            jSONObject2 = new JSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            IMonitorConfig monitorConfig = DownloadComponentManager.getMonitorConfig();
            if (monitorConfig != null) {
                str2 = monitorConfig.getDeviceId();
                str4 = parseDevicePostfix(str2);
                str3 = monitorConfig.getAppId();
                i2 = monitorConfig.getUpdateVersion();
            } else {
                str2 = "";
                str3 = str2;
                i2 = 0;
                str4 = str2;
            }
            String requestLog = (baseException == null || !(baseException instanceof DownloadTTNetException)) ? "" : ((DownloadTTNetException) baseException).getRequestLog();
            jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, str);
            jSONObject2.put("app_id", str3);
            jSONObject2.put("device_id", str2);
            jSONObject2.put(MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, str4);
            jSONObject2.put("update_version", i2);
            jSONObject2.put("download_status", i);
            if (downloadInfo != null) {
                jSONObject2.put(DownloadSettingKeys.SETTING_TAG, DownloadSetting.obtain(downloadInfo.getId()).optString(DownloadSettingKeys.SETTING_TAG));
                jSONObject2.put("download_id", downloadInfo.getId());
                jSONObject2.put("name", downloadInfo.getName());
                jSONObject2.put("url", downloadInfo.getUrl());
                jSONObject2.put("save_path", downloadInfo.getSavePath());
                jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject2.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, downloadInfo.isForce() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, downloadInfo.getRetryCount());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_REUSE_FIRST_CONNECTION, downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_DELAY_STATUS, downloadInfo.getRetryDelayStatus().ordinal());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, downloadInfo.getByteInvalidRetryStatus().ordinal());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, downloadInfo.getAsyncHandleStatus().ordinal());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, downloadInfo.isAddListenerToSameTask() ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                String url = downloadInfo.getUrl();
                if (TextUtils.isEmpty(url)) {
                    str5 = "";
                    str6 = str5;
                    str7 = str5;
                } else {
                    Uri parse = Uri.parse(url);
                    String host = parse.getHost();
                    String path = parse.getPath();
                    String lastPathSegment = parse.getLastPathSegment();
                    str5 = lastPathSegment;
                    str6 = host;
                    str7 = path;
                    if (!TextUtils.isEmpty(path)) {
                        str5 = lastPathSegment;
                        str6 = host;
                        str7 = path;
                        if (!TextUtils.isEmpty(lastPathSegment)) {
                            try {
                                str7 = path.substring(0, path.length() - lastPathSegment.length());
                                str5 = lastPathSegment;
                                str6 = host;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                str5 = lastPathSegment;
                                str6 = host;
                                str7 = path;
                            }
                        }
                    }
                }
                jSONObject2.put(MonitorConstants.URL_HOST, str6);
                jSONObject2.put(MonitorConstants.URL_PATH, str7);
                jSONObject2.put(MonitorConstants.URL_LAST_PATH_SEGMENT, str5);
            }
            int i3 = 0;
            if (baseException != null) {
                i3 = baseException.getErrorCode();
            }
            jSONObject2.put("error_code", i3);
            jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
            jSONObject2.put(MonitorConstants.REQUEST_LOG, requestLog);
            return jSONObject2;
        } catch (JSONException e2) {
            e = e2;
            jSONObject = jSONObject2;
            e.printStackTrace();
            return jSONObject;
        }
    }

    private static boolean isMonitorStatus(int[] iArr, int i) {
        if (iArr == null || iArr.length <= 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i == iArr[i3]) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:11|(7:85|86|87|88|89|90|(25:92|14|(1:16)|60|(3:62|63|(1:67))|69|(2:71|(1:73)(3:74|75|76))|18|19|20|21|(3:23|24|(2:26|27))|30|31|32|33|34|(1:36)|37|38|39|40|(1:54)|44|(2:46|47)(1:51)))|13|14|(0)|60|(0)|69|(0)|18|19|20|21|(0)|30|31|32|33|34|(0)|37|38|39|40|(1:42)|52|54|44|(1:49)|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
        if (r16 >= 400) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0200, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0201, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086 A[Catch: all -> 0x023c, TRY_LEAVE, TryCatch #3 {all -> 0x023c, blocks: (B:19:0x004e, B:21:0x0055, B:49:0x00ff, B:51:0x0119, B:53:0x0121, B:57:0x0142, B:58:0x0145, B:60:0x014d, B:62:0x01bf, B:64:0x01da, B:75:0x0229, B:72:0x0211, B:74:0x0219, B:66:0x0201, B:27:0x007e, B:29:0x0086, B:37:0x00a7, B:40:0x00bc, B:43:0x00cc, B:45:0x00e2, B:47:0x00ea, B:13:0x0034), top: B:93:0x0034, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[Catch: all -> 0x023c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x023c, blocks: (B:19:0x004e, B:21:0x0055, B:49:0x00ff, B:51:0x0119, B:53:0x0121, B:57:0x0142, B:58:0x0145, B:60:0x014d, B:62:0x01bf, B:64:0x01da, B:75:0x0229, B:72:0x0211, B:74:0x0219, B:66:0x0201, B:27:0x007e, B:29:0x0086, B:37:0x00a7, B:40:0x00bc, B:43:0x00cc, B:45:0x00e2, B:47:0x00ea, B:13:0x0034), top: B:93:0x0034, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0121 A[Catch: all -> 0x023c, TRY_LEAVE, TryCatch #3 {all -> 0x023c, blocks: (B:19:0x004e, B:21:0x0055, B:49:0x00ff, B:51:0x0119, B:53:0x0121, B:57:0x0142, B:58:0x0145, B:60:0x014d, B:62:0x01bf, B:64:0x01da, B:75:0x0229, B:72:0x0211, B:74:0x0219, B:66:0x0201, B:27:0x007e, B:29:0x0086, B:37:0x00a7, B:40:0x00bc, B:43:0x00cc, B:45:0x00e2, B:47:0x00ea, B:13:0x0034), top: B:93:0x0034, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bf A[Catch: JSONException -> 0x0200, all -> 0x023c, TRY_ENTER, TryCatch #4 {JSONException -> 0x0200, blocks: (B:60:0x014d, B:62:0x01bf, B:64:0x01da), top: B:95:0x014d, outer: #3 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0243 -> B:57:0x0142). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void monitorDownloadConnect(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r7, java.lang.String r8, java.lang.String r9, long r10, java.lang.String r12, int r13, java.io.IOException r14, com.ss.android.socialbase.downloader.model.DownloadInfo r15) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void monitorDownloadIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        monitorIO(MonitorConstants.DOWNLOAD_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_IO), downloadSetting, downloadInfo, str, null, null, iDownloadHttpConnection, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void monitorIO(String str, int i, DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str2, String str3, String str4, IDownloadHttpConnection iDownloadHttpConnection, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void monitorSegmentIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, IDownloadHttpConnection iDownloadHttpConnection, BaseException baseException, long j, long j2) {
        monitorIO(MonitorConstants.SEGMENT_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_SEGMENT_IO), downloadSetting, downloadInfo, str, str2, str3, iDownloadHttpConnection, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    public static void monitorSegmentsError(DownloadInfo downloadInfo, List<Segment> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            InnerEventListener eventListener = DownloadComponentManager.getEventListener();
            if (eventListener != null) {
                eventListener.onEvent(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSend(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            IDownloadMonitorDepend monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            boolean z = isMonitorStatus;
            if (!isMonitorStatus) {
                boolean isMonitorStatus2 = isMonitorStatus(downloadInfo.getExtraMonitorStatus(), i);
                z = isMonitorStatus2;
                if (!isMonitorStatus2) {
                    z = isMonitorStatus2;
                    if (monitorDepend != null) {
                        z = isMonitorStatus2;
                        if (monitorDepend instanceof AbsDownloadMonitorDepend) {
                            z = isMonitorStatus(((AbsDownloadMonitorDepend) monitorDepend).getAdditionalMonitorStatus(), i);
                        }
                    }
                }
            }
            if (z) {
                IDownloadDepend depend = downloadTask.getDepend();
                if (depend != null) {
                    depend.monitorLogSend(downloadInfo, baseException, i);
                }
                monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i);
                monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, baseException, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSendWithGlobalSdkMonitor(IDownloadMonitorListener iDownloadMonitorListener, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (iDownloadMonitorListener == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject monitorJson = getMonitorJson(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            JSONObject jSONObject = monitorJson;
            if (monitorJson == null) {
                jSONObject = new JSONObject();
            }
            if (i == -1) {
                jSONObject.put("status", baseException.getErrorCode());
                iDownloadMonitorListener.monitorEvent(EventConstants.Label.DOWNLOAD_FAILED, jSONObject, null, null);
                return;
            }
            putMonitorJsonStatus(i, jSONObject, downloadInfo);
            iDownloadMonitorListener.monitorEvent("download_common", jSONObject, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSendWithTaskMonitor(IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (iDownloadMonitorDepend == null) {
            return;
        }
        try {
            String eventPage = iDownloadMonitorDepend.getEventPage();
            String str = eventPage;
            if (TextUtils.isEmpty(eventPage)) {
                str = "default";
            }
            JSONObject monitorJson = getMonitorJson(str, downloadInfo, baseException, i);
            JSONObject jSONObject = monitorJson;
            if (monitorJson == null) {
                jSONObject = new JSONObject();
            }
            iDownloadMonitorDepend.monitorLogSend(jSONObject);
        } catch (Throwable th) {
        }
    }

    public static String parseDevicePostfix(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void putMonitorJsonStatus(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = EventConstants.Label.DOWNLOAD_CANCEL;
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }
}

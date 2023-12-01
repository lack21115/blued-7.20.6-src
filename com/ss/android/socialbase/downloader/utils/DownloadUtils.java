package com.ss.android.socialbase.downloader.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ttmd5.TTMd5;
import com.youzan.androidsdk.tool.WebParameter;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/utils/DownloadUtils.class */
public class DownloadUtils {
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static final String ETAG = "Etag";
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    private static ConnectivityManager connectivityManager;
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static final String TAG = DownloadUtils.class.getSimpleName();
    private static final Pattern CONTENT_RANGE_RIGHT_VALUE = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String sCurProcessName = null;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap = new SparseArray<>();
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners = new SparseArray<>();
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = null;
    private static Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = null;

    public static List<HttpHeader> add0_0RangeHeader(List<HttpHeader> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader("If-Match", str));
        }
        arrayList.add(new HttpHeader("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY));
        arrayList.add(new HttpHeader("Range", "bytes=0-0"));
        return arrayList;
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader("If-Match", str));
        }
        arrayList.add(new HttpHeader("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY));
        String format = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new HttpHeader("Range", format));
        String str2 = TAG;
        Logger.d(str2, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + format);
        return arrayList;
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, DownloadChunk downloadChunk) {
        return addRangeHeader(list, str, downloadChunk.getCurOffset(), downloadChunk.getEndOffset());
    }

    public static void addTTNetProtectTimeout(List<HttpHeader> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static void addThrottleNetSpeed(List<HttpHeader> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(throttleNetSpeed)));
        }
    }

    public static double byteToMb(long j) {
        return j / 1048576.0d;
    }

    public static boolean cacheExpired(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            Logger.d(TAG, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            Logger.d(TAG, "dcache::last modify is emtpy, so just return cache");
        }
        Logger.d(TAG, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        if ("bytes".equals(r4) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean canAcceptPartial(int r3, java.lang.String r4) {
        /*
            r0 = 16777216(0x1000000, float:2.3509887E-38)
            boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(r0)
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L21
            r0 = r3
            r1 = 206(0xce, float:2.89E-43)
            if (r0 == r1) goto L1d
            r0 = r3
            r1 = 1
            if (r0 != r1) goto L1f
        L1d:
            r0 = 1
            r5 = r0
        L1f:
            r0 = r5
            return r0
        L21:
            r0 = r3
            r1 = 400(0x190, float:5.6E-43)
            if (r0 < r1) goto L2a
            r0 = 0
            return r0
        L2a:
            r0 = r3
            r1 = 206(0xce, float:2.89E-43)
            if (r0 == r1) goto L42
            r0 = r3
            r1 = 1
            if (r0 == r1) goto L42
            r0 = r6
            r5 = r0
            java.lang.String r0 = "bytes"
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L44
        L42:
            r0 = 1
            r5 = r0
        L44:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.canAcceptPartial(int, java.lang.String):boolean");
    }

    public static boolean canChunkDowngradeRetry(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= STMobileHumanActionNative.ST_MOBILE_HAND_BLESS) ? false : true;
    }

    public static int checkMd5Status(File file, String str) {
        return TTMd5.checkMd5(str, file);
    }

    public static int checkMd5Status(String str, String str2, String str3) {
        return TTMd5.checkMd5(str3, new File(str, str2));
    }

    public static boolean checkMd5Valid(File file, String str) {
        return isMd5Valid(TTMd5.checkMd5(str, file));
    }

    public static boolean checkMd5Valid(String str, String str2, String str3) {
        return isMd5Valid(checkMd5Status(str, str2, str3));
    }

    public static boolean checkPermission(Context context, String str) {
        boolean z = false;
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            z = false;
            if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
        }
        return z;
    }

    public static void clearAntiHijackDir(DownloadInfo downloadInfo) {
        DownloadSetting obtain;
        JSONObject optJSONObject;
        if (downloadInfo == null || (optJSONObject = (obtain = DownloadSetting.obtain(downloadInfo.getId())).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return;
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
        if (!TextUtils.isEmpty(optString)) {
            deleteFile(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        String str = title;
        if (TextUtils.isEmpty(title)) {
            str = downloadInfo.getName();
        }
        String redirectSavePath = getRedirectSavePath(str, obtain);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(redirectSavePath) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(redirectSavePath);
        File file2 = new File(savePath);
        while (true) {
            File file3 = file2;
            if (file == null || file3 == null || !file3.isDirectory() || !TextUtils.equals(file.getName(), file3.getName())) {
                return;
            }
            deleteDirIfEmpty(file3.getPath());
            file = file.getParentFile();
            file2 = file3.getParentFile();
        }
    }

    public static ListenerType convertListenerType(int i) {
        ListenerType listenerType = ListenerType.MAIN;
        if (i == ListenerType.SUB.ordinal()) {
            return ListenerType.SUB;
        }
        if (i == ListenerType.NOTIFICATION.ordinal()) {
            listenerType = ListenerType.NOTIFICATION;
        }
        return listenerType;
    }

    public static boolean copyFile(File file, File file2) throws BaseException {
        return copyFile(file, file2, true);
    }

    public static boolean copyFile(File file, File file2, boolean z) throws BaseException {
        if (file == null || file2 == null) {
            return false;
        }
        try {
            if (!file.exists() || file.isDirectory() || file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                return false;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
            }
            String str = TAG;
            Log.e(str, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
            if (file2.exists() && !file2.canWrite()) {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
            doCopyFile(file, file2, z);
            return true;
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th) {
            parseException(th, "CopyFile");
            return false;
        }
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str2 = TAG;
        Log.e(str2, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!copyFile(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static long cost(long j) {
        return System.currentTimeMillis() - j;
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo downloadInfo, String str, String str2, int i) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        boolean z = false;
        if (file.exists() && file.isDirectory()) {
            throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (file2.exists()) {
                        file2.delete();
                        if (file2.mkdirs() || file2.exists()) {
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                        throw new BaseException(1031, "download savePath is not directory:path=" + str);
                    } else if (!file2.mkdirs() && !file2.exists()) {
                        if (DownloadSetting.obtain(downloadInfo).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
                            throw new BaseException(1030, "download savePath directory can not created:" + str);
                        }
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (z || i3 >= 3) {
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                                z = file2.mkdirs();
                                i2 = i3 + 1;
                            } catch (InterruptedException e) {
                            }
                        }
                        if (!z) {
                            if (getAvailableSpaceBytes(downloadInfo.getSavePath()) < 16384) {
                                throw new BaseException(1006, "download savePath directory can not created:" + str);
                            }
                            throw new BaseException(1030, "download savePath directory can not created:" + str);
                        }
                    }
                }
                file.createNewFile();
            } catch (IOException e2) {
                throw new BaseException(1036, e2);
            }
        }
        return new RandomAccessOutputStream(file, i);
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo) {
        deleteAllDownloadFiles(downloadInfo, true);
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                deleteFile(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            clearAntiHijackDir(downloadInfo);
        }
        if (z) {
            String md5Hex = md5Hex(downloadInfo.getUrl());
            if (TextUtils.isEmpty(md5Hex) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(md5Hex)) {
                return;
            }
            deleteDirIfEmpty(downloadInfo.getSavePath());
        }
    }

    private static boolean deleteDirIfEmpty(String str) {
        String str2 = TAG;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            if (file.delete()) {
                return true;
            }
            Log.w(TAG, "deleteDirIfEmpty return false");
            return false;
        }
        return false;
    }

    public static void deleteFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = TAG;
            Log.e(str3, "deleteFile: " + str + BridgeUtil.SPLIT_MARK + str2);
            file.delete();
        }
    }

    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                FileChannel channel2 = fileOutputStream.getChannel();
                long size = channel.size();
                long j = 0;
                while (true) {
                    long j2 = j;
                    if (j2 >= size) {
                        break;
                    }
                    long j3 = size - j2;
                    if (j3 > FILE_COPY_BUFFER_SIZE) {
                        j3 = 31457280;
                    }
                    long transferFrom = channel2.transferFrom(channel, j2, j3);
                    if (transferFrom == 0) {
                        break;
                    }
                    j = j2 + transferFrom;
                }
                if (channel2 != null) {
                    channel2.close();
                }
                fileOutputStream.close();
                if (channel != null) {
                    channel.close();
                }
                fileInputStream.close();
                long length = file.length();
                long length2 = file2.length();
                if (length == length2) {
                    if (z) {
                        file2.setLastModified(file.lastModified());
                        return;
                    }
                    return;
                }
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    private static void ensureDirExists(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void ensureDirExists(String str) {
        if (str == null) {
            return;
        }
        ensureDirExists(new File(str));
    }

    public static String generateDistinctDirectory(String str, String str2) {
        String str3 = str;
        if (!TextUtils.isEmpty(str)) {
            String md5Hex = md5Hex(str2);
            str3 = str;
            if (!TextUtils.isEmpty(md5Hex)) {
                str3 = str;
                if (!str.contains(md5Hex)) {
                    str3 = new File(str, md5Hex).getAbsolutePath();
                }
            }
        }
        return str3;
    }

    public static long getAvailableSpaceBytes(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e) {
            throw new BaseException(1050, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static boolean getBoolean(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e) {
            return z;
        }
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        ConnectivityManager connectivityManager2 = connectivityManager;
        ConnectivityManager connectivityManager3 = connectivityManager2;
        if (connectivityManager2 == null) {
            connectivityManager3 = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            connectivityManager = connectivityManager3;
        }
        return connectivityManager3;
    }

    public static long getContentLength(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Length");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase) && DownloadExpSwitchCode.isSwitchEnable(1)) {
            return parseContentLengthFromContentRange(iDownloadHeadHttpConnection);
        }
        try {
            return Long.parseLong(respHeadFieldIgnoreCase);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static long getCurByte(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<DownloadChunk> downloadChunk = DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = true;
        if (chunkCount <= 1) {
            z = false;
        }
        long j = 0;
        if (downloadInfo.isBreakpointAvailable()) {
            if (z) {
                j = 0;
                if (downloadChunk != null) {
                    j = 0;
                    if (chunkCount == downloadChunk.size()) {
                        return getTotalOffset(downloadChunk);
                    }
                }
            } else {
                j = downloadInfo.getCurBytes();
            }
        }
        return j;
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (TextUtils.isEmpty(str)) {
            String curProcessNameByApplication = getCurProcessNameByApplication();
            sCurProcessName = curProcessNameByApplication;
            if (TextUtils.isEmpty(curProcessNameByApplication)) {
                String curProcessNameByActivityThread = getCurProcessNameByActivityThread();
                sCurProcessName = curProcessNameByActivityThread;
                if (TextUtils.isEmpty(curProcessNameByActivityThread)) {
                    String curProcessNameByActivityManager = getCurProcessNameByActivityManager(context);
                    sCurProcessName = curProcessNameByActivityManager;
                    if (TextUtils.isEmpty(curProcessNameByActivityManager)) {
                        String curProcessNameFromProc = getCurProcessNameFromProc();
                        sCurProcessName = curProcessNameFromProc;
                        return curProcessNameFromProc;
                    }
                    return sCurProcessName;
                }
                return sCurProcessName;
            }
            return sCurProcessName;
        }
        return str;
    }

    private static String getCurProcessNameByActivityManager(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                do {
                    if (!it.hasNext()) {
                        return null;
                    }
                    next = it.next();
                } while (next.pid != myPid);
                if (Logger.debug()) {
                    Logger.d("Process", "processName = " + next.processName);
                }
                return next.processName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameByActivityThread() {
        Throwable th;
        String str = null;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                String str2 = (String) invoke;
                str = str2;
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                        if (Logger.debug()) {
                            Logger.d("Process", "processName = " + str2);
                            str = str2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = str2;
                    th.printStackTrace();
                    return str;
                }
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
        return str;
    }

    private static String getCurProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName) && Logger.debug()) {
                    Logger.d("Process", "processName = " + processName);
                }
                return processName;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (Logger.debug()) {
                    Logger.d("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                safeClose(bufferedReader);
                return sb2;
            } catch (Throwable th) {
                safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }

    public static File getDatabaseFile(Context context, boolean z, String str) {
        String str2 = "";
        try {
            str2 = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException e) {
        }
        File externalDBFile = (z && Environment.MEDIA_MOUNTED.equals(str2) && hasExternalStoragePermission(context)) ? getExternalDBFile(str) : null;
        File file = externalDBFile;
        if (externalDBFile == null) {
            file = context.getDatabasePath(str);
        }
        File file2 = file;
        if (file == null) {
            file2 = new File("/data/data/" + context.getPackageName() + "/database/", str);
        }
        return file2;
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir(), true);
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveTempDir(), false);
    }

    public static String getEncodedStr(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public static String getErrorMsgWithTagPrefix(Throwable th, String str) {
        if (str == null) {
            return getThrowableMsg(th);
        }
        return str + "-" + getThrowableMsg(th);
    }

    private static File getExternalDBFile(String str) {
        File file;
        Exception e;
        File file2;
        if (isSdcardAvailable() && isSdcardWritable()) {
            try {
                file = DownloadComponentManager.getAppContext().getExternalFilesDir(WebParameter.PATH_DATABASE + File.separator + str);
            } catch (Exception e2) {
                file = null;
                e = e2;
            }
            if (file == null) {
                return null;
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                file2 = file;
                if (Logger.debug()) {
                    Logger.d(TAG, "download db path:" + file.getAbsolutePath());
                    return file;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                file2 = file;
                return file2;
            }
            return file2;
        }
        return null;
    }

    public static File getExternalDownloadPath() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e) {
            str = "";
        }
        if (Environment.MEDIA_MOUNTED.equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static String getFileNameFromConnection(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        String parseContentDisposition = parseContentDisposition(iDownloadHeadHttpConnection.getResponseHeaderField("Content-Disposition"));
        String str2 = parseContentDisposition;
        if (TextUtils.isEmpty(parseContentDisposition)) {
            str2 = md5Hex(str);
        }
        return str2;
    }

    private static long getFirstChunkCurOffset(List<DownloadChunk> list) {
        long j = -1;
        if (list != null) {
            j = -1;
            if (!list.isEmpty()) {
                j = -1;
                for (DownloadChunk downloadChunk : list) {
                    if (downloadChunk != null && (downloadChunk.getCurrentOffset() <= downloadChunk.getEndOffset() || downloadChunk.getEndOffset() == 0)) {
                        if (j == -1 || j > downloadChunk.getCurrentOffset()) {
                            j = downloadChunk.getCurrentOffset();
                        }
                    }
                }
            }
        }
        return j;
    }

    public static long getFirstOffset(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<DownloadChunk> downloadChunk = DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        long j = 0;
        if (downloadChunk != null) {
            j = 0;
            if (downloadChunk.size() > 1) {
                long firstChunkCurOffset = getFirstChunkCurOffset(downloadChunk);
                j = 0;
                if (firstChunkCurOffset >= 0) {
                    j = firstChunkCurOffset;
                }
            }
        }
        return j;
    }

    public static String getFixLengthString(String str, int i) {
        if (i == 0) {
            return "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() <= i) {
                return str;
            }
            str2 = str.substring(0, i);
        }
        return str2;
    }

    public static int getInt(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            return i;
        }
    }

    public static String getLoggerTag(String str) {
        return Logger.downloaderTag(str);
    }

    public static long getMaxBytesOverMobile() {
        return 2147483648L;
    }

    public static String getMd5StatusMsg(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i == 99) {
            return str + "unknown error";
        }
        switch (i) {
            case 0:
                return str + "md5 match";
            case 1:
                return str + "md5 not match";
            case 2:
                return str + "md5 empty";
            case 3:
                return str + "ttmd5 version not support";
            case 4:
                return str + "ttmd5 tag parser error";
            case 5:
                return str + "file not exist";
            case 6:
                return str + "get file md5 error";
            default:
                return str;
        }
    }

    public static String getRedirectSavePath(String str, DownloadSetting downloadSetting) {
        String str2;
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            str2 = "";
        } else {
            String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
            String str3 = optString;
            if (!TextUtils.isEmpty(optString)) {
                str3 = optString;
                if (optString.startsWith(BridgeUtil.SPLIT_MARK)) {
                    str3 = optString.substring(1);
                }
            }
            str2 = str3;
            if (!TextUtils.isEmpty(str3)) {
                if (str3.contains("%s")) {
                    try {
                        format = String.format(str3, str);
                    } catch (Throwable th) {
                    }
                } else {
                    format = str3 + str;
                }
                str3 = format;
                str2 = str3;
                if (str3.length() > 255) {
                    return str3.substring(str3.length() - 255);
                }
            }
        }
        return str2;
    }

    public static String getRespHeadFieldIgnoreCase(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        if (iDownloadHeadHttpConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str);
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_FIX_GET_HTTP_RESP_HEAD_IGNORE_CASE, true)) {
            String str2 = responseHeaderField;
            if (TextUtils.isEmpty(responseHeaderField)) {
                str2 = iDownloadHeadHttpConnection.getResponseHeaderField(str.toLowerCase());
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str2)) {
                str3 = iDownloadHeadHttpConnection.getResponseHeaderField(str.toUpperCase());
            }
            return str3;
        }
        return responseHeaderField;
    }

    public static String getString(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            return str;
        }
    }

    public static String getTargetFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String getTempFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static String getTempFilePath(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        String targetFilePath = !TextUtils.isEmpty(str2) ? getTargetFilePath(str2, str3) : getTargetFilePath(str, str3);
        if (TextUtils.isEmpty(targetFilePath)) {
            return null;
        }
        return String.format("%s.tp", targetFilePath);
    }

    public static String getTempFileSavePath(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        return str;
    }

    public static String getThrowableMsg(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static long getTotalOffset(List<DownloadChunk> list) {
        Iterator<DownloadChunk> it = list.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = j2 + it.next().getDownloadChunkBytes();
        }
    }

    private static String getValidDownloadPath(File file, boolean z) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (isValidDirectory(file)) {
            return file.getAbsolutePath();
        }
        int i = appContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT < 29 || ((i != 29 || Environment.isExternalStorageLegacy()) && i <= 29)) {
            if (z) {
                File externalDownloadPath = getExternalDownloadPath();
                if (isValidDirectory(externalDownloadPath)) {
                    return externalDownloadPath.getAbsolutePath();
                }
            }
            File externalFilesDir = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (isValidDirectory(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            File externalFilesDir2 = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (isValidDirectory(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return appContext.getFilesDir().getAbsolutePath();
    }

    private static void handleTempSaveCallback(int i, boolean z, BaseException baseException) {
        synchronized (saveTempFileStatusMap) {
            List<ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(i);
            if (list != null) {
                for (ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : list) {
                    if (iTempFileSaveCompleteCallback != null) {
                        if (z) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        } else {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                    }
                }
            }
            String str = TAG;
            Logger.d(str, "handleTempSaveCallback id:" + i);
            saveTempFileStatusMap.remove(i);
        }
    }

    public static boolean hasDownloadCacheHeader(List<HttpHeader> list) {
        boolean z = false;
        if (list != null) {
            if (list.size() != 0) {
                Iterator<HttpHeader> it = list.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    HttpHeader next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue()) && HEADER_TAG_DOWNLOAD_CACHE.equals(next.getName()) && HEADER_TAG_DOWNLOAD_CACHE.equals(next.getValue())) {
                        z = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        return z;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String hexToString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                try {
                    return new String(bArr, "utf-8");
                } catch (Exception e) {
                    e.printStackTrace();
                    return str;
                }
            }
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    public static boolean isChunkedTask(long j) {
        return j == -1;
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        boolean z = false;
        if (iDownloadHeadHttpConnection == null) {
            return false;
        }
        if (DownloadExpSwitchCode.isSwitchEnable(8)) {
            if (VALUE_CHUNKED.equals(iDownloadHeadHttpConnection.getResponseHeaderField("Transfer-Encoding")) || getContentLength(iDownloadHeadHttpConnection) == -1) {
                z = true;
            }
            return z;
        }
        boolean z2 = false;
        if (getContentLength(iDownloadHeadHttpConnection) == -1) {
            z2 = true;
        }
        return z2;
    }

    public static boolean isConnectionException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        boolean z = false;
        if (!TextUtils.isEmpty(throwableMsg)) {
            z = false;
            if (throwableMsg.contains("Exception in connect")) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isDownloadSuccessAndFileNotExist(int i, String str, String str2) {
        return i == -3 && !isFileExist(str, str2);
    }

    public static boolean isDownloaderProcess() {
        Boolean bool = sIsDownloaderProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        if (curProcessName != null) {
            if (curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName() + ":downloader")) {
                sIsDownloaderProcess = true;
                return sIsDownloaderProcess.booleanValue();
            }
        }
        sIsDownloaderProcess = false;
        return sIsDownloaderProcess.booleanValue();
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo) {
        return isFileDownloaded(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo, boolean z, String str) {
        if (z || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        try {
            if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                return checkMd5Valid(downloadInfo.getSavePath(), downloadInfo.getName(), str);
            }
            return false;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFileDownloaded(String str, String str2, String str3, boolean z) {
        if (z || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            if (new File(str, str2).exists()) {
                return checkMd5Valid(str, str2, str3);
            }
            return false;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFileDownloaded(String str, String str2, boolean z) {
        if (z || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            if (new File(str, str2).exists()) {
                return checkMd5Valid(str, str2, null);
            }
            return false;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFileExist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean isForbiddenException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (th instanceof DownloadHttpException) {
            DownloadHttpException downloadHttpException = (DownloadHttpException) th;
            if (downloadHttpException != null && downloadHttpException.getHttpStatusCode() == 403) {
                return true;
            }
            if (!TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("403")) {
                return true;
            }
        }
        boolean z = false;
        if (!TextUtils.isEmpty(throwableMsg)) {
            z = false;
            if (throwableMsg.contains("Forbidden")) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isHeaderEqual(List<HttpHeader> list, List<HttpHeader> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static boolean isHttpDataDirtyError(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if ((r3.getCause() instanceof javax.net.ssl.SSLHandshakeException) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isHttpsError(com.ss.android.socialbase.downloader.exception.BaseException r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r3
            int r0 = r0.getErrorCode()
            r1 = 1011(0x3f3, float:1.417E-42)
            if (r0 == r1) goto L27
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.Throwable r0 = r0.getCause()
            if (r0 == 0) goto L29
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.Throwable r0 = r0.getCause()
            boolean r0 = r0 instanceof javax.net.ssl.SSLHandshakeException
            if (r0 == 0) goto L29
        L27:
            r0 = 1
            r4 = r0
        L29:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.isHttpsError(com.ss.android.socialbase.downloader.exception.BaseException):boolean");
    }

    public static boolean isInsufficientSpaceError(Throwable th) {
        boolean z;
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            z = false;
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                boolean z2 = false;
                if (!TextUtils.isEmpty(message)) {
                    z2 = false;
                    if (message.contains("ENOSPC")) {
                        z2 = true;
                    }
                }
                return z2;
            }
        } else {
            z = false;
            if (th instanceof IOException) {
                String throwableMsg = getThrowableMsg(th);
                z = false;
                if (!TextUtils.isEmpty(throwableMsg)) {
                    z = false;
                    if (throwableMsg.contains("ENOSPC")) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean isMainProcess() {
        Boolean bool = sIsMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        if (curProcessName == null || !curProcessName.contains(":")) {
            boolean z = false;
            if (curProcessName != null) {
                z = false;
                if (curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName())) {
                    z = true;
                }
            }
            sIsMainProcess = Boolean.valueOf(z);
        } else {
            sIsMainProcess = false;
        }
        return sIsMainProcess.booleanValue();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean isMd5Valid(int i) {
        return i == 0 || i == 2;
    }

    public static boolean isNetNotAvailableException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        boolean z = false;
        if (!TextUtils.isEmpty(throwableMsg)) {
            z = false;
            if (throwableMsg.contains("network not available")) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 == null || (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNetworkError(Throwable th) {
        if (th instanceof BaseException) {
            int errorCode = ((BaseException) th).getErrorCode();
            return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
        }
        return false;
    }

    public static boolean isNoWifiAndInNet() {
        Context appContext = DownloadComponentManager.getAppContext();
        return (appContext == null || isWifi(appContext) || !isNetworkConnected(appContext)) ? false : true;
    }

    public static boolean isProcessNameSame(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        return curProcessName != null && curProcessName.equals(str);
    }

    public static boolean isResponseCode304Error(Throwable th) {
        return DownloadComponentManager.getTTNetHandler().isResponseCode304Error(th);
    }

    public static boolean isResponseCode412Error(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        boolean z = false;
        if (!TextUtils.isEmpty(throwableMsg)) {
            z = false;
            if (throwableMsg.contains("Precondition Failed")) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isResponseCode416Error(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        boolean z = false;
        if (!TextUtils.isEmpty(throwableMsg)) {
            z = false;
            if (throwableMsg.contains("Requested Range Not Satisfiable")) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isResponseCodeError(BaseException baseException) {
        if (baseException instanceof DownloadHttpException) {
            DownloadHttpException downloadHttpException = (DownloadHttpException) baseException;
            return downloadHttpException.getHttpStatusCode() == 412 || downloadHttpException.getHttpStatusCode() == 416;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0.contains("Precondition Failed") != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isResponseCodeError(java.lang.Throwable r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r3
            java.lang.String r0 = getThrowableMsg(r0)
            r3 = r0
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2e
            r0 = r3
            java.lang.String r1 = "Requested Range Not Satisfiable"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L2c
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.String r1 = "Precondition Failed"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L2e
        L2c:
            r0 = 1
            r4 = r0
        L2e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCodeError(java.lang.Throwable):boolean");
    }

    public static boolean isResponseCodeValid(int i) {
        return i == 206 || i == 200;
    }

    public static boolean isResponseDataFromBegin(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean isSavePathSecurity(String str) {
        Context appContext;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SAVE_PATH_SECURITY) <= 0 || (appContext = DownloadComponentManager.getAppContext()) == null || TextUtils.isEmpty(str) || str.startsWith("/data")) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Android/data/");
        sb.append(appContext.getPackageName());
        return str.contains(sb.toString());
    }

    private static boolean isSdcardAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(externalStorageState) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState);
    }

    private static boolean isSdcardWritable() {
        try {
            return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r0.contains("Time-out") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isTimeOutException(java.lang.Throwable r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r3
            java.lang.String r0 = getThrowableMsg(r0)
            r6 = r0
            r0 = r3
            boolean r0 = r0 instanceof java.net.SocketTimeoutException
            if (r0 != 0) goto L33
            r0 = r5
            r4 = r0
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L35
            r0 = r6
            java.lang.String r1 = "time out"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L33
            r0 = r5
            r4 = r0
            r0 = r6
            java.lang.String r1 = "Time-out"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L35
        L33:
            r0 = 1
            r4 = r0
        L35:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.isTimeOutException(java.lang.Throwable):boolean");
    }

    public static boolean isValidDirectory(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isWaitWifiAndInNet(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && isNetworkConnected(DownloadComponentManager.getAppContext());
    }

    public static boolean isWifi(Context context) {
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager2.getActiveNetworkInfo();
            boolean z = false;
            if (activeNetworkInfo != null) {
                if (!activeNetworkInfo.isAvailable()) {
                    return false;
                }
                z = false;
                if (1 == activeNetworkInfo.getType()) {
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes("UTF-8"));
                return toHexString(messageDigest.digest());
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static boolean moveFile(File file, File file2) throws BaseException {
        String str = TAG;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        boolean z = renameTo;
        if (!renameTo) {
            z = copyFile(file, file2);
            try {
                String str2 = TAG;
                Log.e(str2, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z;
    }

    public static boolean needNotifyDownloaderProcess() {
        return !isDownloaderProcess() && DownloadComponentManager.isDownloadInMultiProcess() && DownloadProxy.get(true).isServiceAlive();
    }

    private static String parseContentDisposition(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (CONTENT_DISPOSITION_QUOTED_PATTERN == null) {
                CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (CONTENT_DISPOSITION_NON_QUOTED_PATTERN == null) {
                CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static long parseContentLengthFromContentRange(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Range");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(respHeadFieldIgnoreCase);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
            return -1L;
        } catch (Exception e) {
            String str = TAG;
            Logger.w(str, "parse content-length from content-range failed " + e);
            return -1L;
        }
    }

    public static long parseContentRangeOfInstanceLength(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split(BridgeUtil.SPLIT_MARK);
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException e) {
                String str2 = TAG;
                Logger.w(str2, "parse instance length failed with " + str);
                return -1L;
            }
        }
        return -1L;
    }

    public static void parseException(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        } else if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, getErrorMsgWithTagPrefix(th, str2));
        } else {
            if (isTimeOutException(th)) {
                throw new BaseException(1048, getErrorMsgWithTagPrefix(th, str2));
            }
            if (isResponseCode412Error(th)) {
                throw new DownloadHttpException(1004, 412, getErrorMsgWithTagPrefix(th, str2));
            }
            if (isResponseCode416Error(th)) {
                throw new DownloadHttpException(1004, 416, getErrorMsgWithTagPrefix(th, str2));
            }
            if (isForbiddenException(th)) {
                throw new BaseException(1047, getErrorMsgWithTagPrefix(th, str2));
            }
            if (isNetNotAvailableException(th)) {
                throw new BaseException(1049, getErrorMsgWithTagPrefix(th, str2));
            }
            if (isConnectionException(th)) {
                throw new BaseException(1041, getErrorMsgWithTagPrefix(th, str2));
            }
            if (!(th instanceof IOException)) {
                throw new BaseException(1000, getErrorMsgWithTagPrefix(th, str2));
            }
            parseTTNetException(th, str);
            parseIOException((IOException) th, str);
        }
    }

    public static List<DownloadChunk> parseHostChunkList(List<DownloadChunk> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                if (downloadChunk.isHostChunk()) {
                    sparseArray.put(downloadChunk.getChunkIndex(), downloadChunk);
                    List<DownloadChunk> list2 = (List) sparseArray2.get(downloadChunk.getChunkIndex());
                    if (list2 != null) {
                        for (DownloadChunk downloadChunk2 : list2) {
                            downloadChunk2.setHostChunk(downloadChunk);
                        }
                        downloadChunk.setSubChunkList(list2);
                    }
                } else {
                    DownloadChunk downloadChunk3 = (DownloadChunk) sparseArray.get(downloadChunk.getHostChunkIndex());
                    if (downloadChunk3 != null) {
                        List<DownloadChunk> subChunkList = downloadChunk3.getSubChunkList();
                        ArrayList arrayList = subChunkList;
                        if (subChunkList == null) {
                            arrayList = new ArrayList();
                            downloadChunk3.setSubChunkList(arrayList);
                        }
                        downloadChunk.setHostChunk(downloadChunk3);
                        arrayList.add(downloadChunk);
                    } else {
                        List list3 = (List) sparseArray2.get(downloadChunk.getHostChunkIndex());
                        ArrayList arrayList2 = list3;
                        if (list3 == null) {
                            arrayList2 = new ArrayList();
                            sparseArray2.put(downloadChunk.getHostChunkIndex(), arrayList2);
                        }
                        arrayList2.add(downloadChunk);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseArray.size()) {
                break;
            }
            arrayList3.add(sparseArray.get(sparseArray.keyAt(i2)));
            i = i2 + 1;
        }
        return arrayList3.isEmpty() ? list : arrayList3;
    }

    public static void parseIOException(IOException iOException, String str) throws BaseException {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        String errorMsgWithTagPrefix = getErrorMsgWithTagPrefix(iOException, str2);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, errorMsgWithTagPrefix);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_UNKNOWN_SERVICE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_PORT_UNREACHABLE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_SOCKET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, errorMsgWithTagPrefix);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_PROTOCOL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_MALFORMED_URL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_FILE_NOT_FOUND, errorMsgWithTagPrefix);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_UNSUPPORTED_ENCODING, errorMsgWithTagPrefix);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_EOF, errorMsgWithTagPrefix);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException((int) DownloadErrorCode.ERROR_STREAM_RESET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, errorMsgWithTagPrefix);
        }
        if (!isInsufficientSpaceError(iOException)) {
            throw new BaseException(1023, errorMsgWithTagPrefix);
        }
        throw new BaseException(1006, errorMsgWithTagPrefix);
    }

    private static void parseTTNetException(Throwable th, String str) throws DownloadTTNetException {
        DownloadTTNetException translateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th, null);
        DownloadTTNetException downloadTTNetException = translateTTNetException;
        if (translateTTNetException == null) {
            downloadTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th.getCause(), null);
        }
        if (downloadTTNetException == null) {
            return;
        }
        throw new DownloadTTNetException(downloadTTNetException.getErrorCode(), getErrorMsgWithTagPrefix(downloadTTNetException, str)).setRequestLog(downloadTTNetException.getRequestLog());
    }

    public static long parserMaxAge(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (matcher.find()) {
            try {
                return Long.parseLong(matcher.group(1));
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static void safeClose(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        int length = cursorArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Cursor cursor = cursorArr[i2];
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }

    public static void safeClose(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        int length = closeableArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Closeable closeable = closeableArr[i2];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0270 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveFileAsTargetName(com.ss.android.socialbase.downloader.model.DownloadInfo r9, com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend r10, com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback r11) {
        /*
            Method dump skipped, instructions count: 952
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.saveFileAsTargetName(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend, com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback):void");
    }

    public static <K> void sparseArrayPutAll(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return hashMap;
            }
            hashMap.put(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
            i = i2 + 1;
        }
    }

    public static String toHexString(byte[] bArr) {
        if (bArr != null) {
            return toHexString(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + i] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = HEX_CHARS;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new NullPointerException("bytes is null");
    }
}

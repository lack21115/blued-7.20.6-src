package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.f.g.c;
import com.google.common.net.HttpHeaders;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/LogReport.class */
public class LogReport {
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String PRIVATE_CODE = "dqwef1864il4c9m6";
    private static final int SOCKET_TIMEOUT = 20000;
    private static String UPLOADTIME = "uploadtime";
    private static String mAid;
    private static String mAppkey;
    private static String mBaseUrl = "https://api.weibo.com/2/proxy/sdk/statistic.json";
    private static String mChannel;
    private static String mKeyHash;
    public static LogReport mLogReport;
    private static String mPackageName;
    private static JSONObject mParams;
    private static String mVersionName;

    public LogReport(Context context) {
        try {
            if (mPackageName == null) {
                mPackageName = context.getPackageName();
            }
            mAppkey = StatisticConfig.getAppkey(context);
            checkAid(context);
            mKeyHash = Utility.getSign(context, mPackageName);
            mVersionName = LogBuilder.getVersion(context);
            mChannel = StatisticConfig.getChannel(context);
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, e.toString());
        }
        initCommonParams();
    }

    private static void checkAid(Context context) {
        if (TextUtils.isEmpty(mAid)) {
            mAid = Utility.getAid(context, mAppkey);
        }
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("aid", mAid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static HttpPost getNewHttpPost(String str, JSONObject jSONObject) {
        HttpPost httpPost;
        synchronized (LogReport.class) {
            try {
                httpPost = new HttpPost(str);
                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                httpPost.setHeader("Connection", c.f7906c);
                httpPost.addHeader("Content-Encoding", StatisticConfig.isNeedGizp() ? "gzip" : "charset=UTF-8");
                httpPost.addHeader(HttpHeaders.ACCEPT, "*/*");
                httpPost.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-us");
                httpPost.addHeader("Accept-Encoding", "gzip");
            } catch (Throwable th) {
                throw th;
            }
        }
        return httpPost;
    }

    public static String getPackageName() {
        return mPackageName;
    }

    private static String getSign(String str, String str2, long j) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(str2);
        sb.append(PRIVATE_CODE);
        sb.append(j);
        String hexdigest = MD5.hexdigest(sb.toString());
        String substring = hexdigest.substring(hexdigest.length() - 6);
        String hexdigest2 = MD5.hexdigest(String.valueOf(substring) + substring.substring(0, 4));
        return String.valueOf(substring) + hexdigest2.substring(hexdigest2.length() - 1);
    }

    public static long getTime(Context context) {
        return context.getSharedPreferences(UPLOADTIME, 0).getLong("lasttime", 0L);
    }

    private static byte[] gzipLogs(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = str.getBytes("utf-8");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static JSONObject initCommonParams() {
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("appkey", mAppkey);
            mParams.put("platform", "Android");
            mParams.put("packagename", mPackageName);
            mParams.put("key_hash", mKeyHash);
            mParams.put("version", mVersionName);
            mParams.put("channel", mChannel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mParams;
    }

    private static boolean isNetworkConnected(Context context) {
        if (context == null) {
            LogUtil.e(WBAgent.TAG, "unexpected null context in isNetworkConnected");
            return false;
        } else if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            return false;
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (NullPointerException e) {
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03a2  */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.http.HttpResponse requestHttpExecute(java.lang.String r7, java.lang.String r8, org.json.JSONObject r9, org.json.JSONArray r10) {
        /*
            Method dump skipped, instructions count: 1011
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogReport.requestHttpExecute(java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONArray):org.apache.http.HttpResponse");
    }

    public static void setPackageName(String str) {
        mPackageName = str;
    }

    private static void shutdownHttpClient(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().closeExpiredConnections();
            } catch (Exception e) {
            }
        }
    }

    private static void updateTime(Context context, Long l) {
        SharedPreferences.Editor edit = context.getSharedPreferences(UPLOADTIME, 0).edit();
        edit.putLong("lasttime", l.longValue());
        edit.commit();
    }

    public static void uploadAppLogs(Context context, String str) {
        synchronized (LogReport.class) {
            try {
                if (mLogReport == null) {
                    mLogReport = new LogReport(context);
                }
                if (!isNetworkConnected(context)) {
                    LogUtil.i(WBAgent.TAG, "network is not connected");
                    LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), str, true);
                    return;
                }
                List<JSONArray> validUploadLogs = LogBuilder.getValidUploadLogs(str);
                if (validUploadLogs == null) {
                    LogUtil.i(WBAgent.TAG, "applogs is null");
                    return;
                }
                ArrayList<JSONArray> arrayList = new ArrayList();
                checkAid(context);
                for (JSONArray jSONArray : validUploadLogs) {
                    HttpResponse requestHttpExecute = requestHttpExecute(mBaseUrl, "POST", mParams, jSONArray);
                    if (requestHttpExecute != null && requestHttpExecute.getStatusLine().getStatusCode() == 200) {
                        updateTime(context, Long.valueOf(System.currentTimeMillis()));
                    } else {
                        arrayList.add(jSONArray);
                        LogUtil.e(WBAgent.TAG, "upload applogs error");
                    }
                }
                LogFileUtil.delete(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME));
                if (arrayList.size() > 0) {
                    for (JSONArray jSONArray2 : arrayList) {
                        LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), jSONArray2.toString(), true);
                        LogUtil.d(WBAgent.TAG, "save failed_log");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

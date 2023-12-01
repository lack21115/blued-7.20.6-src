package com.tencent.thumbplayer.config;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bp;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.config.TPPlayerCoreConfig;
import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/config/TPPlayerConfig.class */
public class TPPlayerConfig {
    private static String DOT = "\\.";
    public static final boolean ISOTT = false;
    private static final String TAG = "TPPlayerConfig";
    public static final String VERSION = "2.31.0.127";
    private static String appVersion = "";
    private static String appVersionName;
    public static String beacon_log_host = "";
    public static String beacon_policy_host = "";
    private static long buildNum = -1;
    private static String host_config = "";
    private static String mAbUserId = "";
    private static boolean mEnableDataReport = false;
    private static boolean mEnablePlayerReport = true;
    private static String mGuid = "";
    private static String mOutNetIp = "";
    private static int mPlatform = -1;
    private static String mProxyCacheDir;
    private static String mProxyDataDir;
    private static long mProxyMaxStorageSizeMB = 0;
    private static long mProxyMaxUseMemoryMB = 0;
    private static int mProxyServiceType = -1;
    private static boolean mUseP2P = true;
    private static boolean mUserIsVip = false;
    private static String mUserUin;
    private static String mUserUpc = "";
    private static int mUserUpcState;

    public static String getAbUserId() {
        return TextUtils.isEmpty(mAbUserId) ? "" : mAbUserId;
    }

    public static String getAppBigVersion(Context context) {
        String str;
        if (TextUtils.isEmpty(appVersion)) {
            String appVersionName2 = getAppVersionName(context);
            if (TextUtils.isEmpty(appVersionName2)) {
                str = bp.e;
            } else {
                String[] split = appVersionName2.split(DOT);
                str = appVersionName2;
                if (split != null) {
                    str = appVersionName2;
                    if (split.length == 4) {
                        str = appVersionName2.substring(0, appVersionName2.lastIndexOf("."));
                    }
                }
            }
            appVersion = str;
            return str;
        }
        return appVersion;
    }

    public static String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(appVersionName)) {
            if (context == null) {
                return "";
            }
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                appVersionName = str;
                return str == null ? "" : str;
            } catch (Throwable th) {
                return "";
            }
        }
        return appVersionName;
    }

    public static long getBuildNumber(Context context) {
        long j = buildNum;
        if (-1 != j) {
            return j;
        }
        try {
            long longVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
            buildNum = longVersionCode;
            return longVersionCode;
        } catch (Throwable th) {
            TPLogUtil.e(TAG, "getLongVersionCode less api 28");
            return buildNum;
        }
    }

    public static String getGuid() {
        return mGuid;
    }

    public static boolean getMediaDrmReuseEnable() {
        return TPPlayerCoreConfig.getMediaDrmReuseEnable();
    }

    public static boolean getNewReportEnable() {
        return TPPlayerCoreConfig.getCoreEventProcessEnable();
    }

    public static String getOutNetIp() {
        return mOutNetIp;
    }

    public static int getPlatform() {
        return mPlatform;
    }

    public static String getProxyCacheDir() {
        return mProxyCacheDir;
    }

    public static String getProxyConfigDir() {
        if (TextUtils.isEmpty(host_config)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(host_config);
            return !jSONObject.has(TPPlayerMgr.PROXY_HOST_KEY) ? "" : jSONObject.getString(TPPlayerMgr.PROXY_HOST_KEY);
        } catch (JSONException e) {
            TPLogUtil.e(TAG, e);
            return "";
        }
    }

    public static String getProxyDataDir() {
        return mProxyDataDir;
    }

    public static long getProxyMaxStorageSizeMB() {
        return mProxyMaxStorageSizeMB;
    }

    public static long getProxyMaxUseMemoryMB() {
        return mProxyMaxUseMemoryMB;
    }

    public static int getProxyServiceType() {
        int i;
        return (mProxyServiceType != -1 || (i = mPlatform) == -1) ? mProxyServiceType : i;
    }

    public static String getUserUin() {
        return mUserUin;
    }

    public static String getUserUpc() {
        return mUserUpc;
    }

    public static int getUserUpcState() {
        return mUserUpcState;
    }

    public static int getVideoMediaCodecCoexistMaxCnt() {
        return TPPlayerCoreConfig.getVideoMediaCodecCoexistMaxCnt();
    }

    public static String getWidevineProvisioningServerUrl() {
        return TPPlayerCoreConfig.getWidevineProvisioningServerUrl();
    }

    public static boolean isDataReportEnable() {
        return mEnableDataReport;
    }

    public static boolean isPlayerReportEnable() {
        return mEnablePlayerReport;
    }

    public static boolean isUseP2P() {
        return mUseP2P;
    }

    public static boolean isUserIsVip() {
        return mUserIsVip;
    }

    public static void parseHostConfig(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "parseHostConfig, config is null.";
        } else {
            host_config = str;
            TPLogUtil.i(TAG, "parseHostConfig:".concat(String.valueOf(str)));
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(TPPlayerMgr.PLYAER_HOST_KEY)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(TPPlayerMgr.PLYAER_HOST_KEY);
                    if (jSONObject2.has(TPPlayerMgr.BEACON_POLICY_HOST_KEY)) {
                        beacon_policy_host = jSONObject2.getString(TPPlayerMgr.BEACON_POLICY_HOST_KEY);
                    }
                    if (jSONObject2.has(TPPlayerMgr.BEACON_LOG_HOST_KEY)) {
                        beacon_log_host = jSONObject2.getString(TPPlayerMgr.BEACON_LOG_HOST_KEY);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                str2 = "parseHostConfig exception: " + th.toString();
            }
        }
        TPLogUtil.w(TAG, str2);
    }

    public static void setAbUserId(String str) {
        mAbUserId = str;
    }

    public static void setDataReportEnable(boolean z) {
        mEnableDataReport = z;
    }

    public static void setDebugEnable(boolean z) {
        TPLogUtil.setDebugEnable(z);
    }

    public static void setGuid(String str) {
        mGuid = str;
    }

    public static void setMediaDrmReuseEnable(boolean z) {
        TPPlayerCoreConfig.setMediaDrmReuseEnable(z);
    }

    public static void setNewReportEnable(boolean z) {
        TPPlayerCoreConfig.setCoreEventProcessEnable(z);
    }

    public static void setOutNetIp(String str) {
        mOutNetIp = str;
    }

    public static void setP2PEnable(boolean z) {
        mUseP2P = z;
    }

    public static void setPlatform(int i) {
        mPlatform = i;
    }

    public static void setPlayerReportEnable(boolean z) {
        mEnablePlayerReport = z;
    }

    public static void setProxyCacheDir(String str) {
        mProxyCacheDir = str;
    }

    public static void setProxyDataDir(String str) {
        mProxyDataDir = str;
    }

    public static void setProxyMaxStorageSizeMB(long j) {
        mProxyMaxStorageSizeMB = j;
    }

    public static void setProxyMaxUseMemoryMB(long j) {
        mProxyMaxUseMemoryMB = j;
    }

    public static void setProxyServiceType(int i) {
        mProxyServiceType = i;
    }

    public static void setUserIsVip(boolean z) {
        mUserIsVip = z;
    }

    public static void setUserUin(String str) {
        mUserUin = str;
    }

    public static void setUserUpc(String str) {
        mUserUpc = str;
    }

    public static void setUserUpcState(int i) {
        mUserUpcState = i;
    }

    public static void setVideoMediaCodecCoexistMaxCnt(int i) {
        TPPlayerCoreConfig.setVideoMediaCodecCoexistMaxCnt(i);
    }

    public static void setWidevineProvisioningServerUrl(String str) {
        TPPlayerCoreConfig.setWidevineProvisioningServerUrl(str);
    }
}

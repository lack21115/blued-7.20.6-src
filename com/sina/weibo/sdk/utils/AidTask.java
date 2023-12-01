package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.android.internal.telephony.PhoneConstants;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/AidTask.class */
public class AidTask implements Serializable {
    private static final String AID_FILE_NAME = "weibo_sdk_aid";
    private static final int MAX_RETRY_NUM = 3;
    private static final String TAG = "AidTask";
    private static final int VERSION = 1;
    public static final int WHAT_LOAD_AID_ERR = 1002;
    public static final int WHAT_LOAD_AID_SUC = 1001;
    private static AidTask sInstance;
    private static final long serialVersionUID = 1;
    private AidInfo mAidInfo;
    private String mAppKey;
    private Context mContext;
    private CallbackHandler mHandler;
    private volatile ReentrantLock mTaskLock = new ReentrantLock(true);

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/AidTask$AidInfo.class */
    public static final class AidInfo {
        private String mAid;
        private String mSubCookie;

        public static AidInfo parseJson(String str) throws WeiboException {
            AidInfo aidInfo = new AidInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") || jSONObject.has("error_code")) {
                    LogUtil.d(AidTask.TAG, "loadAidFromNet has error !!!");
                    throw new WeiboException("loadAidFromNet has error !!!");
                }
                aidInfo.mAid = jSONObject.optString("aid", "");
                aidInfo.mSubCookie = jSONObject.optString("sub", "");
                return aidInfo;
            } catch (JSONException e) {
                LogUtil.d(AidTask.TAG, "loadAidFromNet JSONException Msg : " + e.getMessage());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        AidInfo cloneAidInfo() {
            AidInfo aidInfo = new AidInfo();
            aidInfo.mAid = this.mAid;
            aidInfo.mSubCookie = this.mSubCookie;
            return aidInfo;
        }

        public String getAid() {
            return this.mAid;
        }

        public String getSubCookie() {
            return this.mSubCookie;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/AidTask$AidResultCallBack.class */
    public interface AidResultCallBack {
        void onAidGenFailed(Exception exc);

        void onAidGenSuccessed(AidInfo aidInfo);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/AidTask$CallbackHandler.class */
    static class CallbackHandler extends Handler {
        private WeakReference<AidResultCallBack> callBackReference;

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AidResultCallBack aidResultCallBack = this.callBackReference.get();
            int i = message.what;
            if (i == 1001) {
                if (aidResultCallBack != null) {
                    aidResultCallBack.onAidGenSuccessed(((AidInfo) message.obj).cloneAidInfo());
                }
            } else if (i == 1002 && aidResultCallBack != null) {
                aidResultCallBack.onAidGenFailed((WeiboException) message.obj);
            }
        }

        public void setCallback(AidResultCallBack aidResultCallBack) {
            WeakReference<AidResultCallBack> weakReference = this.callBackReference;
            if (weakReference == null) {
                this.callBackReference = new WeakReference<>(aidResultCallBack);
            } else if (weakReference.get() == aidResultCallBack) {
            } else {
                this.callBackReference = new WeakReference<>(aidResultCallBack);
            }
        }
    }

    private AidTask(Context context) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
        new Thread(new Runnable() { // from class: com.sina.weibo.sdk.utils.AidTask.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 1) {
                        return;
                    }
                    try {
                        AidTask.this.getAidInfoFile(i2).delete();
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheAidInfo(String str) {
        FileOutputStream fileOutputStream;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                try {
                    fileOutputStream = new FileOutputStream(getAidInfoFile(1));
                } catch (Exception e) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                } catch (Exception e2) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
            }
        }
    }

    private static String encryptRsa(String str, String str2) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] doFinal;
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, getPublicKey(str2));
        byte[] bytes = str.getBytes("UTF-8");
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    int splite = splite(bytes, i2, 117);
                    if (splite == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        LogUtil.d(TAG, "encryptRsa total enBytes len = " + byteArray.length);
                        byte[] encodebyte = Base64.encodebyte(byteArray);
                        LogUtil.d(TAG, "encryptRsa total base64byte len = " + encodebyte.length);
                        String str3 = HiAnalyticsConstant.KeyAndValue.NUMBER_01 + new String(encodebyte, "UTF-8");
                        LogUtil.d(TAG, "encryptRsa total base64string : " + str3);
                        try {
                            byteArrayOutputStream.close();
                            return str3;
                        } catch (IOException e) {
                            return str3;
                        }
                    }
                    byteArrayOutputStream.write(cipher.doFinal(bytes, i2, splite));
                    LogUtil.d(TAG, "encryptRsa offset = " + i2 + "     len = " + splite + "     enBytes len = " + doFinal.length);
                    i = i2 + splite;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    private static String genMfpString(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("1", os);
            }
            String imei = getImei(context);
            if (!TextUtils.isEmpty(imei)) {
                jSONObject.put("2", imei);
            }
            String meid = getMeid(context);
            if (!TextUtils.isEmpty(meid)) {
                jSONObject.put("3", meid);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put("4", imsi);
            }
            String mac = getMac(context);
            if (!TextUtils.isEmpty(mac)) {
                jSONObject.put("5", mac);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put("6", iccid);
            }
            String serialNo = getSerialNo();
            if (!TextUtils.isEmpty(serialNo)) {
                jSONObject.put("7", serialNo);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put("10", androidId);
            }
            String cpu = getCpu();
            if (!TextUtils.isEmpty(cpu)) {
                jSONObject.put("13", cpu);
            }
            String model = getModel();
            if (!TextUtils.isEmpty(model)) {
                jSONObject.put("14", model);
            }
            String sdSize = getSdSize();
            if (!TextUtils.isEmpty(sdSize)) {
                jSONObject.put("15", sdSize);
            }
            String resolution = getResolution(context);
            if (!TextUtils.isEmpty(resolution)) {
                jSONObject.put("16", resolution);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put("17", ssid);
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                jSONObject.put("18", deviceName);
            }
            String connectType = getConnectType(context);
            if (!TextUtils.isEmpty(connectType)) {
                jSONObject.put("19", connectType);
            }
            try {
                str = Utility.generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_HELPER, str);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    private void generateAid(String str, final AidResultCallBack aidResultCallBack) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAppKey = str;
        new Thread(new Runnable() { // from class: com.sina.weibo.sdk.utils.AidTask.3
            @Override // java.lang.Runnable
            public void run() {
                AidTask.this.mTaskLock.lock();
                AidInfo loadAidInfoFromCache = AidTask.this.loadAidInfoFromCache();
                AidInfo aidInfo = loadAidInfoFromCache;
                WeiboException e = null;
                if (loadAidInfoFromCache == null) {
                    aidInfo = loadAidInfoFromCache;
                    try {
                        String loadAidFromNet = AidTask.this.loadAidFromNet();
                        AidInfo parseJson = AidInfo.parseJson(loadAidFromNet);
                        AidTask.this.cacheAidInfo(loadAidFromNet);
                        aidInfo = parseJson;
                        AidTask.this.mAidInfo = parseJson;
                        aidInfo = parseJson;
                        e = null;
                    } catch (WeiboException e2) {
                        e = e2;
                        LogUtil.e(AidTask.TAG, "AidTaskInit WeiboException Msg : " + e.getMessage());
                    }
                }
                AidTask.this.mTaskLock.unlock();
                Message obtain = Message.obtain();
                if (aidInfo != null) {
                    obtain.what = 1001;
                    obtain.obj = aidInfo;
                } else {
                    obtain.what = 1002;
                    obtain.obj = e;
                }
                AidTask.this.mHandler.setCallback(aidResultCallBack);
                AidTask.this.mHandler.sendMessage(obtain);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getAidInfoFile(int i) {
        File filesDir = this.mContext.getFilesDir();
        return new File(filesDir, AID_FILE_NAME + i);
    }

    private static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    private static String getConnectType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            String str = "none";
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "none";
                    }
                }
                str = "none";
                if (activeNetworkInfo.getType() == 1) {
                    str = "wifi";
                }
            }
            return str;
        } catch (Exception e) {
            return "none";
        }
    }

    private static String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    public static AidTask getInstance(Context context) {
        AidTask aidTask;
        synchronized (AidTask.class) {
            try {
                if (sInstance == null) {
                    sInstance = new AidTask(context);
                }
                aidTask = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aidTask;
    }

    private static String getMac(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMeid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMfp(Context context) {
        String str;
        try {
            str = new String(genMfpString(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str = "";
        }
        LogUtil.d(TAG, "genMfpString() utf-8 string : " + str);
        try {
            String encryptRsa = encryptRsa(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            LogUtil.d(TAG, "encryptRsa() string : " + encryptRsa);
            return encryptRsa;
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage());
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getOS() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception e) {
            return "";
        }
    }

    private static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
    }

    private static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(String.valueOf(displayMetrics.widthPixels)) + PhoneConstants.APN_TYPE_ALL + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSerialNo() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception e) {
            return "";
        }
    }

    private void initAidInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAppKey = str;
        new Thread(new Runnable() { // from class: com.sina.weibo.sdk.utils.AidTask.2
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (!AidTask.this.mTaskLock.tryLock()) {
                    LogUtil.e(AidTask.TAG, "tryLock : false, return");
                    return;
                }
                AidInfo loadAidInfoFromCache = AidTask.this.loadAidInfoFromCache();
                if (loadAidInfoFromCache == null) {
                    int i2 = 1;
                    do {
                        i = i2 + 1;
                        try {
                            String loadAidFromNet = AidTask.this.loadAidFromNet();
                            AidInfo parseJson = AidInfo.parseJson(loadAidFromNet);
                            AidTask.this.cacheAidInfo(loadAidFromNet);
                            AidTask.this.mAidInfo = parseJson;
                            break;
                        } catch (WeiboException e) {
                            LogUtil.e(AidTask.TAG, "AidTaskInit WeiboException Msg : " + e.getMessage());
                            i2 = i;
                            if (i >= 3) {
                            }
                        }
                    } while (i >= 3);
                } else {
                    AidTask.this.mAidInfo = loadAidInfoFromCache;
                }
                AidTask.this.mTaskLock.unlock();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loadAidFromNet() throws WeiboException {
        String packageName = this.mContext.getPackageName();
        String sign = Utility.getSign(this.mContext, packageName);
        String mfp = getMfp(this.mContext);
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put("appkey", this.mAppKey);
        weiboParameters.put("mfp", mfp);
        weiboParameters.put("packagename", packageName);
        weiboParameters.put("key_hash", sign);
        try {
            String internalHttpRequest = NetUtils.internalHttpRequest(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", weiboParameters);
            LogUtil.d(TAG, "loadAidFromNet response : " + internalHttpRequest);
            return internalHttpRequest;
        } catch (WeiboException e) {
            LogUtil.d(TAG, "loadAidFromNet WeiboException Msg : " + e.getMessage());
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AidInfo loadAidInfoFromCache() {
        FileInputStream fileInputStream;
        synchronized (this) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(getAidInfoFile(1));
            } catch (Exception e) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                AidInfo parseJson = AidInfo.parseJson(new String(bArr));
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                }
                return parseJson;
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream;
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }
    }

    private static int splite(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    public void aidTaskInit(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LogUtil.e(TAG, "aidTaskInit ");
        initAidInfo(str);
    }

    public void getAidAsync(String str, AidResultCallBack aidResultCallBack) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AidInfo aidInfo = this.mAidInfo;
        if (aidInfo == null || aidResultCallBack == null) {
            generateAid(str, aidResultCallBack);
        } else {
            aidResultCallBack.onAidGenSuccessed(aidInfo.cloneAidInfo());
        }
    }

    public AidInfo getAidSync(String str) throws WeiboException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.e(TAG, "getAidSync ");
        if (this.mAidInfo == null) {
            aidTaskInit(str);
        }
        return this.mAidInfo;
    }
}

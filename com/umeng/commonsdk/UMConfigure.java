package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.amap.api.col.p0003sl.iu;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.downloadlib.OrderDownloader;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.b;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.a;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import com.umeng.commonsdk.utils.d;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/UMConfigure.class */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog = false;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    private static boolean shouldCollectAid = true;
    private static volatile boolean shouldOutputRT = false;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", OrderDownloader.BizType.GAME, bh.al};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/UMConfigure$BS_TYPE.class */
    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static boolean checkShareSdk(Class<?> cls) {
        boolean z = false;
        try {
            if (cls.getDeclaredField("isZyb") != null) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null) {
            Log.e("UMLog", UMLogCommon.SC_10025);
        } else if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", UMLogCommon.SC_10020);
        } else {
            try {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10021);
                    return;
                }
                int ordinal = bs_type.ordinal();
                String str2 = ordinal < BUSINESS_TYPE.length ? BUSINESS_TYPE[ordinal] : "";
                if (TextUtils.isEmpty(str2)) {
                    Log.e("UMLog", UMLogCommon.SC_10022);
                    return;
                }
                TagHelper.deleteModuleTag(str2 + BridgeUtil.UNDERLINE_STR + str);
            } catch (Throwable th) {
            }
        }
    }

    private static void disableAidCollect() {
        try {
            if (getClass("com.umeng.socialize.UMShareAPI") != null) {
                shouldCollectAid = false;
            }
        } catch (Throwable th) {
        }
    }

    public static void enableAzxSwitch(boolean z) {
        b.a(z);
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static String getCurrentActivityName() {
        return PageNameMonitor.getInstance().getCurrentActivityName();
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        Object obj = null;
        if (cls != null) {
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
            } catch (NoSuchMethodException e) {
                constructor = null;
            }
            obj = null;
            if (constructor != null) {
                constructor.setAccessible(true);
                try {
                    obj = constructor.newInstance(new Object[0]);
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e2) {
                    return null;
                }
            }
        }
        return obj;
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method;
        Method method2 = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                method = null;
            }
            method2 = method;
            if (method != null) {
                method.setAccessible(true);
                method2 = method;
            }
        }
        return method2;
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable th) {
            return null;
        }
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
                return;
            }
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        mOnGetOaidListener = onGetOaidListener;
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String a2 = av.a(Context.this);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(a2);
                }
            }
        }).start();
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception e) {
                return strArr;
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(context.getApplicationContext());
        }
        return null;
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:252:0x07d7 -> B:45:0x0115). Please submit an issue!!! */
    public static void init(Context context, String str, String str2, int i, String str3) {
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        Class<?> cls;
        Method declaredMethod3;
        Method declaredMethod4;
        Method declaredMethod5;
        Method declaredMethod6;
        Object invoke2;
        Method declaredMethod7;
        Class<?> cls2;
        Method declaredMethod8;
        Method declaredMethod9;
        try {
            try {
                if (debugLog) {
                    Log.i(TAG, "common version is 9.6.3");
                    Log.i(TAG, "common type is " + SdkVersion.SDK_TYPE);
                }
            } catch (Exception e) {
                if (debugLog) {
                    Log.e(TAG, "init e is " + e);
                }
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "init e is " + th);
            }
        }
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
            }
        } else if (isInit) {
            if (debugLog) {
                Log.e(TAG, "has inited !!!");
            }
        } else {
            final Context applicationContext = context.getApplicationContext();
            UMGlobalContext.getInstance(applicationContext);
            if (c.a()) {
                if (!isPreInit()) {
                    preInitInternal(applicationContext, str, str2);
                    if (!isPreInit()) {
                        return;
                    }
                }
                UMWorkDispatch.sendEvent(applicationContext, a.D, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
                return;
            }
            try {
                if (getClass("com.umeng.umzid.ZIDManager") == null) {
                    Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-asms-1.2.x.aar库。<<<--- ");
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(Context.this, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                                Looper.loop();
                            } catch (Throwable th2) {
                            }
                        }
                    }.start();
                    return;
                }
            } catch (Throwable th2) {
            }
            try {
                Class<?> cls3 = getClass("com.umeng.message.PushAgent");
                if (cls3 != null && !checkShareSdk(cls3)) {
                    Log.e("UMLog", UMLogCommon.SC_10015);
                    if (shouldCheckShareSdk) {
                        new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(Context.this, UMLogCommon.SC_10015, 1).show();
                                    Looper.loop();
                                } catch (Throwable th3) {
                                }
                            }
                        }.start();
                    }
                }
            } catch (Throwable th3) {
            }
            try {
                Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
                if (cls4 != null && !checkShareSdk(cls4)) {
                    Log.e("UMLog", UMLogCommon.SC_10015);
                    if (shouldCheckShareSdk) {
                        new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(Context.this, UMLogCommon.SC_10015, 1).show();
                                    Looper.loop();
                                } catch (Throwable th4) {
                                }
                            }
                        }.start();
                    }
                }
            } catch (Throwable th4) {
            }
            if (!isPreInit()) {
                preInitInternal(applicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            UMEnvelopeBuild.registerNetReceiver(applicationContext);
            UMUtils.setAppkey(applicationContext, sAppkey);
            String lastAppkey = UMUtils.getLastAppkey(applicationContext);
            if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
                if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
                }
                UMUtils.setLastAppkey(applicationContext, sAppkey);
            }
            if (debugLog) {
                Log.i(TAG, "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
            }
            if (debugLog) {
                String appkeyByXML = UMUtils.getAppkeyByXML(applicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                    UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                }
            }
            UMUtils.setChannel(applicationContext, sChannel);
            if (debugLog) {
                Log.i(TAG, "channel is " + sChannel);
            }
            try {
                Class<?> cls5 = Class.forName("com.umeng.analytics.MobclickAgent");
                if (cls5 != null) {
                    Method declaredMethod10 = cls5.getDeclaredMethod("init", Context.class);
                    if (declaredMethod10 != null) {
                        declaredMethod10.setAccessible(true);
                        declaredMethod10.invoke(cls5, applicationContext);
                        if (FieldManager.allow(d.F)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                            l.a(applicationContext).b(applicationContext);
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                        }
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                        }
                    }
                    if (Class.forName("com.umeng.analytics.game.UMGameAgent") != null && (declaredMethod9 = cls5.getDeclaredMethod("setGameScenarioType", Context.class)) != null) {
                        declaredMethod9.setAccessible(true);
                        declaredMethod9.invoke(cls5, applicationContext);
                    }
                }
                if (com.umeng.commonsdk.statistics.b.f40900a.indexOf(iu.h) >= 0 && (cls2 = Class.forName("com.umeng.analytics.MobclickAgent")) != null && (declaredMethod8 = cls2.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                    declaredMethod8.setAccessible(true);
                    declaredMethod8.invoke(cls2, new Object[0]);
                }
            } catch (Throwable th5) {
            }
            try {
                Class<?> cls6 = Class.forName("com.umeng.message.PushAgent");
                if (cls6 != null && (declaredMethod7 = cls6.getDeclaredMethod("init", Context.class)) != null) {
                    declaredMethod7.setAccessible(true);
                    declaredMethod7.invoke(cls6, applicationContext);
                }
            } catch (Throwable th6) {
            }
            try {
                Class<?> cls7 = Class.forName("com.umeng.message.MessageSharedPrefs");
                if (cls7 != null && (declaredMethod6 = cls7.getDeclaredMethod("getInstance", Context.class)) != null && (invoke2 = declaredMethod6.invoke(cls7, applicationContext)) != null) {
                    Method declaredMethod11 = cls7.getDeclaredMethod("setMessageAppKey", String.class);
                    if (declaredMethod11 != null) {
                        declaredMethod11.setAccessible(true);
                        declaredMethod11.invoke(invoke2, sAppkey);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                        }
                    }
                    Method declaredMethod12 = cls7.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                    if (declaredMethod12 != null) {
                        declaredMethod12.setAccessible(true);
                        declaredMethod12.invoke(invoke2, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        boolean z = debugLog;
                    } else {
                        if (debugLog) {
                            Log.i(TAG, "push secret is " + str3);
                        }
                        Method declaredMethod13 = cls7.getDeclaredMethod("setMessageAppSecret", String.class);
                        if (declaredMethod13 != null) {
                            declaredMethod13.setAccessible(true);
                            declaredMethod13.invoke(invoke2, str3);
                            if (debugLog) {
                                UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                            }
                        }
                    }
                }
            } catch (Exception e2) {
            }
            try {
                Class<?> cls8 = getClass("com.umeng.socialize.UMShareAPI");
                setFile(cls8, KEY_FILE_NAME_APPKEY, sAppkey);
                if (cls8 != null && (declaredMethod5 = cls8.getDeclaredMethod("init", Context.class, String.class)) != null) {
                    declaredMethod5.setAccessible(true);
                    declaredMethod5.invoke(cls8, applicationContext, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                    }
                }
            } catch (Throwable th7) {
            }
            AnalyticsConstants.setDeviceType(i);
            try {
                Class<?> cls9 = Class.forName("com.umeng.error.UMError");
                if (cls9 != null && (declaredMethod4 = cls9.getDeclaredMethod("init", Context.class)) != null) {
                    declaredMethod4.setAccessible(true);
                    declaredMethod4.invoke(cls9, applicationContext);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                    }
                }
            } catch (Throwable th8) {
            }
            try {
                if (getClass("com.umeng.umefs.UMEfs") == null && (cls = getClass("com.umeng.umcrash.UMCrash")) != null) {
                    if (SdkVersion.SDK_TYPE == 1 && (declaredMethod3 = cls.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                        declaredMethod3.setAccessible(true);
                        declaredMethod3.invoke(cls, true);
                    }
                    Method declaredMethod14 = cls.getDeclaredMethod("init", Context.class, String.class, String.class);
                    if (declaredMethod14 != null) {
                        declaredMethod14.setAccessible(true);
                        declaredMethod14.invoke(cls, applicationContext, sAppkey, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                        }
                    }
                }
            } catch (Throwable th9) {
            }
            Method declaredMethod15 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
            if (declaredMethod15 != null) {
                try {
                    declaredMethod15.invoke(null, applicationContext, sAppkey, sChannel, Integer.valueOf(i), str3);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
                } catch (Throwable th10) {
                }
            }
            try {
                Method declaredMethod16 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
                if (declaredMethod16 != null) {
                    declaredMethod16.invoke(null, applicationContext, sAppkey);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
                }
            } catch (Throwable th11) {
            }
            synchronized (lockObject) {
                isFinish = true;
            }
            if (needCheckPolicyResult(applicationContext)) {
                synchronized (lock) {
                    if (preInitInvokedFlag == 0) {
                        Log.e(TAG, UMLogCommon.SC_10026);
                    }
                    if (policyGrantResult == 0) {
                        Log.e(TAG, UMLogCommon.SC_10028);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(a.J, preInitInvokedFlag);
                        jSONObject.put(a.K, policyGrantInvokedFlag);
                        jSONObject.put("policyGrantResult", policyGrantResult);
                        UMWorkDispatch.sendEvent(applicationContext, a.A, com.umeng.commonsdk.internal.b.a(applicationContext).a(), jSONObject);
                    } catch (Throwable th12) {
                    }
                }
            }
            if (needSendZcfgEnv(applicationContext)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
                UMWorkDispatch.sendEvent(applicationContext, a.p, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
                if (FieldManager.b()) {
                    UMWorkDispatch.sendEvent(applicationContext, a.y, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
                }
                if (FieldManager.allow(d.G)) {
                    com.umeng.commonsdk.internal.c.a(applicationContext, false);
                }
            }
            if (isDebugLog()) {
                UMConfigureInternation.doSelfCheck(applicationContext);
            }
            try {
                Context applicationContext2 = context.getApplicationContext();
                Class<?> cls10 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
                if (cls10 != null && (declaredMethod = cls10.getDeclaredMethod("getInstance", new Class[0])) != null && (invoke = declaredMethod.invoke(cls10, new Object[0])) != null && (declaredMethod2 = cls10.getDeclaredMethod("init", Context.class)) != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(invoke, applicationContext2);
                }
            } catch (Exception e3) {
            }
            UMWorkDispatch.sendEvent(context, a.F, com.umeng.commonsdk.internal.b.a(context).a(), null);
            if (isInit) {
                return;
            }
            isInit = true;
        }
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            }
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static Boolean isInForeground() {
        return Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    private static boolean isSilentMode() {
        boolean a2 = c.a();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + a2);
        return a2;
    }

    private static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(bl.m);
        return !new File(sb.toString()).exists();
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(bl.l);
        return !new File(sb.toString()).exists();
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "preInit: context is null, pls check!");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if ("1".equals(UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
            shouldOutputRT = true;
        }
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = UMUtils.getAppkeyByXML(applicationContext);
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = UMUtils.getChannelByXML(applicationContext);
        }
        String str5 = str4;
        if (TextUtils.isEmpty(str4)) {
            str5 = "Unknown";
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        sAppkey = str3;
        sChannel = str5;
        UMGlobalContext.getInstance(applicationContext);
        l.a(applicationContext);
        if (!needSendZcfgEnv(applicationContext)) {
            FieldManager.a().a(applicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean a2 = c.a();
        if (debugLog && a2) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void resetStorePrefix(String str) {
        at.b().a(str);
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "setDomain: Parameter domain is null or empty string, do nothing.");
            return;
        }
        UMServerURL.DEFAULT_URL = str;
        UMServerURL.SECONDARY_URL = str;
    }

    public static void setEncryptEnabled(boolean z) {
        com.umeng.commonsdk.statistics.b.a(z);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception e) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception e) {
            }
        }
    }

    private static void setLatencyWindow(long j) {
        com.umeng.commonsdk.statistics.a.f40899c = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        try {
            if (bs_type == null) {
                Log.e("UMLog", UMLogCommon.SC_10024);
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10017);
                    return;
                } else if (str2.trim().getBytes().length > 128) {
                    Log.e("UMLog", UMLogCommon.SC_10018);
                    return;
                } else {
                    int ordinal = bs_type.ordinal();
                    String str3 = ordinal < BUSINESS_TYPE.length ? BUSINESS_TYPE[ordinal] : "";
                    if (TextUtils.isEmpty(str3)) {
                        Log.e("UMLog", UMLogCommon.SC_10019);
                        return;
                    }
                    TagHelper.setModuleTag(str3 + BridgeUtil.UNDERLINE_STR + str, str2);
                    return;
                }
            }
            Log.e("UMLog", UMLogCommon.SC_10016);
        } catch (Throwable th) {
        }
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.f40889a = "native";
                com.umeng.commonsdk.statistics.a.f40898a = "native";
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_COCOS2DX_X;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_COCOS2DX_XLUA;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_UNITY;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_REACTNATIVE;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_PHONEGAP;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_WEEX;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.f40889a = "hybrid";
                com.umeng.commonsdk.statistics.a.f40898a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.f40889a = WRAPER_TYPE_FLUTTER;
                com.umeng.commonsdk.statistics.a.f40898a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.b = str2;
        com.umeng.commonsdk.statistics.a.b = str2;
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void submitPolicyGrantResult(Context context, boolean z) {
        UMWorkDispatch.sendEvent(context, a.B, com.umeng.commonsdk.internal.b.a(context).a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, a.z, com.umeng.commonsdk.internal.b.a(context).a(), Integer.valueOf(policyGrantResult));
    }
}

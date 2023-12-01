package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.heytap.mcssdk.base.Base64;
import com.heytap.mcssdk.constant.IntentConstant;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.manage.NotificatonChannelManager;
import com.heytap.mcssdk.mode.AppLimitBean;
import com.heytap.mcssdk.mode.CallBackResult;
import com.heytap.mcssdk.parser.CallBackResultParser;
import com.heytap.mcssdk.parser.DataMessageParser;
import com.heytap.mcssdk.parser.Parser;
import com.heytap.mcssdk.processor.CallBackResultProcessor;
import com.heytap.mcssdk.processor.DataMessageProcessor;
import com.heytap.mcssdk.processor.Processor;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.mcs.aidl.IMcsSdkService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/PushService.class */
public class PushService implements IPushService {
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_VERSION_CODE = "versionCode";
    private static final String APP_VERSION_NAME = "versionName";
    private static final int DEFAULT_API_MAX_COUNT = 2;
    private static final String EVENT_ID = "eventID";
    private static final String EXTRA = "extra";
    private static final String GLOBAL_ID = "globalID";
    private static final int MAX_HOUR_IN_DAY = 23;
    private static final int MAX_MIN_IN_HOUR = 59;
    private static final int MCS_SUPPORT_VERSION = 1019;
    private static final String MESSAGE_ID = "messageID";
    private static final String MESSAGE_TYPE = "messageType";
    private static final String NEW_MCS_RECEIVE_SDK_ACTION_Base64 = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    private static final String PUSH_SDK_VERSION = "pushSdkVersion";
    private static final int SDK_INT_24 = 24;
    private static final String SUPPORT_OPEN_PUSH = "supportOpenPush";
    private static final int SYSTEM_UID = 1000;
    private static final String TASK_ID = "taskID";
    private static final String TYPE = "type";
    private static boolean sIsNewMcsPkg;
    private static String sMcsPkgName;
    private ConcurrentHashMap<Integer, AppLimitBean> mAppLimitMap;
    private String mAuthCode;
    private Context mContext;
    private ICallBackResultService mICallBackResultService;
    private IGetAppNotificationCallBackService mIGetAppNotificationCallBackService;
    private ISetAppNotificationCallBackService mISetAppNotificationCallBackService;
    private List<Parser> mParsers;
    private List<Processor> mProcessors;
    private String mRegisterID;
    private String mVerifyCode;
    private static final int[] OLD_MCS_PACKAGE = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] OLD_MCS_RECEIVE_SDK_ACTION = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static String NEW_MCS_RECEIVE_SDK_ACTION = "";
    private static int sCount = 0;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/PushService$SingletonHolder.class */
    static class SingletonHolder {
        private static final PushService INSTANCE = new PushService();

        private SingletonHolder() {
        }
    }

    private PushService() {
        this.mProcessors = new ArrayList();
        this.mParsers = new ArrayList();
        this.mRegisterID = null;
        synchronized (PushService.class) {
            try {
                if (sCount > 0) {
                    throw new RuntimeException("PushService can't create again!");
                }
                sCount++;
            } catch (Throwable th) {
                throw th;
            }
        }
        addParser(new DataMessageParser());
        addParser(new CallBackResultParser());
        addProcessor(new DataMessageProcessor());
        addProcessor(new CallBackResultProcessor());
        this.mAppLimitMap = new ConcurrentHashMap<>();
    }

    private AppLimitBean addCommandToMap(int i) {
        String str;
        if (!this.mAppLimitMap.containsKey(Integer.valueOf(i))) {
            AppLimitBean appLimitBean = new AppLimitBean(System.currentTimeMillis(), 1);
            this.mAppLimitMap.put(Integer.valueOf(i), appLimitBean);
            LogUtil.d("addCommandToMap :appBean is null");
            return appLimitBean;
        }
        AppLimitBean appLimitBean2 = this.mAppLimitMap.get(Integer.valueOf(i));
        if (checkTimeNeedUpdate(appLimitBean2)) {
            appLimitBean2.setCount(1);
            appLimitBean2.setLastedTime(System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            appLimitBean2.setCount(appLimitBean2.getCount() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        LogUtil.d(str);
        return appLimitBean2;
    }

    private void addParser(Parser parser) {
        synchronized (this) {
            if (parser != null) {
                this.mParsers.add(parser);
            }
        }
    }

    private void addProcessor(Processor processor) {
        synchronized (this) {
            if (processor != null) {
                this.mProcessors.add(processor);
            }
        }
    }

    private boolean checkAll() {
        return checkContext() && checkRegisterID();
    }

    private boolean checkContext() {
        return this.mContext != null;
    }

    private boolean checkRegisterID() {
        return this.mRegisterID != null;
    }

    private boolean checkTimeNeedUpdate(AppLimitBean appLimitBean) {
        long lastedTime = appLimitBean.getLastedTime();
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.d("checkTimeNeedUpdate : lastedTime " + lastedTime + " currentTime:" + currentTimeMillis);
        return currentTimeMillis - lastedTime > 1000;
    }

    public static PushService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Intent getIntent(int i, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(getReceiveSdkAction(this.mContext));
        intent.setPackage(getMcsPackageName(this.mContext));
        intent.putExtra("type", i);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(APP_VERSION_NAME, Utils.getVersionName(this.mContext, this.mContext.getPackageName()));
            jSONObject2.putOpt(APP_VERSION_CODE, Integer.valueOf(Utils.getVersionCode(this.mContext, this.mContext.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra("appKey", this.mAuthCode);
        intent.putExtra(IntentConstant.APP_SECRET, this.mVerifyCode);
        intent.putExtra(IntentConstant.REGISTER_ID, this.mRegisterID);
        intent.putExtra("sdkVersion", getSDKVersionName());
        return intent;
    }

    private String getNewMcsPackageName(Context context) {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
            NEW_MCS_RECEIVE_SDK_ACTION = new String(Base64.decodeBase64(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(NEW_MCS_RECEIVE_SDK_ACTION), 8192);
        if (Build.VERSION.SDK_INT >= 24) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.packageName;
                try {
                    z = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                    z2 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0);
                } catch (PackageManager.NameNotFoundException e) {
                }
                if (z || z2) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    public static int getSDKVersionCode() {
        return ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION;
    }

    public static String getSDKVersionName() {
        return "3.1.0";
    }

    private boolean isSupportPushInner(Context context) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        String mcsPackageName = getMcsPackageName(this.mContext);
        return Utils.isExistPackage(this.mContext, mcsPackageName) && Utils.getVersionCode(this.mContext, mcsPackageName) >= 1019 && Utils.isSupportPush(this.mContext, mcsPackageName, SUPPORT_OPEN_PUSH);
    }

    @Deprecated
    private static void onAppStart(Context context) {
        StatUtil.statisticMessage(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    private void startMcsService(int i, String str, JSONObject jSONObject) {
        if (checkCommandLimit(i)) {
            ICallBackResultService iCallBackResultService = this.mICallBackResultService;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently");
                return;
            }
            return;
        }
        try {
            this.mContext.startService(getIntent(i, str, jSONObject));
        } catch (Exception e) {
            LogUtil.e("startMcsService--Exception" + e.getMessage());
        }
    }

    private void startMcsService(int i, JSONObject jSONObject) {
        startMcsService(i, "", jSONObject);
    }

    public void bindMcsService(int i) {
        if (!checkCommandLimit(i)) {
            final Intent intent = getIntent(i, "", null);
            this.mContext.bindService(intent, new ServiceConnection() { // from class: com.heytap.mcssdk.PushService.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Bundle bundle = new Bundle();
                    bundle.putAll(intent.getExtras());
                    try {
                        IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
                    } catch (Exception e) {
                        LogUtil.d("bindMcsService exception:".concat(String.valueOf(e)));
                    }
                    PushService.this.mContext.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
            return;
        }
        ICallBackResultService iCallBackResultService = this.mICallBackResultService;
        if (iCallBackResultService != null) {
            iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently");
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void cancelNotification(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_CANCEL_NOTIFICATION, jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    public boolean checkCommandLimit(int i) {
        return (i == 12291 || i == 12312 || addCommandToMap(i).getCount() <= 2) ? false : true;
    }

    @Override // com.heytap.mcssdk.IPushService
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void clearNotificationType(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void clearNotifications(JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
            startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (getPushCallback() != null) {
            this.mISetAppNotificationCallBackService.onSetAppNotificationSwitch(-2);
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
            startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
            return;
        }
        ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.mISetAppNotificationCallBackService;
        if (iSetAppNotificationCallBackService2 != null) {
            iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
        }
    }

    public Map<Integer, AppLimitBean> getAppLimitMap() {
        return this.mAppLimitMap;
    }

    @Override // com.heytap.mcssdk.IPushService
    public void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mIGetAppNotificationCallBackService = iGetAppNotificationCallBackService;
            startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
            return;
        }
        IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.mIGetAppNotificationCallBackService;
        if (iGetAppNotificationCallBackService2 != null) {
            iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getErrorCode(int i) {
        switch (i) {
            case 12289:
                return -1;
            case 12290:
                return -2;
            case 12291:
                return -14;
            default:
                switch (i) {
                    case 12298:
                        return -11;
                    case 12299:
                        return -3;
                    case 12300:
                        return -4;
                    default:
                        switch (i) {
                            case MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i) {
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public String getMcsPackageName(Context context) {
        boolean z;
        if (sMcsPkgName == null) {
            String newMcsPackageName = getNewMcsPackageName(context);
            if (newMcsPackageName == null) {
                sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                z = false;
            } else {
                sMcsPkgName = newMcsPackageName;
                z = true;
            }
            sIsNewMcsPkg = z;
        }
        return sMcsPkgName;
    }

    @Override // com.heytap.mcssdk.IPushService
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void getNotificationStatus(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onGetNotificationStatus(-2, 0);
        }
    }

    public List<Parser> getParsers() {
        return this.mParsers;
    }

    public List<Processor> getProcessors() {
        return this.mProcessors;
    }

    public ICallBackResultService getPushCallback() {
        return this.mICallBackResultService;
    }

    public IGetAppNotificationCallBackService getPushGetAppNotificationCallBack() {
        return this.mIGetAppNotificationCallBackService;
    }

    public ISetAppNotificationCallBackService getPushSetAppNotificationCallBack() {
        return this.mISetAppNotificationCallBackService;
    }

    public void getPushStatus() {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (getPushCallback() != null) {
            getPushCallback().onGetPushStatus(-2, 0);
        }
    }

    public int getPushVersionCode() {
        if (checkContext()) {
            Context context = this.mContext;
            return Utils.getVersionCode(context, getMcsPackageName(context));
        }
        return 0;
    }

    public String getPushVersionName() {
        if (checkContext()) {
            Context context = this.mContext;
            return Utils.getVersionName(context, getMcsPackageName(context));
        }
        return "";
    }

    public String getReceiveSdkAction(Context context) {
        if (sMcsPkgName == null) {
            getNewMcsPackageName(context);
        }
        if (sIsNewMcsPkg) {
            if (TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
                NEW_MCS_RECEIVE_SDK_ACTION = new String(Base64.decodeBase64(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
            }
            return NEW_MCS_RECEIVE_SDK_ACTION;
        }
        return Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void getRegister(JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(12289, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onRegister(-2, null);
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public String getRegisterID() {
        return this.mRegisterID;
    }

    public PushService init(Context context, boolean z) {
        if (context != null) {
            innerInit(context);
            new NotificatonChannelManager().createDefaultChannel(this.mContext);
            LogUtil.setDebugs(z);
            return this;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public void innerInit(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (sMcsPkgName == null) {
            String newMcsPackageName = getNewMcsPackageName(applicationContext);
            if (newMcsPackageName == null) {
                sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                sIsNewMcsPkg = false;
                return;
            }
            sMcsPkgName = newMcsPackageName;
            sIsNewMcsPkg = true;
        }
    }

    public boolean isSupportPushByClient(Context context) {
        return isSupportPushInner(context);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void openNotificationSettings(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void pausePush(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(12299, jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        if (!Utils.isSupportPushByClient(this.mContext)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        this.mAuthCode = str;
        this.mVerifyCode = str2;
        this.mICallBackResultService = iCallBackResultService;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        try {
            jSONObject2.putOpt(DBDefinition.APP_VERSION_CODE, Integer.valueOf(Utils.getVersionCode(context)));
            jSONObject2.putOpt("appVersionName", Utils.getVersionName(context));
        } catch (JSONException e) {
            LogUtil.e("register-Exception:" + e.getMessage());
        }
        startMcsService(12289, jSONObject2);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void requestNotificationPermission() {
        if (checkContext()) {
            bindMcsService(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void resumePush(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(12300, jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    public void setAppKeySecret(String str, String str2) {
        this.mAuthCode = str;
        this.mVerifyCode = str2;
    }

    @Override // com.heytap.mcssdk.IPushService
    public void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void setNotificationType(int i, JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, String.valueOf(i), jSONObject);
        } else {
            LogUtil.e(LogUtil.TAG, "please call the register first!");
        }
    }

    public void setPushCallback(ICallBackResultService iCallBackResultService) {
        this.mICallBackResultService = iCallBackResultService;
    }

    @Override // com.heytap.mcssdk.IPushService
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        if (!checkAll()) {
            if (getPushCallback() != null) {
                getPushCallback().onSetPushTime(-2, "please call the register first!");
            }
        } else if (list == null || list.size() <= 0 || i < 0 || i2 < 0 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weekDays", CallBackResult.parseToString(list));
                jSONObject2.put("startHour", i);
                jSONObject2.put("startMin", i2);
                jSONObject2.put("endHour", i3);
                jSONObject2.put("endMin", i4);
                startMcsService(12298, jSONObject2.toString(), jSONObject);
            } catch (JSONException e) {
                LogUtil.e(LogUtil.TAG, e.getLocalizedMessage());
            }
        }
    }

    @Override // com.heytap.mcssdk.IPushService
    public void setRegisterID(String str) {
        this.mRegisterID = str;
    }

    @Override // com.heytap.mcssdk.IPushService
    public void unRegister() {
        unRegister(null);
    }

    public void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.mAuthCode = str;
        this.mVerifyCode = str2;
        this.mContext = context.getApplicationContext();
        this.mICallBackResultService = iCallBackResultService;
        unRegister(jSONObject);
    }

    @Override // com.heytap.mcssdk.IPushService
    public void unRegister(JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(12290, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onUnRegister(-2);
        }
    }
}

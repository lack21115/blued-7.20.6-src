package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.huawei.openalliance.ad.constant.bc;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ay;
import com.xiaomi.push.bn;
import com.xiaomi.push.db;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.ej;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.ew;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.ia;
import com.xiaomi.push.ig;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient.class */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$CodeResult.class */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$ICallbackResult.class */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$MiPushClientCallback.class */
    public static abstract class MiPushClientCallback {
        private String category;

        /* JADX INFO: Access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$TokenResult.class */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setToken(String str) {
            this.token = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$UPSRegisterCallBack.class */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$UPSTurnCallBack.class */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient$UPSUnRegisterCallBack.class */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_".concat(String.valueOf(str)), -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
                com.xiaomi.push.p.a(edit);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.push.p.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.p.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_".concat(String.valueOf(str)), -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        com.xiaomi.push.ai.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public final void run() {
                PackageInfo packageInfo;
                try {
                    String[] strArr2 = strArr;
                    int length = strArr2.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return;
                        }
                        String str = strArr2[i2];
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr == null) {
            return;
        }
        int length = serviceInfoArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i2];
            if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                try {
                    Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    Intent intent = new Intent();
                    intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                    intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                    intent.putExtra("waker_pkgname", context.getPackageName());
                    PushMessageHandler.a(context, intent);
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            i = i2 + 1;
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        for (String str : getAllAlias(context)) {
            edit.remove("alias_".concat(String.valueOf(str)));
        }
        for (String str2 : getAllUserAccount(context)) {
            edit.remove("account_".concat(String.valueOf(str2)));
        }
        for (String str3 : getAllTopic(context)) {
            edit.remove("topic_".concat(String.valueOf(str3)));
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ao.a(context).f();
    }

    public static void clearNotification(Context context) {
        ao.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ao.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ao.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ao.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ao.a(context).a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m8407a(context).m8416c()) {
            return b.m8407a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.j.m9001b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_COS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenVIVOPush(Context context) {
        return f.a(context).b(e.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m8407a(context).m8416c()) {
            return b.m8407a(context).m8415c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        el.a(new el.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.el.a
            public final void uploader(Context context2, hk hkVar) {
                MiTinyDataClient.upload(context2, hkVar);
            }
        });
        Config a2 = el.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a("5_1_0-C");
        ClientReportClient.init(context, a2, new ej(context), new ek(context));
        a.a(context);
        t.a(context, a2);
        ba.a(context).a(new ba.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ba.a
            public final void onCallback() {
                el.m8666a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 5_1_0-C");
            ay.a(context).a();
            db.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.r.m9019a(sContext)) {
                v.a(sContext);
            }
            boolean z = b.m8407a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                ao.a(sContext).m8395a();
                com.xiaomi.channel.commonutils.logger.b.m8344a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m8407a(sContext).a(str, str2) || b.m8407a(sContext).m8419f()) {
                String a2 = bn.a(6);
                b.m8407a(sContext).m8409a();
                b.m8407a(sContext).a(Constants.a());
                b.m8407a(sContext).a(str, str2, a2);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                ig igVar = new ig();
                igVar.a(bd.b());
                igVar.b(str);
                igVar.e(str2);
                igVar.d(sContext.getPackageName());
                igVar.f(a2);
                Context context2 = sContext;
                igVar.c(com.xiaomi.push.g.m8748a(context2, context2.getPackageName()));
                Context context3 = sContext;
                igVar.b(com.xiaomi.push.g.a(context3, context3.getPackageName()));
                igVar.h("5_1_0-C");
                igVar.a(50010);
                igVar.a(hu.Init);
                if (!TextUtils.isEmpty(str3)) {
                    igVar.g(str3);
                }
                if (!com.xiaomi.push.j.m9003d()) {
                    String d = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(d)) {
                        igVar.i(bn.a(d) + "," + com.xiaomi.push.i.f(sContext));
                    }
                }
                int a3 = com.xiaomi.push.i.a();
                if (a3 >= 0) {
                    igVar.c(a3);
                }
                ao.a(sContext).a(igVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, bc.e.D);
                    miPushClientCallback.onInitializeResult(0L, null, b.m8407a(sContext).m8415c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m8407a(sContext).m8415c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f364a, arrayList, 0L, null, null, null));
                }
                ao.a(sContext).m8395a();
                if (b.m8407a(sContext).m8411a()) {
                    Cif cif = new Cif();
                    cif.b(b.m8407a(sContext).m8408a());
                    cif.c(hq.ClientInfoUpdate.f536a);
                    cif.a(bd.a());
                    cif.f678a = new HashMap();
                    Map<String, String> map = cif.f678a;
                    Context context4 = sContext;
                    map.put("app_version", com.xiaomi.push.g.m8748a(context4, context4.getPackageName()));
                    Map<String, String> map2 = cif.f678a;
                    Context context5 = sContext;
                    map2.put("app_version_code", Integer.toString(com.xiaomi.push.g.a(context5, context5.getPackageName())));
                    cif.f678a.put("push_sdk_vn", "5_1_0-C");
                    cif.f678a.put("push_sdk_vc", Integer.toString(50010));
                    String e = b.m8407a(sContext).e();
                    if (!TextUtils.isEmpty(e)) {
                        cif.f678a.put("deviceid", e);
                    }
                    ao.a(sContext).a((ao) cif, hg.Notification, false, (ht) null);
                    ao.a(sContext).m8396a(sContext);
                }
                if (!com.xiaomi.push.k.m9009a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.k.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    Cif cif2 = new Cif();
                    cif2.b(b.m8407a(sContext).m8408a());
                    cif2.c(hq.PullOfflineMessage.f536a);
                    cif2.a(bd.a());
                    cif2.a(false);
                    ao.a(sContext).a((ao) cif2, hg.Notification, false, (ht) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            av.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(af.a(sContext).a(au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_HUAWEI_TOKEN))) {
            ao.a(sContext).a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_COS_TOKEN))) {
            ao.a(sContext).a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS, "init");
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FTOS_TOKEN))) {
            ao.a(context).a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, hu huVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: ".concat(String.valueOf(huVar)));
        String a2 = bn.a(6);
        String m8408a = b.m8407a(context).m8408a();
        String b = b.m8407a(context).b();
        b.m8407a(context).m8409a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m8407a(context).a(Constants.a());
        b.m8407a(context).a(m8408a, b, a2);
        ig igVar = new ig();
        igVar.a(bd.b());
        igVar.b(m8408a);
        igVar.e(b);
        igVar.f(a2);
        igVar.d(context.getPackageName());
        igVar.c(com.xiaomi.push.g.m8748a(context, context.getPackageName()));
        igVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        igVar.h("5_1_0-C");
        igVar.a(50010);
        igVar.a(huVar);
        int a3 = com.xiaomi.push.i.a();
        if (a3 >= 0) {
            igVar.c(a3);
        }
        ao.a(context).a(igVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
            com.xiaomi.push.l.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("dynamic register network status receiver failed:".concat(String.valueOf(th)));
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, IntentConstant.APP_ID);
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.r.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        f.a(sContext).a(pushConfiguration);
        com.xiaomi.push.ai.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public final void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
                com.xiaomi.push.p.a(edit);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().remove("account_".concat(String.valueOf(str))).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_".concat(String.valueOf(str))).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            try {
                for (String str : getAllUserAccount(context)) {
                    removeAccount(context, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            try {
                for (String str : getAllAlias(context)) {
                    removeAlias(context, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            try {
                for (String str : getAllTopic(context)) {
                    removeTopic(context, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            try {
                context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_".concat(String.valueOf(str))).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void removeWindow(Context context) {
        ao.a(context).m8404e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m8407a(context).m8414b()) {
            hq hqVar = z ? hq.APP_SLEEP : hq.APP_WAKEUP;
            Cif cif = new Cif();
            cif.b(b.m8407a(context).m8408a());
            cif.c(hqVar.f536a);
            cif.d(context.getPackageName());
            cif.a(bd.a());
            cif.a(false);
            ao.a(context).a((ao) cif, hg.Notification, false, (ht) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, ht htVar, String str2, String str3) {
        Cif cif = new Cif();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        cif.b(str3);
        cif.c("bar:click");
        cif.a(str);
        cif.a(false);
        ao.a(context).a(cif, hg.Notification, false, true, htVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        ht htVar = new ht();
        htVar.a(miPushMessage.getMessageId());
        htVar.b(miPushMessage.getTopic());
        htVar.d(miPushMessage.getDescription());
        htVar.c(miPushMessage.getTitle());
        htVar.c(miPushMessage.getNotifyId());
        htVar.a(miPushMessage.getNotifyType());
        htVar.b(miPushMessage.getPassThrough());
        htVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), htVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, ht htVar, String str2) {
        Cif cif = new Cif();
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            if (!b.m8407a(context).m8414b()) {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
            str3 = b.m8407a(context).m8408a();
        }
        cif.b(str3);
        cif.c("bar:click");
        cif.a(str);
        cif.a(false);
        ao.a(context).a((ao) cif, hg.Notification, false, htVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ba.a(sContext).a(hl.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dl.a().a(new r(context));
            com.xiaomi.push.ai.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public final void run() {
                    dm.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.ai.a(sContext).a(new ae(sContext), ba.a(sContext).a(hl.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ew.COMMAND_SET_ACCEPT_TIME.f364a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ew.COMMAND_SET_ACCEPT_TIME.f364a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ew.COMMAND_SET_ACCEPT_TIME.f364a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ew.COMMAND_SET_ALIAS.f364a, str, str2);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (ew.COMMAND_SET_ALIAS.f364a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ew.COMMAND_SET_ALIAS.f364a, arrayList, 0L, null, str3, null));
            }
        } else if (ew.COMMAND_UNSET_ALIAS.f364a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Don't cancel alias for " + bn.a(arrayList.toString(), 3) + " is unseted");
        } else if (ew.COMMAND_SET_ACCOUNT.f364a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ew.COMMAND_SET_ACCOUNT.f364a, arrayList, 0L, null, str3, null));
            }
        } else if (!ew.COMMAND_UNSET_ACCOUNT.f364a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Don't cancel account for " + bn.a(arrayList.toString(), 3) + " is unseted");
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m8407a(context).m8408a())) {
            return;
        }
        ia iaVar = new ia();
        String a2 = bd.a();
        iaVar.a(a2);
        iaVar.b(b.m8407a(context).m8408a());
        iaVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            iaVar.m8884a(it.next());
        }
        iaVar.e(str2);
        iaVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + ", " + a2);
        ao.a(context).a((ao) iaVar, hg.Command, (ht) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        ao.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ew.COMMAND_SET_ACCOUNT.f364a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ao.a(context).m8398a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m8407a(context).m8408a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ew.COMMAND_SUBSCRIBE_TOPIC.f364a, arrayList, 0L, null, null, null));
            return;
        }
        ik ikVar = new ik();
        String a2 = bd.a();
        ikVar.a(a2);
        ikVar.b(b.m8407a(context).m8408a());
        ikVar.c(str);
        ikVar.d(context.getPackageName());
        ikVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ew.COMMAND_SUBSCRIBE_TOPIC + ", " + a2);
        ao.a(context).a((ao) ikVar, hg.Subscription, (ht) null);
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FCM_TOKEN, e.ASSEMBLE_PUSH_FCM, "");
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_".concat(String.valueOf(str)), -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        i.c(context);
        ba.a(context).a();
        if (b.m8407a(context).m8414b()) {
            im imVar = new im();
            imVar.a(bd.a());
            imVar.b(b.m8407a(context).m8408a());
            imVar.c(b.m8407a(context).m8415c());
            imVar.e(b.m8407a(context).b());
            imVar.d(context.getPackageName());
            ao.a(context).a(imVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m8407a(context).m8413b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ew.COMMAND_UNSET_ALIAS.f364a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ew.COMMAND_UNSET_ACCOUNT.f364a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m8407a(context).m8414b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            io ioVar = new io();
            String a2 = bd.a();
            ioVar.a(a2);
            ioVar.b(b.m8407a(context).m8408a());
            ioVar.c(str);
            ioVar.d(context.getPackageName());
            ioVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ew.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a2);
            ao.a(context).a((ao) ioVar, hg.UnSubscription, (ht) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public final void run() {
                String c2;
                if (com.xiaomi.push.j.m9003d()) {
                    return;
                }
                if (com.xiaomi.push.i.c(MiPushClient.sContext) != null || ay.a(MiPushClient.sContext).mo8459a()) {
                    Cif cif = new Cif();
                    cif.b(b.m8407a(MiPushClient.sContext).m8408a());
                    cif.c(hq.ClientInfoUpdate.f536a);
                    cif.a(bd.a());
                    cif.a(new HashMap());
                    String str = "";
                    if (!TextUtils.isEmpty(com.xiaomi.push.i.c(MiPushClient.sContext))) {
                        str = "" + bn.a(c2);
                    }
                    String e = com.xiaomi.push.i.e(MiPushClient.sContext);
                    String str2 = str;
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str;
                        if (!TextUtils.isEmpty(e)) {
                            str2 = str + "," + e;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        cif.m8914a().put(Constants.EXTRA_KEY_IMEI_MD5, str2);
                    }
                    ay.a(MiPushClient.sContext).a(cif.m8914a());
                    int a2 = com.xiaomi.push.i.a();
                    if (a2 >= 0) {
                        cif.m8914a().put("space_id", Integer.toString(a2));
                    }
                    ao.a(MiPushClient.sContext).a((ao) cif, hg.Notification, false, (ht) null);
                }
            }
        }).start();
    }
}

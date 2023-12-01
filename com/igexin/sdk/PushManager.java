package com.igexin.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.b;
import com.igexin.push.core.h;
import com.igexin.push.f.c;
import com.igexin.push.f.d;
import com.igexin.push.f.e;
import com.igexin.push.f.n;
import com.igexin.push.f.o;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import com.umeng.analytics.pro.bh;
import java.util.regex.Pattern;
import javax.crypto.KeyGenerator;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/PushManager.class */
public class PushManager {
    private static final String TAG = "PushManager";
    private volatile h callback;
    private String intentService;
    private byte[] keyBytes;
    private long lastOpAliasTime;
    private long lastQueryTagTime;
    private long lastSendMessageTime;
    private long lastSetTagTime;
    private String safeCode;
    private String uActivty;
    private String uRegisteService;
    private Class uService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/PushManager$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final PushManager f10065a = new PushManager();

        private a() {
        }
    }

    private PushManager() {
        this.lastQueryTagTime = 0L;
    }

    private static void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
    }

    private int getAssistAction(int i, String str) {
        int i2 = i;
        if (!TextUtils.isEmpty(str)) {
            i2 = i;
            if (str.contains("_")) {
                if (i != 60001 && i != 60002) {
                    return i;
                }
                if (str.startsWith(AssistPushConsts.HW_PREFIX)) {
                    return i + 18;
                }
                if (str.startsWith(AssistPushConsts.XM_PREFIX)) {
                    return i + 48;
                }
                if (str.startsWith(AssistPushConsts.OPPO_PREFIX)) {
                    return i + 28;
                }
                if (str.startsWith(AssistPushConsts.VIVO_PREFIX)) {
                    return i + 38;
                }
                if (str.startsWith(AssistPushConsts.MZ_PREFIX)) {
                    return i + 58;
                }
                if (str.startsWith(AssistPushConsts.ST_PREFIX)) {
                    return i + 78;
                }
                if (str.startsWith(AssistPushConsts.FCM_PREFIX)) {
                    return i + 98;
                }
                i2 = i;
                if (str.startsWith(AssistPushConsts.HONOR_PREFIX)) {
                    i2 = i + 118;
                }
            }
        }
        return i2;
    }

    public static PushManager getInstance() {
        return a.f10065a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Application getMainApplication(Context context) {
        if (context == null || !isMainProcess(context)) {
            return null;
        }
        return context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
    }

    private Class getUserPushService(Context context) {
        checkContext(context);
        Class cls = this.uService;
        return cls != null ? cls : ServiceManager.getInstance().b(context);
    }

    private boolean isMainProcess(Context context) {
        try {
            GtcProvider.setContext(context);
            return CommonUtil.isMainProcess();
        } catch (Throwable th) {
            return false;
        }
    }

    private void registerCallback(final Context context) {
        ServiceManager.b = context.getApplicationContext();
        com.igexin.b.a.a().a("GTALCallback").execute(new Runnable() { // from class: com.igexin.sdk.PushManager.1
            @Override // java.lang.Runnable
            public final void run() {
                Application mainApplication;
                try {
                    if (PushManager.this.callback != null || Build.VERSION.SDK_INT < 14 || (mainApplication = PushManager.this.getMainApplication(context)) == null) {
                        return;
                    }
                    System.currentTimeMillis();
                    GtcManager.getInstance().initialize(context, null);
                    System.currentTimeMillis();
                    if (PushManager.this.callback != null || mainApplication == null) {
                        return;
                    }
                    PushManager.this.callback = new h();
                    mainApplication.registerActivityLifecycleCallbacks(PushManager.this.callback);
                    System.currentTimeMillis();
                    com.igexin.c.a.c.a.a("PushManager｜ registerCallback time = " + System.currentTimeMillis(), new Object[0]);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    private void sendBindAliasResult(Context context, String str, String str2) {
        sendResult(context, new BindAliasCmdMessage(str, str2, 10010));
    }

    private void sendResult(Context context, GTCmdMessage gTCmdMessage) {
        try {
            Class c2 = ServiceManager.getInstance().c(context);
            if (c2 == null || context == null) {
                return;
            }
            Intent intent = new Intent(context, c2);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(PushConsts.KEY_CMD_MSG, gTCmdMessage);
            intent.putExtras(bundle);
            context.startService(intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("PushManager|" + th.toString(), new Object[0]);
        }
    }

    private void sendSetTagResult(Context context, String str, String str2) {
        sendResult(context, new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
    }

    private void sendUnBindAliasResult(Context context, String str, String str2) {
        sendResult(context, new UnBindAliasCmdMessage(str, str2, 10011));
    }

    private boolean startService(Context context, Intent intent) {
        try {
            if (TextUtils.isEmpty(this.safeCode)) {
                String obj = o.b(context, "sc", "").toString();
                this.safeCode = obj;
                if (TextUtils.isEmpty(obj)) {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                    keyGenerator.init(128);
                    String a2 = e.a(keyGenerator.generateKey().getEncoded());
                    this.safeCode = a2;
                    o.a(context, "sc", a2);
                }
            }
            intent.putExtra("sc", this.safeCode);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        return ServiceManager.getInstance().b(context, intent);
    }

    private void unRegisterCallback(final Context context) {
        com.igexin.b.a.a().a("GTALCallback").execute(new Runnable() { // from class: com.igexin.sdk.PushManager.2
            @Override // java.lang.Runnable
            public final void run() {
                Application mainApplication;
                try {
                    if (PushManager.this.callback == null || Build.VERSION.SDK_INT < 14 || (mainApplication = PushManager.this.getMainApplication(context)) == null) {
                        return;
                    }
                    mainApplication.unregisterActivityLifecycleCallbacks(PushManager.this.callback);
                    PushManager.this.callback = null;
                    System.currentTimeMillis();
                    com.igexin.c.a.c.a.a("PushManager | unRegisterCallback time= " + System.currentTimeMillis(), new Object[0]);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    public boolean areNotificationsEnabled(Context context) {
        return c.b(context);
    }

    public boolean bindAlias(Context context, String str) {
        return bindAlias(context, str, "bindAlias_" + System.currentTimeMillis());
    }

    public boolean bindAlias(Context context, String str, String str2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call bindAlias");
            com.igexin.c.a.c.a.a("PushManager|call bindAlias", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastOpAliasTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > bindAlias failed, it be called too frequently");
                sendBindAliasResult(context, str2, "30001");
                return false;
            }
            this.lastOpAliasTime = currentTimeMillis;
            Bundle bundle = new Bundle();
            bundle.putString("action", "bindAlias");
            bundle.putString("alias", str);
            bundle.putString("sn", str2);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] bindAlias  error = " + th.toString());
            return false;
        }
    }

    public void checkManifest(Context context) throws GetuiPushException {
        if (isMainProcess(context)) {
            c.c(context);
        }
    }

    public String getClientid(Context context) {
        synchronized (this) {
            try {
                checkContext(context);
                GtcProvider.setContext(context);
                if (this.keyBytes == null) {
                    try {
                        ApplicationInfo b = n.b(context);
                        if (b != null && b.metaData != null) {
                            String a2 = d.a(b);
                            String str = a2;
                            if (TextUtils.isEmpty(a2)) {
                                str = b.metaData.getString(b.b);
                            }
                            String str2 = str;
                            if (TextUtils.isEmpty(str)) {
                                str2 = b.metaData.getString("GETUI_APPID");
                            }
                            String str3 = str2;
                            if (str2 != null) {
                                str3 = str2.trim();
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                String a3 = com.igexin.c.b.a.a(str3 + context.getPackageName());
                                if (a3 != null) {
                                    this.keyBytes = a3.getBytes();
                                }
                            }
                        }
                    } catch (Exception e) {
                        com.igexin.c.a.c.a.a("PushManager|" + e.toString(), new Object[0]);
                    }
                }
                if (this.keyBytes != null) {
                    ServiceManager.b = context.getApplicationContext();
                    if (TextUtils.isEmpty(com.igexin.push.core.d.d.a().a("c"))) {
                        return "";
                    }
                    byte[] decode = Base64.decode(com.igexin.push.core.d.d.a().a("c"), 0);
                    if (decode != null && this.keyBytes.length == decode.length) {
                        int length = decode.length;
                        byte[] bArr = new byte[length];
                        for (int i = 0; i < length; i++) {
                            bArr[i] = (byte) (this.keyBytes[i] ^ decode[i]);
                        }
                        if (Pattern.matches("[a-zA-Z0-9]+", new String(bArr))) {
                            return new String(bArr);
                        }
                    }
                }
            } finally {
                return null;
            }
            return null;
        }
    }

    public String getVersion(Context context) {
        return "3.2.14.0";
    }

    public void initialize(Context context) {
        Class cls;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (TextUtils.isEmpty(this.intentService) && (cls = d.a(context, GTIntentService.class).second) != null) {
                this.intentService = cls.getName();
            }
            if (this.uService == null) {
                this.uService = d.a(context, PushService.class).second;
            }
            initialize(context, this.uService);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] initialize sdk error = " + th.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005c A[Catch: all -> 0x00cc, TryCatch #1 {all -> 0x00cc, blocks: (B:2:0x0000, B:5:0x000e, B:8:0x001e, B:10:0x005c, B:12:0x0069, B:14:0x0072, B:16:0x007f, B:18:0x0088, B:20:0x0095, B:22:0x009d, B:24:0x00a3, B:25:0x00a7), top: B:36:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072 A[Catch: all -> 0x00cc, TryCatch #1 {all -> 0x00cc, blocks: (B:2:0x0000, B:5:0x000e, B:8:0x001e, B:10:0x005c, B:12:0x0069, B:14:0x0072, B:16:0x007f, B:18:0x0088, B:20:0x0095, B:22:0x009d, B:24:0x00a3, B:25:0x00a7), top: B:36:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088 A[Catch: all -> 0x00cc, TryCatch #1 {all -> 0x00cc, blocks: (B:2:0x0000, B:5:0x000e, B:8:0x001e, B:10:0x005c, B:12:0x0069, B:14:0x0072, B:16:0x007f, B:18:0x0088, B:20:0x0095, B:22:0x009d, B:24:0x00a3, B:25:0x00a7), top: B:36:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d A[Catch: all -> 0x00cc, TryCatch #1 {all -> 0x00cc, blocks: (B:2:0x0000, B:5:0x000e, B:8:0x001e, B:10:0x005c, B:12:0x0069, B:14:0x0072, B:16:0x007f, B:18:0x0088, B:20:0x0095, B:22:0x009d, B:24:0x00a3, B:25:0x00a7), top: B:36:0x0000 }] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T extends android.app.Service> void initialize(android.content.Context r7, java.lang.Class<T> r8) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.initialize(android.content.Context, java.lang.Class):void");
    }

    public boolean isPushTurnedOn(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            ServiceManager.b = context.getApplicationContext();
            return com.igexin.push.core.d.d.a().b("p");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] turnOffPush  error = " + th.toString());
            return false;
        }
    }

    public void openNotification(Context context) {
        String str;
        int i;
        try {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                str = "android.provider.extra.CHANNEL_ID";
                i = context.getApplicationInfo().uid;
            } else if (Build.VERSION.SDK_INT < 21) {
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                intent.setFlags(268435456);
                context.startActivity(intent);
            } else {
                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
                str = Settings.EXTRA_APP_UID;
                i = context.getApplicationInfo().uid;
            }
            intent.putExtra(str, i);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th) {
        }
    }

    public boolean queryPushOnLine(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            Bundle bundle = new Bundle();
            bundle.putString("action", "queryPushOnLine");
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] queryPushOnLine  error = " + th.toString());
            return false;
        }
    }

    public int queryTag(Context context, String str) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (str == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager]call -> queryTag failed, parameter [sn] is null");
                return 20007;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastQueryTagTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager]call -> queryTag failed, it be called too frequently");
                return 20002;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", PushConsts.QUERY_TAG);
            bundle.putString("sn", str);
            this.lastQueryTagTime = currentTimeMillis;
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            startService(context, intent);
            return 0;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] queryTag  error = " + th.toString());
            return 0;
        }
    }

    public <T extends Activity> void registerPushActivity(Context context, Class<T> cls) {
        String name;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (cls != null) {
                try {
                    Class.forName(cls.getName());
                    name = cls.getName();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
                    a2.a("[PushManager] can't load activity = " + e.toString());
                    com.igexin.c.a.c.a.a("PushManager|registerPushActiviy|" + e.toString(), new Object[0]);
                    return;
                }
            } else {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> registerPushActiviy, parameter [activity] is null");
                name = "";
            }
            this.uActivty = name;
            if (this.uService != null) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "registerPushActivity");
                bundle.putString("ua", this.uActivty);
                Intent intent = new Intent(context.getApplicationContext(), this.uService);
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                intent.putExtra("ua", this.uActivty);
                startService(context, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a3 = com.igexin.c.a.c.a.c.a();
            a3.a("[PushManager] registerPushActivity sdk error = " + th.toString());
        }
    }

    @Deprecated
    public <T extends GTIntentService> void registerPushIntentService(Context context, Class<T> cls) {
        String name;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.a("PushManager|call registerPushIntentService", new Object[0]);
            if (cls != null) {
                try {
                    Class.forName(cls.getName());
                    if (!c.a(new Intent(context, (Class<?>) cls), context)) {
                        com.igexin.c.a.c.a.e.a(TAG, "call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
                        return;
                    }
                    name = cls.getName();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a("PushManager|registerPushIntentService|" + e.toString(), new Object[0]);
                    return;
                }
            } else {
                name = "";
            }
            this.intentService = name;
            if (this.uService != null) {
                com.igexin.c.a.c.a.b(TAG, "start service to save intent service");
                Intent intent = new Intent(context.getApplicationContext(), this.uService);
                intent.putExtra(o.f10056c, this.intentService);
                startService(context, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] registerPushIntentService  error = " + th.toString());
        }
    }

    public <T extends Service> void registerUserService(Context context, Class<T> cls) {
        String name;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (cls != null) {
                try {
                    Class.forName(cls.getName());
                    name = cls.getName();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
                    a2.a("[PushManager] can't load service = " + e.toString());
                    com.igexin.c.a.c.a.a("PushManager|registerUserService|" + e.toString(), new Object[0]);
                    return;
                }
            } else {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> registerUserService, parameter [service] is null");
                name = "";
            }
            this.uRegisteService = name;
            if (this.uService != null) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "registerUserService");
                bundle.putString(o.f10055a, this.uRegisteService);
                Intent intent = new Intent(context.getApplicationContext(), this.uService);
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                intent.putExtra(o.f10055a, this.uRegisteService);
                startService(context, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a3 = com.igexin.c.a.c.a.c.a();
            a3.a("[PushManager] registerUserService  error = " + th.toString());
        }
    }

    public boolean sendApplinkFeedback(Context context, String str) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > sendApplinkFeedback failed, parameter is illegal");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "sendApplinkFeedback");
            bundle.putString("url", str);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] sendApplinkFeedback  error = " + th.toString());
            return false;
        }
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            boolean z = (i >= 60001 && i <= 60999) || (i >= 90001 && i <= 90999);
            if (str == null || str2 == null || !z) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > sendFeedbackMessage failed, parameter is illegal");
                return false;
            }
            int assistAction = getAssistAction(i, str2);
            Bundle bundle = new Bundle();
            bundle.putString("action", "sendFeedbackMessage");
            bundle.putString("taskid", str);
            bundle.putString("messageid", str2);
            bundle.putString("actionid", String.valueOf(assistAction));
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] sendFeedbackMessage  error = " + th.toString());
            return false;
        }
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (str != null && bArr != null && bArr.length <= 4096 && currentTimeMillis - this.lastSendMessageTime >= 1000) {
                this.lastSendMessageTime = currentTimeMillis;
                Bundle bundle = new Bundle();
                bundle.putString("action", "sendMessage");
                bundle.putString("taskid", str);
                bundle.putByteArray("extraData", bArr);
                Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                return startService(context, intent);
            }
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > sendMessage failed, parameter is illegal or it be called too frequently");
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] sendMessage  error = " + th.toString());
            return false;
        }
    }

    public boolean setBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public void setDebugLogger(Context context, IUserLoggerInterface iUserLoggerInterface) {
        if (context == null || iUserLoggerInterface == null) {
            throw new IllegalArgumentException("context or loggerInterface can not be null");
        }
        try {
            GtcProvider.setContext(context);
            if (!c.a(context)) {
                iUserLoggerInterface.log("only run in debug mode");
            } else if (!isMainProcess(context)) {
                iUserLoggerInterface.log("Must be called in main process!");
            } else {
                try {
                    checkManifest(context);
                } catch (GetuiPushException e) {
                    iUserLoggerInterface.log(e.toString());
                }
                com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
                if (iUserLoggerInterface == null) {
                    com.igexin.c.a.c.a.e.a("LogController", "user logger register parameter can not be null!");
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                a2.a(applicationContext);
                a2.b.a(iUserLoggerInterface);
                a2.b.a();
                a2.a("[LogController] Sdk version = " + getInstance().getVersion(applicationContext));
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public boolean setDeviceToken(Context context, String str) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setDeviceToken  error =  token is empty");
                return false;
            } else if (str.equalsIgnoreCase("InvalidAppKey")) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] setDeviceToken  error =  token is InvalidAppKey");
                return false;
            } else {
                checkContext(applicationContext);
                GtcProvider.setContext(applicationContext);
                Bundle bundle = new Bundle();
                bundle.putString("action", "setDeviceToken");
                bundle.putString("token", str);
                Intent intent = new Intent(applicationContext.getApplicationContext(), getUserPushService(applicationContext));
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                return startService(applicationContext, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setDeviceToken  error = " + th.toString());
            return false;
        }
    }

    public boolean setGuardOptions(Context context, boolean z, boolean z2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            Bundle bundle = new Bundle();
            bundle.putString("action", "setGuardOptions");
            bundle.putBoolean("guardMe", z);
            bundle.putBoolean("guardOthers", z2);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setGuardOptions  error = " + th.toString());
            return false;
        }
    }

    public boolean setHeartbeatInterval(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (i < 0) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setHeartbeatInterval failed, parameter [interval] < 0, illegal");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "setHeartbeatInterval");
            bundle.putInt(bh.aX, i);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setHeartbeatInterval  error = " + th.toString());
            return false;
        }
    }

    @Deprecated
    public boolean setHwBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setHwBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setHwBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setHwBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setNotificationIcon(Context context, String str, String str2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            Bundle bundle = new Bundle();
            bundle.putString("action", "setNotificationIcon");
            bundle.putString("smallIcon", str);
            bundle.putString("largeIcon", str2);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setNotificationIcon  error = " + th.toString());
            return false;
        }
    }

    @Deprecated
    public boolean setOPPOBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setHwBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setOppoBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setOPPOBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setSilentTime(Context context, int i, int i2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (i < 0 || i >= 24 || i2 < 0 || i2 > 23) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setSilentTime failed, parameter [beginHour] or [duration] value exceeding");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "setSilentTime");
            bundle.putInt("beginHour", i);
            bundle.putInt("duration", i2);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] queryTag  error = " + th.toString());
            return false;
        }
    }

    public boolean setSocketTimeout(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (i < 0) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setSocketTimeout failed, parameter [timeout] < 0, illegal");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "setSocketTimeout");
            bundle.putInt("timeout", i);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setSocketTimeout  error = " + th.toString());
            return false;
        }
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        Tag tag;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (tagArr == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, parameter [tags] is null");
                com.igexin.c.a.c.a.a("PushManager|tags is null", new Object[0]);
                sendSetTagResult(context, str, "20006");
                return PushConsts.SETTAG_ERROR_NULL;
            } else if (str == null) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, parameter [sn] is null");
                sendSetTagResult(context, str, "20007");
                return 20007;
            } else if (tagArr.length > 200) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call -> setTag failed, parameter [tags] len > 200 is exceeds");
                sendSetTagResult(context, str, PushConsts.SEND_MESSAGE_ERROR_GENERAL);
                return PushConsts.SETTAG_ERROR_COUNT;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastSetTagTime < 1000) {
                    com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setTag failed, it be called too frequently");
                    sendSetTagResult(context, str, PushConsts.SEND_MESSAGE_ERROR_TIME_OUT);
                    return 20002;
                }
                StringBuilder sb = new StringBuilder();
                int length = tagArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        if (sb.length() <= 0) {
                            sendSetTagResult(context, str, "20006");
                            return PushConsts.SETTAG_ERROR_NULL;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        com.igexin.c.a.c.a.c.a().a("[PushManager] call setTag");
                        Bundle bundle = new Bundle();
                        bundle.putString("action", "setTag");
                        bundle.putString("tags", sb.toString());
                        bundle.putString("sn", str);
                        this.lastSetTagTime = currentTimeMillis;
                        Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
                        intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                        intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
                        startService(context, intent);
                        return 0;
                    }
                    tag = tagArr[i2];
                    if (tag != null && tag.getName() != null) {
                        if (tag.getName().contains(" ") || tag.getName().contains(",")) {
                            break;
                        }
                        sb.append(tag.getName());
                        sb.append(",");
                    }
                    i = i2 + 1;
                }
                com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
                a2.a("[PushManager] call -> setTag failed, the tag [" + tag.getName() + "] is not illegal");
                sendSetTagResult(context, str, "20011");
                return PushConsts.SETTAG_TAG_ILLEGAL;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a3 = com.igexin.c.a.c.a.c.a();
            a3.a("[PushManager] setTag  error = " + th.toString());
            return PushConsts.SETTAG_ERROR_EXCEPTION;
        }
    }

    @Deprecated
    public boolean setVivoAppBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("[PushManager] call - > setHwBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setVivoBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] setOPPOBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public void turnOffPush(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call turnOffPush");
            Bundle bundle = new Bundle();
            bundle.putString("action", "turnOffPush");
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            startService(context, intent);
            unRegisterCallback(context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] turnOffPush  error = " + th.toString());
        }
    }

    public void turnOnPush(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call turnOnPush");
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
            intent.putExtra("op_app", context.getApplicationContext().getPackageName());
            intent.putExtra("isSlave", true);
            startService(context, intent);
            registerCallback(context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] turnOnPush  error = " + th.toString());
        }
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        return unBindAlias(context, str, z, "unBindAlias_" + System.currentTimeMillis());
    }

    public boolean unBindAlias(Context context, String str, boolean z, String str2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.c.a().a("PushManager|call unBindAlias");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastOpAliasTime < 1000) {
                com.igexin.c.a.c.a.c.a().a("[PushManager] call - > unBindAlias failed, it be called too frequently");
                sendUnBindAliasResult(context, str2, "30001");
                return false;
            }
            this.lastOpAliasTime = currentTimeMillis;
            Bundle bundle = new Bundle();
            bundle.putString("action", "unbindAlias");
            bundle.putString("alias", str);
            bundle.putBoolean("isSeft", z);
            bundle.putString("sn", str2);
            Intent intent = new Intent(context.getApplicationContext(), getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra(TTLiveConstants.BUNDLE_KEY, bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c a2 = com.igexin.c.a.c.a.c.a();
            a2.a("[PushManager] unBindAlias  error = " + th.toString());
            return false;
        }
    }
}

package com.soft.blued.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.push.getui.GetuiKeepAliveActivity;
import com.soft.blued.push.getui.GetuiKeepAliveService;
import com.soft.blued.ui.msg.model.MobPushModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushManager.class */
public class PushManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16048a = PushManager.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f16049c;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushManager$InstanceHolder.class */
    public static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        static final PushManager f16052a = new PushManager();

        private InstanceHolder() {
        }
    }

    private PushManager() {
        this.f16049c = "";
        this.d = 0;
        if (this.b == null) {
            this.b = AppInfo.d();
        }
    }

    public static PushManager a() {
        return InstanceHolder.f16052a;
    }

    private void a(String str, int i) {
        ChatHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA>(null) { // from class: com.soft.blued.push.PushManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            public boolean onUIFailure(int i2, String str2) {
                return true;
            }
        }, str, i);
    }

    private Uri b(Intent intent) {
        String stringExtra = intent.getStringExtra(AssistPushConsts.MSG_TYPE_PAYLOAD);
        String str = f16048a;
        Logger.c(str, "getui payload: " + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            MobPushModel mobPushModel = (MobPushModel) AppInfo.f().fromJson(stringExtra, (Class<Object>) MobPushModel.class);
            String str2 = f16048a;
            Logger.c(str2, "跳转链接：" + mobPushModel.getExtra().getLink());
            return Uri.parse(mobPushModel.getExtra().getLink());
        } catch (Exception e) {
            e.printStackTrace();
            String str3 = f16048a;
            Logger.c(str3, "pushData error: " + e.getMessage());
            return null;
        }
    }

    private void b(String str) {
        if (AppInfo.m()) {
            Logger.b(f16048a, "PUSH", str);
        }
    }

    public static boolean b() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return AssistUtils.BRAND_XIAOMI.equals(lowerCase) || AssistUtils.BRAND_HW.equals(lowerCase) || AssistUtils.BRAND_OPPO.equals(lowerCase) || AssistUtils.BRAND_VIVO.equals(lowerCase) || AssistUtils.BRAND_MZ.equals(lowerCase);
    }

    private void c(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("gttask");
            String stringExtra2 = intent.getStringExtra("gtaction");
            String clientid = com.igexin.sdk.PushManager.getInstance().getClientid(AppInfo.d());
            String replaceAll = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("MD5").digest((stringExtra + clientid + replaceAll).getBytes(StandardCharsets.UTF_8))).toString(16);
            if (stringExtra2 != null) {
                com.igexin.sdk.PushManager.getInstance().sendFeedbackMessage(AppInfo.d(), stringExtra, bigInteger, Integer.parseInt(stringExtra2));
            }
        } catch (Exception e) {
        }
    }

    private boolean d(Context context) {
        if (context == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            String packageName = context.getPackageName();
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private void e(Context context) {
        try {
            Method declaredMethod = com.igexin.sdk.PushManager.class.getDeclaredMethod("registerPushActivity", Context.class, Class.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(com.igexin.sdk.PushManager.getInstance(), context.getApplicationContext(), GetuiKeepAliveActivity.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Method declaredMethod2 = com.igexin.sdk.PushManager.class.getDeclaredMethod("registerUserService", Context.class, Class.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(com.igexin.sdk.PushManager.getInstance(), context.getApplicationContext(), GetuiKeepAliveService.class);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private int g() {
        String a2;
        char charAt;
        if (!Build.MANUFACTURER.equalsIgnoreCase(AssistUtils.BRAND_HW) || (a2 = BluedPreferences.a("com.soft.blued.icon0")) == null || a2.length() <= 0 || (charAt = a2.charAt(a2.length() - 1)) < '0' || charAt > '6') {
            return 0;
        }
        return charAt - '0';
    }

    private void h() {
        ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(null) { // from class: com.soft.blued.push.PushManager.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }
        });
    }

    public Uri a(Intent intent) {
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            Uri b = b(intent);
            c(intent);
            return b;
        }
        return null;
    }

    public void a(Context context) {
        this.b = context;
        if (d(context)) {
            String str = f16048a;
            Log.e(str, " 推送初始化：" + Build.MANUFACTURER.toLowerCase());
            b(context);
        }
    }

    public void a(String str) {
        this.f16049c = str;
        int g = g();
        this.d = g;
        a(this.f16049c, g);
    }

    public void b(Context context) {
        try {
            e(context);
            com.igexin.sdk.PushManager.getInstance().initialize(context);
        } catch (Exception e) {
            e.printStackTrace();
            b("initGetui 失败！！！");
        }
    }

    public void c() {
        b(" 暂停推送");
        try {
            com.igexin.sdk.PushManager.getInstance().turnOffPush(AppInfo.d());
        } catch (Exception e) {
            e.printStackTrace();
            b("pausePush 失败！！！");
        }
    }

    public void c(Context context) {
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            com.igexin.sdk.PushManager.getInstance().setBadgeNum(context, 0);
        }
    }

    public void d() {
        try {
            b(" 恢复推送");
            com.igexin.sdk.PushManager.getInstance().turnOnPush(AppInfo.d());
        } catch (Exception e) {
            e.printStackTrace();
            b("resumePush 失败！！！");
        }
    }

    public void e() {
        int g;
        if (!Build.MANUFACTURER.equalsIgnoreCase(AssistUtils.BRAND_HW) || TextUtils.isEmpty(this.f16049c) || (g = g()) == this.d) {
            return;
        }
        this.d = g;
        a(this.f16049c, g);
    }

    public void f() {
        h();
    }
}

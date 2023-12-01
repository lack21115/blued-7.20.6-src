package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.c.e;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/a.class */
public abstract class a<T> implements com.meizu.cloud.pushsdk.handler.c {

    /* renamed from: a  reason: collision with root package name */
    private com.meizu.cloud.pushsdk.handler.a f24131a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<String> f24132c;

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.b = context.getApplicationContext();
        this.f24131a = aVar;
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f24132c = sparseArray;
        sparseArray.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
        this.f24132c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
        this.f24132c.put(16, "MESSAGE_TYPE_REGISTER");
        this.f24132c.put(32, "MESSAGE_TYPE_UNREGISTER");
        this.f24132c.put(8, "MESSAGE_TYPE_THROUGH");
        this.f24132c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
        this.f24132c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
        this.f24132c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
        this.f24132c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
        this.f24132c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
        this.f24132c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
        this.f24132c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
        this.f24132c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
        this.f24132c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
        this.f24132c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
        this.f24132c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
        this.f24132c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
        this.f24132c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
        this.f24132c.put(524288, "MESSAGE_TYPE_BRIGHT_NOTIFICATION");
        this.f24132c.put(1048576, "MESSAGE_TYPE_NOTIFICATION_CLOSE");
    }

    private String a(int i) {
        return this.f24132c.get(i);
    }

    private boolean a(String str, MessageV3 messageV3, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "sa, public key not empty";
        } else if (!PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(str2)) {
            str3 = "sa, message not click method";
        } else if (com.meizu.cloud.pushsdk.util.b.l(d(), messageV3.getPackageName())) {
            com.meizu.cloud.pushsdk.util.b.c(d(), messageV3.getPackageName(), false);
            return true;
        } else {
            str3 = "sa, not first request";
        }
        DebugLogger.i("AbstractMessageHandler", str3);
        return false;
    }

    private boolean b(String str, MessageV3 messageV3, String str2) {
        if (TextUtils.isEmpty(str)) {
            DebugLogger.e("AbstractMessageHandler", "security check fail, public key is null");
            return false;
        }
        String a2 = com.meizu.cloud.pushsdk.util.c.a(str, str2);
        DebugLogger.i("AbstractMessageHandler", "decrypt sign: " + a2);
        boolean a3 = com.meizu.cloud.pushsdk.handler.a.c.e.a(a2, messageV3);
        DebugLogger.i("AbstractMessageHandler", "check public key result: " + a3);
        return a3;
    }

    private String e() {
        String str = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return str;
            }
            str = b();
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            i = i2 + 1;
        }
    }

    protected com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.a.a.a b;
        com.meizu.cloud.pushsdk.notification.model.a a2;
        if (messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage()) || (b = com.meizu.cloud.pushsdk.b.a(context).b()) == null || (a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3)) == null) {
            return;
        }
        b.a(a2.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MessageV3 messageV3) {
        if (messageV3 == null || messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                c().b(d(), MzPushMessage.fromMessageV3(messageV3));
            } else if (MzSystemUtils.isRunningProcess(d(), messageV3.getUploadDataPackageName())) {
                DebugLogger.i("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
                Intent intent = new Intent();
                if (MinSdkChecker.isSupportTransmitMessageValue(this.b, messageV3.getUploadDataPackageName())) {
                    intent.putExtra(PushConstants.MZ_MESSAGE_VALUE, com.meizu.cloud.pushsdk.handler.d.a(messageV3));
                } else {
                    intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
                }
                intent.putExtra("method", "notification_arrived");
                MzSystemUtils.sendMessageFromBroadcast(d(), intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
            }
        }
    }

    protected abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, String str) {
        boolean z = true;
        if (i == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(d(), str);
        } else if (i == 1) {
            z = com.meizu.cloud.pushsdk.util.b.h(d(), str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        DebugLogger.i("AbstractMessageHandler", sb.toString());
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(MessageV3 messageV3, String str) {
        String a2 = com.meizu.cloud.pushsdk.handler.a.c.e.a(messageV3);
        if (TextUtils.isEmpty(a2)) {
            DebugLogger.i("AbstractMessageHandler", "message does not contain signature field");
            return false;
        }
        String k = com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName());
        DebugLogger.i("AbstractMessageHandler", "local public key is: " + k);
        if (a(k, messageV3, str)) {
            DebugLogger.i("AbstractMessageHandler", "message special approval no check");
            return true;
        } else if (b(k, messageV3, a2)) {
            DebugLogger.i("AbstractMessageHandler", "security check passed");
            return true;
        } else {
            String e = e();
            DebugLogger.i("AbstractMessageHandler", "network request public key: " + e);
            if (!b(e, messageV3, a2)) {
                DebugLogger.e("AbstractMessageHandler", "security check fail");
                return false;
            }
            com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName(), e);
            DebugLogger.i("AbstractMessageHandler", "security check passed");
            return true;
        }
    }

    protected boolean a(T t, String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str) {
        try {
            return d().getPackageName().equals(new JSONObject(str).getString("appId"));
        } catch (Exception e) {
            DebugLogger.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        return new e.a((String) com.meizu.cloud.pushsdk.c.a.a(PushConstants.GET_PUBLIC_KEY).a().a().a()).a();
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(com.anythink.expressad.d.a.b.bU);
            return (!jSONObject.has("pkg") || TextUtils.isEmpty(jSONObject.getString("pkg"))) ? "" : jSONObject.getString("pkg");
        } catch (Exception e) {
            DebugLogger.e("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(MessageV3 messageV3) {
        if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            c(messageV3);
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null) {
            DebugLogger.e("AbstractMessageHandler", "delete notifyId " + a2.a() + " notifyKey " + a2.b());
            if (TextUtils.isEmpty(a2.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a2.a());
            } else {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a2.b());
            }
        }
    }

    protected void b(T t) {
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0125  */
    @Override // com.meizu.cloud.pushsdk.handler.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(android.content.Intent r6) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.handler.a.a.b(android.content.Intent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.meizu.cloud.pushsdk.handler.a c() {
        return this.f24131a;
    }

    protected abstract T c(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null) {
            DebugLogger.i("AbstractMessageHandler", "delete notifyKey " + a2.b() + " notifyId " + a2.a());
            if (TextUtils.isEmpty(a2.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.c(d(), messageV3.getUploadDataPackageName(), a2.a());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.a(d(), messageV3.getUploadDataPackageName(), a2.b());
            }
        }
    }

    protected void c(T t) {
    }

    protected int d(T t) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        String str = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            str = com.meizu.cloud.pushsdk.b.c.a(d());
            DebugLogger.e("AbstractMessageHandler", "force get deviceId " + str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    protected void e(T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f(Intent intent) {
        return intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    protected void f(T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        String str = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            str = d().getPackageName();
        }
        return str;
    }

    protected boolean g(T t) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        DebugLogger.i("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        String str = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            str = String.valueOf(System.currentTimeMillis() / 1000);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        DebugLogger.i("AbstractMessageHandler", "receive push whiteList from pushservice " + booleanExtra);
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long j(Intent intent) {
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        DebugLogger.i("AbstractMessageHandler", "receive push delayedReportMillis from pushservice " + longExtra);
        return longExtra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k(Intent intent) {
        return intent.getStringExtra("method");
    }
}

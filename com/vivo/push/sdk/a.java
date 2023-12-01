package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.heytap.mcssdk.constant.IntentConstant;
import com.vivo.push.b.x;
import com.vivo.push.c.d;
import com.vivo.push.e;
import com.vivo.push.q;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/sdk/a.class */
public final class a extends q {

    /* renamed from: c  reason: collision with root package name */
    private static a f27430c;
    private static final List<Integer> e = Arrays.asList(3);
    private String d;
    private String f = "";

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f27430c == null) {
                    f27430c = new a();
                }
                aVar = f27430c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            p.a("CommandWorker", "error  " + e2.getMessage());
            return null;
        }
    }

    private boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("security_avoid_pull");
        if (TextUtils.isEmpty(stringExtra)) {
            p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        }
        try {
            String b = com.vivo.push.util.a.a(this.f27424a).b(stringExtra);
            if ("com.vivo.pushservice".equals(b)) {
                return true;
            }
            p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b)));
            return false;
        } catch (Exception e2) {
            p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
            return false;
        }
    }

    private boolean c(Intent intent) {
        if (Build.VERSION.SDK_INT < 18) {
            return true;
        }
        String c2 = z.c(this.f27424a, "com.vivo.pushservice");
        p.d("CommandWorker", " 配置的验签参数 = ".concat(String.valueOf(c2)));
        if (TextUtils.equals(c2, "1")) {
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                p.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
                return false;
            }
            try {
                if (d.a(this.f27424a).a().a("com.vivo.pushservice".getBytes("UTF-8"), u.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                    p.d("CommandWorker", " RSA验签通过  ");
                    return true;
                }
            } catch (Exception e2) {
                p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
            }
            p.d("CommandWorker", " RSA验签 不通过  ");
            return false;
        }
        return true;
    }

    private int d(Intent intent) {
        if (!TextUtils.isEmpty(this.f) && this.f.contains("CommandService")) {
            if (!(intent != null && b(intent) && c(intent))) {
                p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                return 2151;
            }
        }
        String packageName = this.f27424a.getPackageName();
        try {
            String stringExtra = intent.getStringExtra("command_type");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                int intExtra = intent.getIntExtra(IntentConstant.COMMAND, -1);
                int i = intExtra;
                if (intExtra < 0) {
                    i = intent.getIntExtra("method", -1);
                }
                if (e.contains(Integer.valueOf(i)) && t.c(this.f27424a, packageName) && !t.c(this.f27424a)) {
                    p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                    return 2153;
                }
                String action = intent.getAction();
                if (TextUtils.isEmpty(this.d)) {
                    String a2 = a(this.f27424a, packageName, action);
                    this.d = a2;
                    if (TextUtils.isEmpty(a2)) {
                        p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                        intent.setPackage(packageName);
                        this.f27424a.sendBroadcast(intent);
                        return 2152;
                    }
                    return 0;
                }
                return 0;
            }
            p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
            return 2151;
        } catch (Exception e2) {
            p.a("CommandWorker", e2);
            return 0;
        }
    }

    public final void a(Intent intent) {
        if (intent != null && this.f27424a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
            return;
        }
        p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f27424a);
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void b() {
        this.d = null;
    }

    @Override // com.vivo.push.q
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent == null || this.f27424a == null) {
            p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f27424a);
            return;
        }
        String packageName = this.f27424a.getPackageName();
        int d = d(intent);
        if (d <= 0) {
            try {
                Class<?> cls = Class.forName(this.d);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.d);
                method.invoke(newInstance, ContextDelegate.getContext(this.f27424a).getApplicationContext(), intent);
                return;
            } catch (Exception e2) {
                p.b("CommandWorker", "reflect e: ", e2);
                return;
            }
        }
        x xVar = new x(d);
        HashMap<String, String> hashMap = new HashMap<>();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            long j = 404000044642424832L;
            if (extras != null) {
                j = extras.getLong("notify_id", 404000044642424832L);
            }
            hashMap.put(IntentConstant.MESSAGE_ID, String.valueOf(j));
        }
        String b = z.b(this.f27424a, packageName);
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        e.a().a(xVar);
    }
}

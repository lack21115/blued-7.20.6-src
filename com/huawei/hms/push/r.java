package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/r.class */
public class r {
    public static void a(Context context, Intent intent) {
        try {
            if (context == null || intent == null) {
                HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
                return;
            }
            String action = intent.getAction();
            if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                    a(context, intent, byteArrayExtra, byteArrayExtra2);
                    return;
                }
                HMSLog.i("PushSelfShowLog", "self show info or token is null.");
            }
        } catch (RuntimeException e) {
            HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e);
        } catch (Exception e2) {
            HMSLog.d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    private static void a(Context context, Intent intent, m mVar) {
        HMSLog.i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + mVar.i());
        if (s.a(mVar.i())) {
            long a2 = d.a(mVar.c());
            if (a2 == 0) {
                new n(context, mVar).start();
                return;
            }
            HMSLog.d("PushSelfShowLog", "waiting...");
            intent.setPackage(context.getPackageName());
            d.a(context, intent, a2);
        }
    }

    private static void a(Context context, Intent intent, String str, m mVar, int i) {
        HMSLog.d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if ("-1".equals(str)) {
            d.a(context, i);
        } else {
            d.a(context, intent);
        }
        if ("1".equals(str)) {
            new s(context, mVar).c();
            PluginUtil.onNotificationClicked(context, mVar.p(), mVar.b());
        } else if ("2".equals(str)) {
            j.a(context, mVar.p(), mVar.b(), "2");
        } else {
            HMSLog.d("PushSelfShowLog", "other event");
        }
    }

    private static void a(Context context, Intent intent, byte[] bArr, byte[] bArr2) {
        String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        HMSLog.i("PushSelfShowLog", "get notifyId:" + intExtra);
        m mVar = new m(bArr, bArr2);
        if (!mVar.z()) {
            HMSLog.d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.i("PushSelfShowLog", "onReceive the msg id = " + mVar.p() + ",and cmd is " + mVar.i() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            a(context, intent, mVar);
        } else {
            a(context, intent, stringExtra, mVar, intExtra);
        }
    }
}

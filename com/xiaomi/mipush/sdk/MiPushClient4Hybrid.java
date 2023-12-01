package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bn;
import com.xiaomi.push.ew;
import com.xiaomi.push.g;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient4Hybrid.class */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient4Hybrid$MiPushCallback.class */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            i = Integer.valueOf(str).intValue();
        }
        int i2 = i;
        if (!z) {
            i2 = (i & (-4)) + g.b.NOT_ALLOWED.a();
        }
        return (short) i2;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m11457a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, ih ihVar) {
        b.a aVar;
        String c2 = ihVar.c();
        if (ihVar.a() == 0 && (aVar = dataMap.get(c2)) != null) {
            aVar.a(ihVar.f781e, ihVar.f782f);
            b.m11457a(context).a(c2, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(ihVar.f781e)) {
            arrayList = new ArrayList();
            arrayList.add(ihVar.f781e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f411a, arrayList, ihVar.f769a, ihVar.f780d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(c2, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, in inVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_UNREGISTER.f411a, null, inVar.f847a, inVar.f855d, null, null);
        String a2 = inVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a2, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m11457a(context).m11462a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a2 = b.m11457a(context).a(str);
            if (a2 != null) {
                arrayList.add(a2.f41220c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f411a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                Cif cif = new Cif();
                cif.b(str2);
                cif.c(hq.PullOfflineMessage.f583a);
                cif.a(bd.a());
                cif.a(false);
                ao.a(context).a(cif, hg.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a3 = bn.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a3);
        dataMap.put(str, aVar);
        ig igVar = new ig();
        igVar.a(bd.a());
        igVar.b(str2);
        igVar.e(str3);
        igVar.d(str);
        igVar.f(a3);
        igVar.c(com.xiaomi.push.g.m11798a(context, context.getPackageName()));
        igVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        igVar.h("5_1_0-C");
        igVar.a(50010);
        igVar.a(hu.Init);
        if (!com.xiaomi.push.j.m12053d()) {
            String d = com.xiaomi.push.i.d(context);
            if (!TextUtils.isEmpty(d)) {
                igVar.i(bn.a(d));
            }
        }
        int a4 = com.xiaomi.push.i.a();
        if (a4 >= 0) {
            igVar.c(a4);
        }
        Cif cif2 = new Cif();
        cif2.c(hq.HybridRegister.f583a);
        cif2.b(b.m11457a(context).m11458a());
        cif2.d(context.getPackageName());
        cif2.a(iq.a(igVar));
        cif2.a(bd.a());
        ao.a(context).a((ao) cif2, hg.Notification, (ht) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = miPushMessage.getMessageId();
        }
        am.a(context, str2);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("do not ack message, message is null");
            return;
        }
        try {
            hw hwVar = new hw();
            hwVar.b(b.m11457a(context).m11458a());
            hwVar.a(miPushMessage.getMessageId());
            hwVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            hwVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hwVar.c(miPushMessage.getTopic());
            }
            ao.a(context).a((ao) hwVar, hg.AckMessage, false, br.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            } finally {
                miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
                miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification_".concat(String.valueOf(str)), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a2 = b.m11457a(context).a(str);
        if (a2 == null) {
            return;
        }
        im imVar = new im();
        imVar.a(bd.a());
        imVar.d(str);
        imVar.b(a2.f150a);
        imVar.c(a2.f41220c);
        imVar.e(a2.b);
        Cif cif = new Cif();
        cif.c(hq.HybridUnregister.f583a);
        cif.b(b.m11457a(context).m11458a());
        cif.d(context.getPackageName());
        cif.a(iq.a(imVar));
        cif.a(bd.a());
        ao.a(context).a((ao) cif, hg.Notification, (ht) null);
        b.m11457a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.ak.a(context, linkedList);
    }
}

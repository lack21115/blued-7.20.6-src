package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.xiaomi.push.ai;
import com.xiaomi.push.eo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cc.class */
public class cc {
    private static int a(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.s.a(map.get("notification_top_period"), 0));
    }

    private static Notification a(Notification notification, int i, String str, ax axVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> m12141b = axVar.m12141b();
        Notification notification2 = null;
        if (m12141b != null) {
            Iterator<StatusBarNotification> it = m12141b.iterator();
            while (true) {
                notification2 = null;
                if (!it.hasNext()) {
                    break;
                }
                StatusBarNotification next = it.next();
                notification2 = next.getNotification();
                String string = notification2.extras.getString("message_id");
                if (i == next.getId() && str.equals(string)) {
                    break;
                }
            }
        }
        return notification2;
    }

    private static ai.a a(Context context, String str, int i, String str2, Notification notification) {
        return new cd(i, str2, context, str, notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m12178a(Context context, String str, int i, String str2, Notification notification) {
        if (com.xiaomi.push.j.m12048a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i, str2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, Map<String, String> map, eo eoVar, long j) {
        if (map == null || eoVar == null || !com.xiaomi.push.j.m12048a(context) || !m12179a(map)) {
            return;
        }
        int a2 = a(map);
        int b = b(map);
        if (a2 <= 0 || b > a2) {
            com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + a2 + " frequency:" + b);
            return;
        }
        eoVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (b > 0) {
            bundle.putInt("mipush_n_top_fre", b);
        }
        bundle.putInt("mipush_n_top_prd", a2);
        eoVar.addExtras(bundle);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m12179a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is ".concat(String.valueOf(parseBoolean)));
        return parseBoolean;
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.s.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, String str) {
        return "n_top_update_" + i + BridgeUtil.UNDERLINE_STR + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2, Notification notification) {
        ax a2;
        Notification a3;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (a3 = a(notification, i, str2, (a2 = ax.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (a3.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.bi.a((Object) a3, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = a3.extras.getLong("mipush_org_when", 0L);
        int i2 = a3.extras.getInt("mipush_n_top_fre", 0);
        int i3 = a3.extras.getInt("mipush_n_top_prd", 0);
        if (i3 <= 0 || i3 < i2) {
            return;
        }
        long j2 = (i3 * 1000) + j;
        if (j >= currentTimeMillis || currentTimeMillis >= j2) {
            i3 = 0;
        } else if (i2 > 0) {
            i3 = (int) Math.min((j2 - currentTimeMillis) / 1000, i2);
        }
        if (!z) {
            if (i3 > 0) {
                a3.when = currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m11394a("update top notification: ".concat(String.valueOf(str2)));
                a2.a(i, a3);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, a3);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("update top notification to common: ".concat(String.valueOf(str2)));
                a2.a(i, recoverBuilder.build());
            }
        }
        if (i3 > 0) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("schedule top notification next update delay: ".concat(String.valueOf(i3)));
            com.xiaomi.push.ai.a(context).m11503a(b(i, str2));
            com.xiaomi.push.ai.a(context).b(a(context, str, i, str2, (Notification) null), i3);
        }
    }
}

package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.hl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/au.class */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private static au f41613a = new au();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/au$a.class */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        List<b> f984a;
        List<b> b;

        private a() {
            this.f984a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/au$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f41615a;

        /* renamed from: a  reason: collision with other field name */
        Notification f985a;

        public b(int i, Notification notification) {
            this.f41615a = i;
            this.f985a = notification;
        }

        public String toString() {
            return "id:" + this.f41615a;
        }
    }

    private au() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static au a() {
        return f41613a;
    }

    private String a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    private List<StatusBarNotification> a(ax axVar) {
        List<StatusBarNotification> m12141b = axVar != null ? axVar.m12141b() : null;
        if (m12141b == null || m12141b.size() == 0) {
            return null;
        }
        return m12141b;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        String c2 = ay.c(notification);
        if (TextUtils.isEmpty(c2)) {
            str = "group auto not extract pkg from notification:".concat(String.valueOf(i));
        } else {
            List<StatusBarNotification> a2 = a(ax.a(context, c2));
            if (a2 != null) {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a2) {
                    if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !m12129b(notification)) {
                            (m12128a(notification) ? value.b : value.f984a).add(new b(i, notification));
                        }
                        int size = value.f984a.size();
                        if (value.b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, c2, key, value.f984a.get(0).f985a);
                            }
                        } else if (size <= 0) {
                            a(context, c2, key);
                        }
                    }
                }
                return;
            }
            str = "group auto not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a(str);
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:".concat(String.valueOf(str2)));
        ax.a(context, str).a(a(str, str2));
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("group show summary group is null");
                return;
            }
            int a2 = ay.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("group show summary not get icon from ".concat(String.valueOf(str)));
                return;
            }
            ax a3 = ax.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String b2 = a3.b(notification.getChannelId(), "groupSummary");
                NotificationChannel m12135a = a3.m12135a(b2);
                if ("groupSummary".equals(b2) && m12135a == null) {
                    a3.a(new NotificationChannel(b2, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, b2);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ay.a(defaults, true);
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!com.xiaomi.push.j.m12052c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ay.m12143a(build, str);
            }
            int a4 = a(str, str2);
            a3.a(a4, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:".concat(String.valueOf(a4)));
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("group show summary error ".concat(String.valueOf(e)));
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = new a();
            map.put(b2, aVar2);
        }
        (m12128a(statusBarNotification.getNotification()) ? aVar2.b : aVar2.f984a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m12127a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m12128a(Notification notification) {
        if (notification != null) {
            Object a2 = com.xiaomi.push.bi.a((Object) notification, "isGroupSummary", (Object[]) null);
            if (a2 instanceof Boolean) {
                return ((Boolean) a2).booleanValue();
            }
            return false;
        }
        return false;
    }

    private boolean a(Context context) {
        if (b(context) && ax.m12133a(context)) {
            return ba.a(context).a(hl.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        String group = notification.getGroup();
        if (m12129b(notification)) {
            group = a(notification);
        }
        return group;
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        String c2 = ay.c(notification);
        if (TextUtils.isEmpty(c2)) {
            str = "group restore not extract pkg from notification:".concat(String.valueOf(i));
        } else {
            ax a2 = ax.a(context, c2);
            List<StatusBarNotification> a3 = a(a2);
            if (a3 != null) {
                for (StatusBarNotification statusBarNotification : a3) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && m12129b(notification2) && statusBarNotification.getId() != i) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        ay.a(recoverBuilder, m12128a(notification2));
                        a2.a(statusBarNotification.getId(), recoverBuilder.build());
                        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m12129b(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(j), a(notification)));
    }

    private boolean b(Context context) {
        return ba.a(context).a(hl.NotificationAutoGroupSwitch.a(), true);
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (m12127a() && a(context)) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle extras = builder.getExtras();
            extras.putString("push_src_group_name", str);
            extras.putLong("push_src_group_time", currentTimeMillis);
            return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
        }
        return str;
    }

    public void a(Context context, int i, Notification notification) {
        if (m12127a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("group notify handle restore error ".concat(String.valueOf(e)));
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("group notify handle auto error ".concat(String.valueOf(e2)));
                }
            }
        }
    }
}

package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.ht;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/at.class */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f27921a = Log.isLoggable("NCHelper", 3);

    private static int a(NotificationChannel notificationChannel) {
        int i;
        int i2 = 0;
        try {
            int intValue = ((Integer) com.xiaomi.push.bi.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            i = intValue;
            if (f27921a) {
                StringBuilder sb = new StringBuilder("isUserLockedChannel:");
                sb.append(intValue);
                sb.append(" ");
                sb.append(notificationChannel);
                i2 = intValue;
                a(sb.toString());
                return intValue;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8345a("NCHelper", "is user locked error".concat(String.valueOf(e)));
            i = i2;
        }
        return i;
    }

    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    public static String a(ax axVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String m9088a = axVar.m9088a(str);
        if (f27921a) {
            a("createChannel: appChannelId:" + m9088a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(m9088a, charSequence, i2);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i & 2) != 0);
        boolean z = false;
        if ((i & 4) != 0) {
            z = true;
        }
        notificationChannel.enableLights(z);
        if ((i & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + axVar.m9087a())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (f27921a) {
            a("create channel:".concat(String.valueOf(notificationChannel)));
        }
        a(axVar, notificationChannel, str4);
        return m9088a;
    }

    static void a(Context context, ax axVar, NotificationChannel notificationChannel, int i, String str) {
        if (i <= 0) {
            axVar.a(notificationChannel);
            return;
        }
        int a2 = com.xiaomi.push.g.a(context) >= 2 ? e.a(context.getPackageName(), str) : 0;
        NotificationChannel a3 = a(notificationChannel.getId(), notificationChannel);
        if ((i & 32) != 0) {
            if (notificationChannel.getSound() != null) {
                a3.setSound(null, null);
            } else {
                a3.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if ((i & 16) != 0) {
            if (notificationChannel.shouldVibrate()) {
                a3.enableVibration(false);
            } else {
                a3.enableVibration(true);
            }
        }
        if ((i & 8) != 0) {
            if (notificationChannel.shouldShowLights()) {
                a3.enableLights(false);
            } else {
                a3.enableLights(true);
            }
        }
        if ((i & 4) != 0) {
            int importance = notificationChannel.getImportance() - 1;
            int i2 = importance;
            if (importance <= 0) {
                i2 = 2;
            }
            a3.setImportance(i2);
        }
        if ((i & 2) != 0) {
            a3.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
        }
        axVar.a(a3);
        axVar.a(notificationChannel, true);
        e.a(axVar.m9087a(), notificationChannel.getId(), a2, 0);
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.j.m8998a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        e.a(context, str);
    }

    private static void a(Context context, List<String> list) {
        if (f27921a) {
            a("deleteCopiedChannelRecord:".concat(String.valueOf(list)));
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = a(context).edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ht htVar) {
        if (htVar == null || htVar.f571a == null || !htVar.f571a.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        htVar.f567a = 0;
        htVar.f571a.remove("channel_id");
        htVar.f571a.remove("channel_importance");
        htVar.f571a.remove("channel_name");
        htVar.f571a.remove("channel_description");
        htVar.f571a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m8344a("delete channel info by:" + htVar.f571a.get("REMOVE_CHANNEL_MARK"));
        htVar.f571a.remove("REMOVE_CHANNEL_MARK");
    }

    private static void a(ax axVar, NotificationChannel notificationChannel, String str) {
        int i;
        boolean z;
        Context m9086a = axVar.m9086a();
        String id = notificationChannel.getId();
        String a2 = ax.a(id, axVar.m9087a());
        if (f27921a) {
            a("appChannelId:" + id + " oldChannelId:" + a2);
        }
        if (!com.xiaomi.push.j.m8998a(m9086a) || TextUtils.equals(id, a2)) {
            NotificationChannel m9085a = axVar.m9085a(id);
            if (f27921a) {
                a("elseLogic getNotificationChannel:".concat(String.valueOf(m9085a)));
            }
            if (m9085a == null) {
                axVar.a(notificationChannel);
            }
            i = 0;
            z = false;
        } else {
            NotificationManager notificationManager = (NotificationManager) m9086a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
            NotificationChannel m9085a2 = axVar.m9085a(id);
            if (f27921a) {
                a("xmsfChannel:".concat(String.valueOf(notificationChannel2)));
                a("appChannel:".concat(String.valueOf(m9085a2)));
            }
            if (notificationChannel2 != null) {
                NotificationChannel a3 = a(id, notificationChannel2);
                if (f27921a) {
                    a("copyXmsf copyXmsfChannel:".concat(String.valueOf(a3)));
                }
                if (m9085a2 != null) {
                    i = a(m9085a2);
                    axVar.a(a3, i == 0);
                    z = true;
                } else {
                    i = a(notificationChannel2);
                    a(m9086a, axVar, a3, i, notificationChannel2.getId());
                    z = true;
                }
                b(m9086a, id);
                notificationManager.deleteNotificationChannel(a2);
            } else {
                if (m9085a2 == null) {
                    if (f27921a) {
                        a("appHack createNotificationChannel:".concat(String.valueOf(notificationChannel)));
                    }
                    axVar.a(notificationChannel);
                    z = true;
                } else if (m9075a(m9086a, id) || !a(notificationChannel, m9085a2)) {
                    z = false;
                } else {
                    if (f27921a) {
                        a("appHack updateNotificationChannel:".concat(String.valueOf(notificationChannel)));
                    }
                    i = a(m9085a2);
                    axVar.a(notificationChannel, i == 0);
                    z = true;
                }
                i = 0;
            }
        }
        boolean z2 = true;
        if (!z) {
            z2 = true;
            if (!z) {
                z2 = z;
            }
        }
        e.a(axVar.m9086a(), axVar.m9087a(), id, notificationChannel.getImportance(), str, z2, i);
    }

    private static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m8345a("NCHelper", str);
    }

    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        boolean z2 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (f27921a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f27921a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f27921a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f27921a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f27921a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        boolean z3 = notificationChannel.getSound() != null;
        if (notificationChannel2.getSound() != null) {
            z2 = true;
        }
        if (z3 != z2) {
            notificationChannel.setSound(null, null);
            z = true;
            if (f27921a) {
                a("appHack channelConfigLowerCompare:setSound");
                z = true;
            }
        }
        if (f27921a) {
            a("appHack channelConfigLowerCompare:isDifferent:".concat(String.valueOf(z)));
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m9075a(Context context, String str) {
        if (f27921a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void b(Context context, String str) {
        if (f27921a) {
            a("recordCopiedChannel:".concat(String.valueOf(str)));
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            ax a2 = ax.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.m9090a(str2)) {
                    arrayList.add(str2);
                    if (f27921a) {
                        a("delete channel copy record:".concat(String.valueOf(str2)));
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception e) {
        }
    }
}

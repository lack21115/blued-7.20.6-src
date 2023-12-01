package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.push.service.ay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/e.class */
public class e {

    /* renamed from: a  reason: collision with other field name */
    private static final int[] f1055a = {1, 2, 4, 8, 16};

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<ay.a<String, String, String>> f41681a = new f(5);
    private static final SparseArray<Integer> b = new g(5);

    e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str, String str2) {
        int i = 8;
        if (!a(str, str2, 8)) {
            i = 0;
        }
        int i2 = i;
        if (a(str, str2, 16)) {
            i2 = i | 16;
        }
        int i3 = i2;
        if (a(str, str2, 1)) {
            i3 = i2 | 1;
        }
        int i4 = i3;
        if (a(str, str2, 2)) {
            i4 = i3 | 2;
        }
        int i5 = i4;
        if (a(str, str2, 4)) {
            i5 = i4 | 4;
        }
        return i5;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        List<NotificationChannel> m12139a;
        if (!com.xiaomi.push.j.m12048a(context) || TextUtils.isEmpty(str) || (m12139a = ax.a(context, str).m12139a()) == null) {
            return;
        }
        synchronized (e.class) {
            try {
                SharedPreferences a2 = a(context);
                ArrayList arrayList = new ArrayList();
                for (NotificationChannel notificationChannel : m12139a) {
                    String str2 = (String) com.xiaomi.push.bi.a(notificationChannel, "mId");
                    if (!TextUtils.isEmpty(str2) && a2.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    a(a2, arrayList);
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (!com.xiaomi.push.j.m12048a(context) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (com.xiaomi.push.j.m12048a(context)) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
                return;
            }
            return;
        }
        int a2 = com.xiaomi.push.s.a(str3, 0);
        boolean a3 = a(i, a2);
        if (z) {
            a(str, str2, a2, i2);
            if (a3) {
                synchronized (e.class) {
                    try {
                        a(a(context), a2, str2);
                    } finally {
                    }
                }
                return;
            }
            return;
        }
        synchronized (e.class) {
            try {
                SharedPreferences a4 = a(context);
                if (a3 || a4.contains(str2)) {
                    a(a4, a2, str, str2, i2);
                    if (a3) {
                        a(a4, a2, str2);
                    } else {
                        a(a4, str2);
                    }
                }
            } finally {
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new h(str));
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, int i, int i2) {
        int[] iArr = f1055a;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            int i5 = iArr[i4];
            if ((b.get(i5).intValue() & i2) == 0) {
                a(str, str2, i5, (i & i5) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m11394a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i5 + "> :stoped by userLock");
            }
            i3 = i4 + 1;
        }
    }

    private static void a(String str, String str2, int i, boolean z) {
        boolean a2 = ay.a(com.xiaomi.push.r.m12066a(), str, str2, f41681a.get(i), z);
        com.xiaomi.channel.commonutils.logger.b.m11394a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i + "=" + z + "> :" + a2);
    }

    private static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    private static boolean a(String str, String str2, int i) {
        boolean z = true;
        if (ay.a(com.xiaomi.push.r.m12066a(), str, str2, f41681a.get(i)) != 1) {
            z = false;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i + "=" + z + SimpleComparison.GREATER_THAN_OPERATION);
        return z;
    }
}

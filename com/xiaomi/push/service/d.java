package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static List<a> f27988a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f27989a;

        /* renamed from: a  reason: collision with other field name */
        public final long f1005a;

        /* renamed from: a  reason: collision with other field name */
        public final String f1006a;

        /* renamed from: a  reason: collision with other field name */
        public final Notification.Action[] f1007a;

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f1006a = str;
            this.f1005a = j;
            this.f27989a = i;
            this.f1007a = actionArr;
        }
    }

    private static void a() {
        int size = f27988a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            a aVar = f27988a.get(i);
            if (SystemClock.elapsedRealtime() - aVar.f1005a > 5000) {
                f27988a.remove(aVar);
            }
            size = i;
        }
        if (f27988a.size() > 10) {
            f27988a.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.j.m8998a(context) || i <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ay.m9095a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        f27988a.add(aVar);
        a();
    }
}

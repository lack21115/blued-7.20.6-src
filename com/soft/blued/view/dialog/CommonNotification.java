package com.soft.blued.view.dialog;

import android.app.Notification;
import android.app.NotificationManager;
import com.blued.android.core.AppInfo;
import com.soft.blued.R;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/view/dialog/CommonNotification.class */
public class CommonNotification {
    private static CommonNotification b;

    /* renamed from: c  reason: collision with root package name */
    private Notification f21176c;
    private String d;
    private static AtomicLong e = new AtomicLong(0);

    /* renamed from: a  reason: collision with root package name */
    public static String f21175a = "notification_from_tab";

    public CommonNotification() {
        this.d = "Blued";
        this.d = AppInfo.d().getResources().getString(2131886479) + AppInfo.d().getResources().getString(R.string.biao_notify_new_msg);
        this.f21176c = new Notification(R.drawable.blued_icon_0, this.d, System.currentTimeMillis());
    }

    public static void a() {
        try {
            ((NotificationManager) AppInfo.d().getSystemService("notification")).cancelAll();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }
}

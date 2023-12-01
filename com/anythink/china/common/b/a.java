package com.anythink.china.common.b;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.china.common.NotificationBroadcaseReceiver;
import com.anythink.china.common.a.e;
import com.anythink.core.common.k.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/b/a.class */
public class a implements b {
    public static final String a = a.class.getSimpleName();
    public static final String b = "anythink_action_notification_click";
    public static final String c = "anythink_action_notification_cannel";
    public static final String d = "anythink_broadcast_receiver_extra_url";
    public static final String e = "anythink_broadcast_receiver_extra_unique_id";
    public static final String f = "anythink_broadcast_receiver_extra_request_status";
    public static final String g = "anythink_broadcast_receiver_extra_notification_id";
    private static volatile a j;
    Map<String, c> h = new HashMap();
    private NotificationManager i;
    private Context k;
    private int l;

    private a(Context context) {
        this.k = context;
        this.i = b(context);
    }

    private static int a(long j2, long j3) {
        return (int) (((((float) j2) * 1.0f) / ((float) j3)) * 100.0f);
    }

    public static a a(Context context) {
        if (j == null) {
            synchronized (a.class) {
                try {
                    if (j == null) {
                        j = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    private void a(e eVar, NotificationCompat.Builder builder, c cVar) {
        if (cVar.d == null || cVar.d != eVar.a()) {
            cVar.d = eVar.a();
            Intent intent = new Intent(b);
            intent.putExtra(e, eVar.n);
            intent.putExtra(d, eVar.b);
            intent.putExtra(f, eVar.a().toString());
            intent.putExtra(g, cVar.a);
            intent.setClass(this.k, NotificationBroadcaseReceiver.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.k, cVar.a, intent, 134217728);
            Intent intent2 = new Intent(c);
            intent2.putExtra(e, eVar.n);
            intent2.putExtra(d, eVar.b);
            intent2.putExtra(f, eVar.a().toString());
            intent2.putExtra(g, cVar.a);
            intent2.setClass(this.k, NotificationBroadcaseReceiver.class);
            builder.setContentIntent(broadcast).setDeleteIntent(PendingIntent.getBroadcast(this.k, cVar.a, intent2, 134217728));
        }
    }

    private void d(e eVar) {
        a(eVar, 0L, 100L, true);
    }

    private void e(e eVar) {
        a(eVar, 0L, 100L, true);
    }

    private c f(e eVar) {
        String str = eVar.n;
        c cVar = this.h.get(str);
        if (cVar != null) {
            return cVar;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.k, str);
        if (Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str, 3);
            notificationChannel.setSound(null, null);
            this.i.createNotificationChannel(notificationChannel);
        }
        this.l++;
        builder.setOngoing(true).setSound((Uri) null).setPriority(0).setOnlyAlertOnce(true).setAutoCancel(false);
        try {
            builder.setSmallIcon(this.k.getPackageManager().getApplicationInfo(this.k.getPackageName(), 128).icon);
        } catch (Throwable th) {
            th.printStackTrace();
            builder.setSmallIcon(h.a(this.k, "core_icon_close", "drawable"));
        }
        builder.setContentTitle(eVar.c).setLargeIcon(eVar.d);
        c cVar2 = new c();
        cVar2.a = this.l;
        cVar2.b = builder;
        cVar2.c = -1;
        this.h.put(str, cVar2);
        return cVar2;
    }

    public final void a() {
        NotificationManager notificationManager = this.i;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public final void a(int i) {
        if (i < 0) {
            return;
        }
        try {
            this.i.cancel(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(e eVar) {
        a(eVar, 100L, 100L, true);
    }

    public final void a(e eVar, long j2, long j3) {
        a(eVar, j2, j3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0221 A[Catch: all -> 0x0276, TryCatch #1 {, blocks: (B:6:0x0006, B:9:0x0017, B:11:0x001e, B:13:0x002b, B:15:0x0040, B:20:0x011e, B:25:0x0136, B:62:0x021a, B:64:0x0221, B:66:0x022f, B:68:0x0249, B:71:0x0263, B:69:0x0257, B:29:0x0145, B:33:0x0158, B:44:0x0184, B:46:0x0192, B:50:0x01a2, B:55:0x01b9, B:57:0x01c0, B:59:0x01c8, B:60:0x01ef, B:18:0x004e), top: B:90:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0249 A[Catch: all -> 0x0276, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:6:0x0006, B:9:0x0017, B:11:0x001e, B:13:0x002b, B:15:0x0040, B:20:0x011e, B:25:0x0136, B:62:0x021a, B:64:0x0221, B:66:0x022f, B:68:0x0249, B:71:0x0263, B:69:0x0257, B:29:0x0145, B:33:0x0158, B:44:0x0184, B:46:0x0192, B:50:0x01a2, B:55:0x01b9, B:57:0x01c0, B:59:0x01c8, B:60:0x01ef, B:18:0x004e), top: B:90:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0257 A[Catch: all -> 0x0276, TRY_ENTER, TryCatch #1 {, blocks: (B:6:0x0006, B:9:0x0017, B:11:0x001e, B:13:0x002b, B:15:0x0040, B:20:0x011e, B:25:0x0136, B:62:0x021a, B:64:0x0221, B:66:0x022f, B:68:0x0249, B:71:0x0263, B:69:0x0257, B:29:0x0145, B:33:0x0158, B:44:0x0184, B:46:0x0192, B:50:0x01a2, B:55:0x01b9, B:57:0x01c0, B:59:0x01c8, B:60:0x01ef, B:18:0x004e), top: B:90:0x0006 }] */
    @Override // com.anythink.china.common.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.china.common.a.e r6, long r7, long r9, boolean r11) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.b.a.a(com.anythink.china.common.a.e, long, long, boolean):void");
    }

    @Override // com.anythink.china.common.b.b
    public final NotificationManager b(Context context) {
        if (context == null) {
            return null;
        }
        return (NotificationManager) context.getSystemService("notification");
    }

    @Override // com.anythink.china.common.b.b
    public final String b(e eVar) {
        return eVar.n;
    }

    public final void c(e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.b) || this.i == null) {
            return;
        }
        this.i.cancel(f(eVar).a);
        this.h.remove(eVar.n);
    }
}

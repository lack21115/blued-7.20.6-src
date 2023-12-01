package com.igexin.push.core.a.c;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.push.f.n;
import com.igexin.sdk.GetuiActivity;
import com.igexin.sdk.main.FeedbackImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/g.class */
public class g implements PushMessageInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9806a = com.igexin.push.core.b.e + g.class.getName();
    private static final int b = 131;

    /* renamed from: c  reason: collision with root package name */
    private static final String f9807c = "push_small";

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/g$a.class */
    enum a {
        UNSET(0),
        BIG_IMAGE(1),
        LONG_TEXT(2),
        PURE_IMAGE(3);
        
        int e;

        a(int i) {
            this.e = i;
        }

        private int a() {
            return this.e;
        }
    }

    private static int a(com.igexin.push.core.b.k kVar, boolean z) {
        int i = 0;
        if (!z) {
            if (!TextUtils.isEmpty(com.igexin.push.core.e.aL)) {
                int identifier = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aL, com.anythink.expressad.foundation.h.i.f5112c, com.igexin.push.core.e.g);
                i = identifier;
                if (identifier == 0) {
                    i = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aL, "mipmap", com.igexin.push.core.e.g);
                }
            }
            int identifier2 = com.igexin.push.core.e.l.getResources().getIdentifier("push", com.anythink.expressad.foundation.h.i.f5112c, com.igexin.push.core.e.g);
            int i2 = identifier2;
            if (identifier2 == 0) {
                i2 = com.igexin.push.core.e.l.getResources().getIdentifier("push", "mipmap", com.igexin.push.core.e.g);
            }
            if (TextUtils.isEmpty(kVar.f) || com.igexin.push.core.b.l.equals(kVar.f)) {
                return i > 0 ? i : i2;
            } else if (kVar.f.startsWith("@")) {
                String str = kVar.f;
                return str.substring(1, str.length()).endsWith("email") ? R.drawable.sym_action_email : R.drawable.sym_def_app_icon;
            } else {
                int identifier3 = com.igexin.push.core.e.l.getResources().getIdentifier(kVar.f, com.anythink.expressad.foundation.h.i.f5112c, com.igexin.push.core.e.g);
                int i3 = identifier3;
                if (identifier3 == 0) {
                    i3 = com.igexin.push.core.e.l.getResources().getIdentifier(kVar.f, "mipmap", com.igexin.push.core.e.g);
                }
                return i3 > 0 ? i3 : i > 0 ? i : i2;
            }
        }
        if (!TextUtils.isEmpty(com.igexin.push.core.e.aK)) {
            int identifier4 = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aK, com.anythink.expressad.foundation.h.i.f5112c, com.igexin.push.core.e.g);
            int i4 = identifier4;
            if (identifier4 == 0) {
                i4 = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aK, "mipmap", com.igexin.push.core.e.g);
            }
            if (i4 > 0) {
                return i4;
            }
        }
        int identifier5 = com.igexin.push.core.e.l.getResources().getIdentifier(f9807c, com.anythink.expressad.foundation.h.i.f5112c, com.igexin.push.core.e.g);
        int i5 = identifier5;
        if (identifier5 == 0) {
            i5 = com.igexin.push.core.e.l.getResources().getIdentifier(f9807c, "mipmap", com.igexin.push.core.e.g);
        }
        if (i5 != 0) {
            com.igexin.c.a.c.a.a(f9806a + "|push_small.png is set, use default push_small", new Object[0]);
            return i5;
        }
        com.igexin.c.a.c.a.a(f9806a, "|push_small.png is missing");
        com.igexin.c.a.c.a.a(f9806a + "|push_small.png is missing", new Object[0]);
        return com.igexin.push.core.e.l.getApplicationInfo().icon;
    }

    private static int a(String str) {
        int i = 0;
        for (int i2 = 0; i2 != str.length(); i2++) {
            i = (i * 131) + str.charAt(i2);
        }
        int i3 = i;
        if (i == Integer.MIN_VALUE) {
            i3 = 1;
        }
        return Math.abs(i3);
    }

    private static Notification a(String str, int i, com.igexin.push.core.b.k kVar) {
        Notification.Builder builder;
        if (TextUtils.isEmpty(str) || com.igexin.push.core.e.aj.containsKey(str) || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        com.igexin.push.core.e.aj.put(str, new HashSet<>());
        PendingIntent b2 = b(str);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder builder2 = new Notification.Builder(com.igexin.push.core.e.l);
            NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
            try {
                Constructor<?> constructor = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE);
                Class<?> cls = notificationManager.getClass();
                if (((Parcelable) cls.getMethod("getNotificationChannel", String.class).invoke(notificationManager, kVar.j)) == null) {
                    cls.getMethod("createNotificationChannel", Class.forName("android.app.NotificationChannel")).invoke(notificationManager, (Parcelable) constructor.newInstance(kVar.j, kVar.k, Integer.valueOf(kVar.l)));
                }
                builder2.getClass().getMethod("setChannelId", String.class).invoke(builder2, kVar.j);
                builder = builder2;
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                builder = builder2;
            }
        } else {
            builder = new Notification.Builder(com.igexin.push.core.e.l);
        }
        return builder.setContentTitle("summary").setContentText("summary").setDeleteIntent(b2).setAutoCancel(false).setGroup(str).setSmallIcon(i).setGroupSummary(true).build();
    }

    private static PendingIntent a(String str, int i, String str2, String str3, int i2, com.igexin.push.core.b.k kVar) {
        Intent intent = new Intent();
        intent.putExtra("taskid", str2);
        intent.putExtra("messageid", str3);
        intent.putExtra("appid", com.igexin.push.core.e.f9887a);
        intent.putExtra("actionid", kVar.getDoActionId());
        intent.putExtra("accesstoken", com.igexin.push.core.e.aC);
        intent.putExtra("notifID", i2);
        StringBuilder sb = new StringBuilder();
        sb.append(kVar.h);
        intent.putExtra("notifyStyle", sb.toString());
        intent.putExtra("id", kVar.u);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(kVar.y);
        intent.putExtra("bigStyle", sb2.toString());
        intent.putExtra("isFloat", false);
        intent.putExtra("checkpackage", com.igexin.push.core.e.l.getPackageName());
        intent.putExtra("feedbackid", kVar.getActionId().substring(kVar.getActionId().length() - 1));
        String str4 = kVar.f9838a;
        String str5 = str4;
        if (str4 == null) {
            str5 = "";
        }
        intent.putExtra("title", str5);
        String str6 = kVar.b;
        if (str6 == null) {
            str6 = "";
        }
        intent.putExtra("content", str6);
        intent.putExtra("redisplayFreq", i);
        intent.putExtra("groupId", str);
        int i3 = 134217728;
        if (Build.VERSION.SDK_INT >= 23) {
            i3 = 201326592;
        }
        try {
            Intent intent2 = new Intent(com.igexin.push.core.e.l, GetuiActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("action", "com.igexin.action.notification.click");
            intent2.putExtra("broadcast_intent", intent);
            return PendingIntent.getActivity(com.igexin.push.core.e.l, new Random().nextInt(1000), intent2, i3);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            Intent intent3 = new Intent("com.igexin.action.notification.click");
            intent3.setAction("com.igexin.action.notification.click");
            intent3.putExtra("action", "com.igexin.action.notification.click");
            intent3.putExtra("broadcast_intent", intent);
            return PendingIntent.getBroadcast(com.igexin.push.core.e.l, new Random().nextInt(1000), intent3, i3);
        }
    }

    private static PendingIntent a(String str, int i, String str2, String str3, String str4, com.igexin.push.core.b.k kVar) {
        try {
            Context context = com.igexin.push.core.e.l;
            com.igexin.push.core.a.b.d();
            Intent intent = new Intent(context, com.igexin.push.core.a.b.a(com.igexin.push.core.e.l));
            intent.putExtra("taskid", str3);
            intent.putExtra("messageid", str4);
            intent.putExtra("appid", com.igexin.push.core.e.f9887a);
            intent.putExtra("appkey", str2);
            intent.putExtra("actionid", kVar.getDoActionId());
            StringBuilder sb = new StringBuilder();
            sb.append(kVar.h);
            intent.putExtra("notifyStyle", sb.toString());
            intent.putExtra("id", kVar.u);
            intent.putExtra("feedbackid", kVar.getActionId().substring(kVar.getActionId().length() - 1));
            intent.putExtra("action", "com.igexin.action.notification.delete");
            intent.putExtra("redisplayFreq", i);
            intent.putExtra("groupId", str);
            int i2 = 134217728;
            if (n.a(com.igexin.push.core.e.l) >= 31) {
                i2 = 134217728;
                if (Build.VERSION.SDK_INT >= 30) {
                    i2 = 201326592;
                }
            }
            return PendingIntent.getService(com.igexin.push.core.e.l, new Random().nextInt(1000), intent, i2);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(f9806a + "|getDelPendingIntent err：" + e.toString(), new Object[0]);
            return null;
        }
    }

    private static Bitmap a(com.igexin.push.core.b.k kVar) {
        Bitmap bitmap;
        String str = kVar.z;
        if (TextUtils.isEmpty(str)) {
            bitmap = null;
        } else {
            bitmap = com.igexin.push.f.l.a(str);
            String str2 = f9806a;
            StringBuilder sb = new StringBuilder("|use net logo bitmap is null = ");
            sb.append(bitmap == null);
            com.igexin.c.a.c.a.a(str2, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f9806a);
            sb2.append("|use net logo bitmap is null = ");
            sb2.append(bitmap == null);
            com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            bitmap2 = BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(kVar, false));
        }
        return bitmap2;
    }

    private static void a(Notification notification) {
        if (com.igexin.push.f.a.b() || Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 24) {
            return;
        }
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("right_icon");
            field.setAccessible(true);
            int i = field.getInt(null);
            if (notification.contentView != null) {
                notification.contentView.setViewVisibility(i, 8);
                notification.bigContentView.setViewVisibility(i, 8);
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void a(Notification notification, com.igexin.push.core.b.k kVar) {
        notification.defaults = 4;
        notification.ledARGB = Color.GREEN;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = kVar.e ? notification.flags | 16 : notification.flags | 32;
        if (kVar.f9839c) {
            notification.defaults |= 2;
        }
        if (kVar.d) {
            if (TextUtils.isEmpty(kVar.p)) {
                notification.defaults |= 1;
            } else {
                notification.sound = c(kVar.p);
            }
        }
        if (kVar.o > 0) {
            com.igexin.push.f.d.a(kVar.o, false);
            com.igexin.push.f.d.c(kVar.o, false);
            com.igexin.push.f.d.b(kVar.o, false);
        }
        notification.icon = a(kVar, true);
    }

    private static void a(PushTaskBean pushTaskBean, com.igexin.push.core.b.k kVar, int i) {
        Bitmap bitmap;
        Notification.BigPictureStyle bigText;
        Bitmap a2;
        int i2 = kVar.r;
        String appKey = pushTaskBean.getAppKey();
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        String str = kVar.q;
        com.igexin.push.core.e.ai.put(taskId, Integer.valueOf(i));
        int a3 = a(kVar, true);
        if (a3 != 0 && com.igexin.push.core.e.l.getResources().getDrawable(a3) == null) {
            com.igexin.c.a.c.a.a(f9806a + "|showNotification smallIconId: " + a3 + " couldn't find resource", new Object[0]);
            return;
        }
        Notification a4 = a(str, a3, kVar);
        PendingIntent a5 = a(str, i2, taskId, messageId, i, kVar);
        PendingIntent a6 = a(str, i2, appKey, taskId, messageId, kVar);
        NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
        Notification.Builder b2 = Build.VERSION.SDK_INT >= 26 ? b(kVar) : new Notification.Builder(com.igexin.push.core.e.l);
        String str2 = kVar.f9838a;
        String str3 = kVar.b;
        String str4 = kVar.z;
        if (TextUtils.isEmpty(str4)) {
            bitmap = null;
        } else {
            bitmap = com.igexin.push.f.l.a(str4);
            String str5 = f9806a;
            StringBuilder sb = new StringBuilder("|use net logo bitmap is null = ");
            sb.append(bitmap == null);
            com.igexin.c.a.c.a.a(str5, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f9806a);
            sb2.append("|use net logo bitmap is null = ");
            sb2.append(bitmap == null);
            com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            bitmap2 = BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(kVar, false));
        }
        b2.setSmallIcon(a3).setTicker(kVar.b).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentIntent(a5).setContentText(str3).setDeleteIntent(a6);
        if (bitmap2 != null) {
            b2.setLargeIcon(bitmap2);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            b2.setShowWhen(true);
        }
        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(kVar.i)) {
            try {
                b2.setColor(Color.parseColor(kVar.i));
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (kVar.y == a.BIG_IMAGE.e) {
                String str6 = kVar.A;
                if (!TextUtils.isEmpty(str6) && (a2 = com.igexin.push.f.l.a(str6)) != null) {
                    b2.setPriority(kVar.t);
                    bigText = new Notification.BigPictureStyle().bigPicture(a2);
                    b2.setStyle(bigText);
                }
            } else if (kVar.y == a.LONG_TEXT.e) {
                String str7 = kVar.x;
                if (!TextUtils.isEmpty(str7)) {
                    b2.setPriority(kVar.t);
                    bigText = new Notification.BigTextStyle().bigText(str7);
                    b2.setStyle(bigText);
                }
            }
        }
        if (kVar.v && Build.VERSION.SDK_INT >= 21 && (kVar.f9839c || kVar.d)) {
            b2.setPriority(2);
        }
        if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 24 && com.igexin.push.core.e.aj.containsKey(str)) {
            b2.setGroup(str);
            b2.setGroupSummary(false);
            HashSet<String> hashSet = com.igexin.push.core.e.aj.get(str) == null ? new HashSet<>() : com.igexin.push.core.e.aj.get(str);
            hashSet.add(taskId);
            com.igexin.push.core.e.aj.put(str, hashSet);
        }
        b2.setWhen(System.currentTimeMillis());
        Notification notification = b2.getNotification();
        notification.defaults = 4;
        notification.ledARGB = Color.GREEN;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = kVar.e ? notification.flags | 16 : notification.flags | 32;
        if (kVar.f9839c) {
            notification.defaults |= 2;
        }
        if (kVar.d) {
            if (TextUtils.isEmpty(kVar.p)) {
                notification.defaults |= 1;
            } else {
                notification.sound = c(kVar.p);
            }
        }
        if (kVar.o > 0) {
            com.igexin.push.f.d.a(kVar.o, false);
            com.igexin.push.f.d.c(kVar.o, false);
            com.igexin.push.f.d.b(kVar.o, false);
        }
        notification.icon = a(kVar, true);
        a(notification);
        if (!TextUtils.isEmpty(str) && a4 != null) {
            int a7 = a(str);
            com.igexin.push.core.e.ak.put(str, Integer.valueOf(a7));
            notificationManager.notify(a7, a4);
        }
        com.igexin.c.a.c.a.a(f9806a + "|showNotification notification:" + i, new Object[0]);
        if (i2 > 0) {
            notificationManager.cancel(i);
        }
        notificationManager.notify(i, notification);
        com.igexin.push.core.l.a().b(taskId, messageId, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3, final BaseActionBean baseActionBean, final int i) {
        String str4;
        String str5 = "width=" + com.igexin.push.core.e.k + "&height=" + com.igexin.push.core.e.j;
        if (str.contains(str5)) {
            str4 = str;
        } else if (str.indexOf("?") > 0) {
            str4 = str + ContainerUtils.FIELD_DELIMITER + str5;
        } else {
            str4 = str + "?" + str5;
        }
        com.igexin.push.core.h.b bVar = new com.igexin.push.core.h.b(str4, str, str2, baseActionBean, i, new com.igexin.push.core.h.d() { // from class: com.igexin.push.core.a.c.g.1
            @Override // com.igexin.push.core.h.d
            public final void a() {
                if (((com.igexin.push.core.b.k) baseActionBean).D >= 3) {
                    ((com.igexin.push.core.b.k) baseActionBean).B = true;
                }
                if (((com.igexin.push.core.b.k) baseActionBean).E >= 3) {
                    ((com.igexin.push.core.b.k) baseActionBean).C = true;
                }
                if (!((com.igexin.push.core.b.k) baseActionBean).B || !((com.igexin.push.core.b.k) baseActionBean).C) {
                    g.this.a(str, str2, str3, baseActionBean, i);
                } else if (com.igexin.push.core.e.a(str2) == 0) {
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(str2, str3, "1");
                }
            }

            @Override // com.igexin.push.core.h.d
            public final void a(BaseActionBean baseActionBean2) {
                int i2 = i;
                if (i2 == 2) {
                    ((com.igexin.push.core.b.k) baseActionBean).B = true;
                } else if (i2 == 8) {
                    ((com.igexin.push.core.b.k) baseActionBean).C = true;
                }
                com.igexin.push.core.b.k kVar = (com.igexin.push.core.b.k) baseActionBean2;
                if (kVar.B && kVar.C && com.igexin.push.core.e.a(str2) == 0) {
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(str2, str3, "1");
                }
            }
        });
        if (i == 2) {
            ((com.igexin.push.core.b.k) baseActionBean).D++;
        } else if (i == 8) {
            ((com.igexin.push.core.b.k) baseActionBean).E++;
        }
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.a.e(bVar), false, true);
    }

    private static void a(String str, String str2, String str3, String str4) {
        com.igexin.push.core.l.a().b(str, str2, str3, str4);
    }

    private static Notification.Builder b(com.igexin.push.core.b.k kVar) {
        Notification.Builder builder = new Notification.Builder(com.igexin.push.core.e.l);
        NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE);
            Class<?> cls2 = notificationManager.getClass();
            if (((Parcelable) cls2.getMethod("getNotificationChannel", String.class).invoke(notificationManager, kVar.j)) == null) {
                Parcelable parcelable = (Parcelable) constructor.newInstance(kVar.j, kVar.k, Integer.valueOf(kVar.l));
                Method method = cls2.getMethod("createNotificationChannel", Class.forName("android.app.NotificationChannel"));
                Method method2 = cls.getMethod("enableVibration", Boolean.TYPE);
                Method method3 = cls.getMethod("setSound", Uri.class, AudioAttributes.class);
                method2.invoke(parcelable, Boolean.valueOf(kVar.f9839c));
                if (!kVar.d) {
                    method3.invoke(parcelable, null, null);
                } else if (!TextUtils.isEmpty(kVar.p)) {
                    method3.invoke(parcelable, c(kVar.p), null);
                }
                method.invoke(notificationManager, parcelable);
            }
            builder.getClass().getMethod("setChannelId", String.class).invoke(builder, kVar.j);
            return builder;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return builder;
        }
    }

    private static PendingIntent b(String str) {
        try {
            Context context = com.igexin.push.core.e.l;
            com.igexin.push.core.a.b.d();
            Intent intent = new Intent(context, com.igexin.push.core.a.b.a(com.igexin.push.core.e.l));
            intent.putExtra("isSummary", true);
            intent.putExtra("action", "com.igexin.action.notification.delete");
            intent.putExtra("groupId", str);
            int i = 134217728;
            if (n.a(com.igexin.push.core.e.l) >= 31) {
                i = 134217728;
                if (Build.VERSION.SDK_INT >= 30) {
                    i = 201326592;
                }
            }
            return PendingIntent.getService(com.igexin.push.core.e.l, new Random().nextInt(1000), intent, i);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static Uri c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.parse("android.resource://" + com.igexin.push.core.e.l.getPackageName() + "/raw/" + str.toLowerCase());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        int i;
        Bitmap bitmap;
        Notification.BigPictureStyle bigText;
        Bitmap a2;
        if (pushTaskBean == null || !(baseActionBean instanceof com.igexin.push.core.b.k)) {
            return true;
        }
        com.igexin.push.core.b.k kVar = (com.igexin.push.core.b.k) baseActionBean;
        int a3 = !kVar.n ? a(pushTaskBean.getTaskId()) : kVar.m;
        try {
            i = Integer.parseInt(kVar.getActionId().substring(kVar.getActionId().length() - 1)) + 30000;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            i = 0;
        }
        int i2 = kVar.r;
        String appKey = pushTaskBean.getAppKey();
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        String str = kVar.q;
        com.igexin.push.core.e.ai.put(taskId, Integer.valueOf(a3));
        int a4 = a(kVar, true);
        if (a4 == 0 || com.igexin.push.core.e.l.getResources().getDrawable(a4) != null) {
            Notification a5 = a(str, a4, kVar);
            PendingIntent a6 = a(str, i2, taskId, messageId, a3, kVar);
            PendingIntent a7 = a(str, i2, appKey, taskId, messageId, kVar);
            NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
            Notification.Builder b2 = Build.VERSION.SDK_INT >= 26 ? b(kVar) : new Notification.Builder(com.igexin.push.core.e.l);
            String str2 = kVar.f9838a;
            String str3 = kVar.b;
            String str4 = kVar.z;
            if (TextUtils.isEmpty(str4)) {
                bitmap = null;
            } else {
                bitmap = com.igexin.push.f.l.a(str4);
                String str5 = f9806a;
                StringBuilder sb = new StringBuilder("|use net logo bitmap is null = ");
                sb.append(bitmap == null);
                com.igexin.c.a.c.a.a(str5, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f9806a);
                sb2.append("|use net logo bitmap is null = ");
                sb2.append(bitmap == null);
                com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap == null) {
                bitmap2 = BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(kVar, false));
            }
            b2.setSmallIcon(a4).setTicker(kVar.b).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentIntent(a6).setContentText(str3).setDeleteIntent(a7);
            if (bitmap2 != null) {
                b2.setLargeIcon(bitmap2);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                b2.setShowWhen(true);
            }
            if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(kVar.i)) {
                try {
                    b2.setColor(Color.parseColor(kVar.i));
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (kVar.y == a.BIG_IMAGE.e) {
                    String str6 = kVar.A;
                    if (!TextUtils.isEmpty(str6) && (a2 = com.igexin.push.f.l.a(str6)) != null) {
                        b2.setPriority(kVar.t);
                        bigText = new Notification.BigPictureStyle().bigPicture(a2);
                        b2.setStyle(bigText);
                    }
                } else if (kVar.y == a.LONG_TEXT.e) {
                    String str7 = kVar.x;
                    if (!TextUtils.isEmpty(str7)) {
                        b2.setPriority(kVar.t);
                        bigText = new Notification.BigTextStyle().bigText(str7);
                        b2.setStyle(bigText);
                    }
                }
            }
            if (kVar.v && Build.VERSION.SDK_INT >= 21 && (kVar.f9839c || kVar.d)) {
                b2.setPriority(2);
            }
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 24 && com.igexin.push.core.e.aj.containsKey(str)) {
                b2.setGroup(str);
                b2.setGroupSummary(false);
                HashSet<String> hashSet = com.igexin.push.core.e.aj.get(str) == null ? new HashSet<>() : com.igexin.push.core.e.aj.get(str);
                hashSet.add(taskId);
                com.igexin.push.core.e.aj.put(str, hashSet);
            }
            b2.setWhen(System.currentTimeMillis());
            Notification notification = b2.getNotification();
            notification.defaults = 4;
            notification.ledARGB = Color.GREEN;
            notification.ledOnMS = 1000;
            notification.ledOffMS = 3000;
            notification.flags = 1;
            notification.flags = kVar.e ? 16 | notification.flags : notification.flags | 32;
            if (kVar.f9839c) {
                notification.defaults |= 2;
            }
            if (kVar.d) {
                if (TextUtils.isEmpty(kVar.p)) {
                    notification.defaults |= 1;
                } else {
                    notification.sound = c(kVar.p);
                }
            }
            if (kVar.o > 0) {
                com.igexin.push.f.d.a(kVar.o, false);
                com.igexin.push.f.d.c(kVar.o, false);
                com.igexin.push.f.d.b(kVar.o, false);
            }
            notification.icon = a(kVar, true);
            a(notification);
            if (!TextUtils.isEmpty(str) && a5 != null) {
                int a8 = a(str);
                com.igexin.push.core.e.ak.put(str, Integer.valueOf(a8));
                notificationManager.notify(a8, a5);
            }
            com.igexin.c.a.c.a.a(f9806a + "|showNotification notification:" + a3, new Object[0]);
            if (i2 > 0) {
                notificationManager.cancel(a3);
            }
            notificationManager.notify(a3, notification);
            com.igexin.push.core.l.a().b(taskId, messageId, str2, str3);
        } else {
            com.igexin.c.a.c.a.a(f9806a + "|showNotification smallIconId: " + a4 + " couldn't find resource", new Object[0]);
        }
        if (i != 0) {
            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, String.valueOf(i), "notifyStyle:" + kVar.h);
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(pushTaskBean.getTaskId(), com.igexin.push.core.b.af, kVar.r);
        pushTaskBean.setPerActionid(Integer.parseInt(kVar.getActionId()));
        pushTaskBean.setCurrentActionid(Integer.parseInt(kVar.getDoActionId()));
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(83:1|2|(13:187|188|5|(1:7)|8|9|(1:11)|12|13|(1:15)|16|17|(62:27|(4:178|179|180|(1:182))|29|30|(1:34)|35|36|(9:40|(4:42|(1:44)|45|46)|47|48|(1:50)|51|52|(4:54|55|56|(2:58|45))|46)|59|60|61|(3:63|64|(1:69)(1:68))|70|71|72|(2:164|(2:171|(2:173|174))(1:170))(1:78)|79|(1:83)|84|85|(3:87|(2:89|90)(1:92)|91)|93|94|(3:96|(2:98|99)(1:101)|100)|102|103|(3:105|(2:107|108)(1:110)|109)|111|112|(1:114)|115|116|(1:118)|119|120|(1:122)|123|124|(1:126)|127|128|(1:130)|131|132|(1:134)|135|136|(2:162|163)|140|141|(2:157|158)|143|144|(1:146)|147|148|(1:150)|151|152|(1:154)|155|156)(2:24|25))|4|5|(0)|8|9|(0)|12|13|(0)|16|17|(1:19)|27|(0)|29|30|(2:32|34)|35|36|(10:38|40|(0)|47|48|(0)|51|52|(0)|46)|59|60|61|(0)|70|71|72|(1:74)|164|(1:166)|171|(0)|79|(2:81|83)|84|85|(0)|93|94|(0)|102|103|(0)|111|112|(0)|115|116|(0)|119|120|(0)|123|124|(0)|127|128|(0)|131|132|(0)|135|136|(1:138)|162|163|140|141|(0)|143|144|(0)|147|148|(0)|151|152|(0)|155|156) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
        if (r6 <= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ec, code lost:
        r0.t = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02a8 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02c9 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ea A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x030b A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0321 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0337 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x034d A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0363 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0379 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x041b A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0431 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0447 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0161 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0183 A[Catch: Exception -> 0x0456, TRY_ENTER, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0195 A[Catch: Exception -> 0x0456, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c7 A[Catch: Exception -> 0x0462, TRY_LEAVE, TryCatch #3 {Exception -> 0x0462, blocks: (B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3), top: B:194:0x01be, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0253 A[Catch: Exception -> 0x0456, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0055 A[Catch: Exception -> 0x0456, TryCatch #2 {Exception -> 0x0456, blocks: (B:2:0x0000, B:7:0x004b, B:9:0x0055, B:11:0x0062, B:13:0x006b, B:15:0x0078, B:17:0x0081, B:19:0x008f, B:21:0x0098, B:26:0x00a8, B:28:0x00d6, B:37:0x00fe, B:39:0x0112, B:41:0x0122, B:43:0x012f, B:45:0x013c, B:47:0x014c, B:49:0x0161, B:64:0x01b6, B:52:0x0170, B:55:0x0183, B:59:0x0195, B:61:0x01a2, B:79:0x01f7, B:81:0x0201, B:83:0x0211, B:95:0x0278, B:97:0x0282, B:99:0x028a, B:101:0x029f, B:103:0x02a8, B:107:0x02b8, B:109:0x02c0, B:111:0x02c9, B:115:0x02d9, B:117:0x02e1, B:119:0x02ea, B:123:0x02fa, B:125:0x0302, B:127:0x030b, B:129:0x0318, B:131:0x0321, B:133:0x032e, B:135:0x0337, B:137:0x0344, B:139:0x034d, B:141:0x035a, B:143:0x0363, B:145:0x0370, B:147:0x0379, B:149:0x0387, B:151:0x038e, B:156:0x039d, B:158:0x03aa, B:161:0x0412, B:163:0x041b, B:165:0x0428, B:167:0x0431, B:169:0x043e, B:171:0x0447, B:159:0x03c2, B:154:0x0398, B:86:0x0225, B:88:0x022f, B:90:0x023f, B:93:0x0253, B:75:0x01ec, B:6:0x0043, B:66:0x01be, B:68:0x01c7, B:73:0x01da, B:74:0x01e3, B:4:0x0036), top: B:192:0x0000, inners: #0, #3, #4 }] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject r5) {
        /*
            Method dump skipped, instructions count: 1163
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.g.parseAction(org.json.JSONObject):com.igexin.push.extension.mod.BaseActionBean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean r8, com.igexin.push.extension.mod.BaseActionBean r9) {
        /*
            r7 = this;
            r0 = r9
            boolean r0 = r0 instanceof com.igexin.push.core.b.k
            if (r0 == 0) goto Lb2
            r0 = r9
            com.igexin.push.core.b.k r0 = (com.igexin.push.core.b.k) r0
            r12 = r0
            r0 = r12
            java.lang.String r0 = r0.g
            r13 = r0
            r0 = r12
            java.lang.String r0 = r0.w
            r14 = r0
            r0 = r8
            java.lang.String r0 = r0.getTaskId()
            r15 = r0
            r0 = r8
            java.lang.String r0 = r0.getMessageId()
            r8 = r0
            r0 = 1
            r11 = r0
            r0 = r14
            if (r0 == 0) goto L52
            r0 = r14
            java.lang.String r0 = com.igexin.push.f.j.a(r0)
            r16 = r0
            r0 = r16
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4b
            r0 = r12
            r1 = 0
            r0.C = r1
            r0 = 1
            r10 = r0
            goto L54
        L4b:
            r0 = r12
            r1 = r16
            r0.A = r1
        L52:
            r0 = 0
            r10 = r0
        L54:
            r0 = r13
            if (r0 == 0) goto L7b
            r0 = r13
            java.lang.String r0 = com.igexin.push.f.j.a(r0)
            r16 = r0
            java.lang.String r0 = ""
            r1 = r16
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L74
            r0 = r12
            r1 = 0
            r0.B = r1
            goto L7e
        L74:
            r0 = r12
            r1 = r16
            r0.z = r1
        L7b:
            r0 = 0
            r11 = r0
        L7e:
            r0 = r11
            if (r0 != 0) goto L8e
            r0 = r10
            if (r0 == 0) goto L8a
            goto L8e
        L8a:
            com.igexin.push.extension.mod.PushMessageInterface$ActionPrepareState r0 = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success
            return r0
        L8e:
            r0 = r11
            if (r0 == 0) goto L9e
            r0 = r7
            r1 = r13
            r2 = r15
            r3 = r8
            r4 = r9
            r5 = 2
            r0.a(r1, r2, r3, r4, r5)
        L9e:
            r0 = r10
            if (r0 == 0) goto Lae
            r0 = r7
            r1 = r14
            r2 = r15
            r3 = r8
            r4 = r9
            r5 = 8
            r0.a(r1, r2, r3, r4, r5)
        Lae:
            com.igexin.push.extension.mod.PushMessageInterface$ActionPrepareState r0 = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.wait
            return r0
        Lb2:
            com.igexin.push.extension.mod.PushMessageInterface$ActionPrepareState r0 = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.g.prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean, com.igexin.push.extension.mod.BaseActionBean):com.igexin.push.extension.mod.PushMessageInterface$ActionPrepareState");
    }
}

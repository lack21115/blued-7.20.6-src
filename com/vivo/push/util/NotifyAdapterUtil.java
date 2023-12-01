package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/NotifyAdapterUtil.class */
public class NotifyAdapterUtil {
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static NotificationManager sNotificationManager;
    private static int sNotifyId = 20000000;

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }

    private static boolean cancelNotify(Context context, int i) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(i);
            return true;
        }
        return false;
    }

    private static void initAdapter(Context context) {
        synchronized (NotifyAdapterUtil.class) {
            try {
                if (sNotificationManager == null) {
                    sNotificationManager = (NotificationManager) context.getSystemService("notification");
                }
                if (Build.VERSION.SDK_INT >= 26 && sNotificationManager != null) {
                    NotificationChannel notificationChannel = sNotificationManager.getNotificationChannel("default");
                    if (notificationChannel != null) {
                        CharSequence name = notificationChannel.getName();
                        if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                            sNotificationManager.deleteNotificationChannel("default");
                        }
                    }
                    NotificationChannel notificationChannel2 = new NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
                    notificationChannel2.setLightColor(Color.GREEN);
                    notificationChannel2.enableVibration(true);
                    notificationChannel2.setLockscreenVisibility(1);
                    sNotificationManager.createNotificationChannel(notificationChannel2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith(com.anythink.expressad.video.dynview.a.a.V);
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, r.a aVar) {
        p.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        int i2 = notifyMode;
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            i2 = notifyMode;
            if (list != null) {
                i2 = notifyMode;
                if (list.size() > 1) {
                    i2 = notifyMode;
                    if (list.get(1) != null) {
                        i2 = 1;
                    }
                }
            }
        }
        if (i2 == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, aVar);
        } else if (i2 == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, aVar);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(2:3|(1:5))(2:96|(1:98)(21:99|7|(1:9)|10|(1:12)(1:95)|13|(3:91|(1:93)|94)(1:19)|20|(2:22|(1:24))|25|(3:27|(1:29)(1:89)|30)(1:90)|31|(1:35)|36|(2:38|(2:40|(4:42|(1:44)|45|(1:47)))(2:83|(1:85)))(2:86|(1:88))|48|49|50|(1:52)|54|(3:56|57|(2:59|(2:61|62)(1:64))(2:65|(2:67|(2:69|70)(1:71))(2:72|73)))(1:80)))|6|7|(0)|10|(0)(0)|13|(1:15)|91|(0)|94|20|(0)|25|(0)(0)|31|(2:33|35)|36|(0)(0)|48|49|50|(0)|54|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x03f0, code lost:
        r18 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x03f2, code lost:
        com.vivo.push.util.p.a(com.vivo.push.util.NotifyAdapterUtil.TAG, "pushNotificationByCustom encrypt ：" + r18.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03bf A[Catch: Exception -> 0x03f0, TRY_LEAVE, TryCatch #0 {Exception -> 0x03f0, blocks: (B:68:0x03a5, B:70:0x03bf), top: B:95:0x03a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x043a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void pushNotificationByCustom(android.content.Context r7, java.util.List<android.graphics.Bitmap> r8, com.vivo.push.model.InsideNotificationItem r9, long r10, com.vivo.push.d.r.a r12) {
        /*
            Method dump skipped, instructions count: 1190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.NotifyAdapterUtil.pushNotificationByCustom(android.content.Context, java.util.List, com.vivo.push.model.InsideNotificationItem, long, com.vivo.push.d.r$a):void");
    }

    private static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, r.a aVar) {
        Bitmap bitmap;
        Notification.Builder builder;
        Bitmap decodeResource;
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        String content = insideNotificationItem.getContent();
        int i2 = context.getApplicationInfo().icon;
        boolean isShowTime = insideNotificationItem.isShowTime();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        if (list == null || list.isEmpty()) {
            bitmap = null;
        } else {
            bitmap = list.get(0);
            if (bitmap != null && defaultNotifyIcon > 0 && (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) != null) {
                int width = decodeResource.getWidth();
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = c.a(bitmap, width, height);
            }
        }
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder builder2 = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder = builder2;
            if (bitmap != null) {
                builder = builder2;
                builder.setLargeIcon(bitmap);
            }
        } else {
            Notification.Builder builder3 = new Notification.Builder(context);
            if (bitmap != null) {
                builder = builder3;
                builder.setLargeIcon(bitmap);
            } else {
                builder = builder3;
                if (Build.VERSION.SDK_INT <= 22) {
                    builder3.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i2));
                    builder = builder3;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            bundle.putLong("pushId", j);
            builder.setExtras(bundle);
        }
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i2 = defaultSmallIconId;
        }
        builder.setSmallIcon(i2);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builder.setContentTitle(title);
        }
        builder.setPriority(2);
        builder.setContentText(content);
        builder.setWhen(isShowTime ? System.currentTimeMillis() : 0L);
        builder.setShowWhen(isShowTime);
        builder.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
        } else if (ringerMode == 2) {
            builder.setDefaults(1);
        }
        Bitmap bitmap2 = (list == null || list.size() <= 1) ? null : list.get(1);
        if (i != 1) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(title);
            bigTextStyle.bigText(content);
            builder.setStyle(bigTextStyle);
        }
        if (bitmap2 != null) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(title);
            bigPictureStyle.setSummaryText(content);
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        builder.setAutoCancel(true);
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            if (Build.VERSION.SDK_INT >= 18) {
                intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", u.a(com.vivo.push.c.d.a(context).a().a()));
            }
        } catch (Exception e) {
            p.a(TAG, "pushNotificationBySystem encrypt ：" + e.getMessage());
        }
        new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(intent);
        builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456));
        Notification build = builder.build();
        int k = com.vivo.push.e.a().k();
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager != null) {
            try {
                if (k == 0) {
                    notificationManager.notify(sNotifyId, build);
                    if (aVar != null) {
                        aVar.a();
                    }
                } else if (k != 1) {
                    p.a(TAG, "unknow notify style ".concat(String.valueOf(k)));
                } else {
                    notificationManager.notify((int) j, build);
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            } catch (Exception e2) {
                p.a(TAG, e2);
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    public static boolean repealNotifyById(Context context, long j) {
        int k = com.vivo.push.e.a().k();
        if (k != 0) {
            if (k == 1) {
                return cancelNotify(context, (int) j);
            }
            p.a(TAG, "unknow cancle notify style ".concat(String.valueOf(k)));
            return false;
        }
        long b = w.b().b("com.vivo.push.notify_key", -1L);
        if (b == j) {
            p.d(TAG, "undo showed message ".concat(String.valueOf(j)));
            p.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
            return cancelNotify(context, sNotifyId);
        }
        p.d(TAG, "current showing message id " + b + " not match " + j);
        p.a(context, "与已展示的通知" + b + "与待回收的通知" + j + "不匹配");
        return false;
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }
}

package com.blued.android.framework.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.blued.android.core.AppInfo;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/push/NotificationSender.class */
public class NotificationSender {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9843a = NotificationSender.class.getSimpleName();
    private static NotificationSender b;

    /* renamed from: c  reason: collision with root package name */
    private NotificationManager f9844c;

    private NotificationManager a(NotificationChannel notificationChannel) {
        NotificationManager notificationManager;
        if (this.f9844c == null) {
            this.f9844c = (NotificationManager) AppInfo.d().getSystemService("notification");
        }
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = this.f9844c) != null && notificationChannel != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return this.f9844c;
    }

    public static NotificationSender a() {
        if (b == null) {
            synchronized (NotificationSender.class) {
                try {
                    if (b == null) {
                        b = new NotificationSender();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private NotificationChannel b(NotificationModel notificationModel) {
        NotificationChannel notificationChannel = new NotificationChannel("blued", "Blued", 4);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        if (notificationModel.getRemindEnable()) {
            if (notificationModel.getShakeEnable() && notificationModel.getVoiceEnable()) {
                NotificationChannel notificationChannel2 = new NotificationChannel("blued.sound.vibrate", "Blued", 4);
                if (notificationModel.getInnerVoiceEnable()) {
                    notificationChannel2 = new NotificationChannel("blued.bSound.vibrate", "Blued", 4);
                    notificationChannel2.setSound(notificationModel.getSoundFileUri(), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
                notificationChannel2.enableVibration(true);
                notificationChannel2.setVibrationPattern(new long[]{0, 100, 200, 300});
                return notificationChannel2;
            } else if (notificationModel.getShakeEnable()) {
                NotificationChannel notificationChannel3 = new NotificationChannel("blued.vibrate", "Blued", 4);
                notificationChannel3.setSound(null, null);
                notificationChannel3.enableVibration(true);
                notificationChannel3.setVibrationPattern(new long[]{0, 100, 200, 300});
                return notificationChannel3;
            } else if (notificationModel.getVoiceEnable()) {
                if (notificationModel.getInnerVoiceEnable()) {
                    NotificationChannel notificationChannel4 = new NotificationChannel("blued.bSound", "Blued", 4);
                    notificationChannel4.setSound(notificationModel.getSoundFileUri(), null);
                    return notificationChannel4;
                }
                return new NotificationChannel("blued.sound", "Blued", 4);
            }
        }
        return notificationChannel;
    }

    public void a(int i) {
        a((NotificationChannel) null).cancel(i);
    }

    public void a(NotificationModel notificationModel) {
        int iconResId = notificationModel.getIconResId();
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = notificationModel.getIntent();
        PendingIntent activity = PendingIntent.getActivity(AppInfo.d(), 134217728, intent, 134217728);
        if (notificationModel.intent_flag == 1) {
            activity = PendingIntent.getBroadcast(AppInfo.d(), 134217728, intent, 134217728);
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(AppInfo.d()).setSmallIcon(iconResId).setTicker(notificationModel.getTickerText()).setWhen(currentTimeMillis).setAutoCancel(true).setContentIntent(activity).setContentTitle(notificationModel.getContentTitle()).setContentText(notificationModel.getContentText());
        if (notificationModel.getBitmap() != null) {
            contentText.setLargeIcon(notificationModel.getBitmap());
        } else if (notificationModel.getBitmapDef() != null) {
            contentText.setLargeIcon(notificationModel.getBitmapDef());
        }
        NotificationChannel notificationChannel = null;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationChannel = b(notificationModel);
            contentText.setChannelId(notificationChannel.getId());
        }
        if (notificationModel.getStyle() != null) {
            contentText.setStyle(notificationModel.getStyle());
            contentText.setVisibility(1);
            contentText.setPriority(0);
        }
        Notification build = contentText.build();
        if (notificationModel.getRemindEnable()) {
            if (notificationModel.getShakeEnable() && notificationModel.getVoiceEnable()) {
                if (notificationModel.getInnerVoiceEnable()) {
                    build.sound = notificationModel.getSoundFileUri();
                } else {
                    build.defaults = 1;
                }
                build.defaults |= 2;
            } else if (notificationModel.getShakeEnable()) {
                build.defaults |= 2;
            } else if (notificationModel.getVoiceEnable()) {
                if (notificationModel.getInnerVoiceEnable()) {
                    build.sound = notificationModel.getSoundFileUri();
                } else {
                    build.defaults = 1;
                }
            }
        }
        build.defaults |= 4;
        build.flags |= 16;
        build.flags |= 1;
        try {
            a(notificationChannel).notify(notificationModel.getId(), build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

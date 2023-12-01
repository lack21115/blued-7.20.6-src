package im.zego.internal.screencapture;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

/* loaded from: source-8829756-dex2jar.jar:im/zego/internal/screencapture/ZegoScreenCaptureService.class */
public class ZegoScreenCaptureService extends Service {

    /* loaded from: source-8829756-dex2jar.jar:im/zego/internal/screencapture/ZegoScreenCaptureService$ZegoScreenCaptureLocalBinder.class */
    class ZegoScreenCaptureLocalBinder extends Binder {
        private ZegoScreenCaptureLocalBinder() {
        }
    }

    private void a() {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("notification_id");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
        }
        Notification build = builder.build();
        build.defaults = 1;
        startForeground(110, build);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a();
        return new ZegoScreenCaptureLocalBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        stopForeground(true);
        return super.onUnbind(intent);
    }
}

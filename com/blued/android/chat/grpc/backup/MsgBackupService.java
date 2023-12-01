package com.blued.android.chat.grpc.backup;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.chat.grpc.utils.ChatLog;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/MsgBackupService.class */
public class MsgBackupService extends Service {
    public static final String INTENT_KEY_CONTENT = "CONTENT";
    public static final String INTENT_KEY_FILE_PATH = "FILE_PATH";
    public static final String INTENT_KEY_ICON_RES_ID = "ICON_RES_ID";
    public static final String INTENT_KEY_IS_RESTORE = "IS_RESTORE";
    public static final String INTENT_KEY_NOTIFY_ID = "NOTIFY_ID";
    public static final String INTENT_KEY_SELECTED_SESSION_ID = "SELECTED_SESSION_ID";
    public static final String INTENT_KEY_SUCCEED_MSG = "SUCCEED_MSG";
    public static final String INTENT_KEY_TITLE = "TITLE";
    public static final String INTENT_KEY_UPLOAD_SERVICE_CLASS = "UPLOAD_SERVICE_CLASS";
    private static volatile boolean isRunning = false;
    private String content;
    private String filePath;
    private Handler handler = new Handler(Looper.getMainLooper());
    private int iconResId;
    private boolean isRestore;
    private int notificationId;
    private List<Long> selectedSessionIds;
    private String succeedMsg;
    private String title;
    private Class uploadServiceClass;

    /* JADX INFO: Access modifiers changed from: private */
    public Notification createForegroundNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("msg_backup", "Foreground_Service", 4);
            notificationChannel.setDescription("msg_backup");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setVibrationPattern(new long[]{0, 0, 0, 0});
            notificationChannel.enableVibration(false);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "msg_backup");
        builder.setSmallIcon(this.iconResId);
        builder.setContentTitle(this.title);
        builder.setContentText(this.content);
        builder.setWhen(System.currentTimeMillis());
        return builder.build();
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void startMsgBackupService(Context context, int i, int i2, String str, String str2, String str3, String str4, List<Long> list, Class cls) {
        Intent intent = new Intent();
        intent.putExtra(INTENT_KEY_NOTIFY_ID, i);
        intent.putExtra(INTENT_KEY_ICON_RES_ID, i2);
        intent.putExtra(INTENT_KEY_TITLE, str);
        intent.putExtra(INTENT_KEY_CONTENT, str2);
        intent.putExtra(INTENT_KEY_SUCCEED_MSG, str3);
        intent.putExtra(INTENT_KEY_FILE_PATH, str4);
        intent.putExtra(INTENT_KEY_IS_RESTORE, false);
        intent.putExtra(INTENT_KEY_SELECTED_SESSION_ID, (Serializable) list);
        intent.putExtra(INTENT_KEY_UPLOAD_SERVICE_CLASS, cls);
        intent.setClass(context, MsgBackupService.class);
        context.startService(intent);
    }

    public static void startMsgRestoreService(Context context, int i, int i2, String str, String str2, String str3, String str4) {
        Intent intent = new Intent();
        intent.putExtra(INTENT_KEY_NOTIFY_ID, i);
        intent.putExtra(INTENT_KEY_ICON_RES_ID, i2);
        intent.putExtra(INTENT_KEY_TITLE, str);
        intent.putExtra(INTENT_KEY_CONTENT, str2);
        intent.putExtra(INTENT_KEY_SUCCEED_MSG, str3);
        intent.putExtra(INTENT_KEY_FILE_PATH, str4);
        intent.putExtra(INTENT_KEY_IS_RESTORE, true);
        intent.setClass(context, MsgBackupService.class);
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        List<Long> list;
        isRunning = true;
        this.notificationId = intent.getIntExtra(INTENT_KEY_NOTIFY_ID, 0);
        this.iconResId = intent.getIntExtra(INTENT_KEY_ICON_RES_ID, 0);
        this.title = intent.getStringExtra(INTENT_KEY_TITLE);
        this.content = intent.getStringExtra(INTENT_KEY_CONTENT);
        this.succeedMsg = intent.getStringExtra(INTENT_KEY_SUCCEED_MSG);
        this.filePath = intent.getStringExtra(INTENT_KEY_FILE_PATH);
        this.isRestore = intent.getBooleanExtra(INTENT_KEY_IS_RESTORE, false);
        this.selectedSessionIds = (List) intent.getSerializableExtra(INTENT_KEY_SELECTED_SESSION_ID);
        this.uploadServiceClass = (Class) intent.getSerializableExtra(INTENT_KEY_UPLOAD_SERVICE_CLASS);
        if (this.isRestore) {
            MsgBackupManager.getInstance().restoreMsgDb(this.filePath, new MsgBackupManager.ReserveListener() { // from class: com.blued.android.chat.grpc.backup.MsgBackupService.1
                @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
                public void onError(final String str) {
                    MsgBackupService.this.handler.post(new Runnable() { // from class: com.blued.android.chat.grpc.backup.MsgBackupService.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(MsgBackupService.this, str, 1).show();
                        }
                    });
                    MsgBackupService.this.stopSelf();
                }

                @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
                public void onReserveSucceed(String str) {
                }

                @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
                public void onRestoreSucceed() {
                    if (!TextUtils.isEmpty(MsgBackupService.this.succeedMsg)) {
                        MsgBackupService.this.handler.post(new Runnable() { // from class: com.blued.android.chat.grpc.backup.MsgBackupService.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(MsgBackupService.this, MsgBackupService.this.succeedMsg, 0).show();
                            }
                        });
                    }
                    MsgBackupService.this.stopSelf();
                }

                @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
                public void onStart() {
                    Notification createForegroundNotification = MsgBackupService.this.createForegroundNotification();
                    createForegroundNotification.flags |= 32;
                    MsgBackupService msgBackupService = MsgBackupService.this;
                    msgBackupService.startForeground(msgBackupService.notificationId, createForegroundNotification);
                }
            });
            return 1;
        }
        if (ChatManager.debug && (list = this.selectedSessionIds) != null) {
            for (Long l : list) {
                String simpleName = MsgBackupService.class.getSimpleName();
                ChatLog.d(simpleName, "selectedSessionIds ：" + l);
            }
        }
        MsgBackupManager.getInstance().reserveMsgDb(this.filePath, this.selectedSessionIds, new MsgBackupManager.ReserveListener() { // from class: com.blued.android.chat.grpc.backup.MsgBackupService.2
            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onError(final String str) {
                MsgBackupService.this.handler.post(new Runnable() { // from class: com.blued.android.chat.grpc.backup.MsgBackupService.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(MsgBackupService.this, str, 1).show();
                    }
                });
                MsgBackupService.this.stopSelf();
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onReserveSucceed(String str) {
                if (ChatManager.debug) {
                    String simpleName2 = MsgBackupService.class.getSimpleName();
                    ChatLog.d(simpleName2, "onReserveSucceed ：" + str);
                }
                if (MsgBackupService.this.uploadServiceClass != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(MsgBackupService.INTENT_KEY_FILE_PATH, str);
                    MsgBackupService msgBackupService = MsgBackupService.this;
                    intent2.setClass(msgBackupService, msgBackupService.uploadServiceClass);
                    MsgBackupService.this.startService(intent2);
                } else if (!TextUtils.isEmpty(MsgBackupService.this.succeedMsg)) {
                    MsgBackupService.this.handler.post(new Runnable() { // from class: com.blued.android.chat.grpc.backup.MsgBackupService.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(MsgBackupService.this, MsgBackupService.this.succeedMsg, 0).show();
                        }
                    });
                }
                MsgBackupService.this.stopSelf();
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onRestoreSucceed() {
            }

            @Override // com.blued.android.chat.grpc.backup.MsgBackupManager.ReserveListener
            public void onStart() {
            }
        });
        return 1;
    }
}

package com.ss.android.socialbase.appdownloader.h;

import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/h/mb.class */
public class mb extends AbsNotificationItem {
    private String b;
    private String h;
    private String hj;
    private final Context mb;
    private final Resources ox;

    public mb(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.hj = str2;
        this.b = str3;
        this.h = str4;
        Context applicationContext = context.getApplicationContext();
        this.mb = applicationContext;
        this.ox = applicationContext.getResources();
    }

    private int mb(int i) {
        return DownloadSetting.obtain(i).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 1 ? h.ww() : h.ko();
    }

    private int mb(int i, int i2) {
        if (DownloadSetting.obtain(i2).optInt("notification_opt_2") == 1) {
            return h.df();
        }
        int i3 = 0;
        if (i == 1 || i == 4) {
            i3 = h.gm();
        } else if (i == 2) {
            return h.g();
        } else {
            if (i == 3) {
                return h.df();
            }
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0518, code lost:
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(r11) != false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0705, code lost:
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(r11) != false) goto L130;
     */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x08d9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x08eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification mb(com.ss.android.socialbase.downloader.exception.BaseException r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 2296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.h.mb.mb(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    private PendingIntent mb(String str, int i, int i2) {
        Intent intent = new Intent(this.mb, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.mb, i2, intent, 201326592);
    }

    private RemoteViews mb() {
        RemoteViews remoteViews = new RemoteViews(this.mb.getPackageName(), h.mb());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.b.mb(this.mb)) {
                    remoteViews.setInt(h.u(), "setBackgroundColor", this.mb.getResources().getColor(h.l()));
                }
            } catch (Throwable th) {
                return remoteViews;
            }
        }
        return remoteViews;
    }

    private boolean mb(BaseException baseException, DownloadSetting downloadSetting, DownloadInfo downloadInfo) {
        if (baseException != null) {
            return (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && downloadSetting.optInt(DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
        }
        return false;
    }

    private NotificationCompat.Builder ox() {
        String lz = com.ss.android.socialbase.appdownloader.hj.x().lz();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.mb);
        }
        String str = lz;
        if (TextUtils.isEmpty(lz)) {
            str = com.ss.android.socialbase.appdownloader.b.ox(this.mb);
        }
        try {
            return com.ss.android.socialbase.appdownloader.hj.x().jb() != null ? com.ss.android.socialbase.appdownloader.hj.x().jb().mb(this.mb, str) : new NotificationCompat.Builder(this.mb, str);
        } catch (NoSuchMethodError e) {
            return new NotificationCompat.Builder(this.mb);
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(BaseException baseException, boolean z) {
        if (this.mb == null) {
            return;
        }
        try {
            this.notification = mb(baseException, z);
            notify(this.notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.hj = downloadInfo.getSavePath();
        this.b = downloadInfo.getName();
        this.h = downloadInfo.getExtra();
    }
}

package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.applog.tracker.Tracker;
import com.ss.android.socialbase.appdownloader.b.b;
import com.ss.android.socialbase.appdownloader.b.hj;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.lz;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/view/DownloadTaskDeleteActivity.class */
public class DownloadTaskDeleteActivity extends Activity {
    private jb mb;
    private Intent ox;

    private void mb() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(DownloadInfo downloadInfo, int i) {
        hj ox = com.ss.android.socialbase.appdownloader.hj.x().ox();
        if (ox != null) {
            ox.mb(downloadInfo);
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(10, downloadInfo, "", "");
        }
        if (DownloadComponentManager.getAppContext() != null) {
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i);
        }
    }

    private void ox() {
        Intent intent;
        if (this.mb != null || (intent = this.ox) == null) {
            return;
        }
        try {
            final int intExtra = intent.getIntExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                Log.w("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String format = String.format(getString(lz.mb(this, "tt_appdownloader_notification_download_delete")), title);
            b mb = com.ss.android.socialbase.appdownloader.hj.x().mb();
            com.ss.android.socialbase.appdownloader.hj.mb mbVar = null;
            if (mb != null) {
                mbVar = mb.mb(this);
            }
            com.ss.android.socialbase.appdownloader.hj.mb mbVar2 = mbVar;
            if (mbVar == null) {
                mbVar2 = new com.ss.android.socialbase.appdownloader.hj.mb(this);
            }
            if (mbVar2 != null) {
                int mb2 = lz.mb(this, "tt_appdownloader_tip");
                int mb3 = lz.mb(this, "tt_appdownloader_label_ok");
                int mb4 = lz.mb(this, "tt_appdownloader_label_cancel");
                boolean z = false;
                if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.CANCEL_WITH_NET_OPT, 0) == 1) {
                    z = false;
                    if (DownloadUtils.isNoWifiAndInNet()) {
                        z = false;
                        if (downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                            z = true;
                        }
                    }
                }
                String str = format;
                if (z) {
                    mb3 = lz.mb(this, "tt_appdownloader_label_reserve_wifi");
                    mb4 = lz.mb(this, "tt_appdownloader_label_cancel_directly");
                    str = getResources().getString(lz.mb(this, "tt_appdownloader_resume_in_wifi"));
                }
                final boolean z2 = z;
                final boolean z3 = z;
                mbVar2.mb(mb2).mb(str).mb(mb3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        if (z2) {
                            downloadInfo.setOnlyWifi(true);
                            Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                                }
                            }, 100L);
                        } else {
                            DownloadTaskDeleteActivity.this.mb(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).ox(mb4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        if (z3) {
                            DownloadTaskDeleteActivity.this.mb(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).mb(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.mb = mbVar2.mb();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.ox = getIntent();
        ox();
        jb jbVar = this.mb;
        if (jbVar != null && !jbVar.ox()) {
            this.mb.mb();
        } else if (this.mb == null) {
            finish();
        }
    }
}

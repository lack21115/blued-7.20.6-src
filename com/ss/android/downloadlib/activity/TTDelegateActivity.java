package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadad.api.mb.ox;
import com.ss.android.downloadlib.addownload.je;
import com.ss.android.downloadlib.addownload.mb.hj;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.downloadlib.guide.install.mb;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.downloadlib.utils.ko;
import com.ss.android.downloadlib.utils.lz;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/activity/TTDelegateActivity.class */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static mb hj;
    private ox b;
    protected Intent mb = null;
    private boolean ox;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/activity/TTDelegateActivity$IntentType.class */
    public @interface IntentType {
        public static final int AD_LP_APPINFO_DIALOG = 10;
        public static final int APK_INSTALL = 9;
        public static final int APK_SIZE_RETAIN = 8;
        public static final int DOWNLOAD_PERCENT_RETAIN = 7;
        public static final int INSTALL_GUIDE = 6;
        public static final int INTENT_CLEAN_DISK_SPACE = 3;
        public static final int OPEN_APP_DIALOG = 4;
        public static final int OPEN_URL = 2;
        public static final int OPEN_V1_MARKET = 12;
        public static final int PACKAGE_NAME = 11;
        public static final int REQUEST_PERMISSION = 1;
        public static final int REVERSE_WIFI_DIALOG = 5;
    }

    private static Intent b(com.ss.android.downloadad.api.mb.mb mbVar) {
        return new Intent(x.getContext(), TTDelegateActivity.class);
    }

    private void b() {
        CharSequence charSequence;
        long longExtra = this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L);
        String stringExtra = this.mb.getStringExtra("message_text");
        String stringExtra2 = this.mb.getStringExtra("positive_button_text");
        String stringExtra3 = this.mb.getStringExtra("negative_button_text");
        int intExtra = this.mb.getIntExtra("type", 0);
        ox hj2 = u.mb().hj(longExtra);
        hj.mb b = new hj.mb(this).mb(false).mb(stringExtra).ox(stringExtra2).b(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.b.ox.mb() == null) {
                return;
            }
            b.mb(com.ss.android.downloadlib.addownload.b.ox.mb());
            b.mb().show();
            charSequence = "download_percent";
        } else if (intExtra != 8) {
            charSequence = "";
        } else if (com.ss.android.downloadlib.addownload.b.mb.mb() == null) {
            return;
        } else {
            b.mb(com.ss.android.downloadlib.addownload.b.mb.mb());
            b.mb().show();
            charSequence = EventConstants.ExtraJson.APK_SIZE;
        }
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.ox = true;
        this.b = hj2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, charSequence);
            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, "show_dialog");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, hj2);
    }

    private void b(long j) {
        final ox hj2 = u.mb().hj(j);
        if (hj2 == null) {
            b.mb().mb("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
            return;
        }
        x.b().ox(new DownloadAlertDialogInfo.mb(this).mb("已安装完成").ox(String.format("%1$s已安装完成，是否立即打开？", TextUtils.isEmpty(hj2.pa()) ? "刚刚下载的应用" : hj2.pa())).b("打开").hj("取消").mb(false).mb(jb.b(this, hj2.h())).mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void b(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.b.mb((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void mb(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.ox.mb.ox(hj2);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.b.mb((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void ox(DialogInterface dialogInterface) {
                AdEventHandler.mb().ox(EventConstants.Label.OPEN_APP_DIALOG_CANCEL, hj2);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.b.mb((Activity) TTDelegateActivity.this);
            }
        }).mb(2).mb());
        AdEventHandler.mb().ox(EventConstants.Label.OPEN_APP_DIALOG_SHOW, hj2);
    }

    private void hj(long j) {
        new com.ss.android.downloadlib.addownload.compliance.mb(this, j).show();
    }

    public static void mb(long j) {
        Intent intent = new Intent(x.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (x.getContext() != null) {
            x.getContext().startActivity(intent);
        }
    }

    public static void mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent b = b(mbVar);
        b.addFlags(268435456);
        b.putExtra("type", 4);
        b.putExtra(EventConstants.ExtraJson.MODEL_ID, mbVar.ox());
        if (x.getContext() != null) {
            x.getContext().startActivity(b);
        }
    }

    private static void mb(com.ss.android.downloadad.api.mb.mb mbVar, int i, String str, String str2, String str3) {
        Intent b = b(mbVar);
        b.addFlags(268435456);
        b.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            b.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            b.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            b.putExtra("message_text", str);
        }
        b.putExtra(EventConstants.ExtraJson.MODEL_ID, mbVar.ox());
        if (x.getContext() != null) {
            x.getContext().startActivity(b);
        }
    }

    public static void mb(com.ss.android.downloadad.api.mb.mb mbVar, mb mbVar2) {
        Intent b = b(mbVar);
        b.addFlags(268435456);
        b.putExtra("type", 9);
        hj = mbVar2;
        if (x.getContext() != null) {
            x.getContext().startActivity(b);
        }
    }

    public static void mb(com.ss.android.downloadad.api.mb.mb mbVar, String str, String str2, String str3) {
        mb(mbVar, 8, str, str2, str3);
    }

    private void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
                intent.addFlags(268435456);
                if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }

    public static void mb(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(x.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra(EventConstants.ExtraJson.MODEL_ID, j);
        intent.putExtra(RemoteMessageConst.MessageBody.PARAM, str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (x.getContext() != null) {
            x.getContext().startActivity(intent);
        }
    }

    public static void mb(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent b = b(mbVar);
        b.addFlags(268435456);
        b.putExtra("type", 2);
        b.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
        if (x.getContext() != null) {
            x.getContext().startActivity(b);
        }
    }

    public static void mb(String str, String[] strArr) {
        Intent intent = new Intent(x.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (x.getContext() != null) {
            x.getContext().startActivity(intent);
        }
    }

    private void ox() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void ox(long j) {
        if (je.mb() == null) {
            return;
        }
        ox hj2 = u.mb().hj(j);
        if (hj2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(hj2.m());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.TIME_AFTER_CLICK, Long.valueOf(System.currentTimeMillis() - hj2.sa()));
                jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_SIZE, Long.valueOf(hj2.sr()));
                if (downloadInfo != null) {
                    jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_LENGTH, Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_APK_SIZE, Long.valueOf(downloadInfo.getTotalBytes()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_DIALOG_SHOW, jSONObject, hj2);
        }
        new hj.mb(this).mb(false).mb(je.mb()).mb().show();
        this.ox = true;
        this.b = hj2;
    }

    public static void ox(com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(mbVar, 5, "", "", "");
    }

    public static void ox(com.ss.android.downloadad.api.mb.mb mbVar, String str, String str2, String str3) {
        mb(mbVar, 7, str, str2, str3);
    }

    private void ox(String str) {
        Intent u = jb.u(this, str);
        if (u == null) {
            return;
        }
        try {
            try {
                u.addFlags(268435456);
                u.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(u);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }

    public static void ox(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent b = b(mbVar);
        b.addFlags(268435456);
        b.putExtra("type", 11);
        b.putExtra("package_name", str);
        if (x.getContext() != null) {
            x.getContext().startActivity(b);
        }
    }

    private void ox(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
            return;
        }
        gm gmVar = new gm() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            private WeakReference<Activity> b;

            {
                this.b = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.config.gm
            public void mb() {
                lz.mb(str);
                com.ss.android.socialbase.appdownloader.b.mb(this.b.get());
            }

            @Override // com.ss.android.download.api.config.gm
            public void mb(String str2) {
                lz.mb(str, str2);
                com.ss.android.socialbase.appdownloader.b.mb(this.b.get());
            }
        };
        if (Build.VERSION.SDK_INT < 23) {
            gmVar.mb();
            return;
        }
        try {
            x.h().mb(this, strArr, gmVar);
        } catch (Exception e) {
            x.m().mb(e, "requestPermission");
            gmVar.mb();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void mb() {
        Intent intent = this.mb;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                ox(this.mb.getStringExtra("permission_id_key"), this.mb.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                mb(this.mb.getStringExtra(EventConstants.ExtraJson.OPEN_URL));
                break;
            case 3:
            case 6:
            default:
                com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
                break;
            case 4:
                b(this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L));
                break;
            case 5:
                ox(this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L));
                break;
            case 7:
            case 8:
                b();
                break;
            case 9:
                mb mbVar = hj;
                if (mbVar != null) {
                    mbVar.mb();
                }
                com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
                break;
            case 10:
                hj(this.mb.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                ox(this.mb.getStringExtra("package_name"));
                break;
            case 12:
                ko.mb(this, this.mb.getStringExtra("package_name"), this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L), this.mb.getStringExtra(RemoteMessageConst.MessageBody.PARAM), this.mb.getStringExtra("ext_json"));
                com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
                break;
        }
        this.mb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ox();
        this.mb = getIntent();
        x.ox(this);
        mb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.mb = intent;
        x.ox(this);
        mb();
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        x.h().mb(this, i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        DownloadInfo ox;
        super.onStop();
        if (!this.ox || this.b == null || (ox = ww.mb((Context) null).ox(this.b.mb())) == null || ox.getCurBytes() < ox.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }
}

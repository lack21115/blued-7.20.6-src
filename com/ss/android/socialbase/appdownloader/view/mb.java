package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.appdownloader.h.hj;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/view/mb.class */
public class mb extends Fragment {
    private Context h() {
        Context appContext = DownloadComponentManager.getAppContext();
        Context context = appContext;
        if (appContext == null) {
            context = appContext;
            if (getActivity() != null) {
                context = appContext;
                if (!getActivity().isFinishing()) {
                    context = getActivity().getApplicationContext();
                }
            }
        }
        return context;
    }

    public static Intent hj() {
        return new Intent(Settings.ACTION_APPLICATION_SETTINGS);
    }

    private Intent u() {
        Context h = h();
        if (h == null) {
            return null;
        }
        Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        String packageName = h.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
        int i = h.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra(Settings.EXTRA_APP_UID, i);
        return intent;
    }

    public Intent b() {
        Context h = h();
        if (h == null) {
            return null;
        }
        return new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + h.getPackageName()));
    }

    public void mb() {
        try {
            startActivityForResult(u(), 1000);
        } catch (Throwable th) {
            try {
                startActivityForResult(ox(), 1000);
            } catch (Throwable th2) {
                try {
                    startActivityForResult(b(), 1000);
                } catch (Throwable th3) {
                    startActivityForResult(hj(), 1000);
                }
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (hj.mb()) {
            hj.mb(true);
        } else {
            hj.mb(false);
        }
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    public Intent ox() {
        Context h = h();
        if (h == null) {
            return null;
        }
        String packageName = h.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(DownloadConstants.LOWER_OPPO)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            } else if (lowerCase.contains(AssistUtils.BRAND_VIVO)) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                    return intent2;
                }
                intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                return intent2;
            } else if (lowerCase.contains(AssistUtils.BRAND_MZ) && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + h.getPackageName()));
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }
}

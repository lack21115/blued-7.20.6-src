package com.ss.android.downloadlib.ox;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.video.module.a.a.m;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox/u.class */
public class u {
    private static Handler mb = new Handler(Looper.getMainLooper());

    public static boolean b(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_invoke_switch") == 1;
    }

    public static long h(com.ss.android.downloadad.api.mb.ox oxVar) {
        return oxVar == null ? m.ag : com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_back_time_limit", 3) * 1000;
    }

    public static boolean hj(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_dialog_switch") == 1;
    }

    private static int lz(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_check_delay", 1);
    }

    public static void mb(final com.ss.android.downloadad.api.mb.ox oxVar, final ww wwVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            jb.ox();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        boolean z = !isAppForeground && isAppForeground2;
        if (oxVar != null) {
            oxVar.je(z);
        }
        wwVar.mb(z);
        if (oxVar == null) {
            return;
        }
        ox(oxVar, x(oxVar));
        if (isAppForeground2) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.ox.u.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.u.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean b = jb.b(com.ss.android.downloadad.api.mb.ox.this.h());
                        long h = u.h(com.ss.android.downloadad.api.mb.ox.this);
                        if (!b || h >= System.currentTimeMillis() - currentTimeMillis) {
                            if (System.currentTimeMillis() - currentTimeMillis > u.ww(com.ss.android.downloadad.api.mb.ox.this)) {
                                AdEventHandler.mb().mb(EventConstants.UnityLabel.DEEPLINK_DELAY_TIMEOUT, com.ss.android.downloadad.api.mb.ox.this);
                                return;
                            }
                            com.ss.android.downloadad.api.mb.ox.this.je(true);
                            AdEventHandler.mb().mb(EventConstants.UnityLabel.DEEPLINK_DELAY_INVOKE, com.ss.android.downloadad.api.mb.ox.this);
                            wwVar.mb(true);
                            u.ox(com.ss.android.downloadad.api.mb.ox.this, u.x(com.ss.android.downloadad.api.mb.ox.this));
                        }
                    }
                });
            }
        });
    }

    public static boolean mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(final com.ss.android.downloadad.api.mb.ox oxVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.u.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (!jb.b(com.ss.android.downloadad.api.mb.ox.this.h())) {
                    u.ox(com.ss.android.downloadad.api.mb.ox.this, i - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!com.ss.android.downloadad.api.mb.ox.this.up()) {
                        i2 = 2;
                    }
                    jSONObject.putOpt(EventConstants.ExtraJson.KEY_DEEPLINK_SOURCE, Integer.valueOf(i2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.DEEPLINK_SUCCESS_2, jSONObject, com.ss.android.downloadad.api.mb.ox.this);
            }
        }, lz(oxVar) * 1000);
    }

    public static boolean ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_install_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long ww(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optLong("app_link_check_timeout", 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_check_count", 10);
    }
}

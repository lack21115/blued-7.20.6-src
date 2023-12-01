package com.ss.android.downloadlib.ox;

import android.os.Build;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox/b.class */
public class b {
    public static void mb(final com.ss.android.downloadad.api.mb.ox oxVar, final com.ss.android.downloadlib.guide.install.mb mbVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            jb.ox();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && isAppForeground2 && oxVar != null) {
            oxVar.je(true);
        }
        mbVar.mb();
        Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + isAppForeground2);
        if (isAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.ox.b.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                if (jb.ox(com.ss.android.downloadad.api.mb.ox.this)) {
                    return;
                }
                com.ss.android.downloadad.api.mb.ox.this.nk(true);
                AdEventHandler.mb().mb(EventConstants.UnityLabel.INSTALL_DELAY_INVOKE, com.ss.android.downloadad.api.mb.ox.this);
                mbVar.mb();
            }
        });
    }
}
